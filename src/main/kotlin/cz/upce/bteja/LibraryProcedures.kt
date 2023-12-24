package cz.upce.bteja

import kotlin.reflect.full.memberProperties
import kotlin.reflect.typeOf

object LibraryProcedures {
    val procedures get(): Map<String, LibraryProcedure> =
        LibraryProcedures::class.memberProperties
            .filter { it.returnType == typeOf<LibraryProcedure>() }
            .associate { it.name to it.get(this) as LibraryProcedure }

    val PRINT = LibraryProcedure {
        print(it.joinToString("") { it.valueToString() })

        return@LibraryProcedure null
    }

    val PRINTLN = LibraryProcedure {
        println(it.joinToString("") { it.valueToString() })

        return@LibraryProcedure null
    }

    val LEN = LibraryProcedure {
        if (it.first().type != DataType.ARRAY)
            throw IllegalTypeException()

        return@LibraryProcedure PrimitiveValue(it.first().asArray<Any>().value.size, DataType.INTEGER)
    }

    val LEN_X = LibraryProcedure {
        if (it.first().type != DataType.MATRIX)
            throw IllegalTypeException()

        return@LibraryProcedure PrimitiveValue(it.first().asMatrix<Any>().value.size, DataType.INTEGER)
    }

    val LEN_Y = LibraryProcedure {
        if (it.first().type != DataType.MATRIX)
            throw IllegalTypeException()

        return@LibraryProcedure PrimitiveValue(it.first().asMatrix<Any>().value.first().size, DataType.INTEGER)
    }
}