package org.javagirls.chapter_4

open class RichButton1 : Clickable {
    /*
        4.8 Implementando uma classe aberta com um método aberto
        Outras classes podem herdar de RichButton e substituir o método animate
        Função disable é final e não pode ser sobrescrita
     */
    fun disable() {}
    open fun animate() {}
    override fun click() {}
}

open class ThemeButton: RichButton1() {
    /*
        4.9 Declarando uma subclass de uma classe aberta
        e sobrescrevendo um métodos abertos
     */
    override fun animate() {}
    override fun click() {}
    override fun showOff() {}
}

open class RichButton3 : Clickable {
    /*
        4.10 Proibindo a sobrescrita de um método
        Final não é redundante aqui porque override sem o final implica que o método é aberto
     */
    final override fun click() = println("RichButton3 clicked")
}
