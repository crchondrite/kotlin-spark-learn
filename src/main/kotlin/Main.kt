import controller.BookController
import spark.Spark.before
import spark.Spark.get

fun main(args: Array<String>) {
    before("*", { _, res ->
        // res.type("application/json")
        res.header("Content-Encoding", "gzip")
        res.header("Cache-Control", "no-store")
    })

    get("/books", BookController.findAll())
}