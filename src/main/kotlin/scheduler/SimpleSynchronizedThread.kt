package scheduler

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread
import kotlin.concurrent.withLock

object SimpleSynchronizedThread {
    fun run() {
        val lock = ReentrantLock()
        (1..10).forEach {
            thread {
                lock.withLock {
                    print("<")
                    Thread.sleep(500L)
                    print(">")
                }
            }
        }
    }
}