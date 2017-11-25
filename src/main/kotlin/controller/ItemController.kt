package controller

import repository.SuperItemRepository
import spark.Route

object ItemController {
    fun count() = Route { _, _ ->
        SuperItemRepository.count()
    }

    fun all() = Route { _, _ ->
        SuperItemRepository.findAll()
    }

    fun new() = Route { _, _ ->
        SuperItemRepository.insert()
    }

    fun findByValue() = Route { _, _ ->
        val data = SuperItemRepository.findByValue()
        data ?: "{data: \"null\"}"
    }

    fun findByName() = Route { _, _ ->
        val data = SuperItemRepository.findByName()
        data ?: "{data: \"null\"}"
    }
}