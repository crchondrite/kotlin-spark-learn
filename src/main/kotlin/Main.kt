import controller.BookController
import controller.ItemController
import controller.JsonTransformer
import spark.Spark.get
import spark.Spark.path

fun main(args: Array<String>) {
    path("/books") {
        get("/json-test", BookController.routeJsonTest(), JsonTransformer)
        get("/json-list-test", BookController.routeJsonListTest(), JsonTransformer)
        get("/cache-test/:isbn", BookController.routeCacheTest(), JsonTransformer)
    }

    path("/items") {
        get("/count", ItemController.count())
        get("/all",   ItemController.all(), JsonTransformer)
        get("/new",   ItemController.new())
        get("/find_by_value",  ItemController.findByValue(), JsonTransformer)
        get("/find_by_name",  ItemController.findByName(), JsonTransformer)
    }
}