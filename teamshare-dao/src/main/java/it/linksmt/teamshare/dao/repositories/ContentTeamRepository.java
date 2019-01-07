package it.linksmt.teamshare.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.dao.entities.ContentTeam;

@Repository
public interface ContentTeamRepository extends CrudRepository<ContentTeam, Integer>{

}
