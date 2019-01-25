package it.linksmt.teamshare.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Comment;
import it.linksmt.teamshare.entities.Post;
import it.linksmt.teamshare.entities.User;
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
	
	Optional<Post> findById(Integer idPost);
	
	List<Post> findByUtente(User utente);
}
