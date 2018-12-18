package it.linksmt.teamshare.dao.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.dao.entities.Activity;
import it.linksmt.teamshare.dao.entities.Sprint;

@Repository
public interface SprintRepository extends CrudRepository<Sprint, Integer> {

	//List<Sprint> findByActivity(Activity activity);
	
	List<Sprint> findByStartDate(Date startDate);
	
	List<Sprint> findByEndDate(Date endDate);
	
	List<Sprint> findByStartDateAndStartDate(Date startDate, Date endDate);
}
