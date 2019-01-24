package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.request.DashboardEntryRequestDto;

public interface DashboardEntryService {

	public List<DashboardEntryRequestDto> searchByActivities();
}
