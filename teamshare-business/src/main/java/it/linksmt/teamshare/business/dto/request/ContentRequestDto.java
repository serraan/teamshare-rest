package it.linksmt.teamshare.business.dto.request;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import it.linksmt.teamshare.dao.entities.User;

public class ContentRequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9029038384862935199L;
	
	private String title;
	
	private String type;
	
	private String url;
	
	private String fileName;
	
	private String format;
	
	private File file;
	
	private Date publishDate;
	
	private User user;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
