package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.CommentRequestDto;
import it.linksmt.teamshare.business.dtos.CommentDto;

public interface CommentService {
	
	public CommentDto addComment(CommentRequestDto comment);
	public CommentDto updateComment(Integer commId, CommentRequestDto commentReqDto);
	public void deleteComment(Integer id);
	//public Map<UserDto, Map<PostDto, CommentDto>> showUserCommentsAndPost(Integer idPost, Integer idUser);
	public List<CommentDto> searchCommentsOnPost(Integer idPost);
}
