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
import it.linksmt.teamshare.business.dto.request.TypeRequestDto;
import it.linksmt.teamshare.business.dtos.TypeDto;
import it.linksmt.teamshare.business.services.TypeService;

@RequestMapping(name = "Types Controller", value = "/types", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Types Controller", description = "Types Controller", tags = { "Tipo" })
public class TypesController {

	@Autowired
	private TypeService TypeService;

	@ApiOperation(value = "Get Types", notes = "Servizio rest per visualizzare la lista degli tipi", response = TypeDto.class)
	@ApiResponse(code = 200, message = "Lista tipi", response = TypeDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TypeDto>> getTypes() {

		List<TypeDto> types = TypeService.getTypes();

		return new ResponseEntity<List<TypeDto>>(types, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Type", notes = "Servizio rest per visualizzare il dettaglio dell'Tipo", response = TypeDto.class)
	@ApiResponse(code = 200, message = "Dettaglio Tipo", response = TypeDto.class)
	@RequestMapping(value = "/{idType}", method = RequestMethod.GET)
	public ResponseEntity<TypeDto> getType(
			@PathVariable(name = "idType") @ApiParam(value = "ID Tipo", required = true) final int TypeId) {

		TypeDto Type = TypeService.getType(TypeId);

		return new ResponseEntity<TypeDto>(Type, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert Type", notes = "Servizio rest per aggiungere un Tipo", response = TypeDto.class)
	@ApiResponse(code = 200, message = "Inserimento Tipo", response = TypeDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TypeDto> addType(@RequestBody TypeRequestDto TypeRequestDto) {

		TypeDto u = TypeService.addType(TypeRequestDto);

		return new ResponseEntity<TypeDto>(u, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update Type", notes = "Servizio rest per aggiornare un Tipo", response = TypeDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento Tipo", response = TypeDto.class)
	@RequestMapping(value = "/{idType}", method = RequestMethod.PUT)
	public ResponseEntity<TypeDto> updateType(
			@PathVariable(name = "idType") @ApiParam(value = "ID Tipo", required = true) final int TypeId,
			@RequestBody TypeRequestDto TypeRequestDto) {

		TypeDto Type = TypeService.updateType(TypeId, TypeRequestDto);

		return new ResponseEntity<TypeDto>(Type, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Type", notes = "Servizio rest per eliminare un Tipo", response = TypeDto.class)
	@ApiResponse(code = 200, message = "Eliminazione Tipo", response = TypeDto.class)
	@RequestMapping(value = "/{idType}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteType(
			@PathVariable(name = "idType") @ApiParam(value = "ID Tipo", required = true) final int TypeId) {

		TypeService.deleteType(TypeId);

		return new ResponseEntity<String>("Ok, Type deleted.", HttpStatus.OK);
	}

}
