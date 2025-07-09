package org.javagirls.chapter_7

class PersonNullable(val firstName: String, val lastName: String){

    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? PersonNullable ?: return false

        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
        firstName.hashCode() * 37 + lastName.hashCode()

}

fun main() {
    val p1 = PersonNullable("Dmitry", "Jemerov")
    val p2 = PersonNullable("Dimitry", "Jemerov")
    println(p1 == p2)

    println(p1.equals(p2))
}