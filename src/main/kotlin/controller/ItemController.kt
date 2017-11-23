package controller

import entity.SuperItem
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

    fun findByValue() = Route { _, _ ->
        val data = ItemRepository.findByValue()
        data ?: "{data: \"null\"}"
    }

    fun findByName() = Route { _, _ ->
        val data = ItemRepository.findByName()
        data ?: "{data: \"null\"}"
    }
}