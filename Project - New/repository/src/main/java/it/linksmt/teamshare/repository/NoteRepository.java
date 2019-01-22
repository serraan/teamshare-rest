package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.teamshare.entities.Note;
@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {

}
