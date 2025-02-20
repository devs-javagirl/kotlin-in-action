package org.javagirls.chapter_2

fun main() {
    println("KOTLIN --------------------------")
    val input = readln()
    val name = if (input.isNotBlank()) input else "Kotlin"

    // $variável é substituído pelo conteúdo da mesma
    println("Hello, $name!")

    // complex expression dentro de um string template, utilizar chaves
    println("Hello, ${name.length} letter person!")

    // complex expression utilizando chaves ( pode conter aspas )
    println("Hello, ${if (name.isBlank()) "someone" else name }!")
    
    // utilizar barra invertida para imprimir $
    println("\$name utilizar barra invertida para imprimir $")



}