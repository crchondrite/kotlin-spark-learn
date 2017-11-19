package entity

import com.squareup.moshi.Json

data class Book(
    val isbn:String,
    val title:String,
    val price:Int,

    @Json(name = "author-description")
    val author: Author
)
