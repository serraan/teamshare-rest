package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.TypeConverter;
import it.linksmt.teamshare.business.dto.request.TypeRequestDto;
import it.linksmt.teamshare.business.dtos.TypeDto;
import it.linksmt.teamshare.business.services.TypeService;
import it.linksmt.teamshare.dao.entities.Type;
import it.linksmt.teamshare.dao.repositories.TypeRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, noRollbackFor = Exception.class)
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeRepository typeRepository;
	//////////////////////////////////////////////
	@Override
	public List<TypeDto> searchTypes(String nome) { 
		List<Type> types = (List<Type>) typeRepository.findByNomeContaining(nome);

		return TypeConverter.MAPPER.toListTypeDto(types);
	}

	@Override
	public List<TypeDto> getTypes() {
		List<Type> types = (List<Type>) typeRepository.findAll();

		return TypeConverter.MAPPER.toListTypeDto(types);
	}

	@Override
	public TypeDto getType(Integer id) {
		Optional<Type> type = typeRepository.findById(id);

		return TypeConverter.MAPPER.toTypeDto(type.get());
	}

	@Override
	public TypeDto addType(TypeRequestDto typeRequestDto) {
		Type type = TypeConverter.MAPPER.toType(typeRequestDto);

		type = typeRepository.save(type);

		return TypeConverter.MAPPER.toTypeDto(type);
	}

	@Override
	public TypeDto updateType(Integer id, TypeRequestDto typeRequestDto) {
		Type type = TypeConverter.MAPPER.toType(typeRequestDto);

		type.setId(id);

		typeRepository.save(type);

		return TypeConverter.MAPPER.toTypeDto(type);
	}

	@Override
	public void deleteType(Integer id) {
		typeRepository.deleteById(id);
	}

}
