package org.javagirls.chapter_2

// while | condição | body
// loop é executado enquanto a condição é verdadeira
fun loop(qtd: Int) {
    println("iniciando while com quantidade $qtd")
    var i = 1
    while (i < qtd) {
        println("valor de i: $i")
        i += 1
    }
}

// do | body | condição
// o loop é executado pelo menos uma vez, e a execução continua se a condição for verdadeira
fun doLoop(qtd: Int) {
    println("iniciando do while com quantidade $qtd")
    var i = 1
    do {
        println("valor de i: $i")
        i += 1

    } while (i < qtd)
}

// loops encadeados com label
// break e continue sem label serão executados no loop mais próximo
fun nestedLoops(outerCondition: Boolean, innerCondition: Boolean, shouldExitInner: Boolean,
                shouldSkipInner: Boolean, shouldExit: Boolean, shouldSkip: Boolean) {

    println("iniciando loop ...")
    var cont = 0

    outer@ while (outerCondition) {
        println("entrou no outerCondition")
        while (innerCondition) {
            cont += 1
            println("entrou no innerCondition")
            if (shouldExitInner) {
                println("entrou no shouldExitInner")
                break
            }
            if (shouldSkipInner) {
                println("entrou no shouldSkipInner")
                if (cont == 1) continue
            }
            if (shouldExit) {
                println("entrou no shouldExit")
                break@outer
            }
            if (shouldSkip) {
                println("entrou no shouldSkip")
                if (cont == 1) continue@outer
            }
            println("final do while innerCondition")
            break
        }
        println("final do while outerCondition")
        break

    }

}

fun main() {
    loop(5)
    doLoop(5)
    loop(1)
    doLoop(1)

    nestedLoops(outerCondition = true, innerCondition = true, shouldExitInner = true,
        shouldSkipInner = false, shouldExit = false, shouldSkip = false)

    nestedLoops(outerCondition = true, innerCondition = true, shouldExitInner = false,
        shouldSkipInner = true, shouldExit = false, shouldSkip = false)

    nestedLoops(outerCondition = true, innerCondition = true, shouldExitInner = false,
        shouldSkipInner = false, shouldExit = true, shouldSkip = false)

    nestedLoops(outerCondition = true, innerCondition = true, shouldExitInner = false,
        shouldSkipInner = false, shouldExit = false, shouldSkip = true)
}