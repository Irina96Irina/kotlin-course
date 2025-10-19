package org.example.all.lessons.lesson13.homeworks

fun main() {
    // Задача 1: Среднее время выполнения теста
    val testTimes = mapOf(
        "testLogin" to 2.5,
        "testLogout" to 1.8,
        "testRegistration" to 3.2
    )
    val averageTime = testTimes.values.average()
    println("Среднее время тестов: $averageTime сек.")

    // Задача 2: Вывести список всех тестовых методов
    val testMetadata = mapOf(
        "testLogin" to "Priority: High; Duration: 2s",
        "testLogout" to "Priority: Low; Duration: 1s",
        "testRegistration" to "Priority: Medium; Duration: 3s"
    )
    val testMethods = testMetadata.keys.toList()
    println("Тестовые методы: $testMethods")

    // Задача 3: Добавить новый тест и результат в изменяемый словарь
    val testResultsMutable = mutableMapOf(
        "testLogin" to "Passed",
        "testLogout" to "Failed"
    )
    testResultsMutable["testProfileUpdate"] = "Skipped"
    println("Обновленный список результатов: $testResultsMutable")

    // Задача 4: Количество успешных тестов
    val successCount = testResultsMutable.values.count { it == "Passed" }
    println("Количество успешных тестов: $successCount")

    // Задача 5: Удалить исправленный баг
    val bugStatusMap = mutableMapOf(
        "BUG-101" to "Open",
        "BUG-102" to "Fixed",
        "BUG-103" to "Open"
    )
    bugStatusMap.remove("BUG-102")
    println("Обновленный баг-трекер: $bugStatusMap")

    // Задача 6: Сообщение о статусе проверки страниц
    val pageStatusMap = mapOf(
        "https://example.com" to "200 OK",
        "https://test.com" to "404 Not Found"
    )
    pageStatusMap.forEach { (url, status) ->
        println("Страница $url проверена, статус: $status")
    }

    // Задача 7: Время ответа сервисов выше порога
    val serviceResponseTimes = mapOf(
        "ServiceA" to 120,
        "ServiceB" to 250,
        "ServiceC" to 180
    )
    val threshold = 200
    val slowServices = serviceResponseTimes.filter { it.value > threshold }
    println("Сервисы с временем ответа выше $threshold: $slowServices")

    // Задача 8: Статус API по endpoint
    val apiResults = mapOf(
        "/api/login" to "200 OK",
        "/api/register" to "500 Internal Server Error"
    )
    val endpoint = "/api/login"
    val apiStatus = apiResults[endpoint] ?: "Not Tested"
    println("Статус API для $endpoint: $apiStatus")

    // Задача 9: Значение для "browserType" из конфигураций
    val environmentConfig = mapOf(
        "browserType" to "Chrome",
        "os" to "Windows 10"
    )
    val browserType = environmentConfig["browserType"]!!
    println("Тип браузера: $browserType")

    // Задача 10: Создать копию версии ПО с добавленной новой версией
    val versionMap = mapOf(
        "1.0" to "Initial release",
        "1.1" to "Bug fixes"
    )
    val newVersionMap = versionMap.toMutableMap()
    newVersionMap["1.2"] = "New features"
    println("Обновленная карта версий: $newVersionMap")

    // Задача 11: Получить настройки для конкретной модели
    val deviceConfigs = mapOf(
        "iPhone12" to "iOS, 6GB RAM",
        "SamsungS21" to "Android, 8GB RAM"
    )
    val deviceModel = "iPhone12"
    val deviceSettings = deviceConfigs[deviceModel] ?: "Default Settings"
    println("Настройки для $deviceModel: $deviceSettings")

    // Задача 12: Проверка наличия ошибки по коду
    val errorCodes = mapOf(
        404 to "Not Found",
        500 to "Server Error"
    )
    val errorCodeToCheck = 404
    val hasError = errorCodes.containsKey(errorCodeToCheck)
    println("Есть ли ошибка с кодом $errorCodeToCheck? $hasError")

    // Задача 13: Фильтровать сценарии по версии
    val testScenarios = mapOf(
        "TS1_v1" to "Passed",
        "TS2_v2" to "Failed",
        "TS3_v1" to "Skipped"
    )
    val requiredVersion = "v1"
    val filteredScenarios = testScenarios.filter { it.key.contains(requiredVersion) }
    println("Сценарии с версией $requiredVersion: $filteredScenarios")

    // Задача 14: Проверка наличия модулей с неудачным тестом
    val moduleTests = mapOf(
        "AuthModule" to "Passed",
        "PaymentModule" to "Failed",
        "UIModule" to "Passed"
    )
    val modulesWithFailures = moduleTests.filter { it.value != "Passed" }
    println("Модули с неудачным тестированием: $modulesWithFailures")

    // Задача 15: Добавить настройки из другого словаря
    val envSettings = mutableMapOf(
        "timeout" to "30s"
    )
    val newSettings = mapOf(
        "retryCount" to "3",
        "verboseLogging" to "true"
    )
    envSettings.putAll(newSettings)
    println("Обновленные настройки: $envSettings")

    // Задача 16: Объединение двух словарей багов
    val bugs1 = mapOf(
        "BUG-101" to "Open",
        "BUG-102" to "Fixed"
    )
    val bugs2 = mapOf(
        "BUG-103" to "Open",
        "BUG-104" to "Fixed"
    )
    val combinedBugs = bugs1 + bugs2
    println("Объединённый список багов: $combinedBugs")

    // Задача 17: Очистка временных данных
    val tempTestData = mutableMapOf(
        "test1" to "ok",
        "test2" to "fail"
    )
    tempTestData.clear()
    println("Временные данные после очистки: $tempTestData")

    // Задача 18: Исключить пропущенные тесты
    val testStatuses = mapOf(
        "TestA" to "Passed",
        "TestB" to "Skipped",
        "TestC" to "Failed"
    )
    val filteredTestStatuses = testStatuses.filter { it.value != "Skipped" }
    println("Тесты без пропущенных: $filteredTestStatuses")

    // Задача 19: Копия конфигураций с удалёнными элементами
    val configs = mutableMapOf(
        "param1" to "value1",
        "param2" to "value2",
        "param3" to "value3"
    )
    val configsCopy = configs.toMap().toMutableMap()
    configsCopy.remove("param2")
    configsCopy.remove("param3")
    println("Копия конфигураций после удаления: $configsCopy")

    // Задача 20: Отчет о тестировании в список строк
    val testResults = mapOf(
        "testLogin" to "Passed",
        "testLogout" to "Failed"
    )
    val report = testResults.map { (test, result) -> "Test $test: $result" }
    println("Отчет о тестировании:\n$report")

    // Задача 21: Преобразование результата тестирования в список
    val lastTestResultsMutable = mutableMapOf(
        "testLogin" to "Passed",
        "testLogout" to "Failed"
    )
    val lastTestResultsImmutable = lastTestResultsMutable.toMap()
    println("Архивированный результат: $lastTestResultsImmutable")

    // Задача 22: ID тестов с числовым в строку
    val testIdTimeMap = mapOf(
        101 to 2.5,
        102 to 3.0
    )
    val stringIdMap = testIdTimeMap.mapKeys { it.key.toString() }
    println("ID тестов как строки: $stringIdMap")

    // Задача 23: Увеличение времени ответа на 10%
    val versionResponseTimes = mutableMapOf(
        "1.0" to 100.0,
        "1.1" to 150.0
    )
    for ((version, time) in versionResponseTimes) {
        versionResponseTimes[version] = time * 1.10
    }
    println("Обновлённые оценки: $versionResponseTimes")

    // Задача 24: Проверка, пуст ли словарь ошибок компиляции
    val compileErrors = mapOf<String, String>() // пустой
    println("Ошибки компиляции пусты? ${compileErrors.isEmpty()}")

    // Задача 25: Проверка, не пуст ли результат нагрузочного теста
    val loadTestResults = mapOf(
        "Test1" to "Passed"
    )
    println("Результаты нагрузочного теста есть? ${loadTestResults.isNotEmpty()}")

    // Задача 26: Прошли ли все тесты
    val allPassed = testResults.values.all { it == "Passed" }
    println("Все тесты прошли успешно? $allPassed")

    // Задача 27: Есть ли хоть один тест с ошибкой
    val hasFailures = testResults.values.any { it != "Passed" }
    println("Есть ли тест с ошибкой? $hasFailures")

    // Задача 28: Фильтрация сервисных тестов по failed и 'optional' в названии
    val serviceTestResults = mapOf(
        "service1_optional" to "Failed",
        "service2" to "Passed",
        "service3_optional" to "Failed",
        "service4" to "Passed"
    )
    val filteredFailedOptional = serviceTestResults.filter { (name, result) ->
        result != "Passed" && "optional" in name
    }
    println("Тесты, не прошедшие и содержащие 'optional': $filteredFailedOptional")
}


