package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Post;
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

}
