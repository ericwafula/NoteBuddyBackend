package tech.ericwathome.notesapp.controller

import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tech.ericwathome.notesapp.dto.NoteDto
import tech.ericwathome.notesapp.dto.PageDto
import tech.ericwathome.notesapp.dto.ResponseMessage
import tech.ericwathome.notesapp.model.Note
import tech.ericwathome.notesapp.service.NoteService

@RestController
@RequestMapping("api/v1/notes")
@RequiredArgsConstructor
class NoteController(
    private val noteService: NoteService
) {
    @PostMapping("new")
    fun newNote(@RequestBody noteDto: NoteDto): ResponseEntity<ResponseMessage> {
        val message = ResponseMessage("note added successfully")
        noteService.newNote(noteDto)
        return ResponseEntity(message, HttpStatus.OK)
    }

    @GetMapping
    fun allNotes(@RequestParam(defaultValue = "0") page: Int): ResponseEntity<PageDto> {
        return ResponseEntity(noteService.allNotes(page), HttpStatus.OK)
    }

    @GetMapping("find")
    fun findNote(@RequestParam("id") id: Long): ResponseEntity<Note> {
        return ResponseEntity(noteService.findNote(id), HttpStatus.OK)
    }

    @PatchMapping("update")
    fun updateNote(@RequestParam("id") id: Long, @RequestBody noteDto: NoteDto): ResponseEntity<ResponseMessage> {
        val message = ResponseMessage("note with id: $id updated successfully")
        noteService.updateNote(id, noteDto)
        return ResponseEntity(message, HttpStatus.OK)
    }

    @DeleteMapping("delete")
    fun deleteNote(@RequestParam("id") id: Long): ResponseEntity<ResponseMessage> {
        val message = ResponseMessage("note with id: $id deleted successfully")
        noteService.deleteNote(id)
        return ResponseEntity(message, HttpStatus.OK)
    }
}