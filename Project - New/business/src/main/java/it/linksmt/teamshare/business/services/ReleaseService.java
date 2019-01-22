package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dtos.ReleaseDto;
import it.linksmt.teamshare.business.request.ReleaseRequestDto;

public interface ReleaseService {
	public List<ReleaseDto> searchRelease();
	public ReleaseDto getRelease(Integer id);
	public ReleaseDto addRelease(ReleaseRequestDto att);
	public ReleaseDto updateRelease(Integer attId, ReleaseRequestDto activity);
	public void deleteRelease(Integer id);
}
