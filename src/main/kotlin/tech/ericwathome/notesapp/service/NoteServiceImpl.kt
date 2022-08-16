package tech.ericwathome.notesapp.service

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import tech.ericwathome.notesapp.dto.NoteDto
import tech.ericwathome.notesapp.model.Note
import tech.ericwathome.notesapp.repository.NoteRepository
import java.util.*
import javax.persistence.EntityNotFoundException

@Service
@RequiredArgsConstructor
class NoteServiceImpl(
    private val noteRepository: NoteRepository
) : NoteService {
    override fun newNote(noteDto: NoteDto) {
        noteRepository.save(Note(
            title = noteDto.title,
            description = noteDto.description,
            dateOfCreation = Date()
        ))
    }

    override fun allNotes(): List<Note> {
        return noteRepository.findAll()
    }

    override fun findNote(id: Long): Note {
        return try {
            noteRepository.findById(id).get()
        } catch (e: Exception) {
          throw EntityNotFoundException("CANT_FIND_NOTE_WITH_ID: $id, Exception=${e.message}")
        }
    }

    override fun searchNotes(title: String): List<Note> {
        return noteRepository.findNoteByTitleContainsIgnoreCase(title)
    }

    override fun updateNote(id: Long, noteDto: NoteDto) {
        val note = try {
            noteRepository.findById(id).get()
        } catch (e: Exception) {
            throw EntityNotFoundException("CANT_FIND_NOTE_WITH_ID: $id, Exception=${e.message}")
        }
        note.apply {
            if (noteDto.title.isNotBlank()) {
                title = noteDto.title
            }
            if (noteDto.description.isNotBlank()) {
                description = noteDto.description
            }
        }
        noteRepository.save(note)
    }

    override fun deleteNote(id: Long) {
        try {
            noteRepository.deleteById(id)
        } catch (e: Exception) {
            throw EntityNotFoundException("CANT_FIND_NOTE_WITH_ID: $id, Exception=${e.message}")
        }
    }

}