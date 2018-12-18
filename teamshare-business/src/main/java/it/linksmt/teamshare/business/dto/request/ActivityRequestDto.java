package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;
import java.util.Date;

public class ActivityRequestDto implements Serializable {
	
	private static final long serialVersionUID = -298763132072447661L;
	
	private String title;
	private String description;
	private String type;
	private String priority;
	private Date dateTakenCharge;
	private Integer idUserCreator;
	private Integer idUserAssignee;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Date getDateTakenCharge() {
		return dateTakenCharge;
	}
	public void setDateTakenCharge(Date dateTakenCharge) {
		this.dateTakenCharge = dateTakenCharge;
	}
	public Integer getIdUserCreator() {
		return idUserCreator;
	}
	public void setIdUserCreator(Integer idUserCreator) {
		this.idUserCreator = idUserCreator;
	}
	public Integer getIdUserAssignee() {
		return idUserAssignee;
	}
	public void setIdUserAssignee(Integer idUserAssignee) {
		this.idUserAssignee = idUserAssignee;
	}
	
}
