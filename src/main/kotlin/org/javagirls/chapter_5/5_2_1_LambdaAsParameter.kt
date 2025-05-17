package org.javagirls.chapter_5

import org.javagirls.chapter_5.java.Computation

fun main() {

    val computation = Computation { delay, computation ->
        println("Delay $delay")
        println("endereco $computation")
        computation.run()
        computation.run()
    }

    // se a lambda não acessa variáveis na função, a instância Runnable é reutilizada entre as chamadas
    computation.postponeComputation(1000) { println("computation 42") }

    // lambda usando um objeto anônimo, uma nova instância é criada a cada invocação
    computation.postponeComputation(1000, object: Runnable {
        override fun run() {
            println("Runnable 42")
            println(this)
        }
    })

    handleComputation("abc", computation)
    handleComputation("def", computation)
}

// cria uma nova instância de Runnable a cada chamada de handleComputation, pois faz referência a uma variável
fun handleComputation(id: String, computation: Computation) {
    computation.postponeComputation(1000) {

        println(id)
    }
}
