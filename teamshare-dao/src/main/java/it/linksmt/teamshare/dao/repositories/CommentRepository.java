package it.linksmt.teamshare.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.dao.entities.Comment;
@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

	@Query(value = "SELECT * FROM tb_commento WHERE tb_commento.id_post = :idPost", nativeQuery = true)
	List<Comment> findAllByIdPost(@Param("idPost")Integer idPost);
	
}
