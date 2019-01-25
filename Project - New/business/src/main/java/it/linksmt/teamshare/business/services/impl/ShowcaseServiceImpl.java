package it.linksmt.teamshare.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.teamshare.business.dtos.CommentDto;
import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.ShowcaseRequestDto;
import it.linksmt.teamshare.business.services.PostService;
import it.linksmt.teamshare.business.services.ShowcaseService;
import it.linksmt.teamshare.business.services.UserService;
import it.linksmt.teamshare.converter.CommentConverter;
import it.linksmt.teamshare.converter.PostConverter;
import it.linksmt.teamshare.entities.Comment;
import it.linksmt.teamshare.entities.Post;
import it.linksmt.teamshare.repository.CommentRepository;
import it.linksmt.teamshare.repository.PostRepository;
@Service
@Transactional
public class ShowcaseServiceImpl implements ShowcaseService {

	@Autowired
	private PostService postSrv;
	
	@Autowired
	private PostRepository postRepo;
	@Autowired
	private UserService userSrv;
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<ShowcaseRequestDto> getShowcase() {
		List<ShowcaseRequestDto> showCase = new ArrayList<ShowcaseRequestDto>();
		List<PostDto> posts = postSrv.getAll();
		for (PostDto p : posts) {
			ShowcaseRequestDto dto = new ShowcaseRequestDto();
			UserDto us = userSrv.getUser(p.getIdUtente());
			dto.setUser(us);
			Post po =  new Post();
			po= PostConverter.MAPPER.toPost(p);
			List<Comment> c = commentRepository.findByPost(po);
			List<CommentDto> commDto = new ArrayList<CommentDto>();
			for (Comment comm : c) {
				commDto.add(CommentConverter.MAPPER.toCommentDTO(comm));
				
			}
			dto.setComments(commDto);
			dto.setPost(p);
			showCase.add(dto);
		}
		return showCase;
	}

}
