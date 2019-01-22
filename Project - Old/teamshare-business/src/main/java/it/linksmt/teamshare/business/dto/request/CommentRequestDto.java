package it.linksmt.teamshare.business.dto.request;

import java.io.Serializable;
import java.sql.Date;

public class CommentRequestDto implements Serializable {

	private static final long serialVersionUID = -8087174058306560889L;

	private String text;
	private Date publicationDate;

	private Integer idPost;
	private Integer idUser;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Integer getIdPost() {
		return idPost;
	}

	public void setIdPost(Integer idPost) {
		this.idPost = idPost;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "CommentRequestDto [text=" + text + ", publicationDate=" + publicationDate + ", idPost=" + idPost
				+ ", idUser=" + idUser + "]";
	}

}
