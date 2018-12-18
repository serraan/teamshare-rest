package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_stato")
public class State implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8345772292378160580L;

	@Id
	@Column(name = "IDstato")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Nome")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(mappedBy = "states")
	private Set<Activity> activity;

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + "]";
	}

}
