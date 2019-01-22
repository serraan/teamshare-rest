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
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dto.request.ActivityRequestDto;
import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.services.ActivityService;

@RequestMapping(name = "Activities Controller", value = "/activities", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Activities Controller", description = "Activities Controller", tags = { "Attività" })
public class ActivitiesController {

	@Autowired
	private ActivityService activityService;

	@ApiOperation(value = "Get Activities", notes = "Servizio rest per visualizzare la lista delle attività", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Lista Attività", response = ActivityDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ActivityDto>> getActivities(
			@RequestParam(name = "tipo", required = false, defaultValue = "") @ApiParam(value = "Tipo attività", required = false, defaultValue = "") final String tipo) {
		
		List<ActivityDto> activities = activityService.getActivities();

		return new ResponseEntity<List<ActivityDto>>(activities, HttpStatus.OK);
	}	

	@ApiOperation(value = "Get Activity", notes = "Servizio rest per visualizzare il dettaglio dell'attività", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Dettaglio attività", response = ActivityDto.class)
	@RequestMapping(value = "/{idActivity}", method = RequestMethod.GET)
	public ResponseEntity<ActivityDto> getActivity(
			@PathVariable(name = "idActivity") @ApiParam(value = "ID attivita", required = true) final int activityId) {
		
		ActivityDto a = activityService.getActivity(activityId);

		return new ResponseEntity<ActivityDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert Activity", notes = "Servizio rest per aggiungere un'attività", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Inserimento attività", response = ActivityDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ActivityDto> addActivity(@RequestBody ActivityRequestDto activityRequestDto) {
		
		ActivityDto a = activityService.addActivity(activityRequestDto);

		return new ResponseEntity<ActivityDto>(a, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update Activity", notes = "Servizio rest per aggiornare un'attività", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento attività", response = ActivityDto.class)
	@RequestMapping(value = "/{idActivity}", method = RequestMethod.PUT)
	public ResponseEntity<ActivityDto> updateActivity(
			@PathVariable(name = "idActivity") @ApiParam(value = "ID attivita", required = true) final int activityId,
			@RequestBody ActivityRequestDto activityRequestDto) {
		
		ActivityDto a = activityService.updateActivity(activityId, activityRequestDto);

		return new ResponseEntity<ActivityDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Activity", notes = "Servizio rest per eliminare un'attività", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Eliminazione attività", response = ActivityDto.class)
	@RequestMapping(value = "/{idActivity}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteActivity(
			@PathVariable(name = "idActivity") @ApiParam(value = "ID attivita", required = true) final int activityId) {
		
		activityService.deleteActivity(activityId);

		return new ResponseEntity<String>("Ok, activity deleted.", HttpStatus.OK);
	}

}