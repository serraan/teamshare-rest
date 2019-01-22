package it.linksmt.teamshare.entities;

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
public class State implements Serializable{

	private static final long serialVersionUID = -2726742660977972042L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome")
	private String nomeStato;
	
	@OneToMany(mappedBy = "stato", cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<ActivityState> activityState;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeStato() {
		return nomeStato;
	}
	public void setNomeStato(String nomeStato) {
		this.nomeStato = nomeStato;
	}
	public List<ActivityState> getActivityState() {
		return activityState;
	}
	public void setActivityState(List<ActivityState> activityState) {
		this.activityState = activityState;
	}
	
	
}
