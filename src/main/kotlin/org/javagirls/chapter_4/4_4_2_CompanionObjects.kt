package org.javagirls.chapter_4

class MyClass {
    companion object {
        fun callMe(){
            println("Companion object called.")
        }
    }
}

class UserConstructor {
    val nickname: String

    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    constructor(socialAccountId: Int) {
        nickname = getNameFromSocialNet(socialAccountId)
    }

}

// Utilização de construtor privado, objetos só podem ser criados a partir dos métodos do companion object
class UserFactory private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) =
            UserFactory(email.substringBefore('@'))

        fun newSocialUser(accountId: Int) =
            UserFactory(getNameFromSocialNet(accountId))

    }
}

fun getNameFromSocialNet(accountId: Int) = "kodee$accountId"

fun main() {
    // Para acessar a função callMe, não é necessário instanciar o objeto MyClass
    MyClass.callMe()

    val myObject = MyClass()
    // myObject.callMe() // Error unresolved reference: callMe

    println(UserFactory.newSubscribingUser("maria@gmail.com").nickname)
    println(UserFactory.newSocialUser(45).nickname)

}


