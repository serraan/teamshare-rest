package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dtos.ContentDto;
import it.linksmt.teamshare.business.request.ContentRequestDto;

public interface ContentService {
	public List<ContentDto> getAll();
//	public ContentDto getCont(String titoloCont);
	public ContentDto addCont(ContentRequestDto cont);
	public ContentDto updateCont(Integer contId, ContentRequestDto cont);
	public void deleteCont(Integer contId);
}
