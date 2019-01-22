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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(name = "formato")
	private String formatoFile;
	@Column(name = "file")
	private Blob file;
	@Column(name = "url")
	private String url;
	@Column(name = "data_pubblicazione")
	private Date dataCondivisione;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "id_utente")
	private User utenteCreatore;
	@Column(name = "tipo")
	private String tipo;
	
	@OneToMany(mappedBy = "contenuto", cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<TeamContent> teamContenuto; 
	

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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
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
	public void setUtenteCreatore(User utenteCreatore) {
		this.utenteCreatore = utenteCreatore;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<TeamContent> getTeamContenuto() {
		return teamContenuto;
	}
	public void setTeamContenuto(List<TeamContent> teamContenuto) {
		this.teamContenuto = teamContenuto;
	}

	
	
	
}
