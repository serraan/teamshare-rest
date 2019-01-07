package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.ActivitySprintConverter;
import it.linksmt.teamshare.business.dto.request.ActivitySprintRequestDto;
import it.linksmt.teamshare.business.dtos.ActivitySprintDto;
import it.linksmt.teamshare.business.services.ActivitySprintService;
import it.linksmt.teamshare.dao.entities.ActivitySprint;
import it.linksmt.teamshare.dao.repositories.ActivitySprintRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class ActivitySprintServiceImpl implements ActivitySprintService {

	@Autowired
	private ActivitySprintRepository activitySprintRepository;

	@Override
	public List<ActivitySprintDto> getActivities() {

		List<ActivitySprint> activitySprints = (List<ActivitySprint>) activitySprintRepository.findAll();
		
		return ActivitySprintConverter.MAPPER.toListActivitySprintDto(activitySprints);
	}

	@Override
	public ActivitySprintDto getActivitySprint(Integer activitySprintId) {

		Optional<ActivitySprint> activitySprint = activitySprintRepository.findById(activitySprintId);

		return ActivitySprintConverter.MAPPER.toActivitySprintDTO(activitySprint.get());
	}

	@Override
	public ActivitySprintDto addActivitySprint(ActivitySprintRequestDto activitySprintRequestDto) {

		ActivitySprint activitySprint = ActivitySprintConverter.MAPPER.toActivitySprint(activitySprintRequestDto);
		
		activitySprint = activitySprintRepository.save(activitySprint);
		
		return ActivitySprintConverter.MAPPER.toActivitySprintDTO(activitySprint);
	}

	@Override
	public ActivitySprintDto updateActivitySprint(Integer activitySprintId,
			ActivitySprintRequestDto activitySprintRequestDto) {

		ActivitySprint activitySprint = ActivitySprintConverter.MAPPER.toActivitySprint(activitySprintRequestDto);
		activitySprint.setId(activitySprintId);
		
		activitySprint = activitySprintRepository.save(activitySprint);

		return ActivitySprintConverter.MAPPER.toActivitySprintDTO(activitySprint);
	}

	@Override
	public void deleteActivitySprint(Integer activitySprintId) {
		
		activitySprintRepository.deleteById(activitySprintId);
	}
	
}
