package controller

import repository.ItemRepository
import spark.Route

object ItemController {
    fun count() = Route { _, _ ->
        ItemRepository.count()
    }

    fun all() = Route { _, _ ->
        ItemRepository.findAll()
    }

    fun new() = Route { _, _ ->
        ItemRepository.insert()

    }
}