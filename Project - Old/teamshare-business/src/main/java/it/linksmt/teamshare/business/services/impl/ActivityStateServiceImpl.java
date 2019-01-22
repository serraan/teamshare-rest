package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.ActivityStateConverter;
import it.linksmt.teamshare.business.dto.request.ActivityStateRequestDto;
import it.linksmt.teamshare.business.dtos.ActivityStateDto;
import it.linksmt.teamshare.business.services.ActivityStateService;
import it.linksmt.teamshare.dao.entities.ActivityState;
import it.linksmt.teamshare.dao.repositories.ActivityStateRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class ActivityStateServiceImpl implements ActivityStateService {

	@Autowired
	private ActivityStateRepository activityStateRepository;

	@Override
	public List<ActivityStateDto> getActivityStates() {

		List<ActivityState> activityStatees = (List<ActivityState>) activityStateRepository.findAll();
		
		return ActivityStateConverter.MAPPER.toListActivityStateDto(activityStatees);
	}

	@Override
	public ActivityStateDto getActivityState(Integer activityStateId) {

		Optional<ActivityState> activityState = activityStateRepository.findById(activityStateId);

		return ActivityStateConverter.MAPPER.toActivityStateDto(activityState.get());
	}

	@Override
	public ActivityStateDto addActivityState(ActivityStateRequestDto activityStateRequestDto) {

		ActivityState activityState = ActivityStateConverter.MAPPER.toActivityState(activityStateRequestDto);
		
		activityState = activityStateRepository.save(activityState);
		
		return ActivityStateConverter.MAPPER.toActivityStateDto(activityState);
	}

	@Override
	public ActivityStateDto updateActivityState(Integer activityStateId, ActivityStateRequestDto activityStateRequestDto) {

		ActivityState activityState = ActivityStateConverter.MAPPER.toActivityState(activityStateRequestDto);
		activityState.setId(activityStateId);
		
		activityState = activityStateRepository.save(activityState);

		return ActivityStateConverter.MAPPER.toActivityStateDto(activityState);
	}

	@Override
	public void deleteActivityState(Integer activityStateId) {
		
		activityStateRepository.deleteById(activityStateId);
	}
	
}
