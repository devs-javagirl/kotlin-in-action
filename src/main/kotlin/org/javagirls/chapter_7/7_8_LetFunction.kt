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
    val person: Person ? = getTheBestPersonInTheWorld()
    if (person != null) sendEmailTo(person.email)

    getTheBestPersonInTheWorld()?.let { sendEmailTo(it.email) }
}