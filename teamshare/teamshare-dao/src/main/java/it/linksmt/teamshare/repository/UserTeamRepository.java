package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;

import it.linksmt.teamshare.entities.UserTeam;

public interface UserTeamRepository extends CrudRepository<UserTeam, Integer> {

}
