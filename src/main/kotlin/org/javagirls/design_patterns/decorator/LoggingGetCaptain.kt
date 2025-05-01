package org.javagirls.design_patterns.decorator

// Uso de delegation (by), sobrescrevendo méttodo para logar informações
class LoggingGetCaptain(private val repository: StarTrekRepository) :
    StarTrekRepository by repository {
        override fun getCaptain(starshipName: String): String {
            println("Getting captain for $starshipName")
            return repository.getCaptain(starshipName)
        }
    }
