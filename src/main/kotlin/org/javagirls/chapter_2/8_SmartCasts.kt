package org.javagirls.chapter_2

// função para avaliar uma expressão aritmética simples, a soma de 2 números
// a expressão pode ser representada num árvore, cujo nó pode ser um número ou uma soma
//      - número é sempre um leaf node (não tem filhos)
//      - soma tem 2 filhos que são os argumentos da soma ( que pode ser um número ou uma soma )

// declaração da interface marcadora Expr, ela não tem nenhum método_
interface Expr

// classe Num tem uma propriedade e implementa a interface ( utilização de : )
class Num(val value: Int) : Expr

// classe Sum tem 2 propriedades do tipo Expr, que pode ser Num ou Sum
class Sum(val left: Expr, val right: Expr) : Expr

// função similar ao código Java (block body com chaves), que será refatorada utilizando idiomatic Kotlin
fun eval(e: Expr) : Int {
    // verifica se a variável é do tipo Num, similar ao instanceOf
    if (e is Num) {
        // operação de cast to Num (redundante)
        val n = e as Num
        return n.value
    }

    if (e is Sum) {
        // utilização de smart cast, ao declarar "is Sum", automaticamente vc obtém as propriedades right e left
        return eval(e.left) + eval(e.right)
    }

    throw IllegalArgumentException("Unknown expression")
}

// função utilizando expression-body syntax ( sem chaves, sem return )
fun evalSimpler1(e: Expr) : Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        evalSimpler1(e.left) + evalSimpler1(e.right)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }

// mesma função anterior, com if em cascata sem chaves
fun evalSimpler2(e: Expr) : Int =
    if (e is Num) e.value
    else if (e is Sum) evalSimpler2(e.left) + evalSimpler2(e.right)
    else throw IllegalArgumentException("Unknown expression")

// função mais simplificada, utilizando when com arrow operator
fun evalUsingWhen(e: Expr) : Int =
    when (e) {
        // aqui é feita a validação do tipo + smart cast
        is Num -> e.value
        is Sum -> evalUsingWhen(e.left) +  evalUsingWhen(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

// função utilizando when com blocks ( chaves para execução de mais de um comando )
fun evalWithLogging(e: Expr) : Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)

            val right = evalWithLogging(e.right)
            println("sum: $left + $right = ${left + right}")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun main() {
    println(eval(Num(1)))
    println(eval(Sum(Num(1), Num(2))))
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalSimpler1(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalSimpler2(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalUsingWhen(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}