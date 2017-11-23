package repository

import database.mongodb.DataStore
import entity.SuperItem
import entity.Variation
import org.bson.types.ObjectId
import org.mongodb.morphia.Key

object ItemRepository {

    private val dataStore = DataStore.get()

    fun insert(): Int {
        val key: Key<SuperItem> = dataStore.save(
                SuperItem(ObjectId().toHexString(), "name" + System.currentTimeMillis().toString(), 3, true, listOf(Variation(2, "id")))
        )
        // DEBUG
        println(key)
        return 1
    }

    fun count() = dataStore.getCount(SuperItem::class.java)

    fun findAll() : List<SuperItem> = dataStore.createQuery(SuperItem::class.java).asList()

    fun findByValue() : SuperItem? = dataStore.createQuery(SuperItem::class.java).field("good_value").greaterThan(0).firstOrNull()

    fun findByName()  : SuperItem? = dataStore.createQuery(SuperItem::class.java).field("name").equal("test01").singleOrNull()
}