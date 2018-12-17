package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;

import it.linksmt.teamshare.entities.Team;

public interface TeamRepository extends CrudRepository<Team, Integer> {

}
