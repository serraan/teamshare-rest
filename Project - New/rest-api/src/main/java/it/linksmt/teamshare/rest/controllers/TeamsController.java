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
import it.linksmt.teamshare.business.dtos.TeamDto;
import it.linksmt.teamshare.business.request.TeamRequestDto;
import it.linksmt.teamshare.business.services.TeamService;

@Api(value = "Team Controller", description = "Team Controller", tags = { "Team" })
@Controller
@RequestMapping(name = "Team Controller",value = "/private/teams", produces = { MediaType.APPLICATION_JSON_VALUE })
public class TeamsController {
	@Autowired
	TeamService teamService;
	
	@ApiOperation(value = "Lista Teams", notes = "Servizio rest per visualizzare tutti i team", response = TeamDto.class)
	@ApiResponse(code = 200, message = "Lista Team", response = TeamDto.class)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<TeamDto>> getTeams() {
		List<TeamDto> team = teamService.getAll();
		return new ResponseEntity<List<TeamDto>>(team, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Team By Name", notes = "Servizio rest per visualizzare il team tramite il nome", response = TeamDto.class)
	@ApiResponse(code = 200, message = "Team By Name", response = TeamDto.class)
	@RequestMapping(value = "/{nomeTeam}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<TeamDto> getTeam(@PathVariable String nomeTeam) {
		TeamDto team = teamService.getTeam(nomeTeam.toLowerCase());
		return new ResponseEntity<TeamDto>(team, HttpStatus.OK);
	}
	@ApiOperation(value = "Aggiungere un Team", notes = "Servizio rest per aggiungere un team", response = TeamDto.class)
	@ApiResponse(code = 200, message = "Aggiungere un team", response = TeamDto.class)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<TeamDto> addTeam(@RequestBody TeamRequestDto team) {
		TeamDto t = teamService.addTeam(team);
		return new ResponseEntity<TeamDto>(t, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Aggiorna un team", notes = "Servizio rest per aggiornare un team", response = TeamDto.class)
	@ApiResponse(code = 200, message = "Aggiorna un team", response = TeamDto.class)
	@RequestMapping(value = "/{teamId}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<TeamDto> updateTeam(@PathVariable("teamId") int teamId,@RequestBody TeamRequestDto team) {
		TeamDto t = teamService.updateTeam(teamId,team);
		return new ResponseEntity<TeamDto>(t, HttpStatus.OK);
	}

	@ApiOperation(value = "Cancellare un team", notes = "Servizio rest per cancellare un team", response = String.class)
	@ApiResponse(code = 200, message = "Cancellare un team", response = String.class)
	@RequestMapping(value = "/{teamId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void removeTeam(@PathVariable Integer teamId) {
		if (teamId != null) {
			teamService.deleteTeam(teamId);
		}
	}
}
