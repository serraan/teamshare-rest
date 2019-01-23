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
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.UserRequestDto;
import it.linksmt.teamshare.business.services.UserService;


@Api(value = "Utente Controller", description = "Utente Controller", tags = { "Utente" })
@Controller
@RequestMapping(name = "Utente Controller",value = "/private/users", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UsersController {
	
	@Autowired
	private UserService userService;

	
	/**
	 * @RequestParam(name = "numero_pagina", required = false, defaultValue = "0")
	 *  @ApiParam(value = "Numero di pagina", required = false, defaultValue = "0") final int numeroPagina,
		@RequestParam(name = "numero_elementi_per_pagina", required = false, defaultValue = "0")
		@ApiParam(value = "Numero di elementi per pagina", required = false, defaultValue = "0") final int numeroElementiPerPagina
	 * @return
	 */
	
	@ApiOperation(value = "Lista Utenti By Nome/Cognome/Email", notes = "Servizio rest per visualizzare tutti gli utenti", response = UserDto.class)
	@ApiResponse(code = 200, message = "Lista Utenti", response = UserDto.class)
	@GetMapping(value="/{nome}{cognome}{email}")
	public ResponseEntity<List<UserDto>> getUsers(@RequestParam(name = "email", required = false, defaultValue = "") @ApiParam(value = "Email utente", required = false, defaultValue = "") final String email,
			@RequestParam(name = "nome", required = false, defaultValue = "") @ApiParam(value = "Nome utente", required = false, defaultValue = "") final String nome,
			@RequestParam(name = "cognome", required = false, defaultValue = "") @ApiParam(value = "Cognome utente", required = false, defaultValue = "") final String cognome) {
		List<UserDto> users = new ArrayList<UserDto>();
		users = userService.searchUsers(nome,cognome,email);
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}
	

	@ApiOperation(value = "Utenti By Id", notes = "Servizio rest per visualizzare gli utenti tramite gli id", response = UserDto.class)
	@ApiResponse(code = 200, message = "Utenti By Id", response = UserDto.class)
	@GetMapping( value="/{userId}")
	public ResponseEntity<UserDto> getUser( @PathVariable(name = "userId",required = true) @ApiParam(value = "userId", required = true) final Integer userId ) {
		UserDto user = new UserDto();
		user = userService.getUser(userId);
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "Aggiungi Utente", notes = "Servizio rest per aggiungere un utente", response = UserDto.class)
	@ApiResponse(code = 200, message = "Aggiungi Utente", response = UserDto.class)
	@PostMapping( value="/")
	public ResponseEntity<UserDto> addUser(@RequestBody final UserRequestDto user ) {
		UserDto u = userService.addUser(user);
		return new ResponseEntity<UserDto>(u, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update Utente", notes = "Servizio rest per aggiornare un utente", response = UserDto.class)
	@ApiResponse(code = 200, message = "Update Utente", response = UserDto.class)
	@PutMapping( value="/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("userId") int userId, @RequestBody final UserRequestDto user) {
		UserDto u = userService.updateUser(userId,user);
		return new ResponseEntity<UserDto>(u, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Utente", notes = "Servizio rest per cancellare un utente")
	@ApiResponse(code = 200, message = "Delete Utente")
	@DeleteMapping( value="/{userId}")
	public void removeUser(@PathVariable(name = "userId", required = true) @ApiParam(value = "userId", required = true) final Integer userId ) {
		Integer id = null;
			id = userId;
		if(id != null) {
			userService.deleteUser(id);
		}
	}

}
