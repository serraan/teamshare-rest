package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.dtos.SprintDto;
import it.linksmt.teamshare.business.request.SprintRequestDto;
import it.linksmt.teamshare.business.services.SprintService;
import it.linksmt.teamshare.converter.SprintConverter;
import it.linksmt.teamshare.entities.Sprint;
import it.linksmt.teamshare.repository.SprintRepository;
@Service
@Transactional
public class SprintServiceImpl implements SprintService {

	@Autowired
	private SprintRepository sprintRepository;
	
	@Override
	public List<SprintDto> searchSprint() {
		List<Sprint> spr = (List<Sprint>) sprintRepository.findAll();
		return SprintConverter.MAPPER.toListSprintDTO(spr);
	}

	@Override
	public SprintDto getSprint(Integer id) {
		Optional<Sprint> att = sprintRepository.findById(id);
		return SprintConverter.MAPPER.toSprintDto(att.get());
	}

	@Override
	public SprintDto addSprint(SprintRequestDto spr) {
		Sprint a = SprintConverter.MAPPER.toSprint(spr);
		a = sprintRepository.save(a);
		return SprintConverter.MAPPER.toSprintDto(a);
	}

	@Override
	public SprintDto updateSprint(Integer sprId, SprintRequestDto sprint) {
		Sprint a = SprintConverter.MAPPER.toSprint(sprint);
		a.setId(sprId);
		a = sprintRepository.save(a);
		return SprintConverter.MAPPER.toSprintDto(a);
	}

	@Override
	public void deleteSprint(Integer id) {
		sprintRepository.deleteById(id);

	}

}
