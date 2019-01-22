package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dtos.SprintDto;
import it.linksmt.teamshare.business.request.SprintRequestDto;

public interface SprintService {
	
	public List<SprintDto> searchSprint();
	public SprintDto getSprint(Integer id);
	public SprintDto addSprint(SprintRequestDto att);
	public SprintDto updateSprint(Integer attId, SprintRequestDto activity);
	public void deleteSprint(Integer id);
}
