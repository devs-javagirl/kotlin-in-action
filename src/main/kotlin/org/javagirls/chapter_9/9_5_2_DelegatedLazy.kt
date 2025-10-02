package org.javagirls.chapter_9

// Interface comum para evitar duplicação
interface PersonBase {
    val name: String
}

// Simulação de entidade
class Email(val conteudo: String)

// Função custosa de carregar emails
fun loadEmails(person: PersonBase): List<Email> {
    println("Carregando emails para ${person.name}...")
    return listOf(
        Email("Bem-vindo(a), ${person.name}!"),
        Email("Você tem uma nova mensagem.")
    )
}

// ---------- Versão com backing property ----------
class PersonComBacking(override val name: String) : PersonBase {
    private var _emails: List<Email>? = null // backing property
    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this) // funciona porque PersonComBacking implementa PersonBase
            }
            return _emails!!
        }
}

// ---------- Versão com by lazy ----------
class PersonLazy(override val name: String) : PersonBase {
    val emails: List<Email> by lazy {
        loadEmails(this) // também funciona
    }
}

fun main() {
    println("=== Usando backing property ===")
    val p1 = PersonComBacking("Alice")
    println(p1.emails[0].conteudo) // dispara o carregamento
    println(p1.emails[1].conteudo) // usa cache

    println("\n=== Usando by lazy ===")
    val p2 = PersonLazy("Bob")
    println(p2.emails[0].conteudo) // dispara o carregamento
    println(p2.emails[1].conteudo) // usa cache
}
