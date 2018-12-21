package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.sql.Blob;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contenuto")
public class Content implements Serializable{

	private static final long serialVersionUID = -6538188668111351202L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "titolo")
	private String titolo;
	@Column(name = "nome_file")
	private String nomeFile;
	@Column(name = "Formato")
	private String formatoFile;
	@Column(name = "File")
	private Blob file;
	@Column(name = "URL")
	private Blob url;
	@Column(name = "data_pubblicazione")
	private Date dataCondivisione;
	
	
	@OneToOne
	@JoinColumn(name = "id_utente")
	private User utenteCreatore;
	@OneToMany(mappedBy = "lstContenuto", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<TeamContent> lstTeamContenuto; 
	
	public List<TeamContent> getLstTeamContenuto() {
		return lstTeamContenuto;
	}
	public void setLstTeamContenuto(List<TeamContent> lstTeamContenuto) {
		this.lstTeamContenuto = lstTeamContenuto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getNomeFile() {
		return nomeFile;
	}
	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}
	public String getFormatoFile() {
		return formatoFile;
	}
	public void setFormatoFile(String formatoFile) {
		this.formatoFile = formatoFile;
	}
	public Blob getFile() {
		return file;
	}
	public void setFile(Blob file) {
		this.file = file;
	}
	public Blob getUrl() {
		return url;
	}
	public void setUrl(Blob url) {
		this.url = url;
	}
	public Date getDataCondivisione() {
		return dataCondivisione;
	}
	public void setDataCondivisione(Date dataCondivisione) {
		this.dataCondivisione = dataCondivisione;
	}
	public User getUtenteCreatore() {
		return utenteCreatore;
	}
	public void setUtenteCreatore(User idUtente) {
		this.utenteCreatore = idUtente;
	}
	
	
}
