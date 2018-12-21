package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.StateRequestDto;
import it.linksmt.teamshare.business.dtos.StateDto;
import it.linksmt.teamshare.dao.entities.State;


@Mapper
public interface StateConverter {
	StateConverter MAPPER = Mappers.getMapper(StateConverter.class);

	List<StateDto> toListStateDto(Iterable<State> allState);

	StateDto toStateDto(State state);
	
	State toState(StateDto stateDto);
	
	State toState(StateRequestDto stateRequestDto);
}
