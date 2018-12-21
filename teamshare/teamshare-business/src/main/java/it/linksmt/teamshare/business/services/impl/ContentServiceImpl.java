package it.linksmt.teamshare.business.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.converter.ContentConverter;
import it.linksmt.teamshare.business.dtos.ContentDto;
import it.linksmt.teamshare.business.request.ContentRequestDto;
import it.linksmt.teamshare.business.services.ContentService;
import it.linksmt.teamshare.entities.Content;
import it.linksmt.teamshare.repository.ContentRepository;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	ContentRepository contentRepository;
	
	@Override
	public List<ContentDto> searchContents(String formatoFile, Date dataCondivisione) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContentDto getContent(Integer id) {
		Optional<Content> contents = contentRepository.findById(id);

		return ContentConverter.MAPPER.toContentDTO(contents.get());
	}

	@Override
	public ContentDto addContent(ContentRequestDto content) {
		Content c = ContentConverter.MAPPER.toContent(content);
		c = contentRepository.save(c);
		
		return ContentConverter.MAPPER.toContentDTO(c);
	}

	@Override
	public ContentDto updateContent(Integer contentId, ContentRequestDto content) {
		Content c = ContentConverter.MAPPER.toContent(content);
		c.setId(contentId);
		c = contentRepository.save(c);
		return ContentConverter.MAPPER.toContentDTO(c);
	}

	@Override
	public void deleteContent(Integer id) {
		contentRepository.deleteById(id);	
	}

	@Override
	public List<ContentDto> getAll() {
		List<Content> contents = (List<Content>) contentRepository.findAll();

		return ContentConverter.MAPPER.toListContentDTO(contents);
	}

}
