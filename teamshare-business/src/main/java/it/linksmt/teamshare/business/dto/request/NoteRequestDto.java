package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;

public class NoteRequestDto implements Serializable {

	private static final long serialVersionUID = 5402936467227986604L;

	private String text;
	
	private Integer idActivity;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getIdActivity() {
		return idActivity;
	}
	public void setIdActivity(Integer idActivity) {
		this.idActivity = idActivity;
	}
	
	@Override
	public String toString() {
		return "NoteRequestDto [text=" + text + ", idActivity=" + idActivity + "]";
	}

}
