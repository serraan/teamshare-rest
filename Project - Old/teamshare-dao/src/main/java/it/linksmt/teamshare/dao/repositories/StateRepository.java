package it.linksmt.teamshare.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.dao.entities.State;

@Repository
public interface StateRepository extends CrudRepository<State, Integer> {

}
