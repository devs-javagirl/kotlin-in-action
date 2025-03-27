package org.javagirls.chapter_2

class User(val id: Int, val name: String, val email: String) {
    /*
      3.14 Transformando uma função local em uma extensão
      Transforma a função local em uma extensão da classe User
      A função de validação agora é um método da classe User
     */
    fun User.validateBeforeSave() {
        fun validate(value: String, fieldName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("Can't save user ${id}: empty $fieldName")
            }
        }
        validate(name, "name")
        validate(email, "email")
    }

    fun saveUser(user: User) {
        user.validateBeforeSave()
        // Save user to the database
    }
}


fun saveUserRepetitiveCode(user: User) {

    /*
    3.11 Função com código repetitivo
     Validação de campo está duplicada;
     Em uma função local, a validação de campo é feita uma vez e reutilizada em várias funções.
     */

    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty name")
    }
    if (user.email.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty email")
    }
    // Save user to the database
}

fun saveUserLocalFunction(user: User) {
    /*
      3.12 Extraindo uma função local para evitar repetição
      Declara uma função local para validar qualquer campo
      A função local é chamada duas vezes
     */
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user, user.name, "name")
    validate(user, user.email, "email")
    // Save user to the database
}

fun saveUserLocalFunctionExternalAccess(user: User) {
    /*
      3.13 Acessando parâmetros da função externa em uma funçãp local
      Agora não duplicamos o parâmetro user
      Podemos acessar parâmetros da função externa diretamente
     */
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user.name, "name")
    validate(user.email, "email")
    // Save user to the database
}


fun main() {
    //saveUserRepetitiveCode(User(1,"",""))
    //saveUserLocalFunction(User(1,"",""))
    //saveUserLocalFunctionExternalAccess(User(1, "", ""))

    val user = User(1, "", "")
    user.saveUser(user)

}
