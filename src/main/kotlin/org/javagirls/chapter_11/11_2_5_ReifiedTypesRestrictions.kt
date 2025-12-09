package org.javagirls.chapter_11

    // -----------------------------------------------------------------
    // 1) Coisas que PODEM ser feitas com reified
    // -----------------------------------------------------------------

    inline fun <reified T> checkType(value: Any): Boolean {
        return value is T       // ✔ permitido
    }

    inline fun <reified T> getKotlinClass() = T::class      // ✔
    inline fun <reified T> getJavaClass() = T::class.java   // ✔

    inline fun <reified T> forwardClassInfo() {
        receiveClass(T::class.java)  // ✔ pode enviar o tipo
    }

    fun receiveClass(clazz: Class<*>) {
        println("Received class: $clazz")
    }

    // -----------------------------------------------------------------
    // 2) Coisas que NÃO podem ser feitas
    // -----------------------------------------------------------------

    // ❌ ERRO: não pode criar instância de T
    /*
    inline fun <reified T> invalidNewInstance(): T {
        return T()   // ❌ proibido
    }
    */

    // ❌ ERRO: não pode chamar métodos do companion object via T
    /*
    inline fun <reified T> invalidCompanionCall() {
        T.someCompanionMethod()   // ❌ proibido
    }
    */

    // ❌ ERRO: classes não podem ter parâmetros reified
    /*
    class Wrong<reified T>   // proibido
    */

    // ❌ ERRO: função não inline não pode ter reified
    /*
    fun <reified T> wrongFunction() {}  // proibido
    */

    // -----------------------------------------------------------------
    // 3) Demonstração completa
    // -----------------------------------------------------------------

    fun main() {

        println("===== 1) Checks permitidos =====")
        println(checkType<String>("hello"))   // true
        println(checkType<Int>("hello"))      // false

        println("\n===== 2) Obtendo classes =====")
        println(getKotlinClass<List<Int>>())  // class kotlin.collections.List
        println(getJavaClass<Int>())          // int.class

        println("\n===== 3) Reenviando classe =====")
        forwardClassInfo<String>()            // prints java.lang.String

        println("\n===== 4) Exemplos proibidos (comentados para compilar) =====")
        println("T()  // ❌ não permitido")
        println("T.someCompanionMethod()  // ❌ não permitido")
        println("class Box<reified T>  // ❌ não permitido")
        println("fun <reified T> normalFunction()  // ❌ não permitido sem inline")
    }

