package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.ImpedimentConverter;
import it.linksmt.teamshare.business.dto.request.ImpedimentRequestDto;
import it.linksmt.teamshare.business.dtos.ImpedimentDto;
import it.linksmt.teamshare.business.services.ImpedimentService;
import it.linksmt.teamshare.dao.entities.Impediment;
import it.linksmt.teamshare.dao.repositories.ImpedimentRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class ImpedimentServiceImpl implements ImpedimentService {

	@Autowired
	private ImpedimentRepository impedimentRepository;

	@Override
	public List<ImpedimentDto> getImpediments() {

		List<Impediment> impediments = (List<Impediment>) impedimentRepository.findAll();
		
		return ImpedimentConverter.MAPPER.toListImpedimentDto(impediments);
	}

	@Override
	public ImpedimentDto getImpediment(Integer impedimentId) {

		Optional<Impediment> impediment = impedimentRepository.findById(impedimentId);

		return ImpedimentConverter.MAPPER.toImpedimentDto(impediment.get());
	}

	@Override
	public ImpedimentDto addImpediment(ImpedimentRequestDto impedimentRequestDto) {

		Impediment impediment = ImpedimentConverter.MAPPER.toImpediment(impedimentRequestDto);
		
		impediment = impedimentRepository.save(impediment);
		
		return ImpedimentConverter.MAPPER.toImpedimentDto(impediment);
	}

	@Override
	public ImpedimentDto updateImpediment(Integer impedimentId, ImpedimentRequestDto impedimentRequestDto) {

		Impediment impediment = ImpedimentConverter.MAPPER.toImpediment(impedimentRequestDto);
		impediment.setId(impedimentId);
		
		impediment = impedimentRepository.save(impediment);

		return ImpedimentConverter.MAPPER.toImpedimentDto(impediment);
	}

	@Override
	public void deleteImpediment(Integer impedimentId) {
		
		impedimentRepository.deleteById(impedimentId);
	}
	
}
