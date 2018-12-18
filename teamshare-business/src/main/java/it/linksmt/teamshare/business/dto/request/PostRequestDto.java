package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;
import java.util.Date;

public class PostRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6072948027196684169L;

	private String title;
	private String description;
	private String reference;
	private Date datePublication;
	private Integer idUserCreator;

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

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public Integer getIdUserCreator() {
		return idUserCreator;
	}

	public void setIdUserCreator(Integer idUserCreator) {
		this.idUserCreator = idUserCreator;
	}

	

}
