package it.linksmt.teamshare.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.dtos.ContentDto;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.ShareEntityRequestDto;
import it.linksmt.teamshare.business.services.ContentService;
import it.linksmt.teamshare.business.services.ShareEntityService;
import it.linksmt.teamshare.business.services.UserService;


@Service
@Transactional
public class ShareEntityServiceImpl implements ShareEntityService{

	@Autowired
	private ContentService contService;
	@Autowired
	private UserService userService;
	
	
	@Override
	public List<ShareEntityRequestDto> findByUser() {
		List<ShareEntityRequestDto> dashEnt = new ArrayList<ShareEntityRequestDto>();
		List<ContentDto> content = contService.getAll();
		for (ContentDto c : content) {
			ShareEntityRequestDto dto = new ShareEntityRequestDto();
			dto.setContent(c);
			UserDto userDto = userService.getUser(c.getIdUtenteCreatore());
			dto.setUser(userDto);
			dashEnt.add(dto);
		}
		return dashEnt;
	}

}
