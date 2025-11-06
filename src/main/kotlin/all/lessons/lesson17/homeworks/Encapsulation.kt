package org.example.all.lessons.lesson17.homeworks

// Класс Игровой автомат
class GameMachine(
    val color: String,                       // цвет автомата
    val model: String,                       // модель
    val hasGamePad: Boolean,
    private var isOn: Boolean = false,       // включен/выключен
    private var osLoaded: Boolean = false,   // ОС загружена
    private val installedGames: MutableList<String>, // список установленных игр
    private val hasJoystick: Boolean,          // наличие джойстика
    private var balance: Double,               // баланс вырученных средств
    private val owner: String,                 // владелец
    private val supportPhone: String,          // телефон поддержки
    private var sessionPaid: Boolean = false,  // игровой сеанс оплачен
    private val sessionCost: Double,           // стоимость игрового сеанса
    private val pinCode: String                // пин-код автомата
) {
    // Включить автомат
    fun turnOn() {
        isOn = true
        println("Автомат включен.")
    }

    // Выключить автомат
    fun turnOff() {
        isOn = false
        println("Автомат выключен.")
    }

    // Загрузить операционную систему
    fun loadOS() {
        if (!isOn) {
            println("Сначала включите автомат.")
            return
        }
        osLoaded = true
        println("Операционная система загружена.")
    }

    // Завершить работу ОС
    fun shutdownOS() {
        if (!isOn || !osLoaded) {
            println("Операционная система не загружена или автомат выключен.")
            return
        }
        osLoaded = false
        println("Операционная система завершила работу.")
    }

    // Показать список установленных игр
    fun showInstalledGames() {
        println("Установленные игры: ${installedGames.joinToString(", ")}")
    }

    // Включить игру по названию
    fun startGame(gameName: String) {
        if (!installedGames.contains(gameName)) {
            println("Игра не установлена.")
            return
        }
        if (!osLoaded || !isOn) {
            println("Автомат не готов к игре.")
            return
        }
        println("Запуск игры: $gameName.")
        // логика запуска игры
    }

    // Оплатить игровой сеанс
    fun paySession() {
        if (balance >= sessionCost) {
            balance -= sessionCost
            sessionPaid = true
            println("Игровой сеанс оплачен.")
        } else {
            println("Недостаточно средств для оплаты сеанса.")
        }
    }

    // Забрать наличные с помощью пин-кода
    fun withdrawCash(amount: Double, inputPin: String) {
        if (inputPin != pinCode) {
            println("Неверный пин-код.")
            return
        }
        if (amount > balance) {
            println("На счету недостаточно средств.")
            return
        }
        balance -= amount
        println("Выведено $amount наличными.")
    }

    // Открыть сейф и выдать наличные
    fun openSafekeepingAndDispense(amount: Double, inputPin: String) {
        if (inputPin != pinCode) {
            println("Неверный пин-код.")
            return
        }
        if (amount > balance) {
            println("Недостаточно средств.")
            return
        }
        balance -= amount
        println("Сейф открыт. Выдано $amount наличными.")
    }

    // Метод для добавления средств на баланс, например, через оплату
    fun addFunds(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Пополнено на сумму $amount. Текущий баланс: $balance.")
        }
    }
}





abstract class BaseClass(
    // 1. Почему это поле доступно в main() для чтения из класса ChildrenClass?
    // Ответ: Потому что это публичное свойство (val publicVal), которое наследуется и доступно везде,
    // где есть экземпляр класса. Однако, внутри наследника оно доступно напрямую.
    private val privateVal: String, // Доступно только внутри BaseClass
    // 2. Почему это поле недоступно в main()?
    // Ответ: Потому что оно объявлено как protected. Такие поля доступны внутри класса и в наследниках.
    protected val protectedVal: String,
    val publicVal: String // Объявление как val — публичный геттер, доступен из main()
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    // 5. Почему можно изменить через сеттер в наследнике?
    // Ответ: потому что publicField — публичное свойство (public), доступное везде, в том числе из дочерних классов.
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    // 6. Почему можно добавлять сеттер сюда?
    // Ответ: потому что свойство объявлено как var, и мы можем его расширять или переопределять в наследниках
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()"

    // Метод возвращает сведения обо всех полях и вызов генерирующей функции
    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    // 7. Почему эта функция не может быть публичной?
    // Ответ: потому что она объявлена как protected, чтобы быть доступной только внутри класса и наследников.
    protected open fun getProtectedClass() = ProtectedClass()

    // Эта функция возвращает true, если длина строки меньше 3, используется для валидации publicField
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    // 8. Почему в поле "generate" другой текст?
    // Ответ: потому что метод generate переопределяется в дочерних классах.
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // 9. Почему эта функция не может быть публичной или protected?
    // Ответ: потому что она объявлена как private, её нельзя вызвать извне или из наследника.
    private fun getPrivateClass() = PrivateClass()

    // Внутренние классы с разной степенью доступа.
    protected class ProtectedClass() {}
    private class PrivateClass() {}
}

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. Почему этот аргумент доступен в main(), несмотря на то, что это не поле?
    // Ответ: потому что `protectedVal` передается в конструктор, и параметры конструктора по сути — это аргументы
    // функции, передаваемые при создании экземпляра. Эти параметры доступны в main() при создании объекта.
    // Однако, сам по себе `protectedVal` как свойство — не объявлено. Для доступа его нужно объявить как свойство.
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {
    // 11. Почему в main() доступна функция getAll() хотя её здесь нет?
    // Ответ: потому что getAll() — публичный метод базового класса, доступен через объект дочернего класса.
    // В Kotlin наследники имеют доступ к публичным и защищенным методам базового класса.

    // 12. Проверим, что выводится на печать при вызове функции printText()
    // и объясним, почему не происходит переопределение метода privatePrint()
    fun printText() {
        // вызов privatePrint нельзя переопределить, потому что она private в базовом классе
        //super.privatePrint()
        // Или можно вызвать privatePrint() только внутри BaseClass, из внешнего метода невозможно
        // поскольку оно приватное.
    }

    // Объявляем с приватным модификатором — это скрывает функцию от вызова из main()
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    // Переопределение метода generate()
    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
}

//Итоговые ответы и комментарии по вопросам:
//№	Вопрос	Объяснение
//1	Почему privateVal доступно в main() через ChildrenClass?
//Потому что оно передается как аргумент конструктора и объявлено как val, то есть публичное свойство.
//2	Почему protectedVal недоступно в main()?
//Потому что оно объявлено как protected val, доступное только внутри класса и наследников, но не из main() напрямую.
//В конструкторе — да, для передачи, но при создании объекта оно не видно как свойство.
//3	Почему publicField можно изменить из main()?
//Потому что оно публичное (var) и доступно везде. Можно менять его значения.
//4	Как изменить publicField из main() для проверки?
//Создать объект ChildrenClass, затем object.publicField = "Антонио Бандераса", и вызвать getAll().
//5	Почему protectedField можно изменить в дочернем классе?
//Потому что свойство объявлено как protected var, оно доступно внутри наследников.
//6	Почему добавлен setter?
//Для ограничения или проверки перед присвоением; свойство var по умолчанию имеет геттер/сеттер, можно расширить.
//7	Почему getProtectedClass() — protected?
//Потому что это API, предназначенное для использования только внутри классов и наследников, не должно быть публичным.
//8	Почему generate() переопределяется?
//Потому что объявлено как open, и дочерний класс переопределяет свою версию. В базовом — генерация из родителя.
//9	Почему privatePrint() — private?
//Чтобы вызвать только внутри BaseClass. Это скрыто для подчиненных и сторонних классов.
//10	Почему аргумент в конструкторе доступен в main()?
//Потому что он передается при создание экземпляра, а параметры конструктора — видимы.
//Но сам аргумент не объявлен как свойство (нет val или var), так что только в конструкторе.
//11	Почему getAll() — публичный и работает в main()?
//Потому что он публичный метод базового класса, доступен через объект ChildrenClass.
//12	Почему privatePrint() не переопределен?
//Потому что она приватная, и переменная private fun privatePrint() в дочернем классе — это новая функция, а не переопределение.
//Переопределить приватную нельзя.