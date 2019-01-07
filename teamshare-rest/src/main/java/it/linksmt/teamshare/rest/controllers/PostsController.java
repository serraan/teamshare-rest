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
import it.linksmt.teamshare.business.dto.request.PostRequestDto;
import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.business.services.PostService;

@RequestMapping(name = "Posts Controller", value = "/posts", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Posts Controller", description = "Posts Controller", tags = { "Post" })
public class PostsController {

	@Autowired
	private PostService postService;

	@ApiOperation(value = "Get Posts", notes = "Servizio rest per visualizzare i post", response = PostDto.class)
	@ApiResponse(code = 200, message = "Posts", response = PostDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PostDto>> getPosts() {
		
		List<PostDto> posts = null;

		posts = postService.getPosts();

		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Post", notes = "Servizio rest per visualizzare il dettaglio di un post", response = PostDto.class)
	@ApiResponse(code = 200, message = "Dettaglio post", response = PostDto.class)
	@RequestMapping(value = "/{idPost}", method = RequestMethod.GET)
	public ResponseEntity<PostDto> getPost(
			@PathVariable(name = "idPost") @ApiParam(value = "ID post", required = true) final int postId) {
		
		PostDto post = postService.getPost(postId);

		return new ResponseEntity<PostDto>(post, HttpStatus.OK);
	}

	@ApiOperation(value = "Update Post", notes = "Servizio rest per aggiornare un post", response = PostDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento post", response = PostDto.class)
	@RequestMapping(value = "/{idPost}", method = RequestMethod.PUT)
	public ResponseEntity<PostDto> updateNote(
			@PathVariable(name = "idPost") @ApiParam(value = "ID post", required = true) final int postId,
			@RequestBody PostRequestDto postRequestDto) {
		
		PostDto post = postService.updatePost(postId, postRequestDto);

		return new ResponseEntity<PostDto>(post, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert Post", notes = "Servizio rest per aggiungere un post", response = PostDto.class)
	@ApiResponse(code = 200, message = "Inserimento post", response = PostDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PostDto> addPost(
			@RequestBody PostRequestDto postRequestDto) {
		
		PostDto pst = postService.addPost(postRequestDto);

		return new ResponseEntity<PostDto>(pst, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Delete Post", notes = "Servizio rest per eliminare un post", response = PostDto.class)
	@ApiResponse(code = 200, message = "Eliminazione post", response = PostDto.class)
	@RequestMapping(value = "/{idPost}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deletePost(
			@PathVariable(name = "idPost") @ApiParam(value = "ID post", required = true) final int postId) {
		
		postService.deletePost(postId);

		return new ResponseEntity<String>("Ok, post deleted.", HttpStatus.OK);
	}

}
