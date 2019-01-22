package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.ImpedimentRequestDto;
import it.linksmt.teamshare.business.dtos.ImpedimentDto;

public interface ImpedimentService {

	public List<ImpedimentDto> getImpediments();

	public ImpedimentDto getImpediment(Integer id);

	public ImpedimentDto addImpediment(ImpedimentRequestDto impedimentRequestDto);

	public ImpedimentDto updateImpediment(Integer impedimentId, ImpedimentRequestDto impedimentRequestDto);

	public void deleteImpediment(Integer id);
	
}
