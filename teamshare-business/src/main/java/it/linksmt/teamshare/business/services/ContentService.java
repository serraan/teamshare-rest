package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.ContentRequestDto;
import it.linksmt.teamshare.business.dtos.ContentDto;

public interface ContentService {

	public List<ContentDto> getContents();

	public ContentDto getContent(Integer id);

	public ContentDto addContent(ContentRequestDto contentRequestDto);

	public ContentDto updateContent(Integer contentId, ContentRequestDto contentRequestDto);

	public void deleteContent(Integer id);
	
}
