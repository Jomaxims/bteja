package cz.upce.bteja

import kotlin.reflect.full.memberProperties
import kotlin.reflect.typeOf

class LibraryProcedure(
    val name: String,
    val parameters: Array<Value>?,
    val returnValue: Value?,
    val body: LibraryProcedure.(Array<out Value>) -> Value?
) {
    fun run(vararg parameters: Value) = body(this, parameters)
}

object LibraryProcedures {
    val procedures
        get() =
            LibraryProcedures::class.memberProperties
                .filter { it.returnType == typeOf<LibraryProcedure>() }
                .associate { it.name to it.get(this) as LibraryProcedure }

    val EXIT = LibraryProcedure(
        "EXIT",
        null,
        null
    ) {
        throw ProgramExitException()
    }

    val PRINT = LibraryProcedure(
        "PRINT",
        null,
        null
    ) {
        print(it.joinToString("") { it.valueToString() })

        return@LibraryProcedure null
    }

    val PRINTLN = LibraryProcedure(
        "PRINTLN",
        null,
        null
    ) {
        println(it.joinToString("") { it.valueToString() })

        return@LibraryProcedure null
    }

    val READ_STR = LibraryProcedure(
        "READ_STR",
        null,
        PrimitiveValue.getTypedEmpty(DataType.STRING)
    ) {
        val value = readln()

        return@LibraryProcedure PrimitiveValue(value, DataType.STRING)
    }

    val READ_INT = LibraryProcedure(
        "READ_INT",
        null,
        PrimitiveValue.getTypedEmpty(DataType.INTEGER)
    ) {
        val value = readln().toIntOrNull() ?: throw IllegalTypeException("Očekáván typ INTEGER")

        return@LibraryProcedure PrimitiveValue(value, DataType.INTEGER)
    }

    val READ_REAL = LibraryProcedure(
        "READ_REAL",
        null,
        PrimitiveValue.getTypedEmpty(DataType.REAL)
    ) {
        val value = readln().toDoubleOrNull() ?: throw IllegalTypeException("Očekáván typ REAL")

        return@LibraryProcedure PrimitiveValue(value, DataType.REAL)
    }

    val LEN = LibraryProcedure(
        "LEN",
        arrayOf(ArrayValue.getTypedEmpty(0, DataType.ANY)),
        PrimitiveValue.getTypedEmpty(DataType.INTEGER)
    ) {
        return@LibraryProcedure PrimitiveValue(it.first().asArray<Any>().value.size, DataType.INTEGER)
    }

    val LEN_X = LibraryProcedure(
        "LEN_X",
        arrayOf(MatrixValue.getTypedEmpty(0, 0, DataType.ANY)),
        PrimitiveValue.getTypedEmpty(DataType.INTEGER)
    ) {
        return@LibraryProcedure PrimitiveValue(it.first().asMatrix<Any>().value.size, DataType.INTEGER)
    }

    val LEN_Y = LibraryProcedure(
        "LEN_Y",
        arrayOf(MatrixValue.getTypedEmpty(0, 0, DataType.ANY)),
        PrimitiveValue.getTypedEmpty(DataType.INTEGER)
    ) {
        return@LibraryProcedure PrimitiveValue(it.first().asMatrix<Any>().value.first().size, DataType.INTEGER)
    }

    val INT_TO_REAL = LibraryProcedure(
        "INT_TO_REAL",
        arrayOf(PrimitiveValue.getTypedEmpty(DataType.INTEGER)),
        PrimitiveValue.getTypedEmpty(DataType.REAL)
    ) {
        return@LibraryProcedure PrimitiveValue(it.first().asPrimitive<Int>().value.toDouble(), DataType.REAL)
    }
}