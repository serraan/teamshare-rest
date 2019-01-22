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
@Table(name="tb_tipo")
public class Type implements Serializable{

	private static final long serialVersionUID = -1405254189843717807L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "path_immagine")
	private String pathImage;
	
	@OneToMany(mappedBy = "type" , cascade=CascadeType.ALL)
	private List<UserTypeContent> listUserTypeContent;

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

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	public List<UserTypeContent> getListUserTypeContent() {
		return listUserTypeContent;
	}

	public void setListUserTypeContent(List<UserTypeContent> listUserTypeContent) {
		this.listUserTypeContent = listUserTypeContent;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", pathImage=" + pathImage + ", listUserTypeContent="
				+ listUserTypeContent + "]";
	}
	
}
