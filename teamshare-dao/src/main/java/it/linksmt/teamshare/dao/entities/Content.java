package it.linksmt.teamshare.dao.entities;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contenuto")
public class Content implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4507833896295831399L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "titolo")
	private String title;
	
	@Column(name = "tipo")
	private String type;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "nome_file")
	private String fileName;
	
	@Column(name = "formato")
	private String format;
	
	@Column(name = "file")
	private File file;
	
	@Column(name = "data_pubblicazione")
	private Date publishDate;
	
	@OneToMany(mappedBy = "idContent", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<UserTypeContent> lsUserTypeContent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<UserTypeContent> getLsUserTypeContent() {
		return lsUserTypeContent;
	}

	public void setLsUserTypeContent(List<UserTypeContent> lsUserTypeContent) {
		this.lsUserTypeContent = lsUserTypeContent;
	}
	
}
