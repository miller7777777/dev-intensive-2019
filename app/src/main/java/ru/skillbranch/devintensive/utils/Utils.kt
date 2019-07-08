package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        var str = ("k" + fullName).trim().substring(1)

        when(str){
            ""  -> {firstName = null
                lastName = null}
//            " "  -> {firstName = null
//                lastName = null}
        }





//        return Pair(firstName, lastName)
        return firstName to lastName

    }

    fun transliteration(payload: String, divider: String = " "): String {
        TODO(reason = "not implemented")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
//        TODO(reason = "not implemented")
        return firstName?.substring(0, 1)+lastName?.substring(0, 1)

    }
}