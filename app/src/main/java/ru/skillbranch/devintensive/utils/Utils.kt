package ru.skillbranch.devintensive.utils

object Utils {

    //TODO: Fix me!!!
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        var fName = "null"
        var lName = "null"



        if(firstName != null || firstName?.trim() != ""){
            fName = firstName!!
        }

        if(lastName != null || lastName?.trim() != ""){
            lName = lastName!!
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