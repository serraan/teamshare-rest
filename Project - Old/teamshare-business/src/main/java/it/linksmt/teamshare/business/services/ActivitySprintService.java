package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.ActivitySprintRequestDto;
import it.linksmt.teamshare.business.dtos.ActivitySprintDto;

public interface ActivitySprintService {

	public List<ActivitySprintDto> getActivities();

	public ActivitySprintDto getActivitySprint(Integer id);

	public ActivitySprintDto addActivitySprint(ActivitySprintRequestDto activitySprintRequestDto);

	public ActivitySprintDto updateActivitySprint(Integer activityId, ActivitySprintRequestDto activitySprintRequestDto);

	public void deleteActivitySprint(Integer id);
	
}
