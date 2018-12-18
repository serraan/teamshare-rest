package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.UserTeam;
@Repository
public interface UserTeamRepository extends CrudRepository<UserTeam, Integer> {

}
