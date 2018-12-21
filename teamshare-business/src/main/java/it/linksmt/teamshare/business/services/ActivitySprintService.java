package it.linksmt.teamshare.business.services;

import java.util.List;
import java.util.Map;

import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.dtos.SprintDto;

public interface ActivitySprintService {

	public Map<ActivityDto, List<SprintDto>> getActivitySprintAsMap();
	
}
