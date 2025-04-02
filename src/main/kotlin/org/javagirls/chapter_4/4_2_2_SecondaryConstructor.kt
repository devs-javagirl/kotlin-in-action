package org.javagirls.chapter_4

import java.net.URI

open class Downloader {
    constructor(url: String) {

    }

    constructor(uri: URI?) {

    }
}

class MyDownloader1: Downloader {
    constructor(url: String): super(url)
    constructor(uri: URI?): super(uri)
}

class MyDownloader2: Downloader {
    constructor(url: String): this(URI(url))
    constructor(uri: URI?): super(uri)
}

fun main() {
    val myDownloader1Str = MyDownloader1("https://some.url")
    val myDownloader1Uri = MyDownloader1(URI("https://some.url"))

    val myDownloader2Str = MyDownloader2("https://some.url")


}