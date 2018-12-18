package it.linksmt.teamshare.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.teamshare.business.converter.ActivityConverter;
import it.linksmt.teamshare.business.dto.request.ActivityRequestDto;
import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.services.ActivityService;
import it.linksmt.teamshare.dao.entities.Activity;
import it.linksmt.teamshare.dao.repositories.ActivityRepository;
import it.linksmt.teamshare.dao.repositories.UserRepository;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<ActivityDto> searchActivities(String title, String description, String type, String priority) {
		
		List<Activity> activities = activityRepository.findAll();
		
		return ActivityConverter.MAPPER.toListActivityDTO(activities);
	}

	@Override
	public List<ActivityDto> getActivities() {
		
		List<Activity> activities = activityRepository.findAll();
		
		return ActivityConverter.MAPPER.toListActivityDTO(activities);
	}

	@Override
	public ActivityDto getActivity(Integer id) {

		Activity activity = activityRepository.findAllById(id);

		return ActivityConverter.MAPPER.toActivityDTO(activity);
	}

	@Override
	public ActivityDto addActivity(ActivityRequestDto activityRequestDto) {
		
		Activity activity = ActivityConverter.MAPPER.toActivity(activityRequestDto);
		
		activity = activityRepository.save(activity);
		
		return ActivityConverter.MAPPER.toActivityDTO(activity);
	}

	@Override
	public ActivityDto updateActivity(ActivityRequestDto activityRequestDto) {
		
		Activity activity = ActivityConverter.MAPPER.toActivity(activityRequestDto);
		activity.setUserAssignee(userRepository.findById(activityRequestDto.getIdUserAssignee()).get());
		activity.setUserCreator(userRepository.findById(activityRequestDto.getIdUserCreator()).get());
		
		activityRepository.save(activity);

		return ActivityConverter.MAPPER.toActivityDTO(activity);
	}

	@Override
	public void deleteActivity(Integer id) {
		
		activityRepository.deleteById(id);
	}

}
