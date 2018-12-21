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
import it.linksmt.teamshare.business.dto.request.SprintRequestDto;
import it.linksmt.teamshare.business.dtos.ReleaseDto;
import it.linksmt.teamshare.business.dtos.SprintDto;
import it.linksmt.teamshare.business.services.SprintService;

@RequestMapping(name = "Sprint Controller", value = "/sprints", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Sprint Controller", description = "Sprint Controller", tags = { "Sprint" })
public class SprintController {

	@Autowired
	private SprintService sprintService;

	@ApiOperation(value = "Get Sprints", notes = "Servizio rest per visualizzare la lista degli sprint", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Lista Sprint", response = SprintDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SprintDto>> getSprints (
			@RequestParam(name = "nome", required = false, defaultValue = "") @ApiParam(value = "Nome sprint", required = false, defaultValue = "") final String nome)
	{
		List<SprintDto> sprints = null;

		if(StringUtils.isEmpty(nome)) {
			sprints = sprintService.getSprints();
		} else {
			sprints = sprintService.searchSprints(nome);
		}

		return new ResponseEntity<List<SprintDto>>(sprints, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Sprint", notes = "Servizio rest per visualizzare il dettaglio di uno sprint", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Dettaglio sprint", response = ReleaseDto.class)
	@RequestMapping(value = "/{idSprint}", method = RequestMethod.GET)
	public ResponseEntity<SprintDto> getSprint(
			@PathVariable(name = "idSprint") @ApiParam(value = "ID sprint", required = true) final int sprintId) {
		SprintDto spr = sprintService.getSprint(sprintId);

		return new ResponseEntity<SprintDto>(spr, HttpStatus.OK);
	}

	@ApiOperation(value = "Inserisci Sprint", notes = "Servizio rest per aggiungere uno sprint", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Inserimento sprint", response = SprintDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SprintDto> addSprint(@RequestBody SprintRequestDto sprintRequestDto) {
		SprintDto spr = sprintService.addSprint(sprintRequestDto);

		return new ResponseEntity<SprintDto>(spr, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update Sprint", notes = "Servizio rest per aggiornare uno sprint", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento sprint", response = SprintDto.class)
	@RequestMapping(value = "/{idSprint}", method = RequestMethod.PUT)
	public ResponseEntity<SprintDto> updateSprint(
			@PathVariable(name = "idSprint") @ApiParam(value = "ID sprint", required = true) final int sprintId,
			@RequestBody SprintRequestDto sprintRequestDto) {
		SprintDto spr = sprintService.updateSprint(sprintId, sprintRequestDto);

		return new ResponseEntity<SprintDto>(spr, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Sprint", notes = "Servizio rest per eliminare uno sprint", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Eliminazione release", response = SprintDto.class)
	@RequestMapping(value = "/{idSprint}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteSprint(
			@PathVariable(name = "idSprint") @ApiParam(value = "ID sprint", required = true) final int sprintId) {
		sprintService.deleteSprint(sprintId);

		return new ResponseEntity<String>("Sprint eliminato.", HttpStatus.OK);
	}

}