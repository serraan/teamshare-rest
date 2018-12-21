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
import it.linksmt.teamshare.business.dtos.StateDto;
import it.linksmt.teamshare.business.services.StateService;

@RequestMapping(name = "State Controller", value = "/states", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "State Controller", description = "State Controller", tags = { "State" })
public class StateController {
	
	@Autowired 
	private StateService stateService; 
	
	@ApiOperation(value = "Get States", notes = "Servizio rest per visualizzare la lista di stati", response = StateDto.class)
	@ApiResponse(code = 200, message = "Lista stati", response = StateDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StateDto>> getStates (){
		List<StateDto> stateDtos = null;

		stateDtos = stateService.getStates();
		
		return new ResponseEntity<List<StateDto>>(stateDtos, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get State", notes = "Servizio rest per visualizzare il dettaglio dello stato", response = StateDto.class)
	@ApiResponse(code = 200, message = "Dettaglio stato", response = StateDto.class)
	@RequestMapping(value="/{idStateDto}", method = RequestMethod.GET)
	public ResponseEntity<StateDto> getState (
			@PathVariable(name = "idStateDto") @ApiParam(value = "ID stato", required = true) final int stateId)
	{
		StateDto stateDto = stateService.getState(stateId);
		
		return new ResponseEntity<StateDto>(stateDto, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Insert State", notes = "Servizio rest per aggiungere uno stato", response = StateDto.class)
	@ApiResponse(code = 200, message = "Inserimento stato", response = StateDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<StateDto> addState (
			@RequestBody StateDto stateDto)
	{
		StateDto sDto = stateService.addState(stateDto);

		return new ResponseEntity<StateDto>(sDto, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update State", notes = "Servizio rest per aggiornare uno stato", response = StateDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento stato", response = StateDto.class)
	@RequestMapping(value="/{idState}", method = RequestMethod.PUT)
	public ResponseEntity<StateDto> updateState (
			@PathVariable(name = "idState") @ApiParam(value = "ID stato", required = true) final int idState,
			@RequestBody StateDto stateDto)
	{
		StateDto s = stateService.updateState(idState, stateDto);

		return new ResponseEntity<StateDto>(s, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete State", notes = "Servizio rest per eliminare uno stato", response = StateDto.class)
	@ApiResponse(code = 200, message = "Eliminazione stato", response = StateDto.class)
	@RequestMapping(value="/{idState}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteState (
			@PathVariable(name = "idState") @ApiParam(value = "ID stato", required = true) final int idState)
	{
		stateService.deleteState(idState);

		return new ResponseEntity<String>("Ok, activity deleted.", HttpStatus.OK);
	}


}
