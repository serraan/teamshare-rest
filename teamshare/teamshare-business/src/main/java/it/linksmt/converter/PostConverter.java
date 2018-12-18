package it.linksmt.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.business.request.PostRequestDto;
import it.linksmt.teamshare.entities.Post;

@Mapper
public interface PostConverter {

	PostConverter MAPPER = Mappers.getMapper(PostConverter.class);

	List<PostDto> toListaPostDTOResponse(Iterable<Post> allPosts);

	 @Mapping(target = "idUtente", source = "utenteCreatore.idUtente")
	 PostDto toPostDto(Post post);

	@Mapping(target = "utenteCreatore.idUtente", source = "idUtente")
	Post toPost(PostDto postDto);

	@Mapping(target = "utenteCreatore.idUtente", source = "idUtente")
	 Post toPost(PostRequestDto postRequestDto);

}

