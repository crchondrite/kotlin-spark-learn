package controller

import repository.BookRepository
import spark.Route
import spark.Spark.*

object BookController {
    fun route() {
        get("/book/hello") { _, _ -> "hello" }
        get("/book/bye")   { _, _ -> "bye" }
        get("/book/find-test") { _, _ -> BookRepository.testBook().isbn }
        get("/book/json-test", routeJsonTest(), JsonTransformer())
        get("/book/json-list-test", routeJsonListTest(), JsonTransformer())

    }

    private fun routeJsonTest() = Route {
        _, _ -> BookRepository.testBook()
    }

    private fun routeJsonListTest() = Route {
        _, _ -> BookRepository.testBooks()
    }
}
