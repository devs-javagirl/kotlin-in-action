package org.javagirls.chapter_10

// 10.1.5 - Retornando Funções de Funções - Exemplo Completo

// ========== EXEMPLO 1: SISTEMA DE FRETE ==========
enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

class ShippingSystem {
    fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
        if (delivery == Delivery.EXPEDITED) {
            return { order -> 6 + 2.1 * order.itemCount }
        }
        return { order -> 1.2 * order.itemCount }
    }
}

// ========== EXEMPLO 2: FILTRO DE CONTATOS ==========
data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix = { p: Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }

        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }

        return { startsWithPrefix(it) && it.phoneNumber != null }
    }
}

// ========== EXEMPLO 3: SISTEMA DE DESCONTOS ==========
class DiscountSystem {
    fun getDiscountCalculator(isPremium: Boolean): (Double) -> Double {
        if (isPremium) {
            return { total -> total * 0.8 } // 20% de desconto
        }
        return { total ->
            when {
                total > 100.0 -> total * 0.9  // 10% de desconto
                total > 50.0 -> total * 0.95  // 5% de desconto
                else -> total                 // Sem desconto
            }
        }
    }
}

// ========== EXECUÇÃO DOS EXEMPLOS ==========
fun main() {
    println("=== EXEMPLO 1: Sistema de Frete ===")
    val shippingSystem = ShippingSystem()

    // Obtém calculadora de frete expresso
    val expeditedCalculator = shippingSystem.getShippingCostCalculator(Delivery.EXPEDITED)
    println("Frete expresso (3 itens): R$ ${expeditedCalculator(Order(3))}")

    // Obtém calculadora de frete normal
    val standardCalculator = shippingSystem.getShippingCostCalculator(Delivery.STANDARD)
    println("Frete normal (5 itens): R$ ${standardCalculator(Order(5))}")


    println("\n=== EXEMPLO 2: Filtro de Contatos ===")
    val contacts = listOf(
        Person("Dmitry", "Jemerov", "123-4567"),
        Person("Svetlana", "Isakova", null),
        Person("Daniel", "Silva", "987-6543"),
        Person("David", "Costa", null)
    )

    val contactFilters = ContactListFilters()

    // Filtro 1: Apenas prefixo
    contactFilters.prefix = "Da"
    contactFilters.onlyWithPhoneNumber = false
    val filter1 = contactFilters.getPredicate()
    println("Contatos que começam com 'Da': ${contacts.filter(filter1)}")

    // Filtro 2: Prefixo + com telefone
    contactFilters.prefix = "Da"
    contactFilters.onlyWithPhoneNumber = true
    val filter2 = contactFilters.getPredicate()
    println("Contatos 'Da' com telefone: ${contacts.filter(filter2)}")


    println("\n=== EXEMPLO 3: Sistema de Descontos ===")
    val discountSystem = DiscountSystem()

    // Cliente premium
    val premiumDiscount = discountSystem.getDiscountCalculator(true)
    println("Cliente premium - R$100,00 com desconto: R$ ${premiumDiscount(100.0)}")

    // Cliente normal
    val normalDiscount = discountSystem.getDiscountCalculator(false)
    println("Cliente normal - R$100,00 com desconto: R$ ${normalDiscount(100.0)}")
    println("Cliente normal - R$75,00 com desconto: R$ ${normalDiscount(75.0)}")
    println("Cliente normal - R$30,00 com desconto: R$ ${normalDiscount(30.0)}")

    // Teste do exemplo extra
    println("\n=== EXEMPLO EXTRA: Fábrica de Operações Matemáticas ===")
    testMathOperations()


}

// ========== EXEMPLO EXTRA: FÁBRICA DE OPERAÇÕES MATEMÁTICAS ==========
class MathOperationFactory {
    fun getOperation(operation: String): (Double, Double) -> Double {
        return when (operation) {
            "add" -> { a, b -> a + b }
            "subtract" -> { a, b -> a - b }
            "multiply" -> { a, b -> a * b }
            "divide" -> { a, b ->
                if (b != 0.0) a / b else throw IllegalArgumentException("Divisão por zero")
            }
            else -> throw IllegalArgumentException("Operação desconhecida")
        }
    }
}

// Função para testar o exemplo extra (descomente para usar)

fun testMathOperations() {
    val factory = MathOperationFactory()

    val add = factory.getOperation("add")
    val multiply = factory.getOperation("multiply")

    println("5 + 3 = ${add(5.0, 3.0)}")
    println("5 × 3 = ${multiply(5.0, 3.0)}")
}

