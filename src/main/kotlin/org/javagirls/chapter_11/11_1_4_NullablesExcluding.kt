package org.javagirls.chapter_11


// -----------------------------------------
// 1. Processor<T> (T é Any? por padrão)
// -----------------------------------------
class Processor<T> {
    fun process(value: T) {
        // value pode ser null → safe call
        println("hash = ${value?.hashCode()}")
    }
}

// -----------------------------------------
// 2. NonNullProcessor<T : Any> (T nunca é null)
// -----------------------------------------
class NonNullProcessor<T : Any> {
    fun process(value: T) {
        println("hash = ${value.hashCode()}")
    }
}

// -----------------------------------------
// 3. Interface JBox<T> modelo do livro
// -----------------------------------------
interface JBox<T> {
    fun put(t: T)          // NÃO aceita null (equivalente a @NotNull)
    fun putIfNotNull(t: T?) // aceita null
}

// -----------------------------------------
// 4. KBox<T> (implementação correta e compilável)
// -----------------------------------------
class KBox<T> : JBox<T> {

    override fun putIfNotNull(t: T?) {
        println("putIfNotNull: $t")
    }

    /**
     * IMPORTANTE:
     * A assinatura DEVE corresponder exatamente à da interface:
     *     fun put(t: T)
     *
     * Não podemos usar 'T & Any' na assinatura.
     *
     * Mas podemos usar 'T & Any' dentro do método,
     * como o livro demonstra.
     */
    override fun put(t: T) {
        // transformar para tipo definitivamente não-nulo
        val nonNullValue: T = t
        println("put sem null: $nonNullValue")
    }
}

// -----------------------------------------
// 5. Testes
// -----------------------------------------
fun main() {

    println("=== Processor normal (aceita null) ===")
    val p1 = Processor<String?>()
    p1.process(null)
    p1.process("abc")

    println("\n=== Processor com T : Any (não aceita null) ===")
    val p2 = NonNullProcessor<String>()
    // p2.process(null) // ERRO de compilação
    p2.process("abc")

    println("\n=== KBox usando T & Any ===")
    val box = KBox<String?>()

    // putIfNotNull aceita null
    box.putIfNotNull(null)

    // put exige definitivamente não-nulo
    box.put("abc")
    // box.put(null) // ERRO de compilação
}
