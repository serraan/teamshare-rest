package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.SprintRequestDto;
import it.linksmt.teamshare.business.dtos.SprintDto;

public interface SprintService {
	public List<SprintDto> searchSprints(String nomeSprint);

	public List<SprintDto> getSprints();

	public SprintDto getSprint(Integer id);

	public SprintDto addSprint(SprintRequestDto sprintRequestDto);

	public SprintDto updateSprint(Integer id, SprintRequestDto sprintRequestDto);

	public void deleteSprint(Integer id);
}
