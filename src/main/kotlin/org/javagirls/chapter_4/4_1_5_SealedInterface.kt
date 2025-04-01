package org.javagirls.chapter_4

sealed interface Toggleable {
    fun toggle(): String
}

class LightSwitch: Toggleable {
    override fun toggle() = "Lights!"
}

class Camera: Toggleable {
    override fun toggle() = "Camera!"
}

fun main() {
    val obj: Toggleable
    obj = LightSwitch()

    when (obj) {
        is Camera -> println("Object = ${obj.toggle()}")
        is LightSwitch -> println("Object = ${obj.toggle()}")
        else -> println("other object") // else redundante
    }


}