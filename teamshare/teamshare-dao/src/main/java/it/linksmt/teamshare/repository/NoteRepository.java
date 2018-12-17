package it.linksmt.teamshare.repository;

import org.springframework.data.repository.CrudRepository;

import it.linksmt.teamshare.entities.Note;

public interface NoteRepository extends CrudRepository<Note, Integer> {

}
