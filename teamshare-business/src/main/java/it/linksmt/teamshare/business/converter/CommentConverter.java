package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.CommentRequestDto;
import it.linksmt.teamshare.business.dtos.CommentDto;
import it.linksmt.teamshare.dao.entities.Comment;

@Mapper
public interface CommentConverter {
	
		CommentConverter MAPPER = Mappers.getMapper(CommentConverter.class);
		
		@Mappings({ @Mapping(target = "idUtente", source = "utente.id"),
			@Mapping(target = "idPost", source = "post.id") })
		CommentDto toCommentDTO(Comment comment);
		
		@Mappings({ @Mapping(target = "utente.id", source = "idUtente"),
			@Mapping(target = "post.id", source = "idPost") })
		Comment toComment(CommentDto commentDto);
		
		@Mappings({ @Mapping(target = "utente.id", source = "idUtente"),
			@Mapping(target = "post.id", source = "idPost") })
		Comment toComment(CommentRequestDto commentRequestDto);
		
		List<CommentDto> toListaCommentDTOResponse(Iterable<Comment> commentsByPost);

}
