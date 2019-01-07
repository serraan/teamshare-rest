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
import it.linksmt.teamshare.business.dto.request.CommentRequestDto;
import it.linksmt.teamshare.business.dtos.CommentDto;
import it.linksmt.teamshare.business.services.CommentService;

@RequestMapping(name = "Comments Controllers", value = "/comments", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Controller dei commenti", description = "Controller per i commenti", tags = { "Commenti" })
public class CommentsController {

	@Autowired
	private CommentService commentService;

	@ApiOperation(value = "Get Comments", notes = "Servizio rest per visualizzare la lista dei commenti", response = CommentDto.class)
	@ApiResponse(code = 200, message = "Lista commenti", response = CommentDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CommentDto>> getComments() {
		
		List<CommentDto> comments = null;

		comments = commentService.getComments();

		return new ResponseEntity<List<CommentDto>>(comments, HttpStatus.OK);

	}

	@ApiOperation(value = "Get Comment", notes = "Servizio rest per visualizzare un commento", response = CommentDto.class)
	@ApiResponse(code = 200, message = "Dettaglio commento", response = CommentDto.class)
	@RequestMapping(value = "/{idComment}", method = RequestMethod.GET)
	public ResponseEntity<CommentDto> getComment(
			@PathVariable(name = "idComment") @ApiParam(value = "ID commento", required = true) final int commentId) {
		
		CommentDto c = commentService.getComment(commentId);

		return new ResponseEntity<CommentDto>(c, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert Comment", notes = "Servizio rest per aggiungere un commento", response = CommentDto.class)
	@ApiResponse(code = 200, message = "Inserimento commento", response = CommentDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CommentDto> addComment(@RequestBody CommentRequestDto commentRequestDto) {
		
		CommentDto c = commentService.addComment(commentRequestDto);

		return new ResponseEntity<CommentDto>(c, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update Comment", notes = "Servizio rest per aggiornare un commento", response = CommentDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento commento", response = CommentDto.class)
	@RequestMapping(value = "/{idComment}", method = RequestMethod.PUT)
	public ResponseEntity<CommentDto> updateComment(
			@PathVariable(name = "idComment") @ApiParam(value = "ID commento", required = true) final int commentId,
			@RequestBody CommentRequestDto commentRequestDto) {
		
		CommentDto a = commentService.updateComment(commentId, commentRequestDto);

		return new ResponseEntity<CommentDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Comment", notes = "Servizio rest per eliminare un commento", response = CommentDto.class)
	@ApiResponse(code = 200, message = "Eliminazione commento", response = CommentDto.class)
	@RequestMapping(value = "/{idComment}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteComment(
			@PathVariable(name = "idComment") @ApiParam(value = "ID attivita", required = true) final int commentId) {
		
		commentService.deleteComment(commentId);

		return new ResponseEntity<String>("Ok, comment deleted.", HttpStatus.OK);
	}

}
