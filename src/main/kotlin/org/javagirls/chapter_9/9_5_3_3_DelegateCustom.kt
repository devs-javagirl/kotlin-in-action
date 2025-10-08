package org.javagirls.chapter_9

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Person3(val name: String, age: Int, salary: Int): Observable() {
    private val onChange = { property: KProperty<*>, oldValue: Any?,
        newValue: Any? ->
            notifyObservers(property.name, oldValue, newValue)
            println("property ${property.name} oldValue $oldValue newValue $newValue")
    }

    var age by Delegates.observable(age, onChange)
    var salary by Delegates.observable(salary, onChange)

}

fun main() {
    val p = Person3("Seb", 28, 1000)

    p.age = 29
    // Property age changed from 28 to 29!
    p.salary = 1500
    // Property salary changed from 1000 to 1500!

}
