package service

import entity.SuperItem
import repository.SuperItemRepository

object SuperItemService {

    var publicProperty = 0
    private val privateProperty = 1

    fun findByVariationValue(value: String) =
            SuperItemRepository.findAll().filter { matchVariationValue(it, value) }

    fun add(a: Int, b: Int) = a + b

    fun shouldReturnOne() = 1

    private fun shouldReturnParameter(num: Int) = num

    private fun matchVariationValue(entity: SuperItem, value: String) =
        entity.variations.any { it.value == value }

    private fun matchVariationValue2() = true
}