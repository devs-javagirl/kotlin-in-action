package org.javagirls.chapter_4

class `4_VisibilityModifiers` {

    /*
     4.12 Usandodiferentes modificadores de visibilidade
     */
    internal open class TalkativeButton {
        private fun yell() = println("Hey!")
        /*
          Em java, podemos acessar membros protected do mesmo pacote, mas em Kotlin não
         */
        protected fun whisper() = println("Let's talk!")

        // Error: Cannot access methods with private or protected visibility
        fun TalkativeButton.giveSpeech() {
            yell() // Works: private member is accessible
            whisper() // Works: protected member is accessible
        }
    }


}
