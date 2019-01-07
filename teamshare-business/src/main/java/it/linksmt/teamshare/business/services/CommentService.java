package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.CommentRequestDto;
import it.linksmt.teamshare.business.dtos.CommentDto;

public interface CommentService {

	public List<CommentDto> getComments();

	public CommentDto getComment(Integer id);

	public CommentDto addComment(CommentRequestDto commentRequestDto);

	public CommentDto updateComment(Integer commentId, CommentRequestDto commentRequestDto);

	public void deleteComment(Integer id);
	
}
