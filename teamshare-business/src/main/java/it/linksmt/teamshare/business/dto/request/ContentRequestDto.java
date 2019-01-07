package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

public class ContentRequestDto implements Serializable {

	private static final long serialVersionUID = 9029038384862935199L;

	private String title;
	private boolean type;
	private String url;
	private String fileName;
	private String format;
	private Blob file;
	private Date publicationDate;
	
	private Integer idUser;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Blob getFile() {
		return file;
	}

	public void setFile(Blob file) {
		this.file = file;
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
		return "ContentRequestDto [title=" + title + ", type=" + type + ", url=" + url + ", fileName=" + fileName
				+ ", format=" + format + ", file=" + file + ", publicationDate=" + publicationDate + ", idUser="
				+ idUser + "]";
	}

}
