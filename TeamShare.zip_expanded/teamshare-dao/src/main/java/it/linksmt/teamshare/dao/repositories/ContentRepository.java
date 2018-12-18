package it.linksmt.teamshare.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.linksmt.teamshare.dao.entities.Content;

public interface ContentRepository extends CrudRepository<Content, Integer> {

	List<Content> findAll();

	Content findAllById(Integer id);
	// findByTeam

}
