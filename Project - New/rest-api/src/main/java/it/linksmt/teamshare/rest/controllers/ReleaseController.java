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
import it.linksmt.teamshare.business.request.ReleaseRequestDto;
import it.linksmt.teamshare.business.services.ReleaseService;

@Api(value = "Release Controller", description = "Release Controller", tags = { "Release" })
@Controller
@RequestMapping(name = "Release Controller",value = "/private/release", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ReleaseController {

	@Autowired
	private ReleaseService releaseService;
	
	@ApiOperation(value = "Lista Release", notes = "Servizio rest per visualizzare tutte le release", response = ReleaseDto.class)
	@ApiResponse(code = 200, message = "Lista Release", response = ReleaseDto.class)
	@GetMapping(value = "/")
	public ResponseEntity<List<ReleaseDto>> getRelease() {
		List<ReleaseDto> rel = releaseService.searchRelease();
		return new ResponseEntity<List<ReleaseDto>>(rel, HttpStatus.OK);
	}

	@ApiOperation(value = "Release By Id", notes = "Servizio rest per visualizzare la release tramite id", response = ReleaseDto.class)
	@ApiResponse(code = 200, message = "Release By Id", response = ReleaseDto.class)
	@GetMapping(value = "/{releaseId}")
	public ResponseEntity<ReleaseDto> getRelease(@PathVariable Integer releaseId) {
		ReleaseDto rel = new ReleaseDto();
		rel = releaseService.getRelease(releaseId);
		return new ResponseEntity<ReleaseDto>(rel, HttpStatus.OK);
	}

	@ApiOperation(value = "Aggiungere un Release", notes = "Servizio rest per aggiungere un release", response = ReleaseDto.class)
	@ApiResponse(code = 200, message = "Aggiungere un Release", response = ReleaseDto.class)
	@PostMapping(value = "/")
	public ResponseEntity<ReleaseDto> addRelease(@RequestBody ReleaseRequestDto release) {
		ReleaseDto rel = releaseService.addRelease(release);
		return new ResponseEntity<ReleaseDto>(rel, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Aggiorna una Release", notes = "Servizio rest per aggiornare una release", response = ReleaseDto.class)
	@ApiResponse(code = 200, message = "Aggiorna un Release", response = ReleaseDto.class)
	@PutMapping(value = "/{relId}")
	public ResponseEntity<ReleaseDto> updateUser(@PathVariable("relId") int relId,@RequestBody ReleaseRequestDto release) {
		ReleaseDto u = releaseService.updateRelease(relId,release);
		return new ResponseEntity<ReleaseDto>(u, HttpStatus.OK);
	}

	@ApiOperation(value = "Cancellare una release", notes = "Servizio rest per cancellare una release")
	@ApiResponse(code = 200, message = "Cancellare una release")
	@DeleteMapping(value = "/{releaseId}")
	public void removeUser(@PathVariable Integer releaseId) {
		Integer id = releaseId;
		releaseService.deleteRelease(id);
	}
	
}
