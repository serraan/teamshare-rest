package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.ContentConverter;
import it.linksmt.teamshare.business.dto.request.ContentRequestDto;
import it.linksmt.teamshare.business.dtos.ContentDto;
import it.linksmt.teamshare.business.services.ContentService;
import it.linksmt.teamshare.dao.entities.Content;
import it.linksmt.teamshare.dao.repositories.ContentRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentRepository contentRepository;

	@Override
	public List<ContentDto> getContents() {

		List<Content> contents = (List<Content>) contentRepository.findAll();
		
		return ContentConverter.MAPPER.toListContentDto(contents);
	}

	@Override
	public ContentDto getContent(Integer contentId) {

		Optional<Content> content = contentRepository.findById(contentId);

		return ContentConverter.MAPPER.toContentDto(content.get());
	}

	@Override
	public ContentDto addContent(ContentRequestDto contentRequestDto) {

		Content content = ContentConverter.MAPPER.toContent(contentRequestDto);
		
		content = contentRepository.save(content);
		
		return ContentConverter.MAPPER.toContentDto(content);
	}

	@Override
	public ContentDto updateContent(Integer contentId, ContentRequestDto contentRequestDto) {

		Content content = ContentConverter.MAPPER.toContent(contentRequestDto);
		content.setId(contentId);
		
		content = contentRepository.save(content);

		return ContentConverter.MAPPER.toContentDto(content);
	}

	@Override
	public void deleteContent(Integer contentId) {
		
		contentRepository.deleteById(contentId);
	}
	
}
