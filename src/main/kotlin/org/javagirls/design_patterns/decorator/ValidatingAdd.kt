package org.javagirls.design_patterns.decorator

// Uso de delegation (by), sobrescrevendo méttodo para validar tamanho do nome antes de adicionar
class ValidatingAdd(private val repository: StarTrekRepository) :
    StarTrekRepository by repository {
        private val maxNameLength = 15

    override fun addCaptain(starshipName: String, captainName: String) {
        require (captainName.length < maxNameLength) {
            "$captainName is longer than $maxNameLength characters!"
        }
        repository.addCaptain(starshipName, captainName)
    }

}