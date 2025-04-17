package org.javagirls.chapter_4

data class CustomerData(val name: String, val postalCode: Int)

fun main() {
    val c1 = CustomerData("Sam", 34934)
    val c2 = CustomerData("Mart", 13404)
    val c3 = CustomerData("Sam", 34934)

    println(c1)
    println("c1 == c2: ${c1 == c2}")
    println("c1 == c3: ${c1 == c3}")

    println(c1.hashCode())
    println(c3.hashCode())

    val processed = hashSetOf(c1, c2)
    println(processed.contains(c3))

    println("Conteudo de c1 é igual a c3 ? ${c1 == c3}") //conteúdo
    println("referência de c1 é igual a c3 ? ${c1 === c3}") //endereço


    val c4 = c2.copy(name = "John")
    val c5 = c3; //cuidado com isso
    println("Cópia de c2: ${c4.name}, ${c4.postalCode}")
    println("Cópia de c3: ${c5.name}, ${c5.postalCode}, ${c5 === c3})")

}
