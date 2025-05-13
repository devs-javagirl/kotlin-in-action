package org.javagirls.chapter_5

import org.javagirls.chapter_5.java.Computation

class Compute: Computation {
    override fun postponeComputation(delay: Int, computation: Runnable?) {
        println("Delay: $delay")
        computation?.run()
    }

}

fun main() {
    val compute = Compute()

    // uma nova instância de Runnable é criada a cada chamada
    compute.postponeComputation(1000, object: Runnable {
        override fun run() {
            println(42)
        }
    })

    // se a lambda não acessa variáveis na função, a instância Runnable é reutilizada entre as chamadas
    compute.postponeComputation(2000) { println(42) }

    handleComputation("abc")
}

// cria uma nova instância de Runnable a cada chamada de handleComputation, pois faz referência a uma variável
fun handleComputation(id: String) {
    val compute = Compute()
    compute.postponeComputation(3000) { println(id) }
}
