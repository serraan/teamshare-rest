package it.linksmt.teamshare.rest.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.dtos.ActivitySprintDto;
import it.linksmt.teamshare.business.dtos.SprintDto;
import it.linksmt.teamshare.business.services.ActivitySprintService;

@RequestMapping(name = "ActivitySprint Controller", value = "/ActivitySprint", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "ActivitySprint Controller", description = "ActivitySprint Controller", tags = { "Team" })
public class ActivitySprintController {

	@Autowired
	private ActivitySprintService activitySprintService;
	
	@ApiOperation(value = "Get ActivitySprintAsMap", notes = "Servizio rest per visualizzare la lista dei team", response = ActivitySprintDto.class)
	@ApiResponse(code = 200, message = "Get ActivitySprintAsMap", response = ActivitySprintDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Map<ActivityDto, List<SprintDto>>> getAllActivitySprintAsMap(){
		
		Map<ActivityDto, List<SprintDto>> activitySprint = activitySprintService.getActivitySprintAsMap();
		
		return new ResponseEntity<Map<ActivityDto, List<SprintDto>>>(activitySprint, HttpStatus.OK);
	}
	
}
