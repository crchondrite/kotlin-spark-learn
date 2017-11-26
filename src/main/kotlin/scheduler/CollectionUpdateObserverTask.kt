package scheduler

import service.CollectionUpdateObserverService

object CollectionUpdateObserverTask {
    private var increment = 0L

    fun task() {
        increment += CollectionUpdateObserverService.findLatest().version
        println("latest_version_increment: " + increment)
    }
}
