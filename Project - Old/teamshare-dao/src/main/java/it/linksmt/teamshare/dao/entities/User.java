package it.linksmt.teamshare.dao.entities;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_utente")
public class User implements Serializable {

	private static final long serialVersionUID = 6197130342670307616L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome")
	private String firstName;
	
	@Column(name = "cognome")
	private String lastName;
	
	@Column(name = "data_nascita")
	private Date birthDate;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "avatar")
	private Blob avatar;
	
	@OneToMany(mappedBy = "user" , cascade=CascadeType.ALL)
	private List<Comment> listComment;
	
	@OneToMany(mappedBy = "user" , cascade=CascadeType.ALL)
	private List<Post> listPost;
	
	@OneToMany(mappedBy = "user" , cascade=CascadeType.ALL)
	private List<UserTeam> listUserTeam;
	
	@OneToMany(mappedBy = "user" , cascade=CascadeType.ALL)
	private List<UserTypeContent> listUserTypeContent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Blob getAvatar() {
		return avatar;
	}

	public void setAvatar(Blob avatar) {
		this.avatar = avatar;
	}

	public List<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(List<Comment> listComment) {
		this.listComment = listComment;
	}

	public List<Post> getListPost() {
		return listPost;
	}

	public void setListPost(List<Post> listPost) {
		this.listPost = listPost;
	}

	public List<UserTeam> getListUserTeam() {
		return listUserTeam;
	}

	public void setListUserTeam(List<UserTeam> listUserTeam) {
		this.listUserTeam = listUserTeam;
	}

	public List<UserTypeContent> getListUserTypeContent() {
		return listUserTypeContent;
	}

	public void setListUserTypeContent(List<UserTypeContent> listUserTypeContent) {
		this.listUserTypeContent = listUserTypeContent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", email=" + email + ", password=" + password + ", avatar=" + avatar + ", listComment=" + listComment
				+ ", listPost=" + listPost + ", listUserTeam=" + listUserTeam + ", listUserTypeContent="
				+ listUserTypeContent + "]";
	}
	
}
