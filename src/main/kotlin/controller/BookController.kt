package controller

import repository.BookRepository
import service.BookService
import spark.Route

object BookController {
    fun routeJsonTest() = Route { _, _ ->
        BookRepository.testBook()
    }

    fun routeJsonListTest() = Route { _, _ ->
        BookRepository.testBooks()
    }

    fun routeCacheTest() = Route { req, _ ->
        BookService.testCacheBook(req.params("isbn"))
    }
}
