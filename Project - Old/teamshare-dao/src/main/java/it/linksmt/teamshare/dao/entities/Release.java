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
public class Release implements Serializable {

	private static final long serialVersionUID = -7846720263271395516L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome")
	private String name;
	
	@OneToMany(mappedBy = "release" , cascade=CascadeType.ALL)
	private List<Sprint> listSprint;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sprint> getListSprint() {
		return listSprint;
	}

	public void setListSprint(List<Sprint> listSprint) {
		this.listSprint = listSprint;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Release [id=" + id + ", name=" + name + ", listSprint=" + listSprint + "]";
	}
	
}
