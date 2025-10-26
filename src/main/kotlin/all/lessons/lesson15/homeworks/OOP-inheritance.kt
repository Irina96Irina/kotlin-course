package org.example.all.lessons.lesson15.homeworks

//1. Геометрические фигуры
open class GeometricFigure {
    val name: String = "Фигура"

    open fun area(): Double {
        return 0.0
    }
}

// Многоугольник
open class Polygon : GeometricFigure() {
    val sides: Int = 0
}

// Треугольник
class Triangle(val side1: Double, val side2: Double, val side3: Double) : Polygon() {
    override fun area(): Double {
        val s = (side1 + side2 + side3) / 2
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3))
    }
}

// Четырехугольник
class Quadrilateral(val sideA: Double, val sideB: Double, val sideC: Double, val sideD: Double) : Polygon() {
    override fun area(): Double {
        return sideA * sideB
    }
}

// Круг
class Circle(val radius: Double) : GeometricFigure() {
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}


//2. Учебные заведения
open class EducationalInstitution(val name: String)

class School(name: String, val gradeLevels: List<Int>) : EducationalInstitution(name)


//3. Иерархия мебели
open class Furniture(val material: String)
class Chair(material: String, val numLegs: Int) : Furniture(material)

//4. Контейнеры и расширения для добавления материалов
abstract class Container {
    protected val items = mutableListOf<String>()

    override fun toString(): String {
        return items.toString()
    }

    abstract fun addMaterial(material: String)
}

//5. Вставка на дно (под индексом 0)

class BottomInsertContainer : Container() {
    override fun addMaterial(material: String) {
        items.add(0, material) // вставка в начало (под индексом 0)
    }
}

//6. Вставка списка материалов поочерёдно с существующими — в начало, по индексам 0, 2, 4...

class AlternatingInsertContainer : Container() {
    fun addMaterials(materials: List<String>) {
        for ((index, material) in materials.withIndex()) {
            val insertIndex = index * 2 // 0, 2, 4,...
            if (insertIndex > items.size) {
                items.add(material)
            } else {
                items.add(insertIndex, material)
            }
        }
    }
}

//7. Вставка с сортировкой по алфавиту

class SortedInsertContainer : Container() {
    override fun addMaterial(material: String) {
        items.add(material)
        items.sort()
    }
}

//Вставка словаря: ключи в обратном порядке в начало, потом существующие элементы, потом все значения


class DictInsertContainer : Container() {
    fun addDict(dict: Map<String, String>) {
        // добавление ключей в обратном порядке в начало
        val reversedKeys = dict.keys.reversed()
        for (key in reversedKeys) {
            items.add(0, key)
        }
        // добавляем существующие материалы (если есть, уже есть)
        // далее добавляем все значения в конец
        for (value in dict.values) {
            items.add(value)
        }
    }
}
