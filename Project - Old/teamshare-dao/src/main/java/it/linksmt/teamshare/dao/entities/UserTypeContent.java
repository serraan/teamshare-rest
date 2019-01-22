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
@Table(name="tb_utente_tipo_contenuto")
public class UserTypeContent implements Serializable {

	private static final long serialVersionUID = 4362344218089002134L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name = "id_utente")
	private User user;
	
	@ManyToOne(targetEntity=Type.class)
	@JoinColumn(name = "id_tipo")
	private Type type;
	
	@ManyToOne(targetEntity=Content.class)
	@JoinColumn(name = "id_contenuto")
	private Content content;

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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "UserTypeContent [id=" + id + ", user=" + user + ", type=" + type + ", content=" + content + "]";
	}

}
