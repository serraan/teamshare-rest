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
import it.linksmt.teamshare.business.dto.request.UserTeamRequestDto;
import it.linksmt.teamshare.business.dtos.UserTeamDto;
import it.linksmt.teamshare.business.services.UserTeamService;

@RequestMapping(name = "UtenteTeams Controller", value = "/userTeams", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "UtenteTeams Controller", description = "UtenteTeams Controller", tags = { "UtenteTeam" })
public class UserTeamsController {

	@Autowired
	private UserTeamService UserTeamService;

	@ApiOperation(value = "Get UserTeams", notes = "Servizio rest per visualizzare la lista degli UtenteTeams", response = UserTeamDto.class)
	@ApiResponse(code = 200, message = "Lista UtenteTeam", response = UserTeamDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserTeamDto>> getUserTeams() {

		List<UserTeamDto> UserTeams = UserTeamService.getUserTeams();

		return new ResponseEntity<List<UserTeamDto>>(UserTeams, HttpStatus.OK);
	}

	@ApiOperation(value = "Get UserTeam", notes = "Servizio rest per visualizzare il dettaglio dell'UtenteTeam", response = UserTeamDto.class)
	@ApiResponse(code = 200, message = "Dettaglio UtenteTeam", response = UserTeamDto.class)
	@RequestMapping(value = "/{idUserTeam}", method = RequestMethod.GET)
	public ResponseEntity<UserTeamDto> getUserTeam(
			@PathVariable(name = "idUserTeam") @ApiParam(value = "ID UtenteTeam", required = true) final int UserTeamId) {

		UserTeamDto UserTeam = UserTeamService.getUserTeam(UserTeamId);

		return new ResponseEntity<UserTeamDto>(UserTeam, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert UserTeam", notes = "Servizio rest per aggiungere un UtenteTeam", response = UserTeamDto.class)
	@ApiResponse(code = 200, message = "Inserimento UtenteTeam", response = UserTeamDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserTeamDto> addUserTeam(@RequestBody UserTeamRequestDto UserTeamRequestDto) {

		UserTeamDto u = UserTeamService.addUserTeam(UserTeamRequestDto);

		return new ResponseEntity<UserTeamDto>(u, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update UserTeam", notes = "Servizio rest per aggiornare un UtenteTeam", response = UserTeamDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento UtenteTeam", response = UserTeamDto.class)
	@RequestMapping(value = "/{idUserTeam}", method = RequestMethod.PUT)
	public ResponseEntity<UserTeamDto> updateUserTeam(
			@PathVariable(name = "idUserTeam") @ApiParam(value = "ID UtenteTeam", required = true) final int UserTeamId,
			@RequestBody UserTeamRequestDto UserTeamRequestDto) {

		UserTeamDto UserTeam = UserTeamService.updateUserTeam(UserTeamId, UserTeamRequestDto);

		return new ResponseEntity<UserTeamDto>(UserTeam, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete UserTeam", notes = "Servizio rest per eliminare un UtenteTeam", response = UserTeamDto.class)
	@ApiResponse(code = 200, message = "Eliminazione UtenteTeam", response = UserTeamDto.class)
	@RequestMapping(value = "/{idUserTeam}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUserTeam(
			@PathVariable(name = "idUserTeam") @ApiParam(value = "ID UtenteTeam", required = true) final int UserTeamId) {

		UserTeamService.deleteUserTeam(UserTeamId);

		return new ResponseEntity<String>("Ok, UserTeam deleted.", HttpStatus.OK);
	}

}
