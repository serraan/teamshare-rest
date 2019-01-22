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
import it.linksmt.teamshare.business.dtos.ImpedimentDto;
import it.linksmt.teamshare.business.dtos.TeamDto;
import it.linksmt.teamshare.business.request.ImpedimentRequestDto;
import it.linksmt.teamshare.business.request.TeamRequestDto;
import it.linksmt.teamshare.business.services.ImpedimentService;


@Api(value = "Impediment Controller", description = "Impediment Controller", tags = { "Impediment" })
@Controller
@RequestMapping(name = "Impediment Controller",value = "/impediments", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ImpedimentController {
	@Autowired
	ImpedimentService impedimentService;
	
	@ApiOperation(value = "Lista Impediments", notes = "Servizio rest per visualizzare tutti gli impediment", response = ImpedimentDto.class)
	@ApiResponse(code = 200, message = "Lista Impediment", response = ImpedimentDto.class)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ImpedimentDto>> getImpediments() {
		List<ImpedimentDto> impediment = impedimentService.getAll();
		return new ResponseEntity<List<ImpedimentDto>>(impediment, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Impediment By Id", notes = "Servizio rest per visualizzare gli impediment tramite l'Id", response = ImpedimentDto.class)
	@ApiResponse(code = 200, message = "Impediment By Id", response = ImpedimentDto.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ImpedimentDto> getImpediment(@PathVariable Integer id) {
		ImpedimentDto impediment = impedimentService.getImpediment(id);
		return new ResponseEntity<ImpedimentDto>(impediment, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Aggiungere un Impediment", notes = "Servizio rest per aggiungere un impediment", response = ImpedimentDto.class)
	@ApiResponse(code = 200, message = "Aggiungere un impediment", response = ImpedimentDto.class)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ImpedimentDto> addTeam(@RequestBody ImpedimentRequestDto impediment) {
		ImpedimentDto i = impedimentService.addImpediment(impediment);
		return new ResponseEntity<ImpedimentDto>(i, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Aggiorna un impediment", notes = "Servizio rest per aggiornare un impediment", response = ImpedimentDto.class)
	@ApiResponse(code = 200, message = "Aggiorna un team", response = ImpedimentDto.class)
	@RequestMapping(value = "/{teamId}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ImpedimentDto> updateTeam(@PathVariable("teamId") int id,@RequestBody ImpedimentRequestDto impediment) {
		ImpedimentDto i = impedimentService.updateTeam(id,impediment);
		return new ResponseEntity<ImpedimentDto>(i, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Cancellare un impediment", notes = "Servizio rest per cancellare un impediment", response = String.class)
	@ApiResponse(code = 200, message = "Cancellare un impediment", response = String.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void removeImpediment(@PathVariable Integer id) {
		if (id != null) {
			impedimentService.deleteImpediment(id);
		}
	}
	
}
