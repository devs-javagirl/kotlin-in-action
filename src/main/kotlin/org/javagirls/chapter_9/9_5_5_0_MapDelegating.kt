package org.javagirls.chapter_9

class Person4 {
    private val _attributes = mutableMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    var name: String
        get() = _attributes["name"]!!
        set(value) {
            _attributes["name"] = value
        }
}

fun main() {
    val p = Person4()
    val data = mapOf("name" to "Seb", "company" to "JetBrains")

    for ((attrName, value) in data)
        p.setAttribute(attrName, value)

    println(p.name)
    p.name = "Sebastian"
    println(p.name)

}