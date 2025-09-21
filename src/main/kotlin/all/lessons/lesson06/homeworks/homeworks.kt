package org.example.all.lessons.lesson06.homeworks



class Conditionals {
    // Задание 1: Определение сезона по номеру месяца
    fun determineSeason(month: Int) {
        if (month !in 1..12) {
            println("Некорректный номер месяца")
            return
        }
        val season = when (month) {
            12, 1, 2 -> "Зима"
            3, 4, 5 -> "Весна"
            6, 7, 8 -> "Лето"
            9, 10, 11 -> "Осень"
            else -> "Неизвестный сезон"
        }
        println("Сезон: $season")
    }
}

// Задание 2: Расчет возраста питомца в человеческих годах
fun calculateDogAge(dogAge: Double) {
    if (dogAge < 0) {
        println("Некорректный возраст питомца")
        return
    }
    val humanYears = if (dogAge <= 2) {
        dogAge * 10.5
    } else {
        2 * 10.5 + (dogAge - 2) * 4
    }
    println("Возраст питомца в человеческих годах: $humanYears")
}

// Задание 3: Определение способа перемещения
fun determineTransport(routeLengthKm: Double) {
    if (routeLengthKm < 0) {
        println("Некорректная длина маршрута")
        return
    }
    val method = when {
        routeLengthKm <= 1 -> "пешком"
        routeLengthKm <= 5 -> "велосипед"
        else -> "автотранспорт"
    }
    println("Рекомендуемый способ перемещения: $method")
}

// Задание 4: Расчет бонусных баллов
fun calculateBonusPoints(purchaseAmount: Double) {
    if (purchaseAmount < 0) {
        println("Некорректная сумма покупки")
        return
    }
    val bonusPerHundred = if (purchaseAmount <= 1000) 2 else 3
    val bonusPoints = (purchaseAmount / 100).toInt() * bonusPerHundred
    println("Бонусные баллы: $bonusPoints")
}

// Задание 5: Определение типа документа по расширению
fun identifyFileType(extension: String) {
    val ext = extension.trim().lowercase()
    when (ext) {
        "txt", "doc", "docx", "pdf" ->
            println("Текстовый документ")

        "jpg", "jpeg", "png", "gif" ->
            println("Изображение")

        "xls", "xlsx", "csv" ->
            println("Таблица")

        else -> println("Неизвестный тип")
    }
}

// Задание 6: Конвертация температуры
fun convertTemperature(value: Double, unit: String) {
    when (unit.uppercase()) {
        "C" -> {
            val f = value * 9 / 5 + 32
            print("$f")
            print("F ")
        }

        "F" -> {
            val c = (value - 32) * 5 / 9
            print("$c")
            print("C ")
        }

        else -> println("Некорректная единица измерения")
    }
}

// Задание 7: Подбор одежды по погоде
// Задание 7: Подбор одежды по погоде
fun recommendClothing(temperature: Double) {
    when {
        temperature < -30 || temperature > 35 -> println("Рекомендуется оставаться дома")
        temperature < 10 -> println("Куртка и шапка")
        temperature in 10..18 -> println("Ветровка")
        temperature > 18 -> println("Футболка и шорты")
    }
}


// Задание 8: Выбор фильма по возрасту
fun availableMovieCategories(age: Int) {
    when {
        age in 0..9 ->
            println("Доступны: детские фильмы")
        age in 10..18 ->
            println("Доступны: подростковые фильмы")
        else ->
            println("Доступны: фильмы 18+")
    }
}