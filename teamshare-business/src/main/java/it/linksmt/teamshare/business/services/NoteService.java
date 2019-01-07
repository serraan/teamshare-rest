package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dto.request.NoteRequestDto;
import it.linksmt.teamshare.business.dtos.NoteDto;

public interface NoteService {

	public List<NoteDto> getNotes();

	public NoteDto getNote(Integer id);

	public NoteDto addNote(NoteRequestDto noteRequestDto);

	public NoteDto updateNote(Integer noteId, NoteRequestDto noteRequestDto);

	public void deleteNote(Integer id);
	
}
