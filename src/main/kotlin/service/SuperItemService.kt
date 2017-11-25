package service

import entity.SuperItem
import repository.SuperItemRepository

object SuperItemService {

    val publicProperty = 0
    private val privateProperty = 1

    fun findByVariationValue(value: String) {
        val all = SuperItemRepository.findAll()
    }

    fun shouldReturnOne() = 1


    private fun shouldReturnTwo() = 2

    private fun matchVariationValue(entity: SuperItem): Boolean {
        return false
    }
}