package it.linksmt.teamshare.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dto.request.TypeRequestDto;
import it.linksmt.teamshare.business.dtos.TypeDto;
import it.linksmt.teamshare.business.services.TypeService;

@RequestMapping(name = "Type Controller", value = "/types", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Type Controller", description = "Type Controller", tags = { "Type" })
public class TypeController {

	@Autowired
	private TypeService typeService;

	@ApiOperation(value = "Get Types", notes = "Servizio rest per visualizzare la lista dei tipi", response = TypeDto.class)
	@ApiResponse(code = 200, message = "Lista Types", response = TypeDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TypeDto>> getTypes(
			@RequestParam(name = "nome", required = false, defaultValue = "") @ApiParam(value = "Nome tipo", required = false, defaultValue = "") final String nome) {
		List<TypeDto> types = null;

		if (StringUtils.isEmpty(nome)) {
			types = typeService.getTypes();
		} else {
			types = typeService.searchTypes(nome);
		}

		return new ResponseEntity<List<TypeDto>>(types, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Type", notes = "Servizio rest per visualizzare il dettaglio di un tipo", response = TypeDto.class)
	@ApiResponse(code = 200, message = "Dettaglio tipo", response = TypeDto.class)
	@RequestMapping(value = "/{idType}", method = RequestMethod.GET)
	public ResponseEntity<TypeDto> getType(
			@PathVariable(name = "idType") @ApiParam(value = "ID tipo", required = true) final int typeId) {
		TypeDto tp = typeService.getType(typeId);

		return new ResponseEntity<TypeDto>(tp, HttpStatus.OK);
	}

	@ApiOperation(value = "Inserisci Type", notes = "Servizio rest per aggiungere un tipo", response = TypeDto.class)
	@ApiResponse(code = 200, message = "Inserimento tipo", response = TypeDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TypeDto> addType(@RequestBody TypeRequestDto typeRequestDto) {
		TypeDto tp = typeService.addType(typeRequestDto);

		return new ResponseEntity<TypeDto>(tp, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update Type", notes = "Servizio rest per aggiornare un tipo", response = TypeDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento tipo", response = TypeDto.class)
	@RequestMapping(value = "/{idType}", method = RequestMethod.PUT)
	public ResponseEntity<TypeDto> updateType(
			@PathVariable(name = "idType") @ApiParam(value = "ID tipo", required = true) final int typeId,
			@RequestBody TypeRequestDto typeRequestDto) {
		TypeDto tp = typeService.updateType(typeId, typeRequestDto);

		return new ResponseEntity<TypeDto>(tp, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Type", notes = "Servizio rest per eliminare un tipo", response = TypeDto.class)
	@ApiResponse(code = 200, message = "Eliminazione tipo", response = TypeDto.class)
	@RequestMapping(value = "/{idType}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteType(
			@PathVariable(name = "idType") @ApiParam(value = "ID tipo", required = true) final int typeId) {
		typeService.deleteType(typeId);

		return new ResponseEntity<String>("Tipo eliminato.", HttpStatus.OK);
	}

}