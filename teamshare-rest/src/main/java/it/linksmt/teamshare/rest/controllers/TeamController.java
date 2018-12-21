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
import it.linksmt.teamshare.business.dto.request.TeamRequestDto;
import it.linksmt.teamshare.business.dtos.TeamDto;
import it.linksmt.teamshare.business.services.TeamService;

@RequestMapping(name = "Team Controller", value = "/teams", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Team Controller", description = "Team Controller", tags = { "Team" })
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@ApiOperation(value = "Get Teams", notes = "Servizio rest per visualizzare la lista dei team", response = TeamDto.class)
	@ApiResponse(code = 200, message = "Lista Teams", response = TeamDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TeamDto>> getAllTeams(){
		
		List<TeamDto> teams = teamService.getTeams();
		
		return new ResponseEntity<List<TeamDto>>(teams, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Team By Id", notes = "Servizio rest per visualizzare il dettaglio di team", response = TeamDto.class)
	@ApiResponse(code = 200, message = "Dettaglio Team", response = TeamDto.class)
	@RequestMapping(value="/{idTeam}",method = RequestMethod.GET)
	public ResponseEntity<TeamDto> getTeam(@PathVariable(name = "idTeam") @ApiParam(value = "ID team", required = true) final int idTeam){
		
		TeamDto team = teamService.getTeamById(idTeam);
		
		return new ResponseEntity<TeamDto>(team, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Insert Team", notes = "Servizio rest per inserire un team", response = TeamDto.class)
	@ApiResponse(code = 200, message = "Aggiungi Team", response = TeamDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TeamDto> addTeam(@RequestBody TeamRequestDto teamRequestDto){
		
		TeamDto team = teamService.addTeam(teamRequestDto);
		
		return new ResponseEntity<TeamDto>(team, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update Team", notes = "Servizio rest per aggiornare un team", response = TeamDto.class)
	@ApiResponse(code = 200, message = "Aggiorna Team", response = TeamDto.class)
	@RequestMapping(value="/{idTeam}", method = RequestMethod.PUT)
	public ResponseEntity<TeamDto> updateTeam(
			@PathVariable(name = "idTeam") @ApiParam(value = "ID team", required = true) final int idTeam,
			@RequestBody TeamRequestDto teamRequestDto
			){
		TeamDto team = teamService.updateTeam(idTeam, teamRequestDto);
		
		return new ResponseEntity<TeamDto>(team, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete Team", notes = "Servizio rest per eliminare un team", response = TeamDto.class)
	@ApiResponse(code = 200, message = "Elimina Team", response = TeamDto.class)
	@RequestMapping(value="/{idTeam}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteTeam(
			@PathVariable(name = "idTeam") @ApiParam(value = "ID team", required = true) final int idTeam){
		teamService.deleteTeam(idTeam);
		
		return new ResponseEntity<String>("Ok, Team Deleted.", HttpStatus.OK);
	}
}
