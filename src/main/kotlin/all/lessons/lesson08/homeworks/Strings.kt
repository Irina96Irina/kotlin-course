package org.example.all.lessons.lesson08

// 1. Преобразование строк
fun transformPhrase (arg: String) {
    val result = when {
        arg.contains("невозможно") -> arg.replace("невозможно", "совершенно точно возможно, просто требует времени", true)
        arg.trim().startsWith("Я не уверен",true) -> "$arg, но моя интуиция говорит об обратном"
        arg.contains("катастрофа", true) -> arg.replace("катастрофа", "интересное событие", true)
        arg.endsWith("без проблем", true) -> arg.replace("без проблем", "с парой интересных вызовов на пути", true)
        arg.split("\\s+".toRegex()).filter { it.isNotEmpty() }.count() == 1 -> "Иногда, $arg, но не всегда."
        else -> arg
    }
    println(result)
}

// 2. Извлечение даты из строки лога
fun extractDateTime(logLine: String): Pair<String, String> {
    // Предполагаем формат: "... -> 2021-12-01 09:48:23"
    val parts = logLine.split("->")
    if (parts.size >= 2) {
        val right = parts[1].trim()
        // Разделим на дату и время по пробелу
        val dtParts = right.split(Regex("\\s+"), limit = 2)
        val date = dtParts.getOrNull(0) ?: ""
        val time = dtParts.getOrNull(1) ?: ""
        return Pair(date, time)
    }
    // Если формат не совпал
    return Pair("", "")
}


// 3. Маскирование личных данных
fun maskCardNumber(arg: String) {
    val preResult = arg.replace(" ", "")
    val howManyNumbers = preResult.length
    if (howManyNumbers == 16) {
        val result = preResult.replaceRange(0, 12, "*".repeat(12)).chunked(4).joinToString(" ")
        println(result)
    } else {
        println(" Incorrect card number")
    }
}

// 4. Форматирование адреса электронной почты
fun formatEmail(email: String): String {
    // Преобразуем "username@example.com" в "username [at] example [dot] com"
    return email
        .replace("@", " [at] ")
        .replace(".", " [dot] ")
}


// 5. Извлечение имени файла из пути
fun extractFileNameFromPath(arg: String) {
    val start = arg.substring(arg.lastIndexOf('/') + 1) //отрезаем начиная с ...
    println(start)
}

// 6. Создание аббревиатуры из фразы
fun createAbbreviation(arg: String) {
    val mass = arg.split("\\s+".toRegex())
    var abbreviation = ""
    for (word in mass ) {
        val firstLetter = word[0]
        abbreviation += firstLetter
    }
    println(abbreviation.uppercase())
}

// Демонстрация работы функций
fun main() {
    // 1. Преобразование строк
    val tests = listOf(
        "Это невозможно выполнить за один день",
        "Я не уверен в успехе этого проекта",
        "Произошла катастрофа на сервере",
        "Этот код работает без проблем",
        "Удача"
    )

    println("Преобразование строк:")
    for (t in tests) {
        println("  Исходно: \"$t\" -> преобразованно: \"${transformPhrase(t)}\"")
    }

    println()

    // 2. Извлечение даты из лога
    val logLine = "Пользователь вошел в систему -> 2021-12-01 09:48:23"
    val (date, time) = extractDateTime(logLine)
    println("Дата: $date")
    println("Время: $time")

    println()

    // 3. Маскирование данных
    val card = "4539 1488 0343 6467"
    val masked = maskCardNumber(card)
    println(" masked card: $masked")

    println()

    // 4. Форматирование адреса почты
    val email = "username@example.com"
    val formattedEmail = formatEmail(email)
    println("formatted email: $formattedEmail")

    println()

    // 5. Имя файла из пути
    val path1 = "C:/Пользователи/Документы/report.txt"
    val path2 = "D:/good.themes/dracula.theme"
    println("Файл из пути 1: ${extractFileNameFromPath(path1)}")
    println("Файл из пути 2: ${extractFileNameFromPath(path2)}")

    println()

    // 6. Аббревиатура
    val phrase = "Котлин лучший язык программирования"
    val abbr = createAbbreviation(phrase)
    println("Аббревиатура: $abbr")
}
