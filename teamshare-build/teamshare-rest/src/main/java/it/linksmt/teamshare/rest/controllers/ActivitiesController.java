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
import it.linksmt.teamshare.business.dto.request.ActivityRequestDto;
import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.services.ActivityService;

@RequestMapping(name = "Attività Controller", value = "/activities", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Attività Controller", description = "Attività Controller", tags = { "Attività" })
public class ActivitiesController {

	@Autowired
	private ActivityService activityService;

	@ApiOperation(value = "Get Attività", notes = "Servizio rest per visualizzare la lista delle attività", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Lista Attività", response = ActivityDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ActivityDto>> getActivities (
			@RequestParam(name = "titolo", required = false, defaultValue = "") @ApiParam(value = "Titolo attività", required = false, defaultValue = "") final String title,
			@RequestParam(name = "descrizione", required = false, defaultValue = "") @ApiParam(value = "Descrizione attività", required = false, defaultValue = "") final String description,
			@RequestParam(name = "tipo", required = false, defaultValue = "") @ApiParam(value = "Tipo attività", required = false, defaultValue = "") final String type,
			@RequestParam(name = "priorita", required = false, defaultValue = "") @ApiParam(value = "Priorità attività", required = false, defaultValue = "") final String priority)
	{
		List<ActivityDto> activities = null;

		if(StringUtils.isEmpty(title) && StringUtils.isEmpty(description) && StringUtils.isEmpty(type) && StringUtils.isEmpty(priority)) {
			activities = activityService.getActivities();
		} else {
			activities = activityService.searchActivities(title, description, type, priority);
		}

		return new ResponseEntity<List<ActivityDto>>(activities, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Attività", notes = "Servizio rest per visualizzare il dettaglio dell'attività", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Dettaglio attività", response = ActivityDto.class)
	@RequestMapping(value="/{idAttivita}", method = RequestMethod.GET)
	public ResponseEntity<ActivityDto> getActivity (
			@PathVariable(name = "idAttivita") @ApiParam(value = "ID attivita", required = true) final int activityId)
	{
		ActivityDto a = activityService.getActivity(activityId);
		
		return new ResponseEntity<ActivityDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert Attività", notes = "Servizio rest per aggiungere un'attività", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Inserimento attività", response = ActivityDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ActivityDto> addActivity (
			@RequestBody ActivityRequestDto activityRequestDto)
	{
		ActivityDto a = activityService.addActivity(activityRequestDto);

		return new ResponseEntity<ActivityDto>(a, HttpStatus.CREATED);
	}


	@ApiOperation(value = "Update Attività", notes = "Servizio rest per aggiornare un'attività", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento attività", response = ActivityDto.class)
	@RequestMapping(value="/{idAttivita}", method = RequestMethod.PUT)
	public ResponseEntity<ActivityDto> updateActivity (
			@PathVariable(name = "idAttivita") @ApiParam(value = "ID attivita", required = true) final int activityId,
			@RequestBody ActivityRequestDto activityRequestDto)
	{
		ActivityDto a = activityService.updateActivity(activityRequestDto);

		return new ResponseEntity<ActivityDto>(a, HttpStatus.OK);
	}


	@ApiOperation(value = "Delete Attività", notes = "Servizio rest per eliminare un'attività", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Eliminazione attività", response = ActivityDto.class)
	@RequestMapping(value="/{idAttivita}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteActivity (
			@PathVariable(name = "idAttivita") @ApiParam(value = "ID attivita", required = true) final int activityId)
	{
		activityService.deleteActivity(activityId);

		return new ResponseEntity<String>("Ok, activity deleted.", HttpStatus.OK);
	}

}