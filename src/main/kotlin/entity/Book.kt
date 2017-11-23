package entity

import com.squareup.moshi.Json

data class Book(
    val isbn:String,
    val title:String,
    val price:Int,

    @Json(name = "author-description")
    val author: Author
)

data class Author(
        @Json(name = "id")
        val authorId:String,

        @Json(name = "name")
        val authorName:String
)
