package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;


public class UserTypeContentRequestDto implements Serializable{
	
	private static final long serialVersionUID = 4466501882146362292L;

	private Integer idUser; 
	
	private Integer idType; 
	
	private Integer idContent;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public Integer getIdContent() {
		return idContent;
	}

	public void setIdContent(Integer idContent) {
		this.idContent = idContent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
