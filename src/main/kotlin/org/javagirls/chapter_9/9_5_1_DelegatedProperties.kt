package org.javagirls.chapter_9

// Definição do delegado
class Delegate {
    /*
    Funcionamento interno (gerado pelo compilador):
    Cria uma propriedade auxiliar privada (delegate).
    O getter chama delegate.getValue(...).
    O setter chama delegate.setValue(..., value).
    */
    private var storedValue: String = "valor inicial"

    // Getter
    operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): String {
        println("Chamando getValue para '${property.name}'")
        return storedValue
    }

    // Setter
    operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: String) {
        println("Chamando setValue para '${property.name}' = $value")
        storedValue = value
    }

    // Opcional: provideDelegate (executa ao criar a propriedade)
    operator fun provideDelegate(thisRef: Any?, property: kotlin.reflect.KProperty<*>): Delegate {
        println("Criando delegado para '${property.name}'")
        return this
    }

    /*
    Regras de convenção para a classe Delegate:
    Deve ter operator fun getValue(...) → lógica do getter.
    Deve ter operator fun setValue(...) (apenas se var) → lógica do setter.
    Pode ter operator fun provideDelegate(...) → lógica extra ao criar o delegado.
    */
}

// Classe que usa a propriedade delegada
class Foo {
    var p: String by Delegate()
}
 /*
    Palavra-chave by:
    Associa a propriedade a um objeto delegado.
    Quando usado:
    provideDelegate(...) é chamado (se existir).
    getValue(...) é chamado ao ler.
    setValue(...) é chamado ao atribuir valor.
  */

fun main() {
    val foo = Foo()

    // Lendo a propriedade (chama getValue)
    println("Valor atual: ${foo.p}")

    // Alterando a propriedade (chama setValue)
    foo.p = "novo valor"

    // Lendo novamente
    println("Valor atualizado: ${foo.p}")
}
