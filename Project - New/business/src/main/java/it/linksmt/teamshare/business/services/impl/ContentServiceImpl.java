package it.linksmt.teamshare.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.dtos.ContentDto;
import it.linksmt.teamshare.business.request.ContentRequestDto;
import it.linksmt.teamshare.business.services.ContentService;
import it.linksmt.teamshare.converter.ContentConverter;
import it.linksmt.teamshare.entities.Content;
import it.linksmt.teamshare.repository.ContentRepository;


@Service
@Transactional
public class ContentServiceImpl implements ContentService{
	
	@Autowired
	private ContentRepository contentRepository;
	
	@Override
	public List<ContentDto> getAll() {
		List<Content> cont = (List<Content>) contentRepository.findAll();
		
		return ContentConverter.MAPPER.toListaContentDTOResponse(cont);
	}

//	@Override
//	public ContentDto getCont(String titoloCont) {
//		Content cont = contentRepository.findByTitoloContent(titoloCont);
//		return ContentConverter.MAPPER.toContentDto(cont);
//	}

	@Override
	public ContentDto addCont(ContentRequestDto cont) {
		Content c = ContentConverter.MAPPER.toContent(cont);
		c = contentRepository.save(c);
		return ContentConverter.MAPPER.toContentDto(c);
	}

	@Override
	public ContentDto updateCont(Integer contId, ContentRequestDto cont) {
		Content c = ContentConverter.MAPPER.toContent(cont);
		c.setId(contId);
		c = contentRepository.save(c);
		return	ContentConverter.MAPPER.toContentDto(c);
	}

	@Override
	public void deleteCont(Integer contId) {
		contentRepository.deleteById(contId);
		
	}
}
