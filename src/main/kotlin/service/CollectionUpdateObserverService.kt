package service

import entity.CollectionUpdateObserver
import repository.CollectionUpdateObserverRepository

object CollectionUpdateObserverService {
    fun findLatest(): CollectionUpdateObserver = CollectionUpdateObserverRepository.findLatest()
}