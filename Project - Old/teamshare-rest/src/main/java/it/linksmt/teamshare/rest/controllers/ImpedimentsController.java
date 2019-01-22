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
import it.linksmt.teamshare.business.dto.request.ImpedimentRequestDto;
import it.linksmt.teamshare.business.dtos.ImpedimentDto;
import it.linksmt.teamshare.business.services.ImpedimentService;

@RequestMapping(name = "Impediments Controller", value = "/impediments", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Impediments Controller", description = "Impediments Controller", tags = { "Impediment" })
public class ImpedimentsController {

	@Autowired
	private ImpedimentService impedimentService;

	@ApiOperation(value = "Get Impediments", notes = "Servizio rest per visualizzare gli impediment di un'attività", response = ImpedimentDto.class)
	@ApiResponse(code = 200, message = " Lista Impediments", response = ImpedimentDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ImpedimentDto>> getImpediments() {
		
		List<ImpedimentDto> impediments = null;

		impediments = impedimentService.getImpediments();

		return new ResponseEntity<List<ImpedimentDto>>(impediments, HttpStatus.OK);
	}
	
	// TODO getImpediment(id)
	
	@ApiOperation(value = "Get Impediment", notes = "Servizio rest per visualizzare il dettaglio di un impediment", response = ImpedimentDto.class)
	@ApiResponse(code = 200, message = "Dettaglio impediment", response = ImpedimentDto.class)
	@RequestMapping(value = "/{idImpediment}", method = RequestMethod.GET)
	public ResponseEntity<ImpedimentDto> getImpediment(
			@PathVariable(name = "idImpediment") @ApiParam(value = "ID impediment", required = true) final int impedimentId) {
		
		ImpedimentDto imp = impedimentService.getImpediment(impedimentId);

		return new ResponseEntity<ImpedimentDto>(imp, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Insert Impediment", notes = "Servizio rest per aggiungere un impediment", response = ImpedimentDto.class)
	@ApiResponse(code = 200, message = "Inserimento impediment", response = ImpedimentDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ImpedimentDto> addImpediment(@RequestBody ImpedimentRequestDto impedimentRequestDto) {

		ImpedimentDto imp = impedimentService.addImpediment(impedimentRequestDto);

		return new ResponseEntity<ImpedimentDto>(imp, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update Impediment", notes = "Servizio rest per aggiornare un impediment", response = ImpedimentDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento impediment", response = ImpedimentDto.class)
	@RequestMapping(value = "/{idImpediment}", method = RequestMethod.PUT)
	public ResponseEntity<ImpedimentDto> updateImpediment(
			@PathVariable(name = "idImpediment") @ApiParam(value = "ID impediment", required = true) final int impedimentId,
			@RequestBody ImpedimentRequestDto impedimentRequestDto) {
		
		ImpedimentDto imp = impedimentService.updateImpediment(impedimentId, impedimentRequestDto);

		return new ResponseEntity<ImpedimentDto>(imp, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Impediment", notes = "Servizio rest per eliminare un impediment", response = ImpedimentDto.class)
	@ApiResponse(code = 200, message = "Eliminazione impediment", response = ImpedimentDto.class)
	@RequestMapping(value = "/{idImpediment}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteNote(
			@PathVariable(name = "idImpediment") @ApiParam(value = "ID impediment", required = true) final int impedimentId) {
		
		impedimentService.deleteImpediment(impedimentId);

		return new ResponseEntity<String>("Ok, impediment deleted.", HttpStatus.OK);
	}

}
