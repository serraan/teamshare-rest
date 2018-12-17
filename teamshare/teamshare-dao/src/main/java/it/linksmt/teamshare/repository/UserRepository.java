package it.linksmt.teamshare.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.User;



@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	List<User> findByEmailContainingAndFirstNameContainingAndLastNameContaining(String email, String firstName, String lastName);
}