package org.javagirls.chapter_4

interface User {
    val nickname: String
    val gmail: String
        get() = nickname + "@gmail.com"
}

class PrivateUser(override val nickname: String) : User

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@')
}

class SocialUser(val accountId: Int): User {
    override val nickname = getNameFromSocialNetwork(accountId)
}

fun getNameFromSocialNetwork(accountId: Int) = "kodee$accountId"

fun main() {
    val privateUser = PrivateUser("John")
    println(privateUser.nickname)
    println(privateUser.gmail)
    println(SubscribingUser("test@kotlinlang.org").nickname)
    println(SocialUser(123).nickname)

}