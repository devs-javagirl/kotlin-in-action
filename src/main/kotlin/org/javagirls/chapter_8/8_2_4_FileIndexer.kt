package org.javagirls.chapter_8

import java.io.File

class `8_2_4_FileIndexer`: FileContentProcessor {
    override fun processContents(
        path: File,
        binaryContents: ByteArray?,
        textcontents: List<String>?
    ) {
        println("processing file content")
    }
}

fun main() {
    val fileIndexer = `8_2_4_FileIndexer`()
    fileIndexer.processContents(File("c:/temp/test.txt"), null, null)

}