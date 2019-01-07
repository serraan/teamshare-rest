package it.linksmt.teamshare.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.dao.entities.Activity;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
	
	List<Activity> findByTitleContainingAndDescriptionContainingAndTypeContainingAndPriorityContaining(String title, String description, String type, String priority);
	
}