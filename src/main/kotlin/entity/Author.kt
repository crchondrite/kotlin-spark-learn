package entity

import com.squareup.moshi.Json

data class Author(
    @Json(name = "id")
    val authorId:String,

    @Json(name = "name")
    val authorName:String
)


