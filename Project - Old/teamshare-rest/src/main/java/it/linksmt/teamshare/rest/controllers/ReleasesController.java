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
import it.linksmt.teamshare.business.dto.request.ReleaseRequestDto;
import it.linksmt.teamshare.business.dtos.ReleaseDto;
import it.linksmt.teamshare.business.services.ReleaseService;

@RequestMapping(name = "Releases Controller", value = "/releases", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Releases Controller", description = "Releases Controller", tags = { "Release" })
public class ReleasesController {

	@Autowired
	private ReleaseService releaseService;

	@ApiOperation(value = "Get Releases", notes = "Servizio rest per visualizzare la lista delle release", response = ReleaseDto.class)
	@ApiResponse(code = 200, message = "Lista Releases", response = ReleaseDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ReleaseDto>> getRelease(
			@RequestParam(name = "nome", required = false, defaultValue = "") @ApiParam(value = "Nome release", required = false, defaultValue = "") final String nome) {
		
		List<ReleaseDto> release = null;

		release = releaseService.getReleases();

		return new ResponseEntity<List<ReleaseDto>>(release, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Release", notes = "Servizio rest per visualizzare il dettaglio delle release", response = ReleaseDto.class)
	@ApiResponse(code = 200, message = "Dettaglio release", response = ReleaseDto.class)
	@RequestMapping(value = "/{idRelease}", method = RequestMethod.GET)
	public ResponseEntity<ReleaseDto> getRelease(
			@PathVariable(name = "idRelease") @ApiParam(value = "ID release", required = true) final int releaseId) {
		
		ReleaseDto a = releaseService.getRelease(releaseId);

		return new ResponseEntity<ReleaseDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert Release", notes = "Servizio rest per aggiungere una release", response = ReleaseDto.class)
	@ApiResponse(code = 200, message = "Inserimento release", response = ReleaseDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ReleaseDto> addRelease(
			@RequestBody ReleaseRequestDto releaseRequestDto) {
		
		ReleaseDto a = releaseService.addRelease(releaseRequestDto);

		return new ResponseEntity<ReleaseDto>(a, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update Release", notes = "Servizio rest per aggiornare una release", response = ReleaseDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento release", response = ReleaseDto.class)
	@RequestMapping(value = "/{idRelease}", method = RequestMethod.PUT)
	public ResponseEntity<ReleaseDto> updateRelease(
			@PathVariable(name = "idRelease") @ApiParam(value = "ID release", required = true) final int releaseId,
			@RequestBody ReleaseRequestDto releaseRequestDto) {
		
		ReleaseDto a = releaseService.updateRelease(releaseId, releaseRequestDto);

		return new ResponseEntity<ReleaseDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Release", notes = "Servizio rest per eliminare una release", response = ReleaseDto.class)
	@ApiResponse(code = 200, message = "Eliminazione release", response = ReleaseDto.class)
	@RequestMapping(value = "/{idRelease}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteRelease(
			@PathVariable(name = "idRelease") @ApiParam(value = "ID release", required = true) final int releaseId) {
		
		releaseService.deleteRelease(releaseId);

		return new ResponseEntity<String>("Ok, release deleted.", HttpStatus.OK);
	}

}
