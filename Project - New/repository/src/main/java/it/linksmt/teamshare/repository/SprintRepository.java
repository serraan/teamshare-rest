package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Sprint;
@Repository
public interface SprintRepository extends CrudRepository<Sprint, Integer> {

}
