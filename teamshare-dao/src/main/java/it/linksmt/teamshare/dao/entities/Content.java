package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_contenuto")
public class Content implements Serializable {

	private static final long serialVersionUID = 6230868308985330024L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "titolo")
	private String title;

	@Column(name="tipo")
	private boolean type;

	@Column(name="url")
	private String url;

	@Column(name="nome_file")
	private String fileName;

	@Column(name="formato")
	private String format;

	@Column(name="file")
	private Blob file;

	@Column(name = "data_pubblicazione")
	private Date publicationDate;

	@OneToOne
	@JoinColumn(name = "id_utente")
	private User user;

	@OneToMany(mappedBy = "content" , cascade=CascadeType.ALL)
	private List<ContentTeam> listContentTeam;

	@OneToMany(mappedBy = "content" , cascade=CascadeType.ALL)
	private List<UserTypeContent> listUserTypeContent;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ContentTeam> getListContentTeam() {
		return listContentTeam;
	}

	public void setListContentTeam(List<ContentTeam> listContentTeam) {
		this.listContentTeam = listContentTeam;
	}

	public List<UserTypeContent> getListUserTypeContent() {
		return listUserTypeContent;
	}

	public void setListUserTypeContent(List<UserTypeContent> listUserTypeContent) {
		this.listUserTypeContent = listUserTypeContent;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", type=" + type + ", url=" + url + ", fileName=" + fileName
				+ ", format=" + format + ", file=" + file + ", publicationDate=" + publicationDate + ", user=" + user
				+ ", listContentTeam=" + listContentTeam + ", listUserTypeContent=" + listUserTypeContent + "]";
	}

}
