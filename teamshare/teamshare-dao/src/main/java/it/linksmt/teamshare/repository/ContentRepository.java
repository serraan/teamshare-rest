package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Content;
@Repository
public interface ContentRepository extends CrudRepository<Content, Integer> {

}
