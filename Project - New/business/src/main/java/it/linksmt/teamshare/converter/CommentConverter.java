package it.linksmt.teamshare.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.CommentDto;
import it.linksmt.teamshare.business.request.CommentRequestDto;
import it.linksmt.teamshare.entities.Comment;

@Mapper
public interface CommentConverter {

	CommentConverter MAPPER = Mappers.getMapper(CommentConverter.class);

	List<CommentDto> toListCommentDTO(Iterable<Comment> allComments);

	@Mappings({ @Mapping(target = "idPost", source = "post.id"), @Mapping(target = "idUtente", source = "utente.id") })
	CommentDto toCommentDTO(Comment comment);

	@Mappings({ @Mapping(target = "post.id", source = "idPost"), @Mapping(target = "utente.id", source = "idUtente") })
	Comment toComment(CommentDto comment);

	@Mappings({ @Mapping(target = "post.id", source = "idPost"), @Mapping(target = "utente.id", source = "idUtente") })
	Comment toComment(CommentRequestDto comment);

}
