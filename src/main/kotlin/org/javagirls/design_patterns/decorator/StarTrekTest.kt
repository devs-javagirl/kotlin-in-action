package org.javagirls.design_patterns.decorator

fun main() {
    val starTrekRepository = DefaultStarTrekRepository()
    starTrekRepository.addCaptain("USS Voyager", "Kathryn Janeway")
    println(starTrekRepository.starshipCaptains)

    val withValidatingAdd= ValidatingAdd(starTrekRepository)
    val withLoggingAndValidating = LoggingGetCaptain(withValidatingAdd)
    val captain = withLoggingAndValidating.getCaptain("USS Enterprise")
    println("Captain $captain")
    withLoggingAndValidating.addCaptain("USS Voyager", "Kathryn Janeway")
    println(starTrekRepository.starshipCaptains)


}