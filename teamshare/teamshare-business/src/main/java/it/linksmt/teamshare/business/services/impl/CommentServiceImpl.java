package it.linksmt.teamshare.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.converter.CommentConverter;
import it.linksmt.teamshare.business.dtos.CommentDto;
import it.linksmt.teamshare.business.request.CommentRequestDto;
import it.linksmt.teamshare.business.services.CommentService;
import it.linksmt.teamshare.entities.Comment;
import it.linksmt.teamshare.repository.CommentRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public CommentDto addComment(CommentRequestDto comment) {
		Comment comm = CommentConverter.MAPPER.toComment(comment);
		comm = commentRepository.save(comm);
		return CommentConverter.MAPPER.toCommentDTO(comm);
	}

	@Override
	public CommentDto updateComment(Integer commId, CommentRequestDto commentReqDto) {
		Comment comm = CommentConverter.MAPPER.toComment(commentReqDto);
		comm.setId(commId);
		comm = commentRepository.save(comm);
		return CommentConverter.MAPPER.toCommentDTO(comm);
	}

	@Override
	public void deleteComment(Integer id) {
		commentRepository.deleteById(id);

	}

	@Override
	public List<CommentDto> searchCommentsOnPost(Integer idPost) {
		List<Comment> comments = (List<Comment>) commentRepository.findAllByIdPost(idPost);
	// LIST USING STREAM METHOD
	//	comments = comments.stream().filter(currentComment -> currentComment.getPost().getId() == idPost).collect(Collectors.toList());
		return CommentConverter.MAPPER.toListaCommentDTOResponse(comments);
	}

}