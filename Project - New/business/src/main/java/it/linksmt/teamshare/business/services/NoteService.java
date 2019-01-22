package it.linksmt.teamshare.business.services;

import java.util.List;

import it.linksmt.teamshare.business.dtos.NoteDto;
import it.linksmt.teamshare.business.request.NoteRequestDto;

public interface NoteService {
	
	public List<NoteDto> getNote();
	public NoteDto addNote(NoteRequestDto nota);
	public NoteDto updateNote(Integer idNota, NoteRequestDto nota );
	public void deleteNote(Integer idNota);
}
