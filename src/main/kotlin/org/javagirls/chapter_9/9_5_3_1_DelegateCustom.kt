package org.javagirls.chapter_9

class ObservableProperty(
    val propName: String,      // Nome da propriedade
    var propValue: Int,        // Valor atual da propriedade
    val observable: Observable // Objeto observável para notificações
) {
    fun getValue(): Int = propValue

    fun setValue(newValue: Int) {
        val oldValue = propValue      // Armazena o valor antigo
        propValue = newValue          // Atualiza para o novo valor
        observable.notifyObservers(propName, oldValue, newValue) // Notifica os observadores
    }
}

class Person(val name: String, age: Int, salary: Int): Observable() {
    // Cria uma instância de ObservableProperty para a idade
    val _age = ObservableProperty("age", age, this)
    var age: Int
        get() = _age.getValue()           // Delega o getter para ObservableProperty
        set(newValue) {
            _age.setValue(newValue)       // Delega o setter para ObservableProperty
        }

    // Cria uma instância de ObservableProperty para o salário
    val _salary = ObservableProperty("salary", salary, this)
    var salary: Int
        get() = _salary.getValue()        // Delega o getter para ObservableProperty
        set(newValue) {
            _salary.setValue(newValue)    // Delega o setter para ObservableProperty
        }
}

fun main() {
    val p = Person("Seb", 28, 1000)
    p.observers += Observer { propName, oldValue, newValue ->
        println(
            """
            Property $propName changed from $oldValue to $newValue!
            """.trimIndent()
        )
    }
    p.age = 29
    // Property age changed from 28 to 29!
    p.salary = 1500
    // Property salary changed from 1000 to 1500!

    p.age = 30
    // Property age changed from 28 to 29!
    p.salary = 2000

}