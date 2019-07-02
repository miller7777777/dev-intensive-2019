package ru.skillbranch.devintensive.utils

object Utils {

    //TODO: Fix me!!!
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        var fName = "no fistname"
        var lName = "no lastname"

        when{
            firstName == null -> fName = "no firstname"
            firstName.trim() == "" -> fName = "no firstname"
            else -> fName = firstName
        }

        when{
            lastName == null -> lName = "no lastname"
            lastName.trim() == "" -> lName = "no lastname"
            else -> lName = lastName
        }

//        return Pair(firstName, lastName)
//        return firstName to lastName
        return fName to lName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        TODO(reason = "not implemented")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
//        TODO(reason = "not implemented")
        return firstName?.substring(0, 1)+lastName?.substring(0, 1)

    }
}