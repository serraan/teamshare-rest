package it.linksmt.teamshare.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.DashboardEntryRequestDto;
import it.linksmt.teamshare.business.services.DashboardEntryService;
import it.linksmt.teamshare.business.services.UserService;
import it.linksmt.teamshare.converter.ActivityConverter;
import it.linksmt.teamshare.entities.Activity;
import it.linksmt.teamshare.repository.ActivityRepository;

@Service
@Transactional
public class DashboardEntryServiceImpl implements DashboardEntryService {

	@Autowired
	private UserService userService;

	@Autowired
	private ActivityRepository attRepo;

	@Override
	public List<DashboardEntryRequestDto> searchByActivities() {
		List<DashboardEntryRequestDto> dashEnt = new ArrayList<DashboardEntryRequestDto>();
		List<UserDto> utente = userService.searchAll();
		for (UserDto u : utente) {
			DashboardEntryRequestDto dto = new DashboardEntryRequestDto();
			dto.setUtente(userService.getUser(u.getId()));
			List<Activity> a = attRepo.findByIdUtenteAssegnatario(u.getId());
			List<ActivityDto> attDto = new ArrayList<ActivityDto>();
			for (Activity att : a) {
				attDto.add(ActivityConverter.MAPPER.toActivityDTO(att));
			}
			dto.setAttivita(attDto);

		
			dashEnt.add(dto);
		}
		return dashEnt;
	}

}
