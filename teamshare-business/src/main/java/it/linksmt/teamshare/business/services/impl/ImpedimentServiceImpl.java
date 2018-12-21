package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.teamshare.business.converter.ImpedimentConverter;
import it.linksmt.teamshare.business.dto.request.ImpedimentRequestDto;
import it.linksmt.teamshare.business.dtos.ImpedimentDto;
import it.linksmt.teamshare.business.services.ImpedimentService;
import it.linksmt.teamshare.dao.entities.Impediment;
import it.linksmt.teamshare.dao.repositories.ImpedimentRepository;

@Service
public class ImpedimentServiceImpl implements ImpedimentService {

	
		@Autowired
		ImpedimentRepository impedimentRepository;


		@Override
	    public List<ImpedimentDto> searchImpediments() {
				List<Impediment> imp = (List<Impediment>) impedimentRepository.findAll();
				return ImpedimentConverter.MAPPER.toListImpedimentDTOResponse(imp);
	    }


		@Override
		public ImpedimentDto getImpediment(Integer idImpediment) {
			Optional<Impediment> imp = impedimentRepository.findById(idImpediment);
			return ImpedimentConverter.MAPPER.toImpedimentDTO(imp.get());
		}


		@Override
		public ImpedimentDto addImpediment(ImpedimentRequestDto impedimentRequestDto) {
			Impediment imp = ImpedimentConverter.MAPPER.toImpediment(impedimentRequestDto);
			imp = impedimentRepository.save(imp);
			return ImpedimentConverter.MAPPER.toImpedimentDTO(imp);
		}


		@Override
		public ImpedimentDto updateImpediment(Integer idImpediment, ImpedimentRequestDto impedimentRequestDto) {
			Impediment imp = ImpedimentConverter.MAPPER.toImpediment(impedimentRequestDto);
			imp.setId(idImpediment);
			imp = impedimentRepository.save(imp);
			return ImpedimentConverter.MAPPER.toImpedimentDTO(imp);
		}


		@Override
		public void deleteImpediment(Integer idImpediment) {
			impedimentRepository.deleteById(idImpediment);
			
		}
}
