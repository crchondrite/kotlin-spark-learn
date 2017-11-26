package entity

import org.mongodb.morphia.annotations.Entity
import org.mongodb.morphia.annotations.Id
import org.mongodb.morphia.annotations.Property

@Entity("collection_update_observer")
data class CollectionUpdateObserver(
        @Id
        val id: String,

        val version: Long,

        @Property("last_modified")
        val lastModified: Long
) {
    constructor() : this(
            "", 0L, 0L
    )
}
