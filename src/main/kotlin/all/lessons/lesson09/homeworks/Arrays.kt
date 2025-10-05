package org.example.all.lessons.lesson09.homeworks



// Задачи по работе с массивами, списками и множествами

// Функция поиска подстроки в элементах массива строк
fun findContainingSubstring(arr: Array<String>, substr: String): String? {
    for (item in arr) {
        if (item.contains(substr)) return item
    }
    return null
}

// Функция проверки наличия строки в множестве через цикл
fun setContains(set: Set<String>, target: String): Boolean {
    for (s in set) {
        if (s == target) return true
    }
    return false
}

fun main() {
    // Работа с массивами Array

    // 1. Массив из 5 целых чисел и инициализация 1..5
    val arr1 = intArrayOf(1, 2, 3, 4, 5)
    println("arr1: ${arr1.joinToString()}") // 1, 2, 3, 4, 5

    // 2. Пустой массив строк размером 10
    val arr2 = Array(10) { "" }
    println("arr2: ${arr2.joinToString()}")

    // 3. Массив Double из 5 элементов, заполнен значениями удвоенного индекса
    val arr3 = DoubleArray(5) { i -> i * 2.0 }
    println("arr3: ${arr3.joinToString()}")

    // 4. Массив Int из 5 элементов, каждый элемент = индекс * 3
    val arr4 = IntArray(5) { i -> i * 3 }
    println("arr4: ${arr4.joinToString()}")

    // 5. Массив из 3 nullable строк, инициализирован одним null и двумя строками
    val arr5: Array<String?> = arrayOf(null, "one", "two")
    println("arr5: ${arr5.joinToString(separator = ", ")}")

    // 6. Массив целых чисел и копирование в новый массив в цикле
    val source = intArrayOf(7, 8, 9, 10)
    val copy = IntArray(source.size)
    for (i in source.indices) {
        copy[i] = source[i]
    }
    println("copy: ${copy.joinToString()}")

    // 7. Два массива целых чисел одинаковой длины, третий массив - разность соответствующих элементов
    val a = intArrayOf(10, 20, 30)
    val b = intArrayOf(1, 2, 3)
    val diff = IntArray(a.size)
    for (i in a.indices) diff[i] = a[i] - b[i]
    println("diff: ${diff.joinToString()}")

    // 8. Найти индекс элемента со значением 5 через цикл while, если нет -1
    val arr8 = intArrayOf(3, 4, 5, 6, 7)
    var idx = 0
    var found = -1
    while (idx < arr8.size) {
        if (arr8[idx] == 5) {
            found = idx
            break
        }
        idx++
    }
    println("Index of 5: $found")

    // 9. Массив целых чисел, вывести каждый элемент и чётность
    val arr9 = intArrayOf(1, 4, 7, 8, 10)
    for (num in arr9) {
        val parity = if (num % 2 == 0) "чётное" else "нечётное"
        println("$num - $parity")
    }

    // 10. Функция: найти элемент, содержащий подстроку в массиве строк
    val words = arrayOf("apple pie", "banana", "cherry tart")
    val substr = "an"
    val foundWord = findContainingSubstring(words, substr)
    println("Element containing substring \"$substr\": ${foundWord ?: "нет"}")

    // Работа со списками List

    // 1. Пустой неизменяемый список целых чисел
    val list1 = listOf<Int>()
    println("list1 size: ${list1.size}")

    // 2. Неизменяемый список строк из трех элементов
    val list2 = listOf("Hello", "World", "Kotlin")
    println("list2: $list2")

    // 3. Изменяемый список целых чисел 1..5
    val mutableList = mutableListOf(1, 2, 3, 4, 5)
    println("mutableList: $mutableList")

    // 4. Добавить новые элементы
    mutableList.addAll(listOf(6, 7, 8))
    println("mutableList after adds: $mutableList")

    // 5. Удалить из изменяемого списка строк элемент "World"
    val mutableStrings = mutableListOf("Hello", "World", "Kotlin")
    mutableStrings.remove("World")
    println("mutableStrings after remove: $mutableStrings")

    // 6. Вывести элементы списка
    println("Elements of mutableList:")
    for (elem in mutableList) println(elem)

    // 7. Получить второй элемент из списка строк по индексу
    val stringsList = listOf("Alpha", "Beta", "Gamma")
    println("Second element: ${stringsList[1]}")

    // 8. Изменить значение элемента на позиции 2
    val modList = mutableListOf(10, 20, 30, 40)
    modList[2] = 999
    println("modList after change: $modList")

    // 9. Два списка строк и их объединение циклом
    val s1 = listOf("A", "B", "C")
    val s2 = listOf("D", "E")
    val combined = mutableListOf<String>()
    for (x in s1) combined.add(x)
    for (y in s2) combined.add(y)
    println("Combined list: $combined")

    // 10. Найти минимальный и максимальный элементы в списке через цикл
    val nums = listOf(5, 2, 9, 1, 7)
    var min = nums[0]
    var max = nums[0]
    for (n in nums) {
        if (n < min) min = n
        if (n > max) max = n
    }
    println("Min: $min, Max: $max")

    // 11. Из исходного списка создать новый, содержащий только чётные числа
    val evens = mutableListOf<Int>()
    for (n in nums) if (n % 2 == 0) evens.add(n)
    println("Evens: $evens")

    // Работа с Множествами Set

    // 1. Пустое неизменяемое множество целых чисел
    val set1 = emptySet<Int>()
    println("set1: $set1")

    // 2. Неизменяемое множество три элемента
    val set2 = setOf(1, 2, 3)
    println("set2: $set2")

    // 3. Изменяемое множество строк инициализировано несколькими значениями
    val mutableSetStrings = mutableSetOf("Kotlin", "Java", "Scala")
    println("mutableSetStrings: $mutableSetStrings")

    // 4. Добавить новые элементы
    mutableSetStrings.add("Swift")
    mutableSetStrings.add("Go")
    println("mutableSetStrings after adds: $mutableSetStrings")

    // 5. Удалить элемент 2 из множества целых чисел
    val mutableSetInts = mutableSetOf(1, 2, 3, 4)
    mutableSetInts.remove(2)
    println("mutableSetInts after remove: $mutableSetInts")

    // 6. Множество целых чисел и вывод элементов
    val setInts = setOf(5, 1, 4, 3, 2)
    println("Elements of setInts:")
    for (x in setInts) println(x)

    // 7. Функция: проверить наличие строки в Set через цикл
    val someSet = setOf("Android", "Kotlin", "Java")
    val containsKotlin = setContains(someSet, "Kotlin")
    println("Set contains 'Kotlin'?: $containsKotlin")

    // 8. Конвертация множества строк в изменяемый список через цикл
    val readOnlySet = setOf("One", "Two", "Three")
    val asMutableList = mutableListOf<String>()
    for (s in readOnlySet) asMutableList.add(s)
    println("asMutableList from set: $asMutableList")
}