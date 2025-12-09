package org.javagirls.chapter_11

import java.util.*
import kotlin.reflect.KClass

inline fun <reified T> loadService_() {
    //não é possível criar novas instâncias da classe especificada como type parameter
    //val x = T("Roberta", 34)
    ServiceLoader.load(T::class.java)
}

data class Person (val name: kotlin.String) {
    companion object {
        fun fromString(str: kotlin.String): Person = Person(str)
    }
}

fun main() {
    // criar instância a partir de T em loadService
    val person = Person("Sarah")

    loadService_<Person>()

}

/*
//Now, you want a generic function that, given a class type and a string,
calls the fromString method on that class's companion object:

fun <T> createFromString(clazz: KClass<T>, str: String): T {
    // This is pseudocode! You'd need reflection to actually call the companion object's method.
    val companion = clazz.companionObjectInstance
    val fromStringMethod = clazz.companionObject?.members?.first { it.name == "fromString" }
    return fromStringMethod?.call(companion, str) as T
}

 */