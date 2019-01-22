package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.NoteConverter;
import it.linksmt.teamshare.business.dto.request.NoteRequestDto;
import it.linksmt.teamshare.business.dtos.NoteDto;
import it.linksmt.teamshare.business.services.NoteService;
import it.linksmt.teamshare.dao.entities.Note;
import it.linksmt.teamshare.dao.repositories.NoteRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteRepository noteRepository;

	@Override
	public List<NoteDto> getNotes() {

		List<Note> notes = (List<Note>) noteRepository.findAll();
		
		return NoteConverter.MAPPER.toListNoteDto(notes);
	}

	@Override
	public NoteDto getNote(Integer noteId) {

		Optional<Note> note = noteRepository.findById(noteId);

		return NoteConverter.MAPPER.toNoteDto(note.get());
	}

	@Override
	public NoteDto addNote(NoteRequestDto noteRequestDto) {

		Note note = NoteConverter.MAPPER.toNote(noteRequestDto);
		
		note = noteRepository.save(note);
		
		return NoteConverter.MAPPER.toNoteDto(note);
	}

	@Override
	public NoteDto updateNote(Integer noteId, NoteRequestDto noteRequestDto) {

		Note note = NoteConverter.MAPPER.toNote(noteRequestDto);
		note.setId(noteId);
		
		note = noteRepository.save(note);

		return NoteConverter.MAPPER.toNoteDto(note);
	}

	@Override
	public void deleteNote(Integer noteId) {
		
		noteRepository.deleteById(noteId);
	}
	
}
