package it.linksmt.teamshare.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contenuto")
public class Content implements Serializable{

	private static final long serialVersionUID = -6538188668111351202L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idContenuto;
	@Column(name = "Testo_Contenuto")
	private String testoContenuto;
	@Column(name = "Nome_File")
	private String nomeFile;
	@Column(name = "Formato_File")
	private String formatoFile;
	@Column(name = "File")
	private Blob file;
	@Column(name = "Url")
	private Blob url;
	@Column(name = "Data_Condivisione")
	private Date dataCondivisione;
	@OneToOne
	@JoinColumn(name = "idUtente")
	private User idUtente;
	public Integer getIdContenuto() {
		return idContenuto;
	}
	public void setIdContenuto(Integer idContenuto) {
		this.idContenuto = idContenuto;
	}
	public String getTestoContenuto() {
		return testoContenuto;
	}
	public void setTestoContenuto(String testoContenuto) {
		this.testoContenuto = testoContenuto;
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
	public User getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(User idUtente) {
		this.idUtente = idUtente;
	}
	
	
}
