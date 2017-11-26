package repository

import database.mongodb.DataStore
import entity.CollectionUpdateObserver

object CollectionUpdateObserverRepository {

    private val dataStore = DataStore.get()

    // order by last_modified desc ("-" means desc)
    fun findLatest() : CollectionUpdateObserver
            = dataStore.createQuery(CollectionUpdateObserver::class.java).order("-last_modified").first()
}
