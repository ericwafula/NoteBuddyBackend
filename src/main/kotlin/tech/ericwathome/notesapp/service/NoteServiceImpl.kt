package tech.ericwathome.notesapp.service

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import tech.ericwathome.notesapp.model.Note
import tech.ericwathome.notesapp.repository.NoteRepository

@Service
@RequiredArgsConstructor
class NoteServiceImpl(
    private val noteRepository: NoteRepository
) : NoteService {

}