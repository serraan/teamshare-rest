package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.dtos.TypeDto;
import it.linksmt.teamshare.business.request.TypeRequestDto;
import it.linksmt.teamshare.business.services.TypeService;
import it.linksmt.teamshare.converter.TypeConverter;
import it.linksmt.teamshare.entities.Type;
import it.linksmt.teamshare.repository.TypeRepository;

@Service
@Transactional
public class TypeServiceImpl implements TypeService{

	@Autowired
	private TypeRepository typeRepository;
	
	@Override
	public List<TypeDto> searchType() {
		List<Type> tip = (List<Type>) typeRepository.findAll();
		return TypeConverter.MAPPER.toListTypeDTO(tip);
	}

	@Override
	public TypeRequestDto getType(Integer id) {
		Optional<Type> tip = typeRepository.findById(id);
		return TypeConverter.MAPPER.toTypeDTO(tip.get());
	}

	@Override
	public TypeRequestDto addType(TypeRequestDto tipo) {
		Type t = TypeConverter.MAPPER.toType(tipo);
		t = typeRepository.save(t);
		return TypeConverter.MAPPER.toTypeDTO(t);
	}

	@Override
	public TypeRequestDto updateType(Integer tipoId, TypeRequestDto tipo) {
		Type t = TypeConverter.MAPPER.toType(tipo);
		t.setId(tipoId);
		t = typeRepository.save(t);
		return TypeConverter.MAPPER.toTypeDTO(t);
	}

	@Override
	public void deleteType(Integer id) {
		typeRepository.deleteById(id);
		
	}
	
	
	
	

}
