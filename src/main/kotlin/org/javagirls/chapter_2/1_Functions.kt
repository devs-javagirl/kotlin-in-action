package org.javagirls.chapter_2

// fun palavra chave para declarar uma função
// não é necessário declarar as funções dentro de uma classe
// fun main é o ponto de entrada da aplicação, pode ser utilizado com ou sem argumentos
fun main() {
    // println é uma função da biblioteca padrão do Kotlin, que provê um wrapper para System.out.println
    // não precisa usar ;
    println("KOTLIN --------------------------")
    println("Hello world !")
    println("Máximo entre 4 e 40 é " + maxWithBlockBody(4, 40))
    println("Máximo entre 1 e 2 é " + maxExpressionBody(1, 2))
    println("Máximo entre 10 e 20 é " + maxExpressionBodySimpler(10, 20))
}


// fun nomeFuncao | parâmetros e respectivos tipos | tipo de retorno
// Função com block body (código entre chaves), obrigatória ter a cláusula return
fun maxWithBlockBody(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// Função com expression body (sem chaves, sem return)
fun maxExpressionBody(a: Int, b: Int): Int = if (a > b) a else b

// Omitir tipo de retorno é permitido apenas em funções com expression body
fun maxExpressionBodySimpler(a: Int, b: Int) = if (a > b) a else b
