package it.linksmt.teamshare.business.converter;

import it.linksmt.teamshare.business.dto.request.PostRequestDto;
import it.linksmt.teamshare.business.dtos.PostDto;
import it.linksmt.teamshare.dao.entities.Post;
import it.linksmt.teamshare.dao.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-18T14:33:17+0100",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class PostConverterImpl implements PostConverter {

    @Override
    public List<PostDto> toListPostDto(Iterable<Post> allPosts) {
        if ( allPosts == null ) {
            return null;
        }

        List<PostDto> list = new ArrayList<PostDto>();
        for ( Post post : allPosts ) {
            list.add( toPostDto( post ) );
        }

        return list;
    }

    @Override
    public PostDto toPostDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDto postDto = new PostDto();

        Integer id = postUserCreatorId( post );
        if ( id != null ) {
            postDto.setIdUserCreator( id );
        }
        postDto.setTitle( post.getTitle() );
        postDto.setDescription( post.getDescription() );
        postDto.setReference( post.getReference() );
        postDto.setDatePublication( post.getDatePublication() );
        postDto.setId( post.getId() );

        return postDto;
    }

    @Override
    public Post toPost(PostDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        Post post = new Post();

        post.setUserCreator( postDtoToUser( postDto ) );
        post.setDatePublication( postDto.getDatePublication() );
        post.setId( postDto.getId() );
        post.setTitle( postDto.getTitle() );
        post.setDescription( postDto.getDescription() );
        post.setReference( postDto.getReference() );

        return post;
    }

    @Override
    public Post toPost(PostRequestDto postRequestDto) {
        if ( postRequestDto == null ) {
            return null;
        }

        Post post = new Post();

        post.setUserCreator( postRequestDtoToUser( postRequestDto ) );
        post.setDatePublication( postRequestDto.getDatePublication() );
        post.setTitle( postRequestDto.getTitle() );
        post.setDescription( postRequestDto.getDescription() );
        post.setReference( postRequestDto.getReference() );

        return post;
    }

    private Integer postUserCreatorId(Post post) {
        if ( post == null ) {
            return null;
        }
        User userCreator = post.getUserCreator();
        if ( userCreator == null ) {
            return null;
        }
        Integer id = userCreator.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected User postDtoToUser(PostDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( postDto.getIdUserCreator() );

        return user;
    }

    protected User postRequestDtoToUser(PostRequestDto postRequestDto) {
        if ( postRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( postRequestDto.getIdUserCreator() );

        return user;
    }
}
