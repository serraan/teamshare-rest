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
import it.linksmt.teamshare.business.dto.request.ContentRequestDto;
import it.linksmt.teamshare.business.dtos.ContentDto;
import it.linksmt.teamshare.business.services.ContentService;

@RequestMapping(name = "Contents Controller", value = "/contents", produces = { MediaType.APPLICATION_JSON_VALUE })
@Controller
@Api(value = "Contents Controller", description = "Contents Controller", tags = { "Contenuto" })
public class ContentsController {

	@Autowired
	private ContentService contentService;

	@ApiOperation(value = "Get Contents", notes = "Servizio rest per visualizzare la lista dei contenuti", response = ContentDto.class)
	@ApiResponse(code = 200, message = "Lista Contents", response = ContentDto.class)
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ContentDto>> getContents() {
		
		List<ContentDto> contents;

		contents = contentService.getContents();

		return new ResponseEntity<List<ContentDto>>(contents, HttpStatus.OK);
	}

	@ApiOperation(value = "Get Content", notes = "Servizio rest per visualizzare il dettaglio di un contenuto", response = ContentDto.class)
	@ApiResponse(code = 200, message = "Dettaglio contenuto", response = ContentDto.class)
	@RequestMapping(value = "/{idContent}", method = RequestMethod.GET)
	public ResponseEntity<ContentDto> getContent(
			@PathVariable(name = "idContent") @ApiParam(value = "ID content", required = true) final int contentId) {
		
		ContentDto a = contentService.getContent(contentId);

		return new ResponseEntity<ContentDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert Content", notes = "Servizio rest per aggiungere un contenuto", response = ContentDto.class)
	@ApiResponse(code = 200, message = "Inserimento content", response = ContentDto.class)
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ContentDto> addContent(@RequestBody ContentRequestDto contentRequestDto) {
		
		ContentDto a = contentService.addContent(contentRequestDto);

		return new ResponseEntity<ContentDto>(a, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update Content", notes = "Servizio rest per aggiornare un content", response = ContentDto.class)
	@ApiResponse(code = 200, message = "Aggiornamento contenuto", response = ContentDto.class)
	@RequestMapping(value = "/{idContent}", method = RequestMethod.PUT)
	public ResponseEntity<ContentDto> updateContent(
			@PathVariable(name = "idContent") @ApiParam(value = "ID contenuto", required = true) final int contentId,
			@RequestBody ContentRequestDto contentRequestDto) {
		
		ContentDto a = contentService.updateContent(contentId, contentRequestDto);

		return new ResponseEntity<ContentDto>(a, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Content", notes = "Servizio rest per eliminare un contenuto", response = ContentDto.class)
	@ApiResponse(code = 200, message = "Eliminazione content", response = ContentDto.class)
	@RequestMapping(value = "/{idContent}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteContent(
			@PathVariable(name = "idContent") @ApiParam(value = "ID contenuto", required = true) final int contentId) {
		
		contentService.deleteContent(contentId);

		return new ResponseEntity<String>("Ok, content deleted.", HttpStatus.OK);
	}

}
