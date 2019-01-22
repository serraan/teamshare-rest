package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.dtos.ImpedimentDto;
import it.linksmt.teamshare.business.request.ImpedimentRequestDto;
import it.linksmt.teamshare.business.services.ImpedimentService;
import it.linksmt.teamshare.converter.ImpedimentConverter;
import it.linksmt.teamshare.entities.Impediment;
import it.linksmt.teamshare.repository.ImpedimentRepository;
@Service
@Transactional
public class ImpedimentServiceImpl implements ImpedimentService {

	@Autowired
	private ImpedimentRepository impedimentRepository;

	@Override
	public List<ImpedimentDto> getAll() {
		List<Impediment> imp = (List<Impediment>) impedimentRepository.findAll();

		return ImpedimentConverter.MAPPER.toListaImpedimentDTO(imp);
	}

	@Override
	public ImpedimentDto getImpediment(Integer id) {
		Optional<Impediment> impediment = impedimentRepository.findById(id);
		return ImpedimentConverter.MAPPER.toImpedimentDto(impediment.get());
	}

	@Override
	public ImpedimentDto addImpediment(ImpedimentRequestDto impediment) {
		Impediment i = ImpedimentConverter.MAPPER.toImpediment(impediment);
		i = impedimentRepository.save(i);
		return ImpedimentConverter.MAPPER.toImpedimentDto(i);
	}

	@Override
	public ImpedimentDto updateTeam(Integer id, ImpedimentRequestDto impediment) {
		Impediment i = ImpedimentConverter.MAPPER.toImpediment(impediment);
		i.setId(id);
		i = impedimentRepository.save(i);
		return ImpedimentConverter.MAPPER.toImpedimentDto(i);
	}

	@Override
	public void deleteImpediment(Integer id) {
		impedimentRepository.deleteById(id);
	}
}
