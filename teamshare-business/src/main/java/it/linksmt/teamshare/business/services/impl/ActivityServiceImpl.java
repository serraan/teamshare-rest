package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.ActivityConverter;
import it.linksmt.teamshare.business.dto.request.ActivityRequestDto;
import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.services.ActivityService;
import it.linksmt.teamshare.dao.entities.Activity;
import it.linksmt.teamshare.dao.repositories.ActivityRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public List<ActivityDto> searchActivities(String title, String description, String type, String priority) {
		
		List<Activity> activities = (List<Activity>) activityRepository.findAll();
		
		return ActivityConverter.MAPPER.toListActivityDTO(activities);
	}

	@Override
	public List<ActivityDto> getActivities() {
		
		List<Activity> activities = (List<Activity>) activityRepository.findAll();
		
		return ActivityConverter.MAPPER.toListActivityDTO(activities);
	}

	@Override
	public ActivityDto getActivity(Integer id) {

		Optional<Activity> activity = activityRepository.findById(id);

		return ActivityConverter.MAPPER.toActivityDTO(activity.get());
	}

	@Override
	public ActivityDto addActivity(ActivityRequestDto activityRequestDto) {
		
		Activity activity = ActivityConverter.MAPPER.toActivity(activityRequestDto);
		
		activity = activityRepository.save(activity);
		
		return ActivityConverter.MAPPER.toActivityDTO(activity);
	}

	@Override
	public ActivityDto updateActivity(Integer id, ActivityRequestDto activityRequestDto) {
		
		Activity activity = ActivityConverter.MAPPER.toActivity(activityRequestDto);
		
		activity.setId(id);
		
//		activity.setUserAssignee(userRepository.findById(activityRequestDto.getIdUserAssignee()).get());
//		activity.setUserCreator(userRepository.findById(activityRequestDto.getIdUserCreator()).get());
		
		activityRepository.save(activity);

		return ActivityConverter.MAPPER.toActivityDTO(activity);
	}

	@Override
	public void deleteActivity(Integer id) {
		
		activityRepository.deleteById(id);
	}

}
