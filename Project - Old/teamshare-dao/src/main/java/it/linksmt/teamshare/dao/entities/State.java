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
@Table(name = "tb_stato")
public class State implements Serializable {

	private static final long serialVersionUID = 5955024808860494750L;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	private String name;
	
	@OneToMany(mappedBy = "state" , cascade=CascadeType.ALL)
	private List<ActivityState> listActivityStatus;

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

	public List<ActivityState> getListActivityStatus() {
		return listActivityStatus;
	}

	public void setListActivityStatus(List<ActivityState> listActivityStatus) {
		this.listActivityStatus = listActivityStatus;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + ", listActivityStatus=" + listActivityStatus + "]";
	}
	
}
