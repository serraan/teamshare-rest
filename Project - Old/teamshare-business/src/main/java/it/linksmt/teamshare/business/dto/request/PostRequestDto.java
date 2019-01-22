package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;
import java.sql.Date;

public class PostRequestDto implements Serializable {

	private static final long serialVersionUID = 6072948027196684169L;

	private String title;
	private String description;
	private int reference;
	private Date publicationDate;
	
	private Integer idUser;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "PostRequestDto [title=" + title + ", description=" + description + ", reference=" + reference
				+ ", publicationDate=" + publicationDate + ", idUser=" + idUser + "]";
	}

}
