package it.linksmt.teamshare.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_Contenuto")
public class Content {

	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column(name="Titolo")
	private String title;

	@Column(name="Formato")
	private String format;
	
	@Column(name="File")
	private String file;

	@Column(name="Url")
	private String url;

	@Column(name="Tipo")
	private String type;
	
	@Column(name="NomeFile")
	private String fileName;
	
	
	@ManyToOne
	@JoinColumn(name="tb_Reagisce_idReagisce")
	private Reaction idReaction;

//	@ManyToOne
//	@JoinColumn(name = "tb_Condivide_idCondivide")
//	private Condivide idCondivide;
//
//	@ManyToOne
//	@JoinColumn(name = "tb_Team_Contenuto_idContenuto")
//	private TeamContenuto idContent;
//
//	@ManyToOne
//	@JoinColumn(name = "tb_Team_Contenuto_idTeam")
//	private TeamContenuto idTeam;

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

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Reaction getIdReact() {
		return idReaction;
	}

	public void setIdReaction(Reaction idReagisce) {
		this.idReaction = idReagisce;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", format=" + format + ", file=" + file + ", url=" + url
				+ ", type=" + type + ", fileName=" + fileName + ", idReaction=" + idReaction + "]";
	}

//	public Condivide getIdCondivide() {
//		return idCondivide;
//	}
//
//	public void setIdCondivide(Condivide idCondivide) {
//		this.idCondivide = idCondivide;
//	}
//
//	public TeamContenuto getIdContent() {
//		return idContent;
//	}
//
//	public void setIdContent(TeamContenuto idContent) {
//		this.idContent = idContent;
//	}
//
//	public TeamContenuto getIdTeam() {
//		return idTeam;
//	}
//
//	public void setIdTeam(TeamContenuto idTeam) {
//		this.idTeam = idTeam;
//	}
}
