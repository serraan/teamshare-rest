package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.UserRequestDto;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.dao.entities.User;

@Mapper
public interface UserConverter {

	UserConverter MAPPER = Mappers.getMapper(UserConverter.class);

	List<UserDto> toListUserDto(Iterable<User> users);

	UserDto toUserDto(User user);
	
	User toUser(UserDto userDto);
	
	User toUser(UserRequestDto userRequestDto);

}
