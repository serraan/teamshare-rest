package it.linksmt.teamshare.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.linksmt.teamshare.dao.entities.State;

public interface StateRepository extends CrudRepository<State, Integer> {

	List<State> findByName(String name);
	
}
