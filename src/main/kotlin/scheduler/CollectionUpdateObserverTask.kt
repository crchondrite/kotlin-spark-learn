package scheduler

import service.CollectionUpdateObserverService
import service.SuperItemService

object CollectionUpdateObserverTask {
    private var increment = 0L

    fun task() {
        println(SuperItemService.publicProperty)
        var latestVersion = CollectionUpdateObserverService.findLatest().version

        if (latestVersion > SuperItemService.publicProperty)
            SuperItemService.publicProperty = latestVersion.toInt()
    }
}
