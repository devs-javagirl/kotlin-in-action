package org.javagirls.chapter_2.enum

// no java somente enum, no kotlin precisa declarar como enum class
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

// enum com propriedades
enum class ColorRGB (
    val r: Int,
    val g: Int,
    val b: Int
) {
    //Define as propriedades na criação de cada constante
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    //aqui é obrigatório o ponto e vírgula, separa a lista de constantes dos métodos
    VIOLET(238, 130, 238);

    //Define a propriedade rgb no enum
    val rgb = (r * 256 + g) * 256 + b

    // define o método_ printColor no enum
    fun printColor() = println("$this is $rgb")
}

fun main() {
    println(ColorRGB.BLUE.rgb)
    println(ColorRGB.YELLOW.rgb)
    ColorRGB.GREEN.printColor()
}