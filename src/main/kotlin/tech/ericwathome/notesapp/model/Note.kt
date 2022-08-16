package tech.ericwathome.notesapp.model

import java.sql.Timestamp
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Table

@Table
data class Note(
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    val id: Long,
    val title: String,
    val description: String,
    val dateOfCreation: Timestamp
)