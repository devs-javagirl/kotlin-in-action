package org.javagirls.chapter_10

import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock

inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    }
    finally {
        lock.unlock()
    }
}

fun foo(l: Lock) {
    println("Before sync")
    synchronized(l) {
        println("Action")
    }
    println("After sync")
}

class FakeLock: Lock {
    override fun lock() {
        println("lock")
    }

    override fun lockInterruptibly() {
        println("lockInterruptibly")
    }

    override fun tryLock(): Boolean {
        println("tryLock")
        return true
    }

    override fun tryLock(time: Long, unit: TimeUnit): Boolean {
        TODO("Not yet implemented")
    }

    override fun unlock() {
        println("unlock")
    }

    override fun newCondition(): Condition {
        TODO("Not yet implemented")
    }

}

class LockOwner(val lock: Lock) {
    fun runUnderLock(body: () -> Unit) {
        synchronized(lock, body)
    }
}

fun main() {
    val fakeLock = FakeLock()
    foo(fakeLock)

    val lockOwner = LockOwner(fakeLock)
    lockOwner.runUnderLock { println("runUnderLock") }
}

