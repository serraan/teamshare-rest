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
import it.linksmt.teamshare.business.dto.request.ContentTeamRequestDto;
import it.linksmt.teamshare.business.dtos.ContentTeamDto;
import it.linksmt.teamshare.business.services.ContentTeamService;

@RequestMapping(name = "ContentTeams Controller", value = "/contentTeams", produces = {
		MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "ContentTeams Controller", description = "ContentTeams Controller", tags = { "ContentTeam" })
public class ContentTeamsController {

	@Autowired
	private ContentTeamService contentTeamService;

	@ApiOperation(value = "Get ContentTeams", notes = "Servizio rest per visualizzare i ContentTeams", response = ContentTeamDto.class)
	@ApiResponse(code = 200, message = "Lista ContentTeams", response = ContentTeamDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ContentTeamDto>> getContentTeams() {
		
		List<ContentTeamDto> contentTeam = null;

		contentTeam = contentTeamService.getContentTeams();

		return new ResponseEntity<List<ContentTeamDto>>(contentTeam, HttpStatus.OK);
	}
	
	
	
	@ApiOperation(value = "Get ContentTeam", notes = "Servizio rest per visualizzare il dettaglio di un ContentTeam", response = ContentTeamDto.class)
	@ApiResponse(code = 200, message = "Dettaglio ContentTeam", response = ContentTeamDto.class)
	@RequestMapping(value = "/{idContentTeam}", method = RequestMethod.GET)
	public ResponseEntity<ContentTeamDto> getContentTeam(
			@PathVariable(name = "idContentTeam") @ApiParam(value = "ID ContentTeam", required = true) final int contentTeamId) {
		
		ContentTeamDto ct =contentTeamService.getContentTeam(contentTeamId);

		return new ResponseEntity<ContentTeamDto>(ct, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Insert ContentTeam", notes = "Servizio rest per aggiungere un content team", response = ContentTeamDto.class)
	@ApiResponse(code = 200, message = "Inserimento content team", response = ContentTeamDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ContentTeamDto> addContentTeam(@RequestBody ContentTeamRequestDto contentTeamRequestDto) {

		ContentTeamDto ct = contentTeamService.addContentTeam(contentTeamRequestDto);

		return new ResponseEntity<ContentTeamDto>(ct, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update ContentTeam", notes = "Servizio rest per aggiornare un ContentTeam", response = ContentTeamDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento Content Team", response = ContentTeamDto.class)
	@RequestMapping(value = "/{idContentTeam}", method = RequestMethod.PUT)
	public ResponseEntity<ContentTeamDto> updateContentTeam(
			@PathVariable(name = "idContentTeam") @ApiParam(value = "ID contentTeam", required = true) final int contentTeamId,
			@RequestBody ContentTeamRequestDto contentTeamRequestDto) {
		
		ContentTeamDto ct = contentTeamService.updateContentTeam(contentTeamId, contentTeamRequestDto);

		return new ResponseEntity<ContentTeamDto>(ct, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete ContentTeam", notes = "Servizio rest per eliminare un ContentTeam", response = ContentTeamDto.class)
	@ApiResponse(code = 200, message = "Eliminazione ContentTeam", response = ContentTeamDto.class)
	@RequestMapping(value = "/{idContentTeam}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteContentTeam(
			@PathVariable(name = "idContentTeam") @ApiParam(value = "ID ContentTeam", required = true) final int contentTeamId) {
		
		contentTeamService.deleteContentTeam(contentTeamId);

		return new ResponseEntity<String>("Ok, contentTeam deleted.", HttpStatus.OK);
	}

}
