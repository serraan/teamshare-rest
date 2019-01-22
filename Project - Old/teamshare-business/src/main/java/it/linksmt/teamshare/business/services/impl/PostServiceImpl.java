package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.PostConverter;
import it.linksmt.teamshare.business.dto.request.PostRequestDto;
import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.business.services.PostService;
import it.linksmt.teamshare.dao.entities.Post;
import it.linksmt.teamshare.dao.repositories.PostRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<PostDto> getPosts() {

		List<Post> posts = (List<Post>) postRepository.findAll();
		
		return PostConverter.MAPPER.toListPostDto(posts);
	}

	@Override
	public PostDto getPost(Integer postId) {

		Optional<Post> post = postRepository.findById(postId);

		return PostConverter.MAPPER.toPostDto(post.get());
	}

	@Override
	public PostDto addPost(PostRequestDto postRequestDto) {

		Post post = PostConverter.MAPPER.toPost(postRequestDto);
		
		post = postRepository.save(post);
		
		return PostConverter.MAPPER.toPostDto(post);
	}

	@Override
	public PostDto updatePost(Integer postId, PostRequestDto postRequestDto) {

		Post post = PostConverter.MAPPER.toPost(postRequestDto);
		post.setId(postId);
		
		post = postRepository.save(post);

		return PostConverter.MAPPER.toPostDto(post);
	}

	@Override
	public void deletePost(Integer postId) {

		postRepository.deleteById(postId);
	}
	
}
