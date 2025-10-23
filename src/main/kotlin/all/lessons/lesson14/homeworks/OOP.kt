package org.example.all.lessons.lesson14.homeworks

// 1. Событие: вечеринка.
class Party(val location: String, val attendees: Int) {
    fun details() {
        println("Место проведения: $location, Количество гостей: $attendees")
    }
}

// 2. Аспект реальности: эмоция.
class Emotion(val type: String, val intensity: Int) {
    fun express() {
        val description = when (type.lowercase()) {
            "happy" -> "Я чувствую себя счастливым с интенсивностью $intensity"
            "sad" -> "Я чувствую грусть с интенсивностью $intensity"
            "angry" -> "Я зол с интенсивностью $intensity"
            else -> "Я испытываю эмоцию $type с интенсивностью $intensity"
        }
        println(description)
    }
}

// 3. Природное явление: луна.
object Moon {
    val isVisible: Boolean = true
    val phase: String = "Full Moon"
    fun showPhase() {
        if (isVisible) {
            println("The moon is visible, and it's currently a $phase.")
        } else {
            println("The moon is not visible right now.")
        }
    }
}
fun main() {
    Moon.showPhase()  // The moon is visible, and it's currently a Full Moon.
}

// 4. Покупка: продукт.
data class Product(
    val name: String,
    val price: Double,
    val quantity: Int
)

// 5. Мероприятие: концерт.
class Concert(
    val band: String,
    val venue: String,
    val cost: Double,
    val capacity: Int
) {
    private var ticketsSold: Int = 0

    fun showInfo() {
        println("Концерт группы: $band\nМесто: $venue\nСтоимость: $cost\nВместимость зала: $capacity\nПродано билетов: $ticketsSold")
    }

    fun buyTicket() {
        if (ticketsSold < capacity) {
            ticketsSold++
            println("Билет успешно куплен. Всего продано билетов: $ticketsSold")
        } else {
            println("Все билеты распроданы.")
        }
    }
}

// Задание 6. Стеллаж и полки.
//1. Класс Shelf (Полка стеллажа):

class Shelf(private val capacity: Int) {
    private val items = mutableListOf<String>()

    // Проверка, поместится ли предмет
    fun canAccommodate(itemName: String): Boolean {
        return (getRemainingCapacity() >= itemName.length)
    }

    // Добавление предмета
    fun addItem(itemName: String): Boolean {
        if (canAccommodate(itemName)) {
            items.add(itemName)
            return true
        }
        return false
    }

    // Удаление предмета
    fun removeItem(itemName: String): Boolean {
        return items.remove(itemName)
    }

    // Проверка наличия предмета
    fun containsItem(itemName: String): Boolean {
        return items.contains(itemName)
    }

    // Получение списка предметов
    fun getItems(): List<String> {
        return items.toList()
    }

    // Получение текущего заполнения (сумма длин всех предметов)
    fun getUsedCapacity(): Int {
        return items.sumBy { it.length }
    }

    fun getRemainingCapacity(): Int {
        return capacity - getUsedCapacity()
    }

    fun getCapacity(): Int {
        return capacity
    }
}

//2. Класс Rack (Стеллаж):
class Rack(private val maxShelves: Int) {
    private val shelves = mutableListOf<Shelf>()

    // Добавление полки
    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.size >= maxShelves || shelves.contains(shelf)) {
            return false
        }
        shelves.add(shelf)
        return true
    }

    // Удаление полки по индексу
    fun removeShelf(index: Int): List<String> {
        if (index !in shelves.indices) {
            return emptyList()
        }
        val removedShelf = shelves.removeAt(index)
        return removedShelf.getItems()
    }

    // Добавление предмета на первую найденную полку, которая может вместить
    fun addItem(itemName: String): Boolean {
        for (shelf in shelves) {
            if (shelf.canAccommodate(itemName)) {
                return shelf.addItem(itemName)
            }
        }
        return false
    }

    // Удаление предмета из первой найденной полки
    fun removeItem(itemName: String): Boolean {
        for (shelf in shelves) {
            if (shelf.containsItem(itemName)) {
                return shelf.removeItem(itemName)
            }
        }
        return false
    }

    // Проверка, есть ли предмет на стеллаже
    fun containsItem(itemName: String): Boolean {
        return shelves.any { it.containsItem(itemName) }
    }

    // Получение списка полок
    fun getShelves(): List<Shelf> {
        return shelves.toList()
    }

    // Вывод содержимого
    fun printContents() {
        shelves.forEachIndexed { index, shelf ->
            println("Полка $index:")
            println("  Вместимость: ${shelf.getCapacity()}")
            println("  Осталось места: ${shelf.getRemainingCapacity()}")
            println("  Предметы: ${shelf.getItems()}")
        }
    }

    // Сложное удаление полки
    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in shelves.indices) {
            return emptyList()
        }

        val removedShelfItems = shelves.removeAt(index).getItems()
        val unplacedItems = mutableListOf<String>()

        // Распределение предметов начиная с длинных (по убыванию)
        val sortedItems = removedShelfItems.sortedByDescending { it.length }

        for (item in sortedItems) {
            var placed = false
            for (shelf in shelves) {
                if (shelf.canAccommodate(item)) {
                    shelf.addItem(item)
                    placed = true
                    break
                }
            }
            if (!placed) {
                unplacedItems.add(item)
            }
        }
        return unplacedItems
    }
}
