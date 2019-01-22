package it.linksmt.teamshare.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Impediment;
@Repository
public interface ImpedimentRepository extends CrudRepository<Impediment, Integer> {
	
}
