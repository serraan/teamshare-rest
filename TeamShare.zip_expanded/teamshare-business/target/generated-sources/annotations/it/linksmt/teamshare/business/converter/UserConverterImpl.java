package it.linksmt.teamshare.business.converter;

import it.linksmt.teamshare.business.dto.request.UserRequestDto;
import it.linksmt.teamshare.business.dtos.UserDto;
import it.linksmt.teamshare.dao.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-17T09:43:23+0100",
    comments = "version: 1.2.0.CR2, compiler: Eclipse JDT (IDE) 3.15.0.v20180905-0317, environment: Java 1.8.0_191 (Oracle Corporation)"
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

        userDto.setBirthDate( user.getBirthDate() );
        userDto.setEmail( user.getEmail() );
        userDto.setFirstName( user.getFirstName() );
        userDto.setLastName( user.getLastName() );
        userDto.setPassword( user.getPassword() );
        userDto.setId( user.getId() );

        return userDto;
    }

    @Override
    public User toUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setBirthDate( userDto.getBirthDate() );
        user.setEmail( userDto.getEmail() );
        user.setFirstName( userDto.getFirstName() );
        user.setId( userDto.getId() );
        user.setLastName( userDto.getLastName() );
        user.setPassword( userDto.getPassword() );

        return user;
    }

    @Override
    public User toUser(UserRequestDto userRequestDto) {
        if ( userRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setBirthDate( userRequestDto.getBirthDate() );
        user.setEmail( userRequestDto.getEmail() );
        user.setFirstName( userRequestDto.getFirstName() );
        user.setLastName( userRequestDto.getLastName() );
        user.setPassword( userRequestDto.getPassword() );

        return user;
    }
}
