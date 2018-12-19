package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.NoteRequestDto;
import it.linksmt.teamshare.business.dtos.NoteDto;
import it.linksmt.teamshare.dao.entities.Note;


@Mapper
public interface NoteConverter {

	NoteConverter MAPPER = Mappers.getMapper(NoteConverter.class);

	List<NoteDto> toListNoteDTO(Iterable<Note> allNote);

	NoteDto toNoteDTO(Note note);
	
	Note toNote(NoteDto noteDto);
	
	Note toNote(NoteRequestDto noteRequestDto);
}
