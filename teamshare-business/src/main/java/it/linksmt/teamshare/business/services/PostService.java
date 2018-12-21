package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.PostRequestDto;
import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.dao.entities.User;

public interface PostService {
	public List<PostDto> getAll();
	public PostDto getPostByUtenteCreatore(User utenteCreatore);
	public PostDto addPost(PostRequestDto postRequestDto);
	public PostDto updatePost(Integer postId, PostRequestDto post);
	public void deletePost(Integer id);
	public List<PostDto> getByCreatorUser(Integer idUser);

}