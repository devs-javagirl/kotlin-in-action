package org.javagirls.chapter_7

fun verifyUserInput(input: String?) {
    if(input.isNullOrBlank()) { // não é necessário safe-call input?.isNullOrBlank
        println("Please fill in the required fields")
    }
}

fun String?.isNullOrBlank(): Boolean =
    this == null || this.isBlank()


fun main() {
    // first example
    verifyUserInput(" ")
    verifyUserInput(null)

    // second example
    val recipient: String? = null
    //recipient.let { sendEmailTo(it) }

}

