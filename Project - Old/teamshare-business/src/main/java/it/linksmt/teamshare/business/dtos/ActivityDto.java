package it.linksmt.teamshare.business.dtos;

import java.io.Serializable;

import it.linksmt.teamshare.business.dto.request.ActivityRequestDto;

public class ActivityDto extends ActivityRequestDto implements Serializable {
	
	private static final long serialVersionUID = -3217169896191882826L;

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", getTitle()=" + getTitle() + ", getDescription()=" + getDescription()
				+ ", getType()=" + getType() + ", getPriority()=" + getPriority() + ", getDateTakenIntoCharge()="
				+ getDateTakenIntoCharge() + ", getIdUserCreator()=" + getIdUserCreator() + ", getIdUserAssignee()="
				+ getIdUserAssignee() +  "]";
	}
}