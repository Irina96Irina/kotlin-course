package org.example.all.lessons.lesson11.homeworks

class Funktions {

    // Задачи на сигнатуру метода

    // 1. Не принимает аргументов и не возвращает значения.
    fun doNothing(): Unit {}// пустая реализация }

    // 2. Принимает два целых числа и возвращает их сумму.
    fun sumTwo(a: Int, b: Int): Int {
        return a + b
    }

    // 3. Принимает строку и ничего не возвращает.
    fun getMessage(message: String): Unit {
        println(message)
    }

    // 4. Принимает список целых чисел и возвращает среднее значение типа Double.
    fun average(numbers: List<Int>): Double {
        if (numbers.isEmpty()) return 0.0
        val sum = numbers.sum()
        return sum.toDouble() / numbers.size
    }

    // 5. Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
    private fun lengthIfNotNull(text: String?): Int? {
        return text?.length
    }

    // 6. Не принимает аргументов и возвращает nullable вещественное число.
    fun maybeNullDouble(): Double? {
        return null
    }

    // 7. Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
    private fun getList(list: List<Int>?) {}

    // 8. Принимает целое число и возвращает nullable строку.
    fun returnNullString(a: Int): String? {
        return null
    }

    // 9. Не принимает аргументов и возвращает список nullable строк.
    fun intToNullableString(number: Int): String? {
        return number.toString()
    }

    // 10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
    fun compareNullable(text: String?, number: Int?): Boolean? {
        if (text == null || number == null)
            return null
        return text.length == number
    }


// Задачи на написание кода

    // 1. multiplyByTwo - умножает число на 2
    fun multiplyByTwo(number: Int): Int {
        return number * 2
    }

    // 2. isEven - возвращает true, если число чётное
    fun isEven(a: Int): Boolean {
        if (a % 2 == 0) {
            return true
        } else {
            return false
        }
    }


    // 3. printNumbersUntil - выводит числа от 1 до n, если n >= 1
    fun printNumbersUntil(n: Int) {
        if (n < 1) return
        for (i in 1..n) {
            println(i)
        }
    }

    // 4. findFirstNegative - возвращает первое отрицательное число из списка или null, если их нет
    fun findFirstNegative(numbers: List<Int>): Int? {
        for (num in numbers) {
            if (num < 0) return num
        }
        return null
    }

    // 5. processList - проходит по списку строк, выводит каждую, если встречается null — прекращает выполнение
    fun processList(strings: List<String?>) {
        for (str in strings) {
            if (str == null) return
            println(str)
        }
    }
}
