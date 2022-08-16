package tech.ericwathome.notesapp.model

import java.util.Date
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Table

@Table
data class Note(
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    var id: Long? = null,
    var title: String,
    var description: String,
    val dateOfCreation: Date
)