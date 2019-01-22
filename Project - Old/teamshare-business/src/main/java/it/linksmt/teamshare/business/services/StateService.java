package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.StateRequestDto;
import it.linksmt.teamshare.business.dtos.StateDto;

public interface StateService {

	public List<StateDto> getStates();

	public StateDto getState(Integer id);

	public StateDto addState(StateRequestDto stateRequestDto);

	public StateDto updateState(Integer stateId, StateRequestDto stateRequestDto);

	public void deleteState(Integer id);
	
}
