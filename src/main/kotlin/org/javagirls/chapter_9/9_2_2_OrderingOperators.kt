package org.javagirls.chapter_9

class PersonOperator(
    val firstName: String,
    val lastName: String
): Comparable<PersonOperator> {
    override fun compareTo(other: PersonOperator): Int {
        return compareValuesBy(this, other,
            PersonOperator::lastName, PersonOperator::firstName)
    }
}

fun main() {
    val p1 = PersonOperator("Alice", "Smith")
    val p2 = PersonOperator("Bob", "Johnson")
    val p3 = PersonOperator("Charlie", "Johnson")
    val p4 = PersonOperator("Charlie", "Johnson")
    println(p1 < p2)
    println(p2 < p3)

    println(p4 < p3)
    println(p4 > p3)
    println(p4 == p3) // precisa implementar equals e hashcode para ser coerente

    println("abc" < "bca")
    println("abc" < "abc")
    println("abc" > "abc")
    println("abc" == "abc")
    println("abc" === "abc")
}