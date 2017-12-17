package repository

import database.mongodb.DataStore.DB
import entity.Book

object BookRepository {
    fun findAll() : List<Book> = DB.createQuery(Book::class.java).asList()
}