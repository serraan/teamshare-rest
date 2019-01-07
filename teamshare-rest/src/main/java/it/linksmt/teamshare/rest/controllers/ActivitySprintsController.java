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
import it.linksmt.teamshare.business.dto.request.ActivitySprintRequestDto;
import it.linksmt.teamshare.business.dtos.ActivitySprintDto;
import it.linksmt.teamshare.business.services.ActivitySprintService;

@RequestMapping(name = "ActivitySprints Controller", value = "/activitiesSprints", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "ActivitySprints Controller", description = "ActivitySprints Controller", tags = { "Attivit‡Sprint" })
public class ActivitySprintsController {

	@Autowired
	private ActivitySprintService activitySprintService;

	@ApiOperation(value = "Get ActivitySprints", notes = "Servizio rest per visualizzare la lista degli ActivitySprints", response = ActivitySprintDto.class)
	@ApiResponse(code = 200, message = "Lista ActivitySprints", response = ActivitySprintDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ActivitySprintDto>> getActivities(){

		List<ActivitySprintDto> activitiesSprint;

		activitiesSprint = activitySprintService.getActivities();

		return new ResponseEntity<List<ActivitySprintDto>>(activitiesSprint, HttpStatus.OK);
	}	

	@ApiOperation(value = "Get ActivitySprint", notes = "Servizio rest per visualizzare il dettaglio del ActivitySprint", response = ActivitySprintDto.class)
	@ApiResponse(code = 200, message = "Dettaglio attivit‡ e sprint", response = ActivitySprintDto.class)
	@RequestMapping(value = "/{idActivitySprint}", method = RequestMethod.GET)
	public ResponseEntity<ActivitySprintDto> getActivitySprint(
			@PathVariable(name = "idActivitySprint") @ApiParam(value = "ID attivita", required = true) final int activitySprintId) {

		ActivitySprintDto a = activitySprintService.getActivitySprint(activitySprintId);

		return new ResponseEntity<ActivitySprintDto>(a, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Insert ActivitySprint", notes = "Servizio rest per aggiungere un ActivitySprint", response = ActivitySprintDto.class)
	@ApiResponse(code = 200, message = "Inserimento attivit‡/sprint", response = ActivitySprintDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ActivitySprintDto> addActivitySprint(@RequestBody ActivitySprintRequestDto activitySprintRequestDto) {
		
		ActivitySprintDto a = activitySprintService.addActivitySprint(activitySprintRequestDto);

		return new ResponseEntity<ActivitySprintDto>(a, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update ActivitySprint", notes = "Servizio rest per aggiornare un ActivitySprint", response = ActivitySprintDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento attivit‡", response = ActivitySprintDto.class)
	@RequestMapping(value = "/{idActivitySprint}", method = RequestMethod.PUT)
	public ResponseEntity<ActivitySprintDto> updateActivitySprint(
			@PathVariable(name = "idActivitySprint") @ApiParam(value = "ID attivitasprint", required = true) final int activitySprintId,
			@RequestBody ActivitySprintRequestDto activitySprintRequestDto) {
		
		ActivitySprintDto a = activitySprintService.updateActivitySprint(activitySprintId, activitySprintRequestDto);

		return new ResponseEntity<ActivitySprintDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete ActivitySprint", notes = "Servizio rest per eliminare un ActivitySprint", response = ActivitySprintDto.class)
	@ApiResponse(code = 200, message = "Eliminazione attivit‡ sprint", response = ActivitySprintDto.class)
	@RequestMapping(value = "/{idActivitySprint}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteActivitySprint(
			@PathVariable(name = "idActivitySprint") @ApiParam(value = "ID attivita", required = true) final int activitySprintId) {
		
		activitySprintService.deleteActivitySprint(activitySprintId);

		return new ResponseEntity<String>("Ok, activity sprint deleted.", HttpStatus.OK);
	}

}
