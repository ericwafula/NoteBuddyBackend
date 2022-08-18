package tech.ericwathome.notesapp.dto

import tech.ericwathome.notesapp.model.Note

data class PageDto (
    val currentPage: Int,
    val nextPage: Int,
    val previousPage: Int?,
    val totalPages: Int,
    val notes: List<Note>
)