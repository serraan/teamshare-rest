package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Type;
@Repository
public interface TypeRepository extends CrudRepository<Type, Integer> {

}
