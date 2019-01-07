package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.ContentTeamConverter;
import it.linksmt.teamshare.business.dto.request.ContentTeamRequestDto;
import it.linksmt.teamshare.business.dtos.ContentTeamDto;
import it.linksmt.teamshare.business.services.ContentTeamService;
import it.linksmt.teamshare.dao.entities.ContentTeam;
import it.linksmt.teamshare.dao.repositories.ContentTeamRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class ContentTeamServiceImpl implements ContentTeamService {

	@Autowired
	private ContentTeamRepository contentTeamRepository;

	@Override
	public List<ContentTeamDto> getContentTeams() {

		List<ContentTeam> contentTeams = (List<ContentTeam>) contentTeamRepository.findAll();
		
		return ContentTeamConverter.MAPPER.toListContentTeamDto(contentTeams);
	}

	@Override
	public ContentTeamDto getContentTeam(Integer contentTeamId) {

		Optional<ContentTeam> contentTeam = contentTeamRepository.findById(contentTeamId);

		return ContentTeamConverter.MAPPER.toContentTeamDto(contentTeam.get());
	}

	@Override
	public ContentTeamDto addContentTeam(ContentTeamRequestDto contentTeamRequestDto) {

		ContentTeam contentTeam = ContentTeamConverter.MAPPER.toContentTeam(contentTeamRequestDto);
		
		contentTeam = contentTeamRepository.save(contentTeam);
		
		return ContentTeamConverter.MAPPER.toContentTeamDto(contentTeam);
	}

	@Override
	public ContentTeamDto updateContentTeam(Integer contentTeamId, ContentTeamRequestDto contentTeamRequestDto) {

		ContentTeam contentTeam = ContentTeamConverter.MAPPER.toContentTeam(contentTeamRequestDto);
		contentTeam.setId(contentTeamId);
		
		contentTeam = contentTeamRepository.save(contentTeam);

		return ContentTeamConverter.MAPPER.toContentTeamDto(contentTeam);
	}

	@Override
	public void deleteContentTeam(Integer contentTeamId) {
		
		contentTeamRepository.deleteById(contentTeamId);
	}
	
}
