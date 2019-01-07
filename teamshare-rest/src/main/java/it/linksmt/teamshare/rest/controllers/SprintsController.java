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
import it.linksmt.teamshare.business.dto.request.SprintRequestDto;
import it.linksmt.teamshare.business.dtos.SprintDto;
import it.linksmt.teamshare.business.services.SprintService;

@RequestMapping(name = "Sprints Controller", value = "/sprints", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Sprints Controller", description = "Sprints Controller", tags = { "Sprint" })
public class SprintsController {

	@Autowired
	private SprintService sprintService;

	@ApiOperation(value = "Get Sprints", notes = "Servizio rest per visualizzare la lista degli sprint", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Lista Sprints", response = SprintDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SprintDto>> getSprint() {

		List<SprintDto> sprint = null;

		sprint = sprintService.getSprints();

		return new ResponseEntity<List<SprintDto>>(sprint, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Sprint", notes = "Servizio rest per visualizzare il dettaglio degli sprint", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Dettaglio sprint", response = SprintDto.class)
	@RequestMapping(value = "/{idSprint}", method = RequestMethod.GET)
	public ResponseEntity<SprintDto> getSprint(
			@PathVariable(name = "idSprint") @ApiParam(value = "ID sprint", required = true) final int sprintId) {
		
		SprintDto a = sprintService.getSprint(sprintId);

		return new ResponseEntity<SprintDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert Sprint", notes = "Servizio rest per aggiungere uno sprint", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Inserimento sprint", response = SprintDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SprintDto> addSprint(@RequestBody SprintRequestDto sprintRequestDto) {
		
		SprintDto a = sprintService.addSprint(sprintRequestDto);

		return new ResponseEntity<SprintDto>(a, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update Sprint", notes = "Servizio rest per aggiornare uno sprint", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento sprint", response = SprintDto.class)
	@RequestMapping(value = "/{idSprint}", method = RequestMethod.PUT)
	public ResponseEntity<SprintDto> updateSprint(
			@PathVariable(name = "idSprint") @ApiParam(value = "ID sprint", required = true) final int sprintId,
			@RequestBody SprintRequestDto sprintRequestDto) {
		
		SprintDto a = sprintService.updateSprint(sprintId, sprintRequestDto);

		return new ResponseEntity<SprintDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Sprint", notes = "Servizio rest per eliminare uno sprint", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Eliminazione sprint", response = SprintDto.class)
	@RequestMapping(value = "/{idSprint}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteSprint(
			@PathVariable(name = "idSprint") @ApiParam(value = "ID sprint", required = true) final int sprintId) {
		
		sprintService.deleteSprint(sprintId);

		return new ResponseEntity<String>("Ok, sprint deleted.", HttpStatus.OK);
	}

}
