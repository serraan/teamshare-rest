package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.linksmt.teamshare.business.converter.PostConverter;
import it.linksmt.teamshare.business.dto.request.PostRequestDto;
import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.business.services.Service;
import it.linksmt.teamshare.dao.entities.Post;
import it.linksmt.teamshare.dao.repositories.PostRepository;

@Component
public class PostServiceImpl implements Service<PostDto, PostRequestDto> {

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<PostDto> getAll() {
		List<Post> posts = postRepository.findAll();
		return PostConverter.MAPPER.toListPostDto(posts);
	}

	@Override
	public PostDto getById(Integer id) {
		
		Optional<Post> postO = postRepository.findById(id);
		Post post = null;

		if (postO.isPresent()) {
			post = postO.get();
		}
		return PostConverter.MAPPER.toPostDto(post);
	}

	@Override
	public PostDto add(PostRequestDto requestDto) {
		
		Post post = PostConverter.MAPPER.toPost(requestDto);
		
		post = postRepository.save(post);
		
		return PostConverter.MAPPER.toPostDto(post);
	}

	@Override
	public PostDto update(PostRequestDto requestDto) {
		
		Post post = PostConverter.MAPPER.toPost(requestDto);
		post = postRepository.save(post);
		
		return PostConverter.MAPPER.toPostDto(post);
	}

	@Override
	public void delete(Integer id) {
		postRepository.deleteById(id);
	}

}
