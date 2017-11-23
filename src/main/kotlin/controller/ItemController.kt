package controller

import repository.ItemRepository
import spark.Route

object ItemController {
   fun count() = Route { _, _ ->
      ItemRepository.count()
   }
}