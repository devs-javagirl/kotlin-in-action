package org.javagirls.chapter_4

class User1 constructor(_nickname: String, _age: Int) {
    val nickname: String

    init {
        nickname = _nickname
    }

    val age: Int
    init {
        age = _age
    }
}

class User2(_nickname: String, val _age: Int) {
    val nickname = _nickname
    val age = _age
}

class UserBasic(val nickname: String, val age: Int)

fun main() {


    val user1 = User1("Jose", 40)
    println("${user1.nickname} ${user1.age}")

    val user2 = User2("Renata", 13)
    println("${user2.nickname} ${user2.age}")

    val user = UserBasic("Valéria", 20)
    println("${user.nickname} ${user.age}")

    val user3 = User1(_age=12, _nickname = "Maria")
    println("${user3.nickname} ${user3.age}")
}