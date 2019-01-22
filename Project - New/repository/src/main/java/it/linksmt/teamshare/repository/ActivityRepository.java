package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Activity;


@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
	
}