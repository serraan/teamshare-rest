package it.linksmt.teamshare.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.dao.entities.TeamUser;

@Repository
public interface TeamUserRepository extends CrudRepository<TeamUser, Integer> {

}
