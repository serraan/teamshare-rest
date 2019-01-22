package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;
import java.sql.Date;

public class ActivityStateRequestDto implements Serializable {

	private static final long serialVersionUID = 5862771720500267196L;

	private Date startDate;
	private Date endDate;

	private Integer idState;
	private Integer idActivity;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getIdState() {
		return idState;
	}

	public void setIdState(Integer idState) {
		this.idState = idState;
	}

	public Integer getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Integer idActivity) {
		this.idActivity = idActivity;
	}

	@Override
	public String toString() {
		return "ActivityStatusRequestDto [startDate=" + startDate + ", endDate=" + endDate + ", idState=" + idState
				+ ", idActivity=" + idActivity + "]";
	}

}
