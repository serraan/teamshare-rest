package it.linksmt.teamshare.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dto.request.UserRequestDto;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.services.UserService;

@RequestMapping(name = "Users Controller", value = "/users", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Users Controller", description = "Users Controller", tags = { "Utente" })
public class UsersController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Get Users", notes = "Servizio rest per visualizzare la lista degli utenti", response = UserDto.class)
	@ApiResponse(code = 200, message = "Lista Utenti", response = UserDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> getUsers(
			@RequestParam(name = "email", required = false, defaultValue = "") @ApiParam(value = "Email utente", required = false, defaultValue = "") final String email,
			@RequestParam(name = "nome", required = false, defaultValue = "") @ApiParam(value = "Nome utente", required = false, defaultValue = "") final String firstName,
			@RequestParam(name = "cognome", required = false, defaultValue = "") @ApiParam(value = "Cognome utente", required = false, defaultValue = "") final String lastName) {

		List<UserDto> users = null;

		if (StringUtils.isEmpty(email) && StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
			users = userService.getUsers();
		} else {
			users = userService.searchUsers(email, firstName, lastName);
		}

		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}

	@ApiOperation(value = "Get User", notes = "Servizio rest per visualizzare il dettaglio dell'utente", response = UserDto.class)
	@ApiResponse(code = 200, message = "Dettaglio utente", response = UserDto.class)
	@RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> getUser(
			@PathVariable(name = "idUser") @ApiParam(value = "ID utente", required = true) final int userId) {

		UserDto user = userService.getUser(userId);

		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert User", notes = "Servizio rest per aggiungere un utente", response = UserDto.class)
	@ApiResponse(code = 200, message = "Inserimento utente", response = UserDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDto> addUser(@RequestBody UserRequestDto userRequestDto) {

		UserDto u = userService.addUser(userRequestDto);

		return new ResponseEntity<UserDto>(u, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update User", notes = "Servizio rest per aggiornare un utente", response = UserDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento utente", response = UserDto.class)
	@RequestMapping(value = "/{idUser}", method = RequestMethod.PUT)
	public ResponseEntity<UserDto> updateUser(
			@PathVariable(name = "idUser") @ApiParam(value = "ID utente", required = true) final int userId,
			@RequestBody UserRequestDto userRequestDto) {

		UserDto user = userService.updateUser(userId, userRequestDto);

		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete User", notes = "Servizio rest per eliminare un utente", response = UserDto.class)
	@ApiResponse(code = 200, message = "Eliminazione utente", response = UserDto.class)
	@RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(
			@PathVariable(name = "idUser") @ApiParam(value = "ID utente", required = true) final int userId) {

		userService.deleteUser(userId);

		return new ResponseEntity<String>("Ok, user deleted.", HttpStatus.OK);
	}

}
