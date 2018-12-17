package it.linksmt.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.business.request.UserRequestDto;
import it.linksmt.teamshare.entities.User;

@Mapper
public interface UserConverter {

	UserConverter MAPPER = Mappers.getMapper(UserConverter.class);

	List<UserDto> toListUserDTO(Iterable<User> allUser);

	UserDto toUserDTO(User banca);
	
	User toUser(UserDto banca);
	
	User toUser(UserRequestDto banca);
   


}
