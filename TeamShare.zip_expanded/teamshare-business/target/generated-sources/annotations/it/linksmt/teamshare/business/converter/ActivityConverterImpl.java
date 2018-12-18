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
    date = "2018-12-17T09:43:23+0100",
    comments = "version: 1.2.0.CR2, compiler: Eclipse JDT (IDE) 3.15.0.v20180905-0317, environment: Java 1.8.0_191 (Oracle Corporation)"
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
        activityDto.setDateTakenCharge( activity.getDateTakenCharge() );
        activityDto.setDescription( activity.getDescription() );
        activityDto.setPriority( activity.getPriority() );
        activityDto.setTitle( activity.getTitle() );
        activityDto.setType( activity.getType() );
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
        activity.setDateTakenCharge( activityDto.getDateTakenCharge() );
        activity.setDescription( activityDto.getDescription() );
        activity.setId( activityDto.getId() );
        activity.setPriority( activityDto.getPriority() );
        activity.setTitle( activityDto.getTitle() );
        activity.setType( activityDto.getType() );

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
        activity.setDateTakenCharge( activityRequestDto.getDateTakenCharge() );
        activity.setDescription( activityRequestDto.getDescription() );
        activity.setPriority( activityRequestDto.getPriority() );
        activity.setTitle( activityRequestDto.getTitle() );
        activity.setType( activityRequestDto.getType() );

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
