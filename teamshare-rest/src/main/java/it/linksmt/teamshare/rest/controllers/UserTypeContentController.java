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
import it.linksmt.teamshare.business.dto.request.UserTypeContentRequestDto;
import it.linksmt.teamshare.business.dtos.UserTypeContentDto;
import it.linksmt.teamshare.business.services.UserTypeContentService;

@RequestMapping(name = "User Type Content Controller", value = "/usertypecontents", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "User Type Content Controller", description = "User Type Content Controller", tags = { "UserTypeContent" })
public class UserTypeContentController {
	
	@Autowired
	private UserTypeContentService userTypeContentService; 
	
	@ApiOperation(value = "Get UserTypeContents", notes = "Servizio rest per visualizzare la lista di Reazioni", response = UserTypeContentDto.class)
	@ApiResponse(code = 200, message = "Lista Reazioni", response = UserTypeContentDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserTypeContentDto>> getUserTypeContents (){
		List<UserTypeContentDto> userTypeContentDtos = null;

		userTypeContentDtos = userTypeContentService.getUsersTypesContents();
		
		return new ResponseEntity<List<UserTypeContentDto>>(userTypeContentDtos, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get UserTypeContent", notes = "Servizio rest per visualizzare il dettaglio della reazione", response = UserTypeContentDto.class)
	@ApiResponse(code = 200, message = "Dettaglio reazione", response = UserTypeContentDto.class)
	@RequestMapping(value="/{idUserTypeContentDto}", method = RequestMethod.GET)
	public ResponseEntity<UserTypeContentDto> getUserTypeContent (
			@PathVariable(name = "idUserTypeContentDto") @ApiParam(value = "ID reazione", required = true) final int reactionId)
	{
		UserTypeContentDto u = userTypeContentService.getUserTypeContent(reactionId);
		
		return new ResponseEntity<UserTypeContentDto>(u, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Insert UserTypeContent", notes = "Servizio rest per aggiungere una reazione", response = UserTypeContentDto.class)
	@ApiResponse(code = 200, message = "Inserimento reazione", response = UserTypeContentDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserTypeContentDto> addUserTypeContent (
			@RequestBody UserTypeContentRequestDto userTypeContentRequestDto)
	{
		UserTypeContentDto u = userTypeContentService.addUserTypeContent(userTypeContentRequestDto);

		return new ResponseEntity<UserTypeContentDto>(u, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update UserTypeContent", notes = "Servizio rest per aggiornare una reazione", response = UserTypeContentDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento reazione", response = UserTypeContentDto.class)
	@RequestMapping(value="/{idUserTypeContent}", method = RequestMethod.PUT)
	public ResponseEntity<UserTypeContentDto> updateUserTypeContent (
			@PathVariable(name = "idUserTypeContent") @ApiParam(value = "ID reazione", required = true) final int reactionId,
			@RequestBody UserTypeContentRequestDto userTypeContentRequestDto)
	{
		UserTypeContentDto u = userTypeContentService.updateUserTypeContent(reactionId, userTypeContentRequestDto);

		return new ResponseEntity<UserTypeContentDto>(u, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete UserTypeContent", notes = "Servizio rest per eliminare una reazione", response = UserTypeContentDto.class)
	@ApiResponse(code = 200, message = "Eliminazione reazione", response = UserTypeContentDto.class)
	@RequestMapping(value="/{idUserTypeContent}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUserTypeContent (
			@PathVariable(name = "idUserTypeContent") @ApiParam(value = "ID reazione", required = true) final int reactionId)
	{
		userTypeContentService.deleteUserTypeContent(reactionId);

		return new ResponseEntity<String>("Ok, activity deleted.", HttpStatus.OK);
	}

}
