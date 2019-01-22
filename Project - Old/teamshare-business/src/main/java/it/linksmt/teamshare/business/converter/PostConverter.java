package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.PostRequestDto;
import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.dao.entities.Post;

@Mapper
public interface PostConverter {

	PostConverter MAPPER = Mappers.getMapper(PostConverter.class);
	
	List<PostDto> toListPostDto(List<Post> posts);
	
	@Mappings({
		@Mapping(target = "idUser", source = "user.id")
	})
	PostDto toPostDto(Post post);
	
	@Mappings({
		@Mapping(target = "user.id", source = "idUser")
	})
	Post toPost(PostDto postDto);
	
	@Mappings({
		@Mapping(target = "user.id", source = "idUser")
	})
	Post toPost(PostRequestDto postRequestDto);

}
