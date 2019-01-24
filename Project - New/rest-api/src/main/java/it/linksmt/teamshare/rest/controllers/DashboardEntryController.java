package it.linksmt.teamshare.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.request.DashboardEntryRequestDto;
import it.linksmt.teamshare.business.services.DashboardEntryService;

@Api(value = "Dashboard Controller", description = "Dashboard Controller", tags = { "Dashboard" })
@Controller
@RequestMapping(name = "Dashboard Controller",value = "/private/dashboard", produces = { MediaType.APPLICATION_JSON_VALUE })
public class DashboardEntryController {

	@Autowired
	DashboardEntryService dashService;	
	
	
	
	@ApiOperation(value = "Lista DashboardEnt", notes = "Servizio rest per visualizzare tutti gli utenti con le relative attività", response = DashboardEntryRequestDto.class)
	@ApiResponse(code = 200, message = "Lista ut", response = DashboardEntryRequestDto.class)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<DashboardEntryRequestDto>> getConts() {
		List<DashboardEntryRequestDto> dashEnt = dashService.searchByActivities();
		return new ResponseEntity<List<DashboardEntryRequestDto>>(dashEnt, HttpStatus.OK);
	}
}
