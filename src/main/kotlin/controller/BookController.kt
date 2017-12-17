package controller

import controller.MyTemplateEngine.TEMPLATE_ENGINE
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
