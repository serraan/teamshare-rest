package it.linksmt.teamshare.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_utente_team")
public class UserTeam implements Serializable {

	private static final long serialVersionUID = -899237098497246533L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name = "id_utente")
	private User user;
	
	@ManyToOne(targetEntity=Team.class)
	@JoinColumn(name = "id_team")
	private Team team;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "UserTeam [id=" + id + ", user=" + user + ", team=" + team + "]";
	}
	
}
