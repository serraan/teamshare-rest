package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;

import it.linksmt.teamshare.entities.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

}
