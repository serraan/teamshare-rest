package it.linksmt.teamshare.business.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.ActivityConverter;
import it.linksmt.teamshare.business.converter.ActivitySprintConverter;
import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.dtos.SprintDto;
import it.linksmt.teamshare.business.services.ActivitySprintService;
import it.linksmt.teamshare.dao.entities.Activity;
import it.linksmt.teamshare.dao.repositories.ActivityRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, noRollbackFor = Exception.class)
public class ActivitySprintServiceImpl implements ActivitySprintService {

	@Autowired
	private ActivityRepository acitivityRepository;

	// TODO: implement!
	@Override
	public Map<ActivityDto, List<SprintDto>> getActivitySprintAsMap() {

		List<Activity> activity = (List<Activity>) acitivityRepository.findAll();
		Map<ActivityDto, List<SprintDto>> activitySprint = new HashMap<ActivityDto, List<SprintDto>>();

		for (Activity act : activity) {
			// TODO: change converter to Sprint Converter
			activitySprint.put(ActivityConverter.MAPPER.toActivityDTO(act),
					ActivitySprintConverter.MAPPER.toListActivitySprintDto(act.getSprints()));
		}

		return activitySprint;
	}

}
