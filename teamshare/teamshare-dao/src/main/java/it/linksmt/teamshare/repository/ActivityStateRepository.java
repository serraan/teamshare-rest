package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.ActivityState;
@Repository
public interface ActivityStateRepository extends CrudRepository<ActivityState, Integer> {

}
