package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.PostRequestDto;
import it.linksmt.teamshare.business.services.PostService;
import it.linksmt.teamshare.converter.PostConverter;
import it.linksmt.teamshare.entities.Post;
import it.linksmt.teamshare.repository.PostRepository;
import it.linksmt.teamshare.repository.UserRepository;

@Service
@Transactional()
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public List<PostDto> getAll() {
		List<Post> att = (List<Post>) postRepository.findAll();
//		for (Post post : att) {
//			List<Comment> comments = (List<Comment>) commRepository.findAllByIdPost(post.getId());
//			post.setCommento(comments);
//			
//		}
		return PostConverter.MAPPER.toListaPostDTOResponse(att);
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
	public PostDto getPostById(Integer idPost) {
		Optional<Post> p = postRepository.findById(idPost);
		Post post;
		if(p.isPresent()) {
			post = p.get();
		}else {
			return null;
		}
		return PostConverter.MAPPER.toPostDto(post);
	}




	
}
