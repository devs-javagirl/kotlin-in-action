package org.javagirls.chapter_11

// ---------------------------------------------
// MODELOS DO LIVRO
// ---------------------------------------------
open class Animal {
    open fun feed() {
        println("Feeding animal...")
    }
}

class Cat : Animal() {
    fun cleanLitter() {
        println("Cleaning litter box...")
    }

    override fun feed() {
        println("Feeding cat...")
    }
}

// ---------------------------------------------
// 1) EXEMPLO DE COVARIÂNCIA – Producer<out T>
// ---------------------------------------------
interface Producer<out T> {
    fun produce(): T
}

class CatProducer : Producer<Cat> {
    override fun produce() = Cat()
}

// ---------------------------------------------
// 2) Herd invariável (como no livro - Listing 11.11)
// NÃO usa 'out' → gera problema de subtipagem
// ---------------------------------------------
class InvariantHerd<T : Animal>(private vararg val animals: T) {
    val size: Int get() = animals.size
    operator fun get(index: Int): T = animals[index]
}

fun takeCareOfCatsInvariant(cats: InvariantHerd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
    }

    // ❌ feedAll(cats) → dá erro de tipo (Herd<Cat> não é Herd<Animal>)
}

// ---------------------------------------------
// 3) Herd covariante (usando 'out')
// Agora a subtipagem funciona
// ---------------------------------------------
class Herd<out T : Animal>(private vararg val animals: T) {
    val size: Int get() = animals.size
    operator fun get(index: Int): T = animals[index]
}

// Função que recebe um Herd<Animal>
fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals[i].feed()
    }
}

// Agora podemos passar Herd<Cat> sem erro
fun takeCareOfCatsCovariant(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats[i].cleanLitter()
    }
    // ✔ funciona sem cast
    feedAll(cats)
}

// ---------------------------------------------
// MAIN – roda todos os exemplos
// ---------------------------------------------
fun main() {

    println("=== 1) COVARIÂNCIA EM INTERFACES (Producer) ===")

    val catProducer: Producer<Cat> = CatProducer()
    val animalProducer: Producer<Animal> = catProducer  // ✔ funciona (covariância)
    println("Producer funcionando: ${animalProducer.produce()::class.simpleName}")

    println("\n=== 2) INVARIANCE: Herd<Cat> NÃO é Herd<Animal> ===")

    val catHerdInvariant = InvariantHerd(Cat(), Cat())

    takeCareOfCatsInvariant(catHerdInvariant)

    // ❌ NÃO COMPILA (erro do livro):
    // feedAll(catHerdInvariant)
    // Porque Herd<Cat> não é Herd<Animal>

    println("Tentando usar Herd sem out gera erro → invariância")

    println("\n=== 3) COVARIÂNCIA: Herd<out T> PRESERVA SUBTIPAGEM ===")

    val catHerd = Herd(Cat(), Cat())

    takeCareOfCatsCovariant(catHerd)  // ✔ funciona
    println("Herd covariante permite feedAll(Herd<Cat>)")

    println("\n=== Programa Finalizado ===")
}
