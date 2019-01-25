package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.PostRequestDto;
import it.linksmt.teamshare.entities.User;

public interface PostService {
	public List<PostDto> getAll();
	public PostDto addPost(PostRequestDto postRequestDto);
	public void deletePost(Integer id);
	public PostDto getPostById(Integer idPost); 
}
