package it.linksmt.teamshare.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import it.linksmt.teamshare.business.request.ShareEntityRequestDto;
import it.linksmt.teamshare.business.services.ShareEntityService;

@Api(tags = {"Share"} )
@RestController
@RequestMapping(value = "private/share")
public class ShareEntityController {

	@Autowired
	ShareEntityService shareService;
	
	@GetMapping(value = "/")
	public ResponseEntity<List<ShareEntityRequestDto>> getConts() {
		List<ShareEntityRequestDto> dashEnt = shareService.findByUser();
		return new ResponseEntity<List<ShareEntityRequestDto>>(dashEnt, HttpStatus.OK);
	}
}
