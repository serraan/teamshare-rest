package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.ContentTeamRequestDto;
import it.linksmt.teamshare.business.dtos.ContentTeamDto;

public interface ContentTeamService {

	public List<ContentTeamDto> getContentTeams();

	public ContentTeamDto getContentTeam(Integer id);

	public ContentTeamDto addContentTeam(ContentTeamRequestDto contentTeamRequestDto);

	public ContentTeamDto updateContentTeam(Integer contentTeamId, ContentTeamRequestDto contentTeamRequestDto);

	public void deleteContentTeam(Integer id);
	
}
