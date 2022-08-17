package tech.ericwathome.notesapp.model

import org.hibernate.Hibernate
import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Lob

@Entity
data class Note(
    @GeneratedValue(
        strategy = GenerationType.AUTO
    )
    @Id
    var id: Long? = null,
    @Lob
    var title: String,
    @Lob
    var description: String,
    val dateOfCreation: Date
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Note

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , title = $title , description = $description , dateOfCreation = $dateOfCreation )"
    }
}