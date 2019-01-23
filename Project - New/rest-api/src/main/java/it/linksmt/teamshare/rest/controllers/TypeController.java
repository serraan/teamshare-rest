package it.linksmt.teamshare.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.dtos.TypeDto;
import it.linksmt.teamshare.business.request.TypeRequestDto;
import it.linksmt.teamshare.business.services.TypeService;

@Api( tags = { "Tipo" } )
@RestController
@RequestMapping( name = "Tipo Controller", value = "/private/stato" )
public class TypeController {

	@Autowired
	private TypeService typeService;

	@ApiOperation( value = "Lista tipi", notes = "Servizio rest per visualizzare tutti i tipi", response = TypeDto.class )
	@ApiResponse( code = 200, message = "Lista tipi", response = TypeDto.class )
	@GetMapping
	public ResponseEntity<List<TypeDto>> getTypes() {
		List<TypeDto> types = new ArrayList<>();
		types = typeService.searchType();
		return new ResponseEntity<List<TypeDto>>( types, HttpStatus.OK );
	}

	@ApiOperation( value = "Tipi By Id", notes = "Servizio rest per visualizzare i tipi tramite gli id", response = TypeDto.class )
	@ApiResponse( code = 200, message = "Tipi By Id", response = TypeDto.class )
	@GetMapping( value = "/{typeId}" )
	public ResponseEntity<TypeDto> getUser(
			@PathVariable( name = "typeId", required = true ) @ApiParam( value = "typeId", required = true ) final Integer typeId ) {
		TypeDto type = new TypeDto();
		type = (TypeDto) typeService.getType( typeId );
		return new ResponseEntity<TypeDto>( type, HttpStatus.OK );
	}

	@ApiOperation( value = "Aggiungi Tipo", notes = "Servizio rest per aggiungere un tipo", response = TypeDto.class )
	@ApiResponse( code = 200, message = "Aggiungi Tipo", response = TypeDto.class )
	@PostMapping
	public ResponseEntity<TypeDto> addUser( @RequestBody final TypeRequestDto type ) {
		TypeDto t = (TypeDto) typeService.addType( type );
		return new ResponseEntity<TypeDto>( t, HttpStatus.CREATED );
	}

	@ApiOperation( value = "Update Tipo", notes = "Servizio rest per aggiornare un tipo", response = TypeDto.class )
	@ApiResponse( code = 200, message = "Update Tipo", response = TypeDto.class )
	@PutMapping( "/{typeId}" )
	public ResponseEntity<TypeDto> updateUser( @PathVariable( "typeId" ) int typeId, @RequestBody final TypeRequestDto type ) {
		TypeDto t = (TypeDto) typeService.updateType( typeId, type );
		return new ResponseEntity<TypeDto>( t, HttpStatus.OK );
	}

	@ApiOperation( value = "Delete Tipo", notes = "Servizio rest per cancellare un tipo" )
	@ApiResponse( code = 204, message = "Delete Tipo" )
	@DeleteMapping( "/{typeId}" )
	public void removeUser( @PathVariable( name = "typeId", required = true ) @ApiParam( value = "typeId", required = true ) final Integer typeId ) {
		Integer id = null;
		id = typeId;
		if (id != null) {
			typeService.deleteType( typeId );
		}
	}
}
