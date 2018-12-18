package it.linksmt.teamshare.business.converter;

import it.linksmt.teamshare.business.dto.request.UserRequestDto;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.dao.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-18T14:33:16+0100",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class UserConverterImpl implements UserConverter {

    @Override
    public List<UserDto> toListUserDTO(Iterable<User> allUser) {
        if ( allUser == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>();
        for ( User user : allUser ) {
            list.add( toUserDTO( user ) );
        }

        return list;
    }

    @Override
    public UserDto toUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );
        userDto.setBirthDate( user.getBirthDate() );
        userDto.setId( user.getId() );

        return userDto;
    }

    @Override
    public User toUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );
        user.setBirthDate( userDto.getBirthDate() );
        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );

        return user;
    }

    @Override
    public User toUser(UserRequestDto userRequestDto) {
        if ( userRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( userRequestDto.getFirstName() );
        user.setLastName( userRequestDto.getLastName() );
        user.setBirthDate( userRequestDto.getBirthDate() );
        user.setEmail( userRequestDto.getEmail() );
        user.setPassword( userRequestDto.getPassword() );

        return user;
    }
}
