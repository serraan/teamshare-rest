package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.CommentConverter;
import it.linksmt.teamshare.business.dto.request.CommentRequestDto;
import it.linksmt.teamshare.business.dtos.CommentDto;
import it.linksmt.teamshare.business.services.CommentService;
import it.linksmt.teamshare.dao.entities.Comment;
import it.linksmt.teamshare.dao.repositories.CommentRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<CommentDto> getComments() {

		List<Comment> comments = (List<Comment>) commentRepository.findAll();
		
		return CommentConverter.MAPPER.toListCommentDto(comments);
	}

	@Override
	public CommentDto getComment(Integer commentId) {

		Optional<Comment> comment = commentRepository.findById(commentId);

		return CommentConverter.MAPPER.toCommentDto(comment.get());
	}

	@Override
	public CommentDto addComment(CommentRequestDto commentRequestDto) {

		Comment comment = CommentConverter.MAPPER.toComment(commentRequestDto);
		
		comment = commentRepository.save(comment);
		
		return CommentConverter.MAPPER.toCommentDto(comment);
	}

	@Override
	public CommentDto updateComment(Integer commentId, CommentRequestDto commentRequestDto) {

		Comment comment = CommentConverter.MAPPER.toComment(commentRequestDto);
		comment.setId(commentId);
		
		comment = commentRepository.save(comment);

		return CommentConverter.MAPPER.toCommentDto(comment);
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		commentRepository.deleteById(commentId);
	}
	
}
