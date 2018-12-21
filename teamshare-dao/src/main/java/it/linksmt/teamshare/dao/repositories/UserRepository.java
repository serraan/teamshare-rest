package it.linksmt.teamshare.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.dao.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	List<User> findByEmailContainingAndNomeContainingAndCognomeContaining(String email, String nome, String cognome);
}