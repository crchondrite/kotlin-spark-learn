package service

import repository.BookRepository

object BookService {
    fun findAll() = BookRepository.findAll()
}