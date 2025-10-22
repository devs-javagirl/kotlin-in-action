package org.javagirls.chapter_10



// 10.1.6 - Eliminando Duplicação com Funções de Ordem Superior

    enum class OS { WINDOWS, MAC, IOS, ANDROID }

    data class SiteVisit(
        val path: String,
        val duration: Double,
        val os: OS
    )

class `10_1_6_ReusableCode` {

        // Dados de exemplo
        val log = listOf(
            SiteVisit("/", 34.0, OS.WINDOWS),
            SiteVisit("/", 22.0, OS.MAC),
            SiteVisit("/login", 12.0, OS.WINDOWS),
            SiteVisit("/signup", 8.0, OS.IOS),
            SiteVisit("/", 16.3, OS.ANDROID)
        )

        // === MÉTODO 1: Código duplicado (NÃO RECOMENDADO) ===
        fun calculateAverageWindowsDuration(): Double {
            return log
                .filter { it.os == OS.WINDOWS }
                .map(SiteVisit::duration)
                .average()
        }

        fun calculateAverageMobileDuration(): Double {
            return log
                .filter { it.os in setOf(OS.IOS, OS.ANDROID) }
                .map(SiteVisit::duration)
                .average()
        }

        // === MÉTODO 2: Função com parâmetro simples ===
        fun calculateAverageDurationFor(os: OS): Double {
            return log
                .filter { it.os == os }
                .map(SiteVisit::duration)
                .average()
        }

        // === MÉTODO 3: Função de ordem superior (RECOMENDADO) ===
        fun calculateAverageDurationWithFilter(predicate: (SiteVisit) -> Boolean): Double {
            return log
                .filter(predicate)
                .map(SiteVisit::duration)
                .average()
        }
    }

    // Função de extensão para List<SiteVisit>
    fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean): Double {
        return filter(predicate).map(SiteVisit::duration).average()
    }

    fun main() {
        val analyzer = `10_1_6_ReusableCode`()

        println("=== MÉTODO 1: Código Duplicado ===")
        println("Duração média Windows: ${analyzer.calculateAverageWindowsDuration()}")
        println("Duração média Mobile: ${analyzer.calculateAverageMobileDuration()}")

        println("\n=== MÉTODO 2: Parâmetro Simples ===")
        println("Duração média Windows: ${analyzer.calculateAverageDurationFor(OS.WINDOWS)}")
        println("Duração média Mac: ${analyzer.calculateAverageDurationFor(OS.MAC)}")

        println("\n=== MÉTODO 3: Função de Ordem Superior ===")

        // Consultas complexas sem duplicação de código
        val mobileAvg = analyzer.calculateAverageDurationWithFilter {
            it.os in setOf(OS.IOS, OS.ANDROID)
        }
        println("Duração média Mobile: $mobileAvg")

        val signupIosAvg = analyzer.calculateAverageDurationWithFilter {
            it.os == OS.IOS && it.path == "/signup"
        }
        println("Duração média iOS signup: $signupIosAvg")

        val windowsLoginAvg = analyzer.calculateAverageDurationWithFilter {
            it.os == OS.WINDOWS && it.path == "/login"
        }
        println("Duração média Windows login: $windowsLoginAvg")

        println("\n=== Função de Extensão na Lista ===")
        // Agora podemos usar averageDurationFor diretamente no log!
        val longVisits = analyzer.log.averageDurationFor { it.duration > 20.0 }
        println("Duração média visitas longas: $longVisits")

        val androidVisits = analyzer.log.averageDurationFor { it.os == OS.ANDROID }
        println("Duração média Android: $androidVisits")
    }

    // EXEMPLO ADICIONAL: Aplicando o conceito em outro contexto
    class ProductAnalyzer {
        data class Product(val name: String, val price: Double, val category: String)

        val products = listOf(
            Product("Laptop", 1500.0, "Eletrônicos"),
            Product("Phone", 800.0, "Eletrônicos"),
            Product("Book", 30.0, "Livros"),
            Product("Tablet", 600.0, "Eletrônicos")
        )

        // Função de ordem superior reutilizável
        fun <T> List<T>.analyzeWith(predicate: (T) -> Boolean, transform: (T) -> Double): Double {
            return filter(predicate).map(transform).average()
        }

        fun demonstrate() {
            println("\n=== ANÁLISE DE PRODUTOS ===")

            // Preço médio de eletrônicos
            val avgElectronics = products.analyzeWith(
                predicate = { it.category == "Eletrônicos" },
                transform = { it.price }
            )
            println("Preço médio eletrônicos: $avgElectronics")

            // Preço médio de produtos acima de R$500
            val avgExpensive = products.analyzeWith(
                predicate = { it.price > 500.0 },
                transform = { it.price }
            )
            println("Preço médio produtos caros: $avgExpensive")
        }
    }

// Para testar o exemplo adicional:
// fun main() {
//     ProductAnalyzer().demonstrate()
// }


