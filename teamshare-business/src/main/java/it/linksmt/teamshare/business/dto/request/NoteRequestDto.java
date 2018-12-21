package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;


import it.linksmt.teamshare.dao.entities.Activity;

public class NoteRequestDto implements Serializable{

	private static final long serialVersionUID = 5402936467227986604L;
	
	private String text; 
	
	private Activity idActivity;
	
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
