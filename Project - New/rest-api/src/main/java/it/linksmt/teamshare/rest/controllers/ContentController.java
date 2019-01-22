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
import it.linksmt.teamshare.business.dtos.ContentDto;
import it.linksmt.teamshare.business.dtos.TeamDto;
import it.linksmt.teamshare.business.request.ContentRequestDto;
import it.linksmt.teamshare.business.request.TeamRequestDto;
import it.linksmt.teamshare.business.services.ContentService;

@Api(value = "Content Controller", description = "Content Controller", tags = { "Content" })
@Controller
@RequestMapping(name = "Content Controller",value = "/Content", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ContentController {

	@Autowired
	ContentService contService;
	
	
	@ApiOperation(value = "Lista Contents", notes = "Servizio rest per visualizzare tutti i contenuti", response = ContentDto.class)
	@ApiResponse(code = 200, message = "Lista Contenuti", response = ContentDto.class)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ContentDto>> getConts() {
		List<ContentDto> cont = contService.getAll();
		return new ResponseEntity<List<ContentDto>>(cont, HttpStatus.OK);
	}
	
//	@ApiOperation(value = "Content By Titolo", notes = "Servizio rest per visualizzare il contenuto tramite il titolo", response = ContentDto.class)
//	@ApiResponse(code = 200, message = "Contenuto by Titolo", response = ContentDto.class)
//	@RequestMapping(value = "/{titoloCont}", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<ContentDto> getCont(@PathVariable String titoloCont) {
//		ContentDto cont = contService.getCont(titoloCont);
//		return new ResponseEntity<ContentDto>(cont, HttpStatus.OK);
//	}
	
	@ApiOperation(value = "Aggiungere un Contenuto", notes = "Servizio rest per aggiungere un contenuto", response = ContentDto.class)
	@ApiResponse(code = 200, message = "Aggiungere un contenuto", response = ContentDto.class)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ContentDto> addCont(@RequestBody ContentRequestDto cont) {
		ContentDto c = contService.addCont(cont);
		return new ResponseEntity<ContentDto>(c, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Aggiorna un contenuto", notes = "Servizio rest per aggiornare un contenuto", response = ContentDto.class)
	@ApiResponse(code = 200, message = "Aggiorna un contenuto", response = ContentDto.class)
	@RequestMapping(value = "/{contId}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<ContentDto> updateCont(@PathVariable("contId") int contId,@RequestBody ContentRequestDto cont) {
		ContentDto c = contService.updateCont(contId,cont);
		return new ResponseEntity<ContentDto>(c, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Cancellare un contenuto", notes = "Servizio rest per cancellare un contenuto", response = String.class)
	@ApiResponse(code = 200, message = "Cancellare un contenuto", response = String.class)
	@RequestMapping(value = "/{contId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void removeTeam(@PathVariable Integer contId) {
		if (contId != null) {
			contService.deleteCont(contId);
		}
	}

}
