package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.TypeRequestDto;
import it.linksmt.teamshare.business.dtos.TypeDto;

public interface TypeService {
	public List<TypeDto> searchTypes(String nome);

	public List<TypeDto> getTypes();

	public TypeDto getType(Integer id);

	public TypeDto addType(TypeRequestDto typeRequestDto);

	public TypeDto updateType(Integer id, TypeRequestDto typeRequestDto);

	public void deleteType(Integer id);
}
