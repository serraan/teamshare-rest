package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.UserTypeContentConverter;
import it.linksmt.teamshare.business.dto.request.UserTypeContentRequestDto;
import it.linksmt.teamshare.business.dtos.UserTypeContentDto;
import it.linksmt.teamshare.business.services.UserTypeContentService;
import it.linksmt.teamshare.dao.entities.UserTypeContent;
import it.linksmt.teamshare.dao.repositories.UserTypeContentRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class UserTypeContentServiceImpl implements UserTypeContentService {

	@Autowired
	private UserTypeContentRepository userTypeContentRepository;

	@Override
	public List<UserTypeContentDto> getUserTypeContents() {

		List<UserTypeContent> userTypeContents = (List<UserTypeContent>) userTypeContentRepository.findAll();
		
		return UserTypeContentConverter.MAPPER.toListUserTypeContentDto(userTypeContents);
	}

	@Override
	public UserTypeContentDto getUserTypeContent(Integer userTypeContentId) {

		Optional<UserTypeContent> userTypeContent = userTypeContentRepository.findById(userTypeContentId);

		return UserTypeContentConverter.MAPPER.toUserTypeContentDto(userTypeContent.get());
	}

	@Override
	public UserTypeContentDto addUserTypeContent(UserTypeContentRequestDto userTypeContentRequestDto) {

		UserTypeContent userTypeContent = UserTypeContentConverter.MAPPER.toUserTypeContent(userTypeContentRequestDto);
		
		userTypeContent = userTypeContentRepository.save(userTypeContent);
		
		return UserTypeContentConverter.MAPPER.toUserTypeContentDto(userTypeContent);
	}

	@Override
	public UserTypeContentDto updateUserTypeContent(Integer userTypeContentId,
			UserTypeContentRequestDto userTypeContentRequestDto) {

		UserTypeContent userTypeContent = UserTypeContentConverter.MAPPER.toUserTypeContent(userTypeContentRequestDto);
		userTypeContent.setId(userTypeContentId);
		
		userTypeContent = userTypeContentRepository.save(userTypeContent);

		return UserTypeContentConverter.MAPPER.toUserTypeContentDto(userTypeContent);
	}

	@Override
	public void deleteUserTypeContent(Integer userTypeContentId) {
		
		userTypeContentRepository.deleteById(userTypeContentId);
	}
	
}
