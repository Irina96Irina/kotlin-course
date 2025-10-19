package org.example.all.lessons.lesson12.homeworks


// 1. Проверить, что размер коллекции больше 5 элементов.
fun isSizeGreaterThanFive(collection: Collection<*>) = collection.size > 5

// 2. Проверить, что коллекция пустая.
fun isCollectionEmpty(collection: Collection<*>) = collection.isEmpty()

// 3. Проверить, что коллекция не пустая.
fun isCollectionNotEmpty(collection: Collection<*>) = collection.isNotEmpty()

// 4. Взять элемент по индексу или создать значение если индекса не существует.
fun getElementAtOrDefault(list: List<*>, index: Int, default: Any?) = list.getOrNull(index) ?: default

// 5. Собрать коллекцию в строку.
fun collectionToString(collection: Collection<*>) = collection.joinToString(separator = ", ")

// 6. Посчитать сумму всех значений (предполагается коллекция чисел).
fun sumOfCollection(numbers: Collection<Number>) = numbers.sumOf { it.toDouble() }

// 7. Посчитать среднее.
fun averageOfCollection(numbers: Collection<Number>) = if (numbers.isNotEmpty()) numbers.map { it.toDouble() }.average() else null

// 8. Взять максимальное число.
fun maxOfCollection(numbers: Collection<Number>) = numbers.maxOfOrNull { it.toDouble() }

// 9. Взять минимальное число.
fun minOfCollection(numbers: Collection<Number>) = numbers.minOfOrNull { it.toDouble() }

// 10. Взять первое число или null.
fun firstOrNullElement(collection: Collection<*>) = collection.firstOrNull()

// 11. Проверить что коллекция содержит элемент.
fun containsElement(collection: Collection<*>, element: Any) = collection.contains(element)



// Обработка коллекций

// 1. Отфильтровать коллекцию по диапазону 18-30.
fun filterRange18To30(collection: Collection<Int>) = collection.filter { it in 18..30 }

// 2. Выбрать числа, которые не делятся на 2 и 3 одновременно.
fun filterNotDivisibleBy2And3(collection: Collection<Int>) = collection.filter { !(it % 2 == 0 && it % 3 == 0) }

// 3. Очистить текстовую коллекцию от null элементов.
fun filterNullStrings(collection: Collection<String?>) = collection.filterNotNull()

// 4. Преобразовать текстовую коллекцию в коллекцию длин слов.
fun mapStringsToLengths(collection: Collection<String>) = collection.map { it.length }

// 5. Преобразовать текстовую коллекцию в мапу, где ключи - перевёрнутые слова, а значения - длина слов.
fun mapReversedWordToLength(collection: Collection<String>) =
    collection.associate { it.reversed() to it.length }

// 6. Отсортировать список в алфавитном порядке.
fun sortListAlphabetically(collection: List<String>) = collection.sorted()

// 7. Взять первые 3 элемента списка.
fun takeFirstThree(collection: List<*>) = collection.take(3)

// 8. Распечатать квадраты элементов списка.
fun printSquares(collection: List<Int>) {
    collection.forEach { println(it * it) }
}

// 9. Группировать список по первой букве слов.
fun groupByFirstLetter(collection: List<String>) = collection.groupBy { it.first() }

// 10. Очистить список от дублей.
fun removeDuplicates(collection: List<*>) = collection.distinct()

// 11. Отсортировать список по убыванию.
//fun sortDescending(collection: List<Comparable<*>>) = collection.sortedDescending()


// 12. Взять последние 3 элемента списка.
fun takeLastThree(collection: List<*>) = collection.takeLast(3)



// Задача 24. Характеристика числовой коллекции

fun characterizeCollection(numbers: Collection<Int>): String {
    return when {
        numbers.isEmpty() -> "Пусто"
        numbers.size < 5 -> "Короткая"
        numbers.firstOrNull() == 0 -> "Стартовая"
        numbers.sum() > 10000 -> "Массивная"
        numbers.average() == 10.0 -> "Сбалансированная"
        numbers.joinToString().length == 20 -> "Клейкая"
        (numbers.maxOrNull() ?: 0) < -10 -> "Отрицательная"
        (numbers.minOrNull() ?: 0) > 1000 -> "Положительная"
        (3 in numbers && 14 in numbers) -> "Пи***тая"
        else -> "Уникальная"
    }
}

//Задача 25. Анализ учебных оценок

fun processGrades(grades: List<Int>): List<Int> {
    // Отфильтровать оценки >=60
    val filtered = grades.filter { it >= 60 }
    // Отсортировать по возрастанию
    val sortedGrades = filtered.sorted()
    // Взять первые 3
    return sortedGrades.take(3)
}


//Задача 26. Создание каталога по первой букве

fun createCatalog(words: List<String>): Map<Char, String> {
    return words
        .map { it.lowercase() }
        .groupBy { it.first() }
        .mapValues { entry -> entry.value.joinToString(", ") }
}

// Начальные данные:
val list = listOf(
    "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка",
    "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик",
    "вешалка", "Подставка", "телевизор", "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска",
    "Бра", "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба",
    "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир", "Корзина для белья",
    "посуда", "Настольная лампа", "торшер", "Этажерка"
)
val catalog = createCatalog(list)
// В каталоге ключ - первая буква, значение - список слов через запятую

//Задача 27. Подсчёт средней длины слов в списке

fun averageWordLength(words: List<String>): String {
    val totalLetters = words.sumOf { it.length }
    val count = words.size
    val average = if (count > 0) totalLetters.toDouble() / count else 0.0
    return String.format("%.2f", average)
}

// Задача 28. Категоризация чисел
fun categorizeNumbers(numbers: List<Int>): Map<String, Int> {
    return numbers
        .distinct()
        .sortedDescending()
        .groupBy { if (it % 2 == 0) "чётные" else "нечётные" }
        .mapValues { it.value.size }
}

// Задача 29. Поиск первого подходящего элемента


fun findFirstAboveAge(ages: List<Int?>, ageThreshold: Int): Int? {
    return ages.firstOrNull { it != null && it > ageThreshold }
}

