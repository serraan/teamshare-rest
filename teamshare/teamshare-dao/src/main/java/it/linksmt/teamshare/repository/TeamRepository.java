package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {
	Team findByNomeTeam(String nomeTeam);
}
