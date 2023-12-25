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

    val PRINT = LibraryProcedure(
        "PRINT",
        null,
        null
    ) {
        println(it.joinToString("") { it.valueToString() })

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

    val LEN = LibraryProcedure(
        "LEN",
        arrayOf(ArrayValue.getTypedEmpty(0, DataType.ANY)),
        PrimitiveValue.getTypedEmpty(DataType.INTEGER)
    ) {
        if (it.size != parameters!!.size)
            throw WrongNumberOfParametersException("Neplatný počet parametrů")
        if (it.first().type != parameters.first().type)
            throw IllegalTypeException("Neplatný typ ${it.first().type}")

        return@LibraryProcedure PrimitiveValue(it.first().asArray<Any>().value.size, DataType.INTEGER)
    }

    val LEN_X = LibraryProcedure(
        "LEN_X",
        arrayOf(MatrixValue.getTypedEmpty(0, 0, DataType.ANY)),
        PrimitiveValue.getTypedEmpty(DataType.INTEGER)
    ) {
        if (it.size != parameters!!.size)
            throw WrongNumberOfParametersException("Neplatný počet parametrů")

        if (it.first().type != parameters.first().type)
            throw IllegalTypeException("Neplatný typ ${it.first().type}")

        return@LibraryProcedure PrimitiveValue(it.first().asMatrix<Any>().value.size, DataType.INTEGER)
    }

    val LEN_Y = LibraryProcedure(
        "LEN_Y",
        arrayOf(MatrixValue.getTypedEmpty(0, 0, DataType.ANY)),
        PrimitiveValue.getTypedEmpty(DataType.INTEGER)
    ) {
        if (it.size != parameters!!.size)
            throw WrongNumberOfParametersException("Neplatný počet parametrů")

        if (it.first().type != parameters.first().type)
            throw IllegalTypeException("Neplatný typ ${it.first().type}")

        return@LibraryProcedure PrimitiveValue(it.first().asMatrix<Any>().value.first().size, DataType.INTEGER)
    }
}