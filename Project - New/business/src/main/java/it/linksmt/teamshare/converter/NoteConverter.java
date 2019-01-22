package it.linksmt.teamshare.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dtos.NoteDto;
import it.linksmt.teamshare.business.request.NoteRequestDto;
import it.linksmt.teamshare.entities.Note;

@Mapper
public interface NoteConverter {



		NoteConverter MAPPER = Mappers.getMapper(NoteConverter.class);
		
		List<NoteDto> toListNoteDTO(Iterable<Note> allnote);
		@Mapping(target = "idAttivita", source = "attivita.id")
		NoteDto toNoteDTO(Note banca);
		@Mapping(target = "attivita.id", source = "idAttivita")
		Note toNote(NoteDto banca);
		@Mapping(target = "attivita.id", source = "idAttivita")
		Note toNote(NoteRequestDto banca);
	   

	}



