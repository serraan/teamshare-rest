package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

public class UserRequestDto implements Serializable {

	private static final long serialVersionUID = 8289143077979931763L;

	private String firstName;
	private String lastName;
	private Date birthDate;
	private String email;
	private String password;
	private Blob avatar;

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

	@Override
	public String toString() {
		return "UserRequestDto [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", email=" + email + ", password=" + password + ", avatar=" + avatar + "]";
	}

}
