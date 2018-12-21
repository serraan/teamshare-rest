package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dtos.CommentDto;
import it.linksmt.teamshare.business.request.CommentRequestDto;

public interface CommentService {
	
	public List<CommentDto> searchCommentsOnPost(Integer idPost);
	public CommentDto addComment(CommentRequestDto comment);
	public CommentDto updateComment(Integer commId, CommentRequestDto commentReqDto);
	public void deleteComment(Integer id);
}
