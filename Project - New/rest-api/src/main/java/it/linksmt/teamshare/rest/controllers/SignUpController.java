package it.linksmt.teamshare.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.UserRequestDto;
import it.linksmt.teamshare.business.services.SignUpService;

@RestController
@RequestMapping( "/public/signup" )
public class SignUpController {

	@Autowired
	SignUpService signUpService;
	
	@ApiOperation(value = "Aggiungi Utente", notes = "Servizio rest per aggiungere un utente", response = UserDto.class)
	@ApiResponse(code = 200, message = "Aggiungi Utente", response = UserDto.class)
	@PostMapping( value="")
	public ResponseEntity<UserDto> addUser(@RequestBody final UserRequestDto user ) {
		UserDto u = signUpService.addUser(user);
		return new ResponseEntity<UserDto>(u, HttpStatus.CREATED);
	}
}
