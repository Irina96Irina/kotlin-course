package org.example.all.lessons.lesson16.homeworks

class Polymorphism {
    open class Animal {
        open fun makeSound() {
            println("This animal makes no sound.")
        }
    }

    class Dog : Animal() {
        override fun makeSound() {
            println("\u001B[31mBark\u001B[0m") // Красный цвет (или можно выбрать любой другой для выделения)
        }
    }

    class Cat : Animal() {
        override fun makeSound() {
            println("\u001b[32mMeow\u001b[0m") // Зеленый цвет
        }
    }

    class Bird : Animal() {
        override fun makeSound() {
            println("\u001b[34mTweet\u001b[0m") // Синий цвет
        }
    }

    fun mainAnimals() {
        val animals = listOf(Animal(), Dog(), Cat(), Bird())
        for (animal in animals) {
            animal.makeSound()
        }
    }

    abstract class Shape {
        open fun area(): Double = 0.0
    }

    class Circle(val radius: Double) : Shape() {
        override fun area() = Math.PI * radius * radius
    }

    class Square(private val side: Double) : Shape() {
        override fun area(): Double = side * side
    }

    class Triangle(val a: Double, val b: Double, val angleBetween: Double) : Shape() {
        override fun area(): Double {
            // Используем формулу: 1/2 * a * b * sin(угол)
            return 0.5 * a * b * Math.sin(Math.toRadians(angleBetween))
        }
    }

    fun mainShapes() {
        val shapes = listOf<Shape>(
            Circle(3.0),
            Square(4.0),
            Triangle(3.0, 4.0, 60.0)
        )
        for (shape in shapes) {
            println("Area: ${shape.area()}")
        }
    }

    abstract class Printer {
        abstract fun print(text: String)
    }

    class LaserPrinter : Printer() {
        override fun print(text: String) {
            val words = text.split(" ")
            for (word in words) {
                println("\u001B[30;47m$word\u001B[0m") // Черные буквы на белом фоне
            }
        }
    }

    class InkjetPrinter : Printer() {
        private val colors = listOf(
            Pair("\u001B[31m", "\u001B[41m"), // Красный на красном фоне
            Pair("\u001B[32m", "\u001B[42m"), // Зеленый
            Pair("\u001B[34m", "\u001B[44m"), // Синий
            Pair("\u001B[35m", "\u001B[45m"), // Пурпурный
            Pair("\u001B[36m", "\u001B[46m")  // Глубокий голубой
        )

        override fun print(text: String) {
            val words = text.split(" ")
            for ((index, word) in words.withIndex()) {
                val (textColor, bgColor) = colors[index % colors.size]
                println("$bgColor$textColor$word\u001B[0m")
            }
        }
    }

    fun mainPrinters() {
        val laser = LaserPrinter()
        val inkjet = InkjetPrinter()
        val longText = "Это пример для теста работы принтеров, чтобы проверить цветовое оформление слов."
        println("Laser Printer output:")
        laser.print(longText)
        println("\nInkjet Printer output:")
        inkjet.print(longText)
    }

    class ShoppingCart {
        private val items: MutableMap<Int, Int> = mutableMapOf()

        fun addToCart(itemId: Int) {
            items[itemId] = items.getOrDefault(itemId, 0) + 1
        }

        // Перегрузка: добавление с указанием количества
        fun addToCart(itemId: Int, amount: Int) {
            if (amount <= 0) return
            items[itemId] = items.getOrDefault(itemId, 0) + amount
        }

        // Перегрузка: добавление из списка id
        fun addToCart(itemIds: List<Int>) {
            for (id in itemIds) {
                addToCart(id)
            }
        }

        override fun toString(): String {
            val totalItems = items.values.sum()
            val sb = StringBuilder()
            sb.append("Корзина товаров:\n")
            sb.append("%-10s %-10s\n".format("Артикул", "Кол-во"))
            for ((id, count) in items) {
                sb.append("%-10d %-10d\n".format(id, count))
            }
            sb.append("Итого уникальных товаров: ${items.size}\n")
            sb.append("Общее количество товаров: $totalItems\n")
            return sb.toString()
        }
    }

    fun mainShoppingCart() {
        val cart = ShoppingCart()
        cart.addToCart(101)
        cart.addToCart(102, 3)
        cart.addToCart(listOf(101, 103, 104))
        println(cart)
    }

    class Logger {
        fun log(message: String) {
            println("[INFO] $message")
        }

        fun log(level: String, message: String) {
            when (level.uppercase()) {
                "WARNING" -> println("\u001B[33m[$level] $message\u001B[0m") // Желтый цвет
                "ERROR" -> println("\u001B[37;41m[$level] $message\u001B[0m") // Белый на красном фоне
                else -> println("[$level] $message")
            }
        }

        fun log(messages: List<String>) {
            for (msg in messages) {
                log("INFO", msg)
            }
        }

        fun log(exception: Exception) {
            println("\u001B[37;41m[ERROR] ${exception.message}\u001B[0m")
        }
    }

    fun mainLogger() {
        val logger = Logger()

        logger.log("Это информационное сообщение.")
        logger.log("WARNING", "Это предупреждение.")
        logger.log("ERROR", "Это ошибка.")
        logger.log(listOf("Сообщение 1", "Сообщение 2"))
        try {
            throw Exception("Тест исключения")
        } catch (e: Exception) {
            logger.log(e)
        }
    }


}