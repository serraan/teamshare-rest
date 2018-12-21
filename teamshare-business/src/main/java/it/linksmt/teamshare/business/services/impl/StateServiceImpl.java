package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.StateConverter;
import it.linksmt.teamshare.business.dto.request.StateRequestDto;
import it.linksmt.teamshare.business.dtos.StateDto;
import it.linksmt.teamshare.business.services.StateService;
import it.linksmt.teamshare.dao.entities.State;
import it.linksmt.teamshare.dao.repositories.StateRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class StateServiceImpl implements StateService{

	@Autowired
	private StateRepository stateRepository;
	
	@Override
	public List<StateDto> getStates() {
		List<State> stateDtos= (List<State>) stateRepository.findAll();
		return StateConverter.MAPPER.toListStateDto(stateDtos);
	}

	@Override
	public StateDto getState(Integer id) {
		Optional<State> state= stateRepository.findById(id);
		return StateConverter.MAPPER.toStateDto(state.get());
	}

	@Override
	public StateDto addState(StateRequestDto stateRequestDto) {
		State state= StateConverter.MAPPER.toState(stateRequestDto);
		state= stateRepository.save(state);
		return StateConverter.MAPPER.toStateDto(state);
	}

	@Override
	public StateDto updateState(Integer stateId, StateRequestDto stateRequestDto) {
		State state= StateConverter.MAPPER.toState(stateRequestDto);
		state.setId(stateId);
		state= stateRepository.save(state);
		return StateConverter.MAPPER.toStateDto(state);
	}

	@Override
	public void deleteState(Integer id) {
		stateRepository.deleteById(id);
		
	}

}
