package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.request.ActivityRequestDto;
import it.linksmt.teamshare.business.services.ActivityService;
import it.linksmt.teamshare.converter.ActivityConverter;
import it.linksmt.teamshare.entities.Activity;
import it.linksmt.teamshare.repository.ActivityRepository;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityRepository activityRepository;


	@Override
	public List<ActivityDto> searchActivity() {
		List<Activity> att = (List<Activity>) activityRepository.findAll();
		return ActivityConverter.MAPPER.toListaAttivitaDTO(att);
	}
	
	@Override
	public ActivityDto getActivity(Integer id) {
		Optional<Activity> att = activityRepository.findById(id);
		return ActivityConverter.MAPPER.toActivityDTO(att.get());
	}

	@Override
	public ActivityDto addActivity(ActivityRequestDto att) {
		Activity a = ActivityConverter.MAPPER.toActivity(att);
		a = activityRepository.save(a);
		return ActivityConverter.MAPPER.toActivityDTO(a);
	}

	@Override
	public ActivityDto updateActivity(Integer attid,ActivityRequestDto att) {
		Activity a = ActivityConverter.MAPPER.toActivity(att);
		a.setId(attid);
		a = activityRepository.save(a);
		return ActivityConverter.MAPPER.toActivityDTO(a);
	}

	@Override
	public void deleteActivity(Integer id) {
		activityRepository.deleteById(id);
	}

}
