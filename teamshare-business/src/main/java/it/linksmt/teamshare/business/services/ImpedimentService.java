package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.ImpedimentRequestDto;
import it.linksmt.teamshare.business.dtos.ImpedimentDto;

public interface ImpedimentService {

	public List<ImpedimentDto> searchImpediments();
	
	public ImpedimentDto updateImpediment(Integer idImpediment, ImpedimentRequestDto impedimentRequestDto);
	
	public ImpedimentDto addImpediment(ImpedimentRequestDto impedimentRequestDto);
	
	public ImpedimentDto getImpediment(Integer idImpediment);
	
	public void deleteImpediment(Integer idImpediment);
	
}
