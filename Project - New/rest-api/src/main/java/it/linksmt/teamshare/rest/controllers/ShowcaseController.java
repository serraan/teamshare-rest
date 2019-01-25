package it.linksmt.teamshare.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import it.linksmt.teamshare.business.request.ShowcaseRequestDto;
import it.linksmt.teamshare.business.services.ShowcaseService;

@Api(value = "Showcase Controller", description = "Showcase Controller", tags = { "Showcase" })
@Controller
@RequestMapping(name = "Showcase Controller",value = "/private/showcase", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ShowcaseController {
	
	@Autowired
	ShowcaseService showcaseService;
	
	@ApiOperation(value = "Showcase view", notes = "Servizio rest per visualizzare tutti gli utenti", response = ShowcaseRequestDto.class)
	@ApiResponse(code = 200, message = "Showcase view", response = ShowcaseRequestDto.class)
	@GetMapping(value="/")
	public ResponseEntity<List<ShowcaseRequestDto>> getShowcaseView() {
		List<ShowcaseRequestDto> showcase = showcaseService.getShowcase();
		return new ResponseEntity<List<ShowcaseRequestDto>>(showcase, HttpStatus.OK);
	}

}
