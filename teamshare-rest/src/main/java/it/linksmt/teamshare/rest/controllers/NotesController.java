package it.linksmt.teamshare.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dto.request.NoteRequestDto;
import it.linksmt.teamshare.business.dtos.NoteDto;
import it.linksmt.teamshare.business.services.NoteService;

@RequestMapping(name = "Note Controller", value = "/notes", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Note Controller", description = "Note Controller", tags = { "Nota" })
public class NotesController {

	@Autowired
	private NoteService noteService;

	@ApiOperation(value = "Get Notes", notes = "Servizio rest per visualizzare tutte le note", response = NoteDto.class)
	@ApiResponse(code = 200, message = "Lista Notes", response = NoteDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<NoteDto>> getNotes(
			@RequestParam(name = "testo", required = false, defaultValue = "") @ApiParam(value = "testo note", required = false, defaultValue = "") final String testo) {
		
		List<NoteDto> notes = null;

		notes = noteService.getNotes();

		return new ResponseEntity<List<NoteDto>>(notes, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Note", notes = "Servizio rest per visualizzare il dettaglio di una nota", response = NoteDto.class)
	@ApiResponse(code = 200, message = "Dettaglio nota", response = NoteDto.class)
	@RequestMapping(value = "/{idNote}", method = RequestMethod.GET)
	public ResponseEntity<NoteDto> getNote(
			@PathVariable(name = "idNote") @ApiParam(value = "ID note", required = true) final int notaId) {
		
		NoteDto nota = noteService.getNote(notaId);

		return new ResponseEntity<NoteDto>(nota, HttpStatus.OK);
	}

	@ApiOperation(value = "Update Note", notes = "Servizio rest per aggiornare una nota", response = NoteDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento nota", response = NoteDto.class)
	@RequestMapping(value = "/{idNote}", method = RequestMethod.PUT)
	public ResponseEntity<NoteDto> updateNote(
			@PathVariable(name = "idNote") @ApiParam(value = "ID nota", required = true) final int noteId,
			@RequestBody NoteRequestDto noteRequestDto) {
		
		NoteDto note = noteService.updateNote(noteId, noteRequestDto);

		return new ResponseEntity<NoteDto>(note, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert Note", notes = "Servizio rest per aggiungere una nota ad un post", response = NoteDto.class)
	@ApiResponse(code = 200, message = "Inserimento note", response = NoteDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<NoteDto> addNote(
			@RequestBody NoteRequestDto noteRequestDto) {

		NoteDto nota = noteService.addNote(noteRequestDto);

		return new ResponseEntity<NoteDto>(nota, HttpStatus.CREATED);

	}

	@ApiOperation(value = "Delete Note", notes = "Servizio rest per eliminare una nota", response = NoteDto.class)
	@ApiResponse(code = 200, message = "Eliminazione nota", response = NoteDto.class)
	@RequestMapping(value = "/{idNote}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteNote(
			@PathVariable(name = "idNote") @ApiParam(value = "ID note", required = true) final int noteId) {
		
		noteService.deleteNote(noteId);

		return new ResponseEntity<String>("Ok, note deleted.", HttpStatus.OK);
	}

}
