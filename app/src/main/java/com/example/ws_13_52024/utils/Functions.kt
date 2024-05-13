package com.example.ws_13_52024.utils

fun validIsEmail(email: String): Boolean{
    val emailPattern = Regex("[a-z0-9]+@[a-z0-9]+\\.[a-z]{2,}")
    return emailPattern.matches(email)
}


fun generatePasswordFromPhrase(phrase: String): String {
    val password = StringBuilder()

    var isUpperCase = false

    for (char in phrase) {
        var char = char
        if (char.isLetter()){
            char = char.toLowerCase()
        }

        when (char) {
            'а' -> password.append('A')
            'е' -> password.append('E')
            'о' -> password.append('0')
            'с' -> password.append('c')
            'р' -> password.append('p')
            'к' -> password.append('k')
            'м' -> password.append('M')
            'г' -> password.append('g')
            'н' -> password.append('№')
            'п' -> password.append('p')
            'в' -> password.append('v')
            'д' -> password.append('9')
            'ч' -> password.append('4')
            'я' -> password.append('I')
            '№' -> password.append('#')
            'ю' -> password.append('u')
            ' ' -> password.append(listOf(" ", "_").random())
            else -> password.append(char)
        }
        if (password.last().isLowerCase() && !isUpperCase){
            val char = password.last()
            password.dropLast(1)
            password.append(char.toUpperCase())
            isUpperCase = true
        }
    }

    return password.toString()
}