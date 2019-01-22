package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dtos.ImpedimentDto;
import it.linksmt.teamshare.business.request.ImpedimentRequestDto;



public interface ImpedimentService {

	public List<ImpedimentDto> getAll();
	public ImpedimentDto getImpediment(Integer id);
	public ImpedimentDto addImpediment(ImpedimentRequestDto impediment);
	public ImpedimentDto updateTeam(Integer id, ImpedimentRequestDto impediment);
	public void deleteImpediment(Integer id);
}
