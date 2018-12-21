package it.linksmt.teamshare.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.linksmt.teamshare.dao.entities.Type;

public interface TypeRepository extends CrudRepository<Type, Integer> {
	
	List<Type> findByNomeContaining(String nome);
}
