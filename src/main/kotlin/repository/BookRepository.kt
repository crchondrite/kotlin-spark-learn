package repository

import entity.Author
import entity.Book

object BookRepository {
    fun testBook(): Book = Book("9784839961749", "Kotlin in Action", 4114, Author("1", "foo"))

    fun testBooks(): List<Book> = listOf(
        Book("9784839961749", "Kotlin in Action", 4114, Author("1", "foo")),
        Book("9784839961741", "Spark  in Action", 2110, Author("2", "bar"))
    )

    fun testCacheBook(isbn: String) : Book = Book(isbn + System.currentTimeMillis(), "Kotlin in Action", 4114, Author("1", "foo"))
}