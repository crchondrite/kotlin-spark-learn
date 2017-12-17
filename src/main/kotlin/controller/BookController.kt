package controller

import service.BookService
import spark.Route

object BookController {
    fun findAll() = Route { _, _ ->
        JsonTransformer.render(BookService.findAll())
    }
}
