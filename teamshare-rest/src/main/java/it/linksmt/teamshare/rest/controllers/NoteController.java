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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dto.request.NoteRequestDto;
import it.linksmt.teamshare.business.dtos.NoteDto;
import it.linksmt.teamshare.business.services.NoteService;

@RequestMapping(name = "Note Controller", value = "/notes", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Note Controller", description = "Note Controller", tags = { "Note" })
public class NoteController {

	@Autowired
	private NoteService noteService;
	
	@ApiOperation(value = "Get Notes", notes = "Servizio rest per visualizzare la lista di Note", response = NoteDto.class)
	@ApiResponse(code = 200, message = "Lista Note", response = NoteDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<NoteDto>> getNotes (){
		List<NoteDto> noteDtos = null;

		noteDtos = noteService.getNotes();
		
		return new ResponseEntity<List<NoteDto>>(noteDtos, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Note", notes = "Servizio rest per visualizzare il dettaglio della Note", response = NoteDto.class)
	@ApiResponse(code = 200, message = "Dettaglio note", response = NoteDto.class)
	@RequestMapping(value="/{idNoteDto}", method = RequestMethod.GET)
	public ResponseEntity<NoteDto> getNote (
			@PathVariable(name = "idNoteDto") @ApiParam(value = "ID note", required = true) final int idNoteDto)
	{
		NoteDto n = noteService.getNote(idNoteDto);
		
		return new ResponseEntity<NoteDto>(n, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Insert Note", notes = "Servizio rest per aggiungere una Note", response = NoteDto.class)
	@ApiResponse(code = 200, message = "Inserimento Note", response = NoteDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<NoteDto> addNote (
			@RequestBody NoteRequestDto noteRequestDto)
	{
		NoteDto n = noteService.addNote(noteRequestDto);

		return new ResponseEntity<NoteDto>(n, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update Note", notes = "Servizio rest per aggiornare una nota", response = NoteDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento nota", response = NoteDto.class)
	@RequestMapping(value="/{idNote}", method = RequestMethod.PUT)
	public ResponseEntity<NoteDto> updateNote (
			@PathVariable(name = "idNote") @ApiParam(value = "ID nota", required = true) final int idNote,
			@RequestBody NoteRequestDto noteRequestDto)
	{
		NoteDto n = noteService.updateNote(idNote, noteRequestDto);

		return new ResponseEntity<NoteDto>(n, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete Note", notes = "Servizio rest per eliminare una nota", response = NoteDto.class)
	@ApiResponse(code = 200, message = "Eliminazione nota", response = NoteDto.class)
	@RequestMapping(value="/{idNote}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteNote (
			@PathVariable(name = "idNote") @ApiParam(value = "ID nota", required = true) final int idNote)
	{
		noteService.deleteNote(idNote);

		return new ResponseEntity<String>("Ok, activity deleted.", HttpStatus.OK);
	}
}
