package controller

import repository.BookRepository
import service.BookService
import spark.Route
import spark.Spark.*

object BookController {
    fun route() {
        get("/book/hello") { _, _ -> "hello" }
        get("/book/bye")   { _, _ -> "bye" }
        get("/book/find-test") { _, _ -> BookRepository.testBook().isbn }
        get("/book/json-test", routeJsonTest(), JsonTransformer())
        get("/book/json-list-test", routeJsonListTest(), JsonTransformer())
        get("/book/cache-test/:isbn", routeCacheTest(), JsonTransformer())
    }

    private fun routeJsonTest() = Route { _, _ ->
        BookRepository.testBook()
    }

    private fun routeJsonListTest() = Route { _, _ ->
        BookRepository.testBooks()
    }

    private fun routeCacheTest() = Route { req, _ ->
        BookService.testCacheBook(req.params("isbn"))
    }
}
