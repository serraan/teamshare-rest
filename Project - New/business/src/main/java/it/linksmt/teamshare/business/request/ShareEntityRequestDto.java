package it.linksmt.teamshare.business.request;

import java.io.Serializable;
import java.util.List;

import it.linksmt.teamshare.business.dtos.ContentDto;
import it.linksmt.teamshare.business.dtos.UserDto;

public class ShareEntityRequestDto implements Serializable{

	private static final long serialVersionUID = 2247600455830832182L;
	
	private UserDto user;
	
	private ContentDto content;





	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public ContentDto getContent() {
		return content;
	}

	public void setContent(ContentDto contentDto) {
		this.content = contentDto;
	}



	
	

}
