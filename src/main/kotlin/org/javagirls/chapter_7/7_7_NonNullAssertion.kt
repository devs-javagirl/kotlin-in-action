package org.javagirls.chapter_7

// first example
fun ignoreNulls(str: String?) {
    val strNotNull: String = str!!
    println(strNotNull.length)
}

// second example
class SelectableTextList(
    val contents: List<String>,
    var selectedIndex: Int? = null
)

class CopyRowAction(val list: SelectableTextList) {
    fun isActionEnabled(): Boolean =
        list.selectedIndex != null

    fun executeCopyRow(): String {
        val index = list.selectedIndex!!
        val value = list.contents[index]
        return value

    }
}

// third example


fun main() {
    // first
    ignoreNulls("Kotlin")

    // second
    val content = SelectableTextList(
        listOf("glass", "fork", "knife"),
        null
    )

    val content1 = SelectableTextList(
        listOf("glass", "fork", "knife"),
        0
    )

    val sheet = CopyRowAction(content)
    if (sheet.isActionEnabled())
        println(sheet.executeCopyRow())




    // third
    val company = Company("Bosch", null)
    val person = Person("Cris", company, "cris@gmail.com")

    //println(person.company!!.address!!.country)

    println(person
        .company!!
        .address!!
        .country)



}



