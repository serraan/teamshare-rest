package it.linksmt.teamshare.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.dao.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	List<User> findByEmail(String email);

	List<User> findByFirstName(String firstName);

	List<User> findByLastName(String lastName);
	
	List<User> findByFirstNameAndLastName(String firstName, String lastName);
	
	List<User> findByEmailContainingIgnoreCaseAndFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String email, String firstName, String lastName);
//	List<User> findAll();
//	
//	User findAllById(Integer id);
	
//	@Query(value = "SELECT * FROM utente t WHERE t.email LIKE %:email% && t.nome LIKE %:firstName% && t.cognome LIKE %:lastName%", nativeQuery = true)
//	List<User> findBy(@Param("email") String email, 
//		@Param("firstName") String firstName, 
//		@Param("lastName") String lastName);
	
}