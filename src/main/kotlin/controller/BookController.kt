package controller

import controller.MytemplateEngine.TEMPLATE_ENGINE
import entity.Book
import service.BookService
import spark.ModelAndView
import spark.Route

object BookController {
    fun findAll() = Route { _, _ ->
        TEMPLATE_ENGINE.render(
            ModelAndView(
                mapOf("books" to BookService.findAll()), "index"
            )
        )
    }
}
