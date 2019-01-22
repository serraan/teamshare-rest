package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.SprintConverter;
import it.linksmt.teamshare.business.dto.request.SprintRequestDto;
import it.linksmt.teamshare.business.dtos.SprintDto;
import it.linksmt.teamshare.business.services.SprintService;
import it.linksmt.teamshare.dao.entities.Sprint;
import it.linksmt.teamshare.dao.repositories.SprintRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class SprintServiceImpl implements SprintService {

	@Autowired
	private SprintRepository sprintRepository;

	@Override
	public List<SprintDto> getSprints() {

		List<Sprint> sprints = (List<Sprint>) sprintRepository.findAll();
		
		return SprintConverter.MAPPER.toListSprintDto(sprints);
	}

	@Override
	public SprintDto getSprint(Integer sprintId) {
		
		Optional<Sprint> sprint = sprintRepository.findById(sprintId);

		return SprintConverter.MAPPER.toSprintDto(sprint.get());
	}

	@Override
	public SprintDto addSprint(SprintRequestDto sprintRequestDto) {

		Sprint sprint = SprintConverter.MAPPER.toSprint(sprintRequestDto);
		
		sprint = sprintRepository.save(sprint);
		
		return SprintConverter.MAPPER.toSprintDto(sprint);
	}

	@Override
	public SprintDto updateSprint(Integer sprintId, SprintRequestDto sprintRequestDto) {

		Sprint sprint = SprintConverter.MAPPER.toSprint(sprintRequestDto);
		sprint.setId(sprintId);
		
		sprint = sprintRepository.save(sprint);

		return SprintConverter.MAPPER.toSprintDto(sprint);
	}

	@Override
	public void deleteSprint(Integer sprintId) {

		sprintRepository.deleteById(sprintId);
	}
	
}
