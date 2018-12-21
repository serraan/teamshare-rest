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
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dtos.ImpedimentDto;
import it.linksmt.teamshare.business.dto.request.ImpedimentRequestDto;
import it.linksmt.teamshare.business.services.ImpedimentService;

@Api(value = "Impediment Controller", description = "Impediment Controller", tags = { "Impediment" })
@Controller
@RequestMapping(name = "Impediment Controller",value = "/impediment", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ImpedimentController {

	@Autowired
	ImpedimentService impedimentService;
	
	@ApiOperation(value = "Lista impediment ", notes = "Servizio rest per visualizzare tutti gli impediment", response = ImpedimentDto.class)
	@ApiResponse(code = 200, message = "Lista Impediment", response = ImpedimentDto.class)
	@GetMapping(value="/")
	public ResponseEntity<List<ImpedimentDto>> getImpediments() {
		List<ImpedimentDto> imp = impedimentService.searchImpediments();
		return new ResponseEntity<List<ImpedimentDto>>(imp, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Impediment By Id", notes = "Servizio rest per visualizzare gli impediment tramite gli id", response = ImpedimentDto.class)
	@ApiResponse(code = 200, message = "Utenti By Id", response = ImpedimentDto.class)
	@GetMapping( value="/{idImpediment}")
	public ResponseEntity<ImpedimentDto> getImpediment( @PathVariable(name = "idImpediment",required = true) @ApiParam(value = "idImpediment", required = true) final Integer idImpediment ) {
		ImpedimentDto impediment = new ImpedimentDto();
		impediment = impedimentService.getImpediment(idImpediment);
		return new ResponseEntity<ImpedimentDto>(impediment, HttpStatus.OK);
	}

	@ApiOperation(value = "Aggiungi Impediment", notes = "Servizio rest per aggiungere un impediment", response = ImpedimentDto.class)
	@ApiResponse(code = 200, message = "Aggiungi Impediment", response = ImpedimentDto.class)
	@PostMapping( value="/")
	public ResponseEntity<ImpedimentDto> addImpediment(@RequestBody final ImpedimentRequestDto impediment ) {
		ImpedimentDto u = impedimentService.addImpediment(impediment);
		return new ResponseEntity<ImpedimentDto>(u, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Update Impediment", notes = "Servizio rest per aggiornare un impediment", response = ImpedimentDto.class)
	@ApiResponse(code = 200, message = "Update Impediment", response = ImpedimentDto.class)
	@PutMapping( value="/{idImpediment}")
	public ResponseEntity<ImpedimentDto> updateImpediment(
			@PathVariable(name = "idImpediment") @ApiParam(value = "ID impediment", required = true) final Integer idImpediment, 
			@RequestBody final ImpedimentRequestDto impedimentRequestDto) {
		ImpedimentDto imp = impedimentService.updateImpediment(idImpediment,impedimentRequestDto);
		return new ResponseEntity<ImpedimentDto>(imp, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Impediment", notes = "Servizio rest per cancellare un impediment")
	@ApiResponse(code = 200, message = "Delete Impediment")
	@DeleteMapping( value="/{idImpediment}")
	public void removeImpediment(@PathVariable(name = "idImpediment", required = true) @ApiParam(value = "idImpediment", required = true) final Integer idImpediemnt ) {
		Integer id = null;
			id = idImpediemnt;
		if(id != null) {
			impedimentService.deleteImpediment(id);
		}
	
	}
}
