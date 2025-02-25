package org.javagirls.chapter_2

// import do enum ColorRGB para utilizar diretamente o nome das constantes
import org.javagirls.chapter_2.enum.Color
import org.javagirls.chapter_2.enum.ColorRGB
import org.javagirls.chapter_2.enum.ColorRGB.*

// when | expressão | chaves com branches (opções)
// when sempre retorna um valor, portanto pode ser utilizado com expression body (sem chaves)
// é obrigatório indicar todas as possibilidade no when, ou incluir else
// when expression must be exaustive, add necessary XXX branch or else branch instead
// arrow operator -> separa a condição da expressão; a expressão sempre tem um valor
fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard" // não é necessário break
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun measureColor() = ORANGE

fun getWarmthFromSensor1(): String {
    val color = measureColor()

    // variável color sendo referenciada na expressão de retorno
    return when(color) {
        // devido ao import, não é necessário declarar ColorRGB.
        // é necessário definir todas as cores ou um retorno padrão com else (exhaustive)
        RED, ORANGE, YELLOW -> "warm (red = ${color.r})"
        GREEN -> "neutral (green = ${color.g}"
        BLUE, INDIGO, VIOLET -> "cold (blue = ${color.b}"
    }
}

// simplificando a função
// define a variável color dentro da cláusula when, o escopo da variável fica restrito ao body do when
// utilização de expression body na função
fun getWarmthFromSensor2() =
    when (val color = measureColor()) {
        RED, ORANGE, YELLOW -> "warm (red = ${color.r})"
        GREEN -> "neutral (green = ${color.g}"
        BLUE, INDIGO, VIOLET -> "cold (blue = ${color.b}"
    }

fun mix(c1: ColorRGB, c2: ColorRGB) =
    // set é uma coleção na qual os objetos não se repetem e a ordem não importa
    // 2 sets são iguais se tiverem o mesmo conteúdo
    // neste caso o compilador não consegue cobrir todas as posibilidades
    // precisa da utilização do else para garantir todos os cenários "exhaustive"
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }


fun mixOptimized(c1: ColorRGB, c2: ColorRGB) =
    // o algoritmo anterior é ineficiente (many short-lived objects, trabalho para o  garbage collector)
    // este algoritmo é otimizado, mas de difícil leitura
    // when sem argumentos, a branch condition (opção correta) é a expressão booleana que retornar true
    when {
        (c1 == RED && c2 == YELLOW) ||
                (c1 == YELLOW && c2 == RED) -> ORANGE
        (c1 == YELLOW && c2 == BLUE) ||
                (c1 == BLUE && c2 == YELLOW) -> GREEN
        (c1 == BLUE && c2 == VIOLET) ||
                (c1 == VIOLET && c2 == BLUE) -> INDIGO
        else -> throw Exception("Dirty color")
    }


fun main() {
    println(getMnemonic(Color.BLUE))
    println(getWarmthFromSensor1())
    println(getWarmthFromSensor2())
    println(mix(BLUE, YELLOW))
    println(mixOptimized(BLUE, YELLOW))

}
