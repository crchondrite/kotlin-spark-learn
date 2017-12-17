import controller.BookController
import controller.JsonTransformer
import spark.Spark.get

fun main(args: Array<String>) {
    get("/books", BookController.findAll())
}