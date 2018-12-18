package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_release")
public class Release implements Serializable{

	private static final long serialVersionUID = -7846720263271395516L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@OneToMany(mappedBy = "release" , cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Sprint> lstSprint;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Sprint> getLstSprint() {
		return lstSprint;
	}

	public void setLstSprint(List<Sprint> lstSprint) {
		this.lstSprint = lstSprint;
	}
	
	
	
	
}
