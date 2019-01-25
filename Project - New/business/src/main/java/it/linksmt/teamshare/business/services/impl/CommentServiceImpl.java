package it.linksmt.teamshare.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.dtos.CommentDto;
import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.business.request.CommentRequestDto;
import it.linksmt.teamshare.business.services.CommentService;
import it.linksmt.teamshare.business.services.PostService;
import it.linksmt.teamshare.converter.CommentConverter;
import it.linksmt.teamshare.converter.PostConverter;
import it.linksmt.teamshare.entities.Comment;
import it.linksmt.teamshare.entities.Post;
import it.linksmt.teamshare.repository.CommentRepository;

@Service

@Transactional()
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository 	commentRepository;
	
	@Autowired
	private PostService postService;
	@Override
	public CommentDto addComment(CommentRequestDto comment) {
		Comment com = CommentConverter.MAPPER.toComment(comment);
		com = commentRepository.save(com);
		return CommentConverter.MAPPER.toCommentDTO(com);
		
	}

	@Override
	public CommentDto updateComment(Integer idCommento, CommentRequestDto comment) {
		Comment com = CommentConverter.MAPPER.toComment(comment);
		com = commentRepository.save(com);
		return CommentConverter.MAPPER.toCommentDTO(com);
	
	}

	@Override
	public void deleteComment(Integer idCommento) {
		commentRepository.deleteById(idCommento);
		
	}

	
	@Override
	public List<CommentDto> getComment() {
		List<Comment> com = (List<Comment>) commentRepository.findAll();
		return CommentConverter.MAPPER.toListCommentDTO(com);	
	}

	@Override
	public List<CommentDto> searchCommentsOnPost(Integer idPost) {
		PostDto post = postService.getPostById(idPost);
		Post p = PostConverter.MAPPER.toPost(post);
		List<Comment> comments = commentRepository.findByPost(p);	
		return CommentConverter.MAPPER.toListCommentDTO(comments);
	}

}
