package org.javagirls.chapter_7



fun printAllCaps(str: String?) {
    val allCaps: String? =  str?.uppercase()
    println(allCaps)
}

fun main() {
    printAllCaps("abc")
    printAllCaps(null)

    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(developer))
    println(managerName(ceo))

    val person = Person("Dmitry", null, "dmitry@gmail.com")
    println(person.countryName())
}

class Employee(val name: String, val manager: Employee?)

fun managerName(employee:Employee): String? = employee.manager?.name

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?, val email: String)

fun Person.countryName(): String {
    val country = this.company?.address?.country
    return if (country != null) country else "Unknown"
}
