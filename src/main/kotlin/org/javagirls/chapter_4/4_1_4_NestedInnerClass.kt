package org.javagirls.chapter_4



class NewButton {
    val label = "Outer label"

    fun getNestedButton(): NestedButton {
        return NestedButton()
    }


    class NestedButton {
        // nested class, não consegue referenciar label da classe Field
        // val nestedLabel = label
        fun printSomething() {
            println("Nested Button")
        }
    }

    inner class InnerNewButton {
        // inner class consegue referenciar label da classe Field
        fun printLabel() {
            println("variável externa: $label")
        }

    }
}

fun main() {
    val newButton = NewButton()
    newButton.InnerNewButton().printLabel()
    // não é possível referenciar a nested class, são independentes
    // newButton.NestedButton().printSomething()
    newButton.getNestedButton().printSomething()


}