package it.linksmt.teamshare.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.teamshare.business.converter.PostConverter;
import it.linksmt.teamshare.business.dto.request.PostRequestDto;
import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.business.services.PostService;
import it.linksmt.teamshare.dao.entities.Post;
import it.linksmt.teamshare.dao.entities.User;
import it.linksmt.teamshare.dao.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<PostDto> getAll() {
		List<Post> att = (List<Post>) postRepository.findAll();
		return PostConverter.MAPPER.toListaPostDTOResponse(att);
	}

	@Override
	public PostDto getPostByUtenteCreatore(User utenteCreatore) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<PostDto> getByCreatorUser(Integer idUser) {
	        List<Post> posts = (List<Post>) postRepository.findAllByIdUtente(idUser);
	        return PostConverter.MAPPER.toListaPostDTOResponse(posts);
	}

	@Override
	public PostDto addPost(PostRequestDto postRequestDto) {
		Post p = PostConverter.MAPPER.toPost(postRequestDto);
		p = postRepository.save(p);
		return PostConverter.MAPPER.toPostDto(p);
	}

	@Override
	public void deletePost(Integer id) {
		postRepository.deleteById(id);

	}

	@Override
	public PostDto updatePost(Integer postId, PostRequestDto post) {
		Post p = PostConverter.MAPPER.toPost(post);
		p.setId(postId);
		p = postRepository.save(p);
		return PostConverter.MAPPER.toPostDto(p);
	}

}
