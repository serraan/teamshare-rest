package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.State;
@Repository
public interface StateRepository extends CrudRepository<State, Integer> {

}
