	package it.linksmt.teamshare.rest.controllers;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dtos.NoteDto;
import it.linksmt.teamshare.business.request.NoteRequestDto;
import it.linksmt.teamshare.business.services.NoteService;


@Api(value = "Note Controller", description = "Note Controller", tags = { "Note" })
@Controller
@RequestMapping(name = "Note Controller",value = "/note", produces = { MediaType.APPLICATION_JSON_VALUE })

public class NoteController {



	
		
		@Autowired
		private NoteService noteService;

		
		/**
		 * @RequestParam(name = "numero_pagina", required = false, defaultValue = "0")
		 *  @ApiParam(value = "Numero di pagina", required = false, defaultValue = "0") final int numeroPagina,
			@RequestParam(name = "numero_elementi_per_pagina", required = false, defaultValue = "0")
			@ApiParam(value = "Numero di elementi per pagina", required = false, defaultValue = "0") final int numeroElementiPerPagina
		 * @return
		 */
		
	

		@ApiOperation(value = "Note By Id", notes = "Servizio rest per visualizzare le note tramite gli id", response = NoteDto.class)
		@ApiResponse(code = 200, message = "Note By Id", response = NoteDto.class)
		@GetMapping( value="/")
		public ResponseEntity<List<NoteDto>> getNote() {
			List<NoteDto> note = noteService.getNote() ;
			return new ResponseEntity<List<NoteDto>>(note, HttpStatus.OK);
		}

		@ApiOperation(value = "Aggiungi nota", notes = "Servizio rest per aggiungere una nota", response = NoteDto.class)
		@ApiResponse(code = 200, message = "Nota Aggiunta", response = NoteDto.class)
		@PostMapping( value="/")
		public ResponseEntity<NoteDto> addUser(@RequestBody final NoteRequestDto nota ) {
			NoteDto u = noteService.addNote(nota);
			return new ResponseEntity<NoteDto>(u, HttpStatus.CREATED);
		}
		
		@ApiOperation(value = "Update nota", notes = "Servizio rest per aggiornare una nota", response = NoteDto.class)
		@ApiResponse(code = 200, message = "Update nota", response = NoteDto.class)
		@PutMapping( value="/{noteId}")
		public ResponseEntity<NoteDto> updateUser( @RequestParam("noteId") Integer idNota, @RequestBody final NoteRequestDto nota) {
			NoteDto u = noteService.updateNote(idNota,nota);
			return new ResponseEntity<NoteDto>(u, HttpStatus.OK);			
		}

		@ApiOperation(value = "Delete nota", notes = "Servizio rest per cancellare una nota")
		@ApiResponse(code = 200, message = "Delete nota")
		@DeleteMapping( value="/{noteid}")
		public void removeUser(@RequestParam(name = "noteId", required = true) @ApiParam(value = "noteId", required = true) final Integer noteId ) {
			Integer id = null;
				id = noteId;
			if(id != null) {
				noteService.deleteNote(id);
			}
		}

	}


