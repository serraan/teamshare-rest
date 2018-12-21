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
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dtos.CommentDto;
import it.linksmt.teamshare.business.request.CommentRequestDto;
import it.linksmt.teamshare.business.services.CommentService;

@Api(value = "Comment Controller", description = "Comment Controller", tags = { "Commento" })
@Controller
@RequestMapping(name = "Comment Controller",value = "/comments", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CommentsController {

	@Autowired
	CommentService commentService;
	@ApiOperation(value = "Lista commenti di un post", notes = "Servizio rest per visualizzare tutti i commenti relativi ad un post", response = CommentDto.class)
	@ApiResponse(code = 200, message = "Lista commenti di un post", response = CommentDto.class)
	@RequestMapping(value = "/idPost", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<CommentDto>> getCommentsByPost(@RequestParam(name="idPost") Integer idPost) {
		List<CommentDto> comments = commentService.searchCommentsOnPost(idPost);
		return new ResponseEntity<List<CommentDto>>(comments, HttpStatus.OK);
	}
	@ApiOperation(value = "Aggiungere un Commento", notes = "Servizio rest per aggiungere un commento", response = CommentDto.class)
	@ApiResponse(code = 200, message = "Aggiungere un commento", response = CommentDto.class)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CommentDto> addComment(@RequestBody	CommentRequestDto comment) {
		CommentDto a = commentService.addComment(comment);
		return new ResponseEntity<CommentDto>(a, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Aggiorna un commento", notes = "Servizio rest per aggiornare un commento", response = CommentDto.class)
	@ApiResponse(code = 200, message = "Aggiorna un commento", response = CommentDto.class)
	@RequestMapping(value = "/{commId}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<CommentDto> updateComment(@PathVariable("commId") int commId,@RequestBody CommentRequestDto comment) {
		CommentDto u = commentService.updateComment(commId,comment);
		return new ResponseEntity<CommentDto>(u, HttpStatus.OK);
	}

	@ApiOperation(value = "Cancellare un commento", notes = "Servizio rest per cancellare un commento", response = String.class)
	@ApiResponse(code = 200, message = "Cancellare un commento", response = String.class)
	@RequestMapping(value = "/{commentId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void removeComment(@PathVariable Integer commentId) {

		commentService.deleteComment(commentId);
}

}