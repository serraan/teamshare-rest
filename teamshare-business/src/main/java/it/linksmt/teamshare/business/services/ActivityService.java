package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.ActivityRequestDto;
import it.linksmt.teamshare.business.dtos.ActivityDto;

public interface ActivityService {

	public List<ActivityDto> getActivities();

	public ActivityDto getActivity(Integer id);

	public ActivityDto addActivity(ActivityRequestDto activityRequestDto);

	public ActivityDto updateActivity(Integer activityId, ActivityRequestDto activityRequestDto);

	public void deleteActivity(Integer id);

}
