package it.linksmt.teamshare.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.dao.entities.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
	
	List<Post> findAll();
	
}
