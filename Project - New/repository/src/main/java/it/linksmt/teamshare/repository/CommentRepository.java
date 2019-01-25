package it.linksmt.teamshare.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Comment;
import it.linksmt.teamshare.entities.Post;
@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
	
	List<Comment> findByPost(Post post);
}
