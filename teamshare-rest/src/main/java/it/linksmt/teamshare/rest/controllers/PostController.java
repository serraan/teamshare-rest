package it.linksmt.teamshare.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.business.services.impl.PostServiceImpl;

@RequestMapping(name = "Post Controller", value = "/posts", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Post Controller", description = "Post Controller", tags = { "Posts" })
public class PostController {

	@Autowired
	private PostServiceImpl service;
	
	@ApiOperation(value = "Get Posts", notes = "Servizio rest per visualizzare la lista dei posts", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Lista Posts", response = ActivityDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PostDto>> getPosts(){
		List<PostDto> posts = null;
		
		posts = service.getAll();
		
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}
	
}
