package tech.ericwathome.notesapp.service

import tech.ericwathome.notesapp.dto.NoteDto
import tech.ericwathome.notesapp.model.Note

interface NoteService {
    fun newNote(noteDto: NoteDto)
    fun allNotes(): List<Note>
    fun findNote(id: Long): Note
    fun searchNotes(title: String): List<Note>
    fun updateNote(id: Long, noteDto: NoteDto)
    fun deleteNote(id: Long)
}