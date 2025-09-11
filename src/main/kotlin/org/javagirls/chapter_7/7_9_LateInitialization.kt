package org.javagirls.chapter_7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


class MyService {
    fun performAction(): String = "Action Done!"
}


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyTestNullable {
    private var myService: MyService? = null

    @BeforeAll
    fun setUp() {
        myService = MyService()
    }

    @Test
    fun testAction() {
        assertEquals("Action Done!", myService!!.performAction())
    }
}

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyTest {
    private lateinit var myService: MyService

    @BeforeAll
    fun setUp() {
        myService = MyService()
    }

    @Test
    fun testAction() {
        assertEquals("Action Done!", myService.performAction())
    }
}

