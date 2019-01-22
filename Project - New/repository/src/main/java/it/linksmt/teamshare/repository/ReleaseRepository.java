package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Release;
@Repository
public interface ReleaseRepository extends CrudRepository<Release, Integer> {

}
