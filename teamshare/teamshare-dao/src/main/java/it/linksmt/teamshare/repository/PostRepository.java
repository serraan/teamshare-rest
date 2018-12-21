package it.linksmt.teamshare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Post;
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
		@Query(value = "SELECT * FROM tb_post AS p WHERE p.id_utente = :idUtente", nativeQuery = true)
		List<Post> findAllByIdUtente(@Param("idUtente") Integer idUtente);
		
		
}
