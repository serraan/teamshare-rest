package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.TeamContent;
@Repository
public interface TeamContentRepository extends CrudRepository<TeamContent, Integer> {

}
