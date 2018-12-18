package it.linksmt.teamshare.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.dao.entities.Activity;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
	
	List<Activity> findAll();
	
	Activity findAllById(Integer id);

//	@Query(value = "SELECT * FROM attivita t WHERE t.titolo LIKE %:title% && t.descrizione LIKE %:description% && t.tipo LIKE %:type% && t.priorita LIKE %:priority%", nativeQuery = true)
//	List<Activity> findBy(@Param("title") String title,
//		@Param("description") String description,
//		@Param("type") String type,
//		@Param("priority") String priority);
}