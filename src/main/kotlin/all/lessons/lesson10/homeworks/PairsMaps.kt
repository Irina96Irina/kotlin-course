package org.example.all.lessons.lesson10.homeworks


fun main() {
    // 1. Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
    val emptyIntMap: Map<Int, Int> = emptyMap()
    println("emptyIntMap: $emptyIntMap")

    // 2. Создайте словарь, инициализированный несколькими парами "ключ-значение",
    // где ключи - float, а значения - double
    val floatToDoubleMap: Map<Float, Double> = mapOf(
        1.0f to 2.0,
        2.5f to 3.14,
        0.0f to 0.0
    )
    println("floatToDoubleMap: $floatToDoubleMap")

    // 3. Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
    val mutableIntToString: MutableMap<Int, String> = mutableMapOf(
        1 to "один",
        2 to "два",
        3 to "три"
    )

    // 4. Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
    mutableIntToString[1] = "один"
    mutableIntToString[2] = "два"
    println("mutableIntToString after adds: $mutableIntToString")

    // 5. Используя словарь из предыдущего задания, извлеките значение, используя ключ.
    // Попробуй получить значение с ключом, которого в словаре нет.
    val valueForKey1 = mutableIntToString[1]
    val valueForKey99 = mutableIntToString[99] // вернёт null
    println("valueForKey 1: $valueForKey1, valueForKey99: $valueForKey99")

    // 6. Удалите определенный элемент из изменяемого словаря по его ключу.
    mutableIntToString.remove(2)
    println("mutableIntToString после удаления ключа 2: $mutableIntToString")

    // 7. Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение.
    // Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
    val doubleToIntMap: Map<Double, Int> = mapOf(
        10.0 to 2,
        5.0 to 0,
        7.5 to 3
    )
    println("Division results:")
    for ((k, v) in doubleToIntMap) {
        if (v == 0) {
            println("$k / $v = бесконечность")
        } else {
            val res = k / v.toDouble()
            println("$k / $v = $res")
        }
    }

    // 8. Измените значение для существующего ключа в изменяемом словаре.
    // (используем ранее созданный mutableIntToString)
    mutableIntToString[1] = "один обновлён"
    println("mutableIntToString после обновления ключа 1: $mutableIntToString")

    // 9. Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
    val dictA: Map<String, Int> = mapOf("a" to 1, "b" to 2)
    val dictB: Map<String, Int> = mapOf("c" to 3, "d" to 4)

    val mergedDict: MutableMap<String, Int> = mutableMapOf()
    for ((k, v) in dictA) mergedDict[k] = v
    for ((k, v) in dictB) mergedDict[k] = v
    println("mergedDict: $mergedDict")

    // 10. Создайте словарь, где ключами являются строки, а значениями - списки целых чисел.
    // Добавьте несколько элементов в этот словарь.
    val stringToIntList: MutableMap<String, MutableList<Int>> = mutableMapOf(
        "primes" to mutableListOf(2, 3, 5),
        "evens" to mutableListOf(2, 4, 6)
    )
    stringToIntList["primes"]?.add(7)
    stringToIntList["evens"]?.addAll(listOf(8, 10))
    println("stringToIntList: $stringToIntList")

    // 11. Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк.
    // Добавь данные в словарь. Получи значение по ключу (это должно быть множество строк)
    // и добавь в это множество ещё строку. Распечатай полученное множество.
    val intToStringSet: MutableMap<Int, MutableSet<String>> = mutableMapOf(
        1 to mutableSetOf("один", "первый"),
        2 to mutableSetOf("два")
    )
    // получение множества по ключу и добавление новой строки
    intToStringSet[1]?.add("первый-добавленный")
    println("intToStringSet[1]: ${intToStringSet[1]}")

    // 12. Создай словарь, где ключами будут пары чисел. Через перебор найди значение у которого пара будет содержать цифру 5 в качестве первого или второго значения.
    // В качестве значений возьмём строку.
    val pairKeyToString: Map<Pair<Int, Int>, String> = mapOf(
        Pair(12, 34) to "alpha",
        Pair(5, 20) to "bravo",
        Pair(7, 5) to "charlie",
        Pair(11, 11) to "delta"
    )

    fun hasDigitFive(n: Int): Boolean {
        return n.toString().contains('5')
    }

    val foundEntry = pairKeyToString.entries.firstOrNull { entry ->
        val (a, b) = entry.key
        hasDigitFive(a) || hasDigitFive(b)
    }

    if (foundEntry != null) {
        println("Found entry with pair containing digit 5: key=${foundEntry.key}, value=${foundEntry.value}")
    } else {
        println("No entry found with pair containing digit 5.")
    }


    // Задачи на подбор оптимального типа для словаря
    // Примерные варианты, чтобы показать типы. Реальные данные можно подставлять по месту использования.

    // 1) Словарь библиотека: Ключи - автор книги, значения - список книг
    val library: Map<String, List<String>> = mapOf(
        "Толстой" to listOf("Война и мир", "Анна Каренина"),
        "Достоевский" to listOf("Преступление и наказание", "Братья Коготь")
    )
    println("library: $library")

    // 2) Справочник растений: Ключи - типы растений, значения - списки названий растений
    val plantsByType: Map<String, List<String>> = mapOf(
        "Цветы" to listOf("Роза", "Лилия"),
        "Деревья" to listOf("Береза", "Дуб")
    )
    println("plantsByType: $plantsByType")

    // 3) Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
    val quarterFinalists: Map<String, List<String>> = mapOf(
        "TeamA" to listOf("Player1", "Player2"),
        "TeamB" to listOf("Player3", "Player4")
    )
    println("quarterFinalists: $quarterFinalists")

    // 4) Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
    // простая демонстрация с строковыми датами
    val treatmentSchedule: Map<String, List<String>> = mapOf(
        "2025-10-01" to listOf("DrugA", "DrugB"),
        "2025-10-02" to listOf("DrugC")
    )
    println("treatmentSchedule: $treatmentSchedule")

    // 5) Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.
    val placesByCountry: Map<String, Map<String, List<String>>> = mapOf(
        "France" to mapOf("Paris" to listOf("Eiffel Tower", "Louvre")),
        "Japan" to mapOf("Tokyo" to listOf("Shibuya", "Asakusa"))
    )
    println("placesByCountry: $placesByCountry")
}