package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.ActivitySprint;

@Repository
public interface ActivitySprintRepository extends CrudRepository<ActivitySprint, Integer> {

}
