package it.linksmt.teamshare.business.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import it.linksmt.teamshare.business.dto.request.NoteRequestDto;
import it.linksmt.teamshare.business.dtos.NoteDto;
import it.linksmt.teamshare.dao.entities.Note;

@Mapper
public interface NoteConverter {

	NoteConverter MAPPER = Mappers.getMapper(NoteConverter.class);
	
	List<NoteDto> toListNoteDto(List<Note> notes);
	
	@Mappings({
		@Mapping(target = "idActivity", source = "activity.id")
	})
	NoteDto toNoteDto(Note note);
	
	@Mappings({
		@Mapping(target = "activity.id", source = "idActivity")
	})
	Note toNote(NoteDto noteDto);
	
	@Mappings({
		@Mapping(target = "activity.id", source = "idActivity")
	})
	Note toNote(NoteRequestDto noteRequestDto);
	
}
