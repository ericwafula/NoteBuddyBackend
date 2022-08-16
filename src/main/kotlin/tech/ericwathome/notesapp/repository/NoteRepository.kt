package tech.ericwathome.notesapp.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tech.ericwathome.notesapp.model.Note

@Repository
interface NoteRepository : JpaRepository<Note, Long> {
    fun findAllByTitleIgnoreCase(name: String): List<Note>
}