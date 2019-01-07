package it.linksmt.teamshare.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.dao.entities.Sprint;

@Repository
public interface SprintRepository extends CrudRepository<Sprint, Integer> {

}
