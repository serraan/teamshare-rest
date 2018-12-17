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
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.request.ActivityRequestDto;
import it.linksmt.teamshare.business.services.ActivityService;

@Api(value = "Activity Controller", description = "Activity Controller", tags = { "Attivita" })
@Controller
@RequestMapping(name = "Activity Controller",value = "/activities", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ActivitiesController {

	@Autowired
	private ActivityService activityService;

	
	@ApiOperation(value = "Lista Attivita", notes = "Servizio rest per visualizzare tutte le attivita", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Lista Attivita", response = ActivityDto.class)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ActivityDto>> getActivities() {
		List<ActivityDto> att = activityService.searchActivity();
		return new ResponseEntity<List<ActivityDto>>(att, HttpStatus.OK);
	}

	@ApiOperation(value = "Attivita By Id", notes = "Servizio rest per visualizzare l'attivita tramite id", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Attivita By Id", response = ActivityDto.class)
	@RequestMapping(value = "/{activityId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ActivityDto> getACtivity(@PathVariable Integer activityId) {
		ActivityDto att = new ActivityDto();
		att = activityService.getActivity(activityId);
		return new ResponseEntity<ActivityDto>(att, HttpStatus.OK);
	}

	@ApiOperation(value = "Aggiungere un Attivita", notes = "Servizio rest per aggiungere un attivita", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Aggiungere un Attivita", response = ActivityDto.class)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ActivityDto> addAttivity(@RequestBody ActivityRequestDto activity) {
		ActivityDto a = activityService.addActivity(activity);
		return new ResponseEntity<ActivityDto>(a, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Aggiorna un Attivita", notes = "Servizio rest per aggiornare un attivita", response = ActivityDto.class)
	@ApiResponse(code = 200, message = "Aggiorna un Attivita", response = ActivityDto.class)
	@RequestMapping(value = "/{attId}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ActivityDto> updateUser(@PathVariable("attId") int attId,@RequestBody ActivityRequestDto activity) {
		ActivityDto u = activityService.updateActivity(attId,activity);
		return new ResponseEntity<ActivityDto>(u, HttpStatus.OK);
	}

	@ApiOperation(value = "Cancellare un attivita", notes = "Servizio rest per cancellare un attivita", response = String.class)
	@ApiResponse(code = 200, message = "Cancellare un attivita", response = String.class)
	@RequestMapping(value = "/{activityId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void removeUser(@PathVariable Integer activityId) {
		Integer id = activityId;
		if (id != null) {
			activityService.deleteActivity(id);
		}
	}
}