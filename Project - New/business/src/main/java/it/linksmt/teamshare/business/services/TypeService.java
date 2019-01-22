package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dtos.TypeDto;
import it.linksmt.teamshare.business.request.TypeRequestDto;

public interface TypeService {
	
	public List<TypeDto> searchType();
	public TypeRequestDto getType(Integer id);
	public TypeRequestDto addType(TypeRequestDto tipo);
	public TypeRequestDto updateType(Integer tipoId, TypeRequestDto tipo);
	public void deleteType(Integer id);
}
