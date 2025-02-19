package org.javagirls.capitulo_2

fun main() {
    println("KOTLIN --------------------------")
    // construtor sem uso de new
    val `4Person` = Person("Bob", true)
    // acesso direto a propriedade name, mas o getter é invocado
    println(`4Person`.name)
    println(`4Person`.isStudent)
    //acesso direto a propriedade, mas o setter é invocado
    `4Person`.isStudent = false
    println(`4Person`.isStudent)
}