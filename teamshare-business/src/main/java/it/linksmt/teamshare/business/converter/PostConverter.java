package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.PostRequestDto;
import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.dao.entities.Post;

@Mapper
public interface PostConverter {

	PostConverter MAPPER = Mappers.getMapper(PostConverter.class);

	List<PostDto> toListaPostDTOResponse(Iterable<Post> allPosts);

	 @Mapping(target = "idUtente", source = "utenteCreatore.id")
	 PostDto toPostDto(Post post);

	@Mapping(target = "utenteCreatore.id", source = "idUtente")
	Post toPost(PostDto postDto);

	@Mapping(target = "utenteCreatore.id", source = "idUtente")
	 Post toPost(PostRequestDto postRequestDto);

}

