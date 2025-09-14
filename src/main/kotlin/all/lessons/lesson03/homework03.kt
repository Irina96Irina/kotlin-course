package org.example.all.lessons.lesson03

import kotlin.properties.ReadOnlyProperty

class homework03 {

    // 1. Название мероприятия (неизменяемая публичная переменная известная на момент написания)
    val name: String = "Monster Hackaton"

    // 2. Дата проведения (публичная переменная известная на момент написания, но может быть изменена из-за переноса)
    var date: String = "10 ноября 2025"

    // 3. Место проведения
    var place: String = "Address"

    // 4. Подробный бюджет мероприятия, включая расходы на оборудование, кейтеринг и другие операционные расходы. (приватная неизменяемая переменная - её не должны увидеть и бюджет уже запланирован и утверждён и не должен изменяться)
    private val fullBudget: String = ""

    // 5. Количество участников
    var participantCount: Int = 0

    // 6. Длительность хакатона
    val hackathonDurationHours: Int = 48

    // 7. Контактная информация и условия соглашений с поставщиками пищи, оборудования и других услуг.
    private val supplierContacts: String = "Contact info of suppliers"

    // 8. Текущее состояние хакатона (статус)
    var hackathonStatus: String = "Not started" // например, "Not started", "In progress", "Finished"

    // 9. Список спонсоров
    var sponsorsList: String = "List of sponsors"

    // 10. Бюджет мероприятия
    private val budget: Int = 1000000

    // 11. Текущий уровень доступа к интернету
    var internetAccessLevel: String = "Medium" // "High", "Medium", "Low"

    // 12. Информация о транспортировке оборудования, распределении ресурсов и координации между различными командами поддержки.
    private val logisticsInfo: String = "Logistics info"

    // 13. Количество команд
    var teamCount: Int = 0

    // 14. Перечень задач
    var taskList: String = "Tasks list"

    // 15. План эвакуации
    var evacuationPlan: String = "Evacuation Plan"

    // 16. Список доступного оборудования (всё, что выделено для использования на мероприятии)
    var availableEquipment: String = "Equipment List"

    // 17. Список свободного оборудования (всё, что можно взять прямо сейчас и что не занято другими участниками)
    var freeEquipment: String = "List of free equipment"

    // 18. График питания участников (зависит от поставщика питания, определяемого за неделю до начала) (публичная изменяемая переменная с отложенной инициализацией, так как на момент создания поставщик и график не известны)
    lateinit var mealSchedule: String

    // 19. План мероприятий на случай сбоев
    private val contingencyPlan: String = "Contingency Plan"

    // 20. Список экспертов и жюри
    var judgesAndExperts: String = "Judges and Experts"

    // 21. Политика конфиденциальности
    val privacyPolicy: String = "Privacy Policy."

    // 22. Приватные отзывы (фидбэк) участников и зрителей для анализа проблем.
    private lateinit var participantsFeedback: String

    // 23. Текущая температура в помещении
    var currentTemperature: Int = 22

    // 24. Данные мониторинга и анализ производительности сетевого оборудования и интернет-соединения для целей отладки своих приложений командами
    var networkMonitoringData: String = "Network Monitoring Data"

    // 25. Регулятор скорости интернета (понижающий коэффициент, например 0.5)
    val internetSpeedRegulator: String = "Internet Speed Regulator"

    // 26. Уровень освещения
    var lightingLevel: Int = 1000

    // 27. Лог событий мероприятия
    lateinit var eventLog: String

    // 28. Возможность получения медицинской помощи прямо на мероприятии (да/нет)
    val medicalAssistanceAvailable: Boolean = true

    // 29. Планы и процедуры для обеспечения безопасности мероприятия, включая планы эвакуации и протоколы чрезвычайных ситуаций.
    private val safetyProcedures: String = "Safety Procedures"

    // 30. Регистрационный номер мероприятия
    val registrationNumber: Int = 11111

    // 31. Максимально допустимый уровень шума в помещении хакатона.
    val maxNoiseLevelDb: Int = 85

    // 32. Индикатор превышения уровня шума в помещениях (превышен или не превышен в данный момент)
    val noiseExceeded: Boolean = false

    // 33. План взаимодействия с прессой
    private val pressInteractionPlan: String = "Press Interaction Plan"

    // 34. Детальная публичная информация о проектах каждой команды, сбор данных включает в себя компиляцию кода и сбор статистики прогона автоматизированных проверок.
    lateinit var teamProjectsInfo: String

    // 35. Статус получения всех необходимых разрешений для проведения мероприятия
    var permissionsStatus: String = "No permission"

    // 36. Индикатор доступности специализированного оборудования в данный момент (например, специальному оборудованию)
    var equipmentAvailability: Boolean = true

    // 37. Список партнеров мероприятия
    var partners: String = "List of Partners"

    // 38. Отчет, включающий фотографии, видео и отзывы, генерируется и становится доступен после завершения мероприятия.
    val finalReport: String by lasy {
        "Final Report"
    }

    // 39. Внутренние правила распределения призов
    private val prizeDistributionRules: String = "Prize Distribution Rules"

    // 40. Список разыгрываемых призов
    val prizes: String = "Prizes"

    // 41. Контактная информация экстренных служб, медицинского персонала и других важных служб, для внутреннего пользования.
    private val emergencyContacts: String = "Emergency Contacts"

    // 42. Особые условия для участников с ограниченными возможностями
    var accommodationsForParticipants: String = "Accommodations For Participants"

    // 43. Общее настроение участников (определяется опросами)
    var participantMood: String = "Participant Mood"

    // 44. Подробный план хакатона, включающий время и содержание каждого сегмента, инициализируется непосредственно перед началом мероприятия, так как зависит от фактического состава команд и взятых в работу задач.
    lateinit var detailedSchedule: String

    // 45. Имя знаменитого специального гостя, которое будет объявлено за день до мероприятия, но в момент инициализации неизвестно.
    lateinit var specialGuestName: String

    // 46. Максимальное количество людей, которое может вместить место проведения.
    val venueCapacity: Int = 200

    // 47. Количество часов, отведенное каждой команде для работы над проектом.
    val teamWorkHours: Int = 48

}


private fun lasy(function: () -> String): ReadOnlyProperty<homework03, String> {
    return TODO("Provide the return value")
}
