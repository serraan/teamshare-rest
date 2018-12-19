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
@Table(name = "tb_nota")
public class Note implements Serializable{
	
	private static final long serialVersionUID = 1318362253321049205L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "testo")
	private String text; 
	
	@ManyToOne
    @JoinColumn(name = "id_attivita")
	private Activity idActivity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Activity getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Activity idActivity) {
		this.idActivity = idActivity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 

}
