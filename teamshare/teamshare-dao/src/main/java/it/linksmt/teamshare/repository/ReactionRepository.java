package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Reaction;
@Repository
public interface ReactionRepository extends CrudRepository<Reaction, Integer> {

}
