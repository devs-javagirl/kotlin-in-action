package org.javagirls.chapter_7

class PersonNullable(var firstName: String, var lastName: String){

    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? PersonNullable ?: return false

        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
        firstName.hashCode() * 37 + lastName.hashCode()


}

fun main() {
    val p1 = Person("Dimitry", null, "")
    val p2 = PersonNullable("Dimitry", "Jemerov")
    val x = p1 as? PersonNullable ?: println("Cannot cast Person to PersonNullable")

    println(p1 == p2)
    println(p1.equals(p2))
   //println(p1 === p2)
}
