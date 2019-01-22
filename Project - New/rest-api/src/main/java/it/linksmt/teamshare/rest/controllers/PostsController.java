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
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.business.request.PostRequestDto;
import it.linksmt.teamshare.business.services.PostService;

@Api(value = "Post Controller", description = "Post Controller", tags = { "Post" })
@Controller
@RequestMapping(name = "Post Controller", value = "/posts", produces = { MediaType.APPLICATION_JSON_VALUE })
public class PostsController {
	@Autowired
	private PostService postService;

	@ApiOperation(value = "Lista Post", notes = "Servizio rest per visualizzare tutti i post", response = PostDto.class)
	@ApiResponse(code = 200, message = "Lista Attivita", response = PostDto.class)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<PostDto>> getPosts() {
		List<PostDto> posts = postService.getAll();
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}

	@ApiOperation(value = "Aggiungere un post", notes = "Servizio rest per aggiungere un post", response = PostDto.class)
	@ApiResponse(code = 200, message = "Aggiungere un post", response = PostDto.class)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PostDto> addPost(@RequestBody PostRequestDto post) {
		PostDto p = postService.addPost(post);
		return new ResponseEntity<PostDto>(p, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Cancellare un post", notes = "Servizio rest per cancellare un post", response = String.class)
	@ApiResponse(code = 200, message = "Cancellare un post", response = String.class)
	@RequestMapping(value = "/{postId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void removeAct(@PathVariable Integer postId) {
		if (postId != null) {
			postService.deletePost(postId);
		}
	}
}
