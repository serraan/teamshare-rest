package it.linksmt.teamshare.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.dao.entities.TeamContent;

@Repository
public interface TeamContentRepository extends CrudRepository<TeamContent, Integer> {

}
