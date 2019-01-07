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
import it.linksmt.teamshare.business.dto.request.StateRequestDto;
import it.linksmt.teamshare.business.dtos.StateDto;
import it.linksmt.teamshare.business.services.StateService;

@RequestMapping(name = "States Controller", value = "/states", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "States Controller", description = "States Controller", tags = { "Stato" })
public class StatesController {

	@Autowired
	private StateService stateService;

	@ApiOperation(value = "Get States", notes = "Servizio rest per visualizzare la lista degli state", response = StateDto.class)
	@ApiResponse(code = 200, message = "Lista States", response = StateDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StateDto>> getState(
			@RequestParam(name = "nome", required = false, defaultValue = "") @ApiParam(value = "Nome state", required = false, defaultValue = "") final String nome) {
		
		List<StateDto> state = null;

		state = stateService.getStates();

		return new ResponseEntity<List<StateDto>>(state, HttpStatus.OK);
	}

	@ApiOperation(value = "Get State", notes = "Servizio rest per visualizzare il dettaglio degli stati", response = StateDto.class)
	@ApiResponse(code = 200, message = "Dettaglio state", response = StateDto.class)
	@RequestMapping(value = "/{idState}", method = RequestMethod.GET)
	public ResponseEntity<StateDto> getState(
			@PathVariable(name = "idState") @ApiParam(value = "ID state", required = true) final int stateId) {
		
		StateDto a = stateService.getState(stateId);

		return new ResponseEntity<StateDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert State", notes = "Servizio rest per aggiungere uno state", response = StateDto.class)
	@ApiResponse(code = 200, message = "Inserimento state", response = StateDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<StateDto> addState(
			@RequestBody StateRequestDto stateRequestDto) {
		
		StateDto a = stateService.addState(stateRequestDto);

		return new ResponseEntity<StateDto>(a, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update State", notes = "Servizio rest per aggiornare uno state", response = StateDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento state", response = StateDto.class)
	@RequestMapping(value = "/{idState}", method = RequestMethod.PUT)
	public ResponseEntity<StateDto> updateState(
			@PathVariable(name = "idState") @ApiParam(value = "ID state", required = true) final int stateId,
			@RequestBody StateRequestDto stateRequestDto) {
		
		StateDto a = stateService.updateState(stateId, stateRequestDto);

		return new ResponseEntity<StateDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete State", notes = "Servizio rest per eliminare uno state", response = StateDto.class)
	@ApiResponse(code = 200, message = "Eliminazione state", response = StateDto.class)
	@RequestMapping(value = "/{idState}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteState(
			@PathVariable(name = "idState") @ApiParam(value = "ID state", required = true) final int stateId) {
		
		stateService.deleteState(stateId);

		return new ResponseEntity<String>("Ok, state deleted.", HttpStatus.OK);
	}

}
