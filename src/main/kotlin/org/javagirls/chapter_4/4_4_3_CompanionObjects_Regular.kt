package org.javagirls.chapter_4

// Companion object nomeado como Loader
class Employee(val nickname: String) {
    companion object Loader {
        fun fromJsonSimpleQuote(jsonText: String): Employee =
            Employee(jsonText.substringAfter(":'").substringBefore("'"))
    }
}

interface JsonFactory<T> {
    fun fromJson(jsonText: String): T
}

// Companion object implementando interface JsonFactory
class Employeee(val name: String) {
    companion object: JsonFactory<Employeee> {
        override fun fromJson(jsonText: String): Employeee =
            Employeee(jsonText.substringAfter(":'").substringBefore("'"))
    }
}

// Extension function utilizando companion object, não precisa instanciar a classe
fun Employeee.Companion.getGmail(name: String) = "$name@gmail.com"

// Extension function sem companion, precisa instanciar a classe para utilizar a função
fun Employeee.getYahooMail(name: String) = "$name@yahoo.com"

fun main() {
    val employee = Employee.Loader.fromJsonSimpleQuote(
        """
        { 'name':'Dmitry' }
        """
    )

    println(employee.nickname)

    val employee1 = Employee.fromJsonSimpleQuote(
        """
        { 'name':'Dmitry' }
        """
    )

    println(employee1.nickname)

    val employeee = Employeee.fromJson(
        """
            { 'name':'Dmitry' }
        """
    )

    println(employeee.name)
    println(employeee.getYahooMail(employeee.name))

    println(Employeee.getGmail("javagirls"))

}

