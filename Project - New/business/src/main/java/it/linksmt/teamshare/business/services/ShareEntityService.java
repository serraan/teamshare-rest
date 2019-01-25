package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.request.ShareEntityRequestDto;

public interface ShareEntityService {

	public List<ShareEntityRequestDto> findByUser();
}
