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
import it.linksmt.teamshare.business.dto.request.ActivityStateRequestDto;
import it.linksmt.teamshare.business.dtos.ActivityStateDto;
import it.linksmt.teamshare.business.services.ActivityStateService;

@RequestMapping(name = "ActivityStatees Controller", value = "/activityStatees", produces = {
		MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "ActivityStatees Controller", description = "ActivityStatees Controller", tags = { "Attività" })
public class ActivityStatesController {

	@Autowired
	private ActivityStateService activityStateService;

	@ApiOperation(value = "Get ActivityStatees", notes = "Servizio rest per visualizzare la lista degli ActivityStatees", response = ActivityStateDto.class)
	@ApiResponse(code = 200, message = "Lista ActivityStatees", response = ActivityStateDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ActivityStateDto>> getActivityStates() {

		List<ActivityStateDto> activityStatees;

		activityStatees = activityStateService.getActivityStates();

		return new ResponseEntity<List<ActivityStateDto>>(activityStatees, HttpStatus.OK);
	}

	@ApiOperation(value = "Get ActivityState", notes = "Servizio rest per visualizzare il dettaglio dell'attività", response = ActivityStateDto.class)
	@ApiResponse(code = 200, message = "Dettaglio attività", response = ActivityStateDto.class)
	@RequestMapping(value = "/{idActivityState}", method = RequestMethod.GET)
	public ResponseEntity<ActivityStateDto> getActivityState(
			@PathVariable(name = "idActivityState") @ApiParam(value = "ID attivitaStati", required = true) final int activityStateId) {

		ActivityStateDto a = activityStateService.getActivityState(activityStateId);

		return new ResponseEntity<ActivityStateDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert ActivityState", notes = "Servizio rest per aggiungere un'attività", response = ActivityStateDto.class)
	@ApiResponse(code = 200, message = "Inserimento attività", response = ActivityStateDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ActivityStateDto> addActivityState(
			@RequestBody ActivityStateRequestDto activityStateRequestDto) {

		ActivityStateDto a = activityStateService.addActivityState(activityStateRequestDto);

		return new ResponseEntity<ActivityStateDto>(a, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update ActivityState", notes = "Servizio rest per aggiornare un'attività", response = ActivityStateDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento attività", response = ActivityStateDto.class)
	@RequestMapping(value = "/{idActivityState}", method = RequestMethod.PUT)
	public ResponseEntity<ActivityStateDto> updateActivityState(
			@PathVariable(name = "idActivityState") @ApiParam(value = "ID attivitaStati", required = true) final int activityStateId,
			@RequestBody ActivityStateRequestDto activityStateRequestDto) {

		ActivityStateDto a = activityStateService.updateActivityState(activityStateId, activityStateRequestDto);

		return new ResponseEntity<ActivityStateDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete ActivityState", notes = "Servizio rest per eliminare un'attività", response = ActivityStateDto.class)
	@ApiResponse(code = 200, message = "Eliminazione attività", response = ActivityStateDto.class)
	@RequestMapping(value = "/{idActivityState}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteActivityState(
			@PathVariable(name = "idActivityState") @ApiParam(value = "ID attivitaStati", required = true) final int activityStateId) {

		activityStateService.deleteActivityState(activityStateId);

		return new ResponseEntity<String>("Ok, activityState deleted.", HttpStatus.OK);
	}

}