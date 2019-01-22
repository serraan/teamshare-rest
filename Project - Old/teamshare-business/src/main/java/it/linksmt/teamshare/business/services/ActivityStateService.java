package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.ActivityStateRequestDto;
import it.linksmt.teamshare.business.dtos.ActivityStateDto;

public interface ActivityStateService {

	public List<ActivityStateDto> getActivityStates();

	public ActivityStateDto getActivityState(Integer id);

	public ActivityStateDto addActivityState(ActivityStateRequestDto activityStateRequestDto);

	public ActivityStateDto updateActivityState(Integer activityId, ActivityStateRequestDto activityStateRequestDto);

	public void deleteActivityState(Integer id);
	
}
