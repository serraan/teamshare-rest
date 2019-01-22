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

@RequestMapping(name = "UserTypeContents Controller", value = "/userTypeContents", produces = {
		MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "UserTypeContents Controller", description = "UserTypeContents Controller", tags = {
		"UtenteTipoContenuto" })
public class UserTypeContentsController {

	@Autowired
	private UserTypeContentService UserTypeContentService;

	@ApiOperation(value = "Get UserTypeContents", notes = "Servizio rest per visualizzare la lista degli UtenteTipoContenuti", response = UserTypeContentDto.class)
	@ApiResponse(code = 200, message = "Lista UtenteTipoContenuti", response = UserTypeContentDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserTypeContentDto>> getUserTypeContents() {

		List<UserTypeContentDto> userTypeContents = UserTypeContentService.getUserTypeContents();

		return new ResponseEntity<List<UserTypeContentDto>>(userTypeContents, HttpStatus.OK);
	}

	@ApiOperation(value = "Get UserTypeContent", notes = "Servizio rest per visualizzare il dettaglio dell'UtenteTipoContenuto", response = UserTypeContentDto.class)
	@ApiResponse(code = 200, message = "Dettaglio UtenteTipoContenuto", response = UserTypeContentDto.class)
	@RequestMapping(value = "/{idUserTypeContent}", method = RequestMethod.GET)
	public ResponseEntity<UserTypeContentDto> getUserTypeContent(
			@PathVariable(name = "idUserTypeContent") @ApiParam(value = "ID UtenteTipoContenuto", required = true) final int UserTypeContentId) {

		UserTypeContentDto UserTypeContent = UserTypeContentService.getUserTypeContent(UserTypeContentId);

		return new ResponseEntity<UserTypeContentDto>(UserTypeContent, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert UserTypeContent", notes = "Servizio rest per aggiungere un UtenteTipoContenuto", response = UserTypeContentDto.class)
	@ApiResponse(code = 200, message = "Inserimento UtenteTipoContenuto", response = UserTypeContentDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserTypeContentDto> addUserTypeContent(
			@RequestBody UserTypeContentRequestDto UserTypeContentRequestDto) {

		UserTypeContentDto u = UserTypeContentService.addUserTypeContent(UserTypeContentRequestDto);

		return new ResponseEntity<UserTypeContentDto>(u, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update UserTypeContent", notes = "Servizio rest per aggiornare un UtenteTipoContenuto", response = UserTypeContentDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento UtenteTipoContenuto", response = UserTypeContentDto.class)
	@RequestMapping(value = "/{idUserTypeContent}", method = RequestMethod.PUT)
	public ResponseEntity<UserTypeContentDto> updateUserTypeContent(
			@PathVariable(name = "idUserTypeContent") @ApiParam(value = "ID UtenteTipoContenuto", required = true) final int UserTypeContentId,
			@RequestBody UserTypeContentRequestDto UserTypeContentRequestDto) {

		UserTypeContentDto UserTypeContent = UserTypeContentService.updateUserTypeContent(UserTypeContentId,
				UserTypeContentRequestDto);

		return new ResponseEntity<UserTypeContentDto>(UserTypeContent, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete UserTypeContent", notes = "Servizio rest per eliminare un UtenteTipoContenuto", response = UserTypeContentDto.class)
	@ApiResponse(code = 200, message = "Eliminazione UtenteTipoContenuto", response = UserTypeContentDto.class)
	@RequestMapping(value = "/{idUserTypeContent}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUserTypeContent(
			@PathVariable(name = "idUserTypeContent") @ApiParam(value = "ID UtenteTipoContenuto", required = true) final int UserTypeContentId) {

		UserTypeContentService.deleteUserTypeContent(UserTypeContentId);

		return new ResponseEntity<String>("Ok, UserTypeContent deleted.", HttpStatus.OK);
	}

}
