package org.javagirls.chapter_3

class `3_2_Calling_Functions` {

    fun <T> joinToString(
        collection: Collection<T>,
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
    ): String {
        val result = StringBuilder(prefix)

        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }
        result.append(postfix)

        return result.toString()
    }
}

fun main() {
    val callingFunctions = `3_2_Calling_Functions`()

    val list = listOf(1, 7, 53)

    //println(callingFunctions.joinToString(list)) // padrao


    //println(callingFunctions.joinToString(list,"; ", "(", ")"))


    //println(callingFunctions.joinToString(collection = list,
    //                                                               prefix = "(",
    //                                                                separator = "; ",
    //                                                                postfix = ")")) //nomeado




    //sayHello()

    //println(MAX_EXPERIENCE)

    println(1 add 2)
}


infix fun Int.add(x: Int): Int {
    return this + x
}
