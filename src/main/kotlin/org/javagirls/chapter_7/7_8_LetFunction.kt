package org.javagirls.chapter_7

// first example
fun sendEmailTo(email: String) {
    println("Sendind email to $email")
}

// second example
fun getTheBestPersonInTheWorld(): Person? = null

fun main() {
    // first example
    var email: String? = "foo@bar.com"
    //sendEmailTo(email)


    if(email != null) sendEmailTo(email)
    email?.let { email -> sendEmailTo(email) }
    email?.let { sendEmailTo(it) }

    email = null
    email?.let { sendEmailTo(it) }

    //second example
    val person: Person? = getTheBestPersonInTheWorld()
    if (person != null) sendEmailTo(person.email)
    getTheBestPersonInTheWorld()?.let { sendEmailTo(it.email) }

    var p1 = PersonNullable("Dimitry","")
    p1.apply {
        this.firstName = "New Name"
        this.lastName = "New Last"
        println(p1.firstName + " " + p1.lastName)
    }
    p1.also {
        it.firstName = "First Name"
        it.lastName = "Last Name"
        println(p1.firstName + " " + p1.lastName)
    }

    p1.run {
        this.firstName = "Name"
        this.lastName = "Last"
        println(p1.firstName + " " + p1.lastName)
    }

    with(p1) {
        this.firstName = "With Name"
        this.lastName = "With Last"
        println(p1.firstName + " " + p1.lastName)
    }
}
