package entity

import org.mongodb.morphia.annotations.Entity
import org.mongodb.morphia.annotations.Id

@Entity("super_items")
data class SuperItem(
        @Id
        val id: String,

        val name: String,

        val goodValue: Int,

        val enabled: Boolean,

        val variations: List<Variation>
) {
    constructor() : this(
            "", "", 0, false, listOf()
    )
}

data class Variation(
        val id: Int,
        val value: String
) {
    constructor() : this(
            1, "1"
    )
}
