package it.linksmt.teamshare.rest.controllers;

import java.util.ArrayList;
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
import it.linksmt.teamshare.business.dtos.CommentDto;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.CommentRequestDto;
import it.linksmt.teamshare.business.request.UserRequestDto;
import it.linksmt.teamshare.business.services.CommentService;



	@Api(value = "Commento Controller", description = "Commento Controller", tags = { "Commento" })
	@Controller
	@RequestMapping(name = "Commento Controller",value = "/comment", produces = { MediaType.APPLICATION_JSON_VALUE })
	public class CommentController {
		
		@Autowired
		private CommentService commentService;
	

		
		
		
		@ApiOperation(value = "Lista Commenti ", notes = "Servizio rest per visualizzare tutti i commenti", response = CommentDto.class)
		@ApiResponse(code = 200, message = "Lista Commenti", response = CommentDto.class)
		@GetMapping(value="/{idCommento")
		public ResponseEntity<List<CommentDto>> getComment(
		@RequestParam(name = "idCommento", required = false, defaultValue = "") @ApiParam(value = "idCommento", required = false, defaultValue = "") final Integer idCommento ){
			
			
			List<CommentDto> comment = new ArrayList<CommentDto>();
			comment = commentService.getComment();
			return new ResponseEntity<List<CommentDto>>(comment, HttpStatus.OK);
		}
			
			
			@ApiOperation(value = "Aggiungi Commento", notes = "Servizio rest per aggiungere un commento", response = CommentDto.class)
			@ApiResponse(code = 200, message = "Aggiungi Commento", response = CommentDto.class)
			@PostMapping( value="/")
			public ResponseEntity<CommentDto> addComment(@RequestBody final CommentRequestDto comment ) {
				CommentDto com = commentService.addComment(comment);
				return new ResponseEntity<CommentDto>(com, HttpStatus.CREATED);
			}
			
			@ApiOperation(value = "Update Commento", notes = "Servizio rest per aggiornare un commento", response = CommentDto.class)
			@ApiResponse(code = 200, message = "Update Commento", response = CommentDto.class)
			@PutMapping( value="/{idCommento}")
			public ResponseEntity<CommentDto> updateComment(@PathVariable("idCommento") int idCommento, @RequestBody final CommentRequestDto comment) {
				CommentDto com = commentService.updateComment(idCommento,comment);
				return new ResponseEntity<CommentDto>(com, HttpStatus.OK);
			}
			
			@ApiOperation(value = "Delete Utente", notes = "Servizio rest per cancellare un commento")
			@ApiResponse(code = 200, message = "Delete Commento")
			@DeleteMapping( value="/{idCommento}")
			public void removeUser(@PathVariable(name = "idCommento", required = true) @ApiParam(value = "idCommento", required = true) final Integer commentId ) {
				Integer id = null;
					id = commentId;
				if(id != null) {
					commentService.deleteComment(id);
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		}
		

	