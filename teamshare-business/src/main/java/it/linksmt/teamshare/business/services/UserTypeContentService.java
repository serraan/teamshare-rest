package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.UserTypeContentRequestDto;
import it.linksmt.teamshare.business.dtos.UserTypeContentDto;


public interface UserTypeContentService {

	public List<UserTypeContentDto> getUsersTypesContents();
	public UserTypeContentDto getUserTypeContent(Integer id);
	public UserTypeContentDto addUserTypeContent(UserTypeContentRequestDto userTypeContentRequestDto);
	public UserTypeContentDto updateUserTypeContent(Integer userTypeContentId, UserTypeContentRequestDto userTypeContentRequestDto);
	public void deleteUserTypeContent(Integer id);
}
