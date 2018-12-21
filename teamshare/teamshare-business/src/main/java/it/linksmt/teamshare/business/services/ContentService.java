package it.linksmt.teamshare.business.services;

import java.util.Date;
import java.util.List;

import it.linksmt.teamshare.business.dtos.ContentDto;
import it.linksmt.teamshare.business.request.ContentRequestDto;



public interface ContentService {

	public List<ContentDto> searchContents(String formatoFile, Date dataCondivisione);
	public ContentDto getContent(Integer id);
	public ContentDto addContent(ContentRequestDto content);
	public ContentDto updateContent(Integer contentId, ContentRequestDto content);
	public void deleteContent(Integer id);
	List<ContentDto> getAll();
}
