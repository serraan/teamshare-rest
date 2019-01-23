
package it.linksmt.teamshare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Activity;




@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
	@Query(value="SELECT * FROM tb_attivita WHERE tb_attivita.id_utente_creatore = :idUtenteCreatore", nativeQuery= true)
	List<Activity> findByIdUtenteCreatore(@Param("idUtenteCreatore") Integer idUtenteCreatore);
	@Query(value="SELECT * FROM tb_attivita WHERE tb_attivita.id_utente_assegnatario = :idUtenteAssegnatario", nativeQuery= true)
	List<Activity> findByIdUtenteAssegnatario(@Param("idUtenteAssegnatario") Integer idUtenteAssegnatario);
}