package it.linksmt.teamshare.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dtos.ReleaseDto;
import it.linksmt.teamshare.business.dtos.SprintDto;
import it.linksmt.teamshare.business.request.SprintRequestDto;
import it.linksmt.teamshare.business.services.SprintService;

@Api(value = "Sprint Controller", description = "Sprint Controller", tags = { "Sprint" })
@Controller
@RequestMapping(name = "Sprint Controller",value = "/private/sprint", produces = { MediaType.APPLICATION_JSON_VALUE })
public class SprintController {
	@Autowired
	private SprintService sprintService;
	
	@ApiOperation(value = "Lista Sprint", notes = "Servizio rest per visualizzare tutte le Sprint", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Lista Sprint", response = ReleaseDto.class)
	@GetMapping(value = "/")
	public ResponseEntity<List<SprintDto>> getRelease() {
		List<SprintDto> rel = sprintService.searchSprint();
		return new ResponseEntity<List<SprintDto>>(rel, HttpStatus.OK);
	}

	@ApiOperation(value = "Sprint By Id", notes = "Servizio rest per visualizzare la sprint tramite id", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Sprint By Id", response = ReleaseDto.class)
	@GetMapping(value = "/{sprintId}")
	public ResponseEntity<SprintDto> getRelease(@PathVariable Integer sprintId) {
		SprintDto rel = new SprintDto();
		rel = sprintService.getSprint(sprintId);
		return new ResponseEntity<SprintDto>(rel, HttpStatus.OK);
	}

	@ApiOperation(value = "Aggiungere un Sprint", notes = "Servizio rest per aggiungere un sprint", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Aggiungere uno sprint", response = SprintDto.class)
	@PostMapping(value = "/")
	public ResponseEntity<SprintDto> addSprint(@RequestBody SprintRequestDto sprint) {
		SprintDto rel = sprintService.addSprint(sprint);
		return new ResponseEntity<SprintDto>(rel, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Aggiorna una sprint", notes = "Servizio rest per aggiornare una sprint", response = SprintDto.class)
	@ApiResponse(code = 200, message = "Aggiorna uno Sprint", response = SprintDto.class)
	@PutMapping(value = "/{sprId}")
	public ResponseEntity<SprintDto> updateUser(@PathVariable("sprId") int sprId,@RequestBody SprintRequestDto sprint) {
		SprintDto u = sprintService.updateSprint(sprId,sprint);
		return new ResponseEntity<SprintDto>(u, HttpStatus.OK);
	}

	@ApiOperation(value = "Cancellare una release", notes = "Servizio rest per cancellare una release")
	@ApiResponse(code = 200, message = "Cancellare una release")
	@DeleteMapping(value = "/{releaseId}")
	public void removeUser(@PathVariable Integer releaseId) {
		Integer id = releaseId;
		sprintService.deleteSprint(id);
	}
}
