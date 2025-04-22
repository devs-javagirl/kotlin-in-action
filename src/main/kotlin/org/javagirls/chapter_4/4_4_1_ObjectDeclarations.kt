package org.javagirls.chapter_4

import java.io.File

object Payroll {
    val allEmployees = mutableListOf<Person>()

    fun calculateSalary() {
        for(person in allEmployees) {
            println("Calculating salary of ${person.name}")
        }
    }
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

data class Persons(val name: String) {
    object NameComparator : Comparator<Persons> {
        override fun compare(p1: Persons, p2: Persons): Int =
            p1.name.compareTo(p2.name)

    }
}

// Inicialização de um singleton com a função init (executada uma única vez)
object Logger {
    init {
        println("I was accessed for the first time")
    }

    fun log (information: String) {
        println("logging $information")
    }
}

fun main() {
    Payroll.allEmployees.add(Person(2010, "João"))
    Payroll.allEmployees.add(Person(2000, "Maria"))

    Payroll.calculateSalary()

    val files = listOf(File("/User1"), File("/user"), File("/directory"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(Persons("Maria"), Persons("João"), Persons("Lucia"))
    println(persons.sortedWith(Persons.NameComparator))

    println(Logger.log("teste1"))
    println(Logger.log("teste2"))
}