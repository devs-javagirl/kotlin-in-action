package org.javagirls.chapter_11

import java.util.ServiceLoader


        // Função reified equivalente ao exemplo do livro
        inline fun <reified T> loadService(): T? {
            val loader = ServiceLoader.load(T::class.java)
            return loader.findFirst().orElse(null)
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
            val service = loadService<MyService>()

            if (service != null) {
                println(service.execute())
            } else {
                println("Nenhum serviço encontrado.")
            }
        }



