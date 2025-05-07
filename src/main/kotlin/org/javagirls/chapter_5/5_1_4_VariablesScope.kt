package org.javagirls.chapter_5

// lambda acessando parâmetros da função
fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

// lambda alterando valores das variáveis
fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0

    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")

}

fun main() {
    val errors = listOf("403 Forbidden", "404 Not Found", "500 Internal Server Error")
    printMessagesWithPrefix(errors, "Error:")

    printProblemCounts(errors)

}
