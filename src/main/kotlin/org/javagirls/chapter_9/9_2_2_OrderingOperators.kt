package org.javagirls.chapter_9

class PersonOperator(
    val firstName: String,
    val lastName: String
): Comparable<PersonOperator> {
    override fun compareTo(other: PersonOperator): Int {
        val result = compareValuesBy(this, other,
            PersonOperator::lastName, PersonOperator::firstName)
        println("Comparing $result")
        return result
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PersonOperator) return false
        return other.firstName == firstName && other.lastName == lastName
    }
    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        return result
    }
}

fun main() {
    val p1 = PersonOperator("Alice", "Smith")
    val p2 = PersonOperator("Bob", "Johnson")
    val p3 = PersonOperator("Charlie", "Johnson")
    val p4 = PersonOperator("Charlie", "Johnson")

    println(p1 < p2) // 9
    println(p2 < p3) // -1
    println(p4 < p3) // 0
    println(p4 > p3) // 0
    println(p4 == p3) // precisa implementar equals e hashcode para ser coerente

    println("abc" < "bca")
    println("abc" < "abc")
    println("abc" > "abc")
    println("abc" == "abc")
    println("abc" === "abc")
}
