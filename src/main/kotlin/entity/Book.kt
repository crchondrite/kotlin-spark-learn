package entity

import org.bson.types.ObjectId
import org.mongodb.morphia.annotations.Entity
import org.mongodb.morphia.annotations.Id

@Entity("books")
data class Book(
    @Id
    val id: ObjectId = ObjectId(),
    val title: String = "",
    val isbn: String = "",
    val price: Int = 0,
    val publisher: String = "",
    val authors: List<String> = listOf(),
    val description: String = ""
)
