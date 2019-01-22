package it.linksmt.teamshare.business.services.impl;




	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.dtos.NoteDto;
import it.linksmt.teamshare.business.request.NoteRequestDto;
import it.linksmt.teamshare.business.services.NoteService;
import it.linksmt.teamshare.converter.NoteConverter;
import it.linksmt.teamshare.entities.Note;
import it.linksmt.teamshare.repository.NoteRepository;


	@Transactional
	@Service
	public class NoteServiceImpl  implements NoteService {
		
		@Autowired
		private NoteRepository noteRepository;

	
		@Override
		public List<NoteDto> getNote() {
			List<Note> att = (List<Note>) noteRepository.findAll();
			return NoteConverter.MAPPER.toListNoteDTO(att);		
		}

		@Override
		public NoteDto addNote(NoteRequestDto nota) {
			Note n = NoteConverter.MAPPER.toNote(nota);
			n = noteRepository.save(n);
			return NoteConverter.MAPPER.toNoteDTO(n);
			
		}

		@Override
		public NoteDto updateNote(Integer idNota, NoteRequestDto nota) {
			Note n = NoteConverter.MAPPER.toNote(nota);
			n.setId(idNota);
			n = noteRepository.save(n);
			return NoteConverter.MAPPER.toNoteDTO(n);
		}

		@Override
		public void deleteNote(Integer idNota) {
			noteRepository.deleteById(idNota);
		}

	}


