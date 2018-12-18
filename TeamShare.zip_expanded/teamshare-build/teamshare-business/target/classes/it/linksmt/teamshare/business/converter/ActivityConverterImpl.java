package it.linksmt.teamshare.business.converter;

import it.linksmt.teamshare.business.dto.request.ActivityRequestDto;
import it.linksmt.teamshare.business.dtos.ActivityDto;
import it.linksmt.teamshare.dao.entities.Activity;
import it.linksmt.teamshare.dao.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-18T15:01:03+0100",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class ActivityConverterImpl implements ActivityConverter {

    @Override
    public List<ActivityDto> toListActivityDTO(Iterable<Activity> allUser) {
        if ( allUser == null ) {
            return null;
        }

        List<ActivityDto> list = new ArrayList<ActivityDto>();
        for ( Activity activity : allUser ) {
            list.add( toActivityDTO( activity ) );
        }

        return list;
    }

    @Override
    public ActivityDto toActivityDTO(Activity activity) {
        if ( activity == null ) {
            return null;
        }

        ActivityDto activityDto = new ActivityDto();

        Integer id = activityUserCreatorId( activity );
        if ( id != null ) {
            activityDto.setIdUserCreator( id );
        }
        Integer id1 = activityUserAssigneeId( activity );
        if ( id1 != null ) {
            activityDto.setIdUserAssignee( id1 );
        }
        activityDto.setTitle( activity.getTitle() );
        activityDto.setDescription( activity.getDescription() );
        activityDto.setType( activity.getType() );
        activityDto.setPriority( activity.getPriority() );
        activityDto.setDateTakenCharge( activity.getDateTakenCharge() );
        activityDto.setId( activity.getId() );

        return activityDto;
    }

    @Override
    public Activity toActivity(ActivityDto activityDto) {
        if ( activityDto == null ) {
            return null;
        }

        Activity activity = new Activity();

        activity.setUserAssignee( activityDtoToUser( activityDto ) );
        activity.setUserCreator( activityDtoToUser1( activityDto ) );
        activity.setId( activityDto.getId() );
        activity.setTitle( activityDto.getTitle() );
        activity.setDescription( activityDto.getDescription() );
        activity.setType( activityDto.getType() );
        activity.setPriority( activityDto.getPriority() );
        activity.setDateTakenCharge( activityDto.getDateTakenCharge() );

        return activity;
    }

    @Override
    public Activity toActivity(ActivityRequestDto activityRequestDto) {
        if ( activityRequestDto == null ) {
            return null;
        }

        Activity activity = new Activity();

        activity.setUserAssignee( activityRequestDtoToUser( activityRequestDto ) );
        activity.setUserCreator( activityRequestDtoToUser1( activityRequestDto ) );
        activity.setTitle( activityRequestDto.getTitle() );
        activity.setDescription( activityRequestDto.getDescription() );
        activity.setType( activityRequestDto.getType() );
        activity.setPriority( activityRequestDto.getPriority() );
        activity.setDateTakenCharge( activityRequestDto.getDateTakenCharge() );

        return activity;
    }

    private Integer activityUserCreatorId(Activity activity) {
        if ( activity == null ) {
            return null;
        }
        User userCreator = activity.getUserCreator();
        if ( userCreator == null ) {
            return null;
        }
        Integer id = userCreator.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer activityUserAssigneeId(Activity activity) {
        if ( activity == null ) {
            return null;
        }
        User userAssignee = activity.getUserAssignee();
        if ( userAssignee == null ) {
            return null;
        }
        Integer id = userAssignee.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected User activityDtoToUser(ActivityDto activityDto) {
        if ( activityDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( activityDto.getIdUserAssignee() );

        return user;
    }

    protected User activityDtoToUser1(ActivityDto activityDto) {
        if ( activityDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( activityDto.getIdUserCreator() );

        return user;
    }

    protected User activityRequestDtoToUser(ActivityRequestDto activityRequestDto) {
        if ( activityRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( activityRequestDto.getIdUserAssignee() );

        return user;
    }

    protected User activityRequestDtoToUser1(ActivityRequestDto activityRequestDto) {
        if ( activityRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( activityRequestDto.getIdUserCreator() );

        return user;
    }
}
