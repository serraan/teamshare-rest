package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.PostRequestDto;
import it.linksmt.teamshare.business.dtos.PostDto;

public interface PostService {

	public List<PostDto> getPosts();

	public PostDto getPost(Integer id);

	public PostDto addPost(PostRequestDto postRequestDto);

	public PostDto updatePost(Integer postId, PostRequestDto postRequestDto);

	public void deletePost(Integer id);
	
}
