package org.javagirls.chapter_11

import java.util.ServiceLoader


        // Função reified equivalente ao exemplo do livro
        inline fun <reified T> loadService(): ServiceLoader<T?>? {
            return ServiceLoader.load(T::class.java)
        }

        // Serviço usado para teste
        interface MyService {
            fun execute(): String
        }

        class MyServiceImpl : MyService {
            override fun execute() = "Serviço carregado com sucesso!"
        }

        fun main() {
            println("=== Exercício 11.2.3 ===")

            // Chamada usando reified (igual ao livro)
            val service = loadService<MyServiceImpl>()

            if (service != null) {
                    println(service.execute())
            } else {
                println("Nenhum serviço encontrado.")
            }
        }

private fun ServiceLoader<MyServiceImpl?>.execute(): String {
    return "Serviço carregado!"
}





