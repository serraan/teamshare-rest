package it.linksmt.teamshare.business.request;

import java.io.Serializable;
import java.util.List;

import it.linksmt.teamshare.business.dtos.CommentDto;
import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.business.dtos.UserDto;

public class ShowcaseRequestDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1990151231310929257L;

	private UserDto user;
	private PostDto post;
	private List<CommentDto> comments;
	
	public List<CommentDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
	}


	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public PostDto getPost() {
		return post;
	}

	public void setPost(PostDto post) {
		this.post = post;
	}

}
