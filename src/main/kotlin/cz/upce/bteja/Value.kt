package cz.upce.bteja

import org.antlr.v4.runtime.tree.TerminalNode

enum class DataType {
    INTEGER,
    REAL,
    STRING,
    ARRAY,
    MATRIX,
    ANY;

    companion object {
        fun parse(type: String): DataType {
            entries.forEach {
                if (it.name.lowercase() == type.lowercase())
                    return it
            }

            return ANY
        }

        val primitiveTypes = listOf(INTEGER, REAL, STRING)
    }
}

fun Array<Value>.areOfSameTypes(other: Array<Value?>): Boolean {
    if (this.size != other.size)
        return false

    this.forEachIndexed { i, value ->
        if (!value.areOfSameType(other[i]))
            return false
    }

    return true
}

@JvmName("areOfSameTypesNullable")
fun Array<Value?>.areOfSameTypes(other: Array<Value?>): Boolean {
    if (this.size != other.size)
        return false

    this.forEachIndexed { i, value ->
        if (value == null || !value.areOfSameType(other[i]))
            return false
    }

    return true
}

sealed class Value(val type: DataType) {
    fun <T : Any> asPrimitive() = this as PrimitiveValue<T>
    fun <T : Any> asArray() = this as ArrayValue<T>
    fun <T : Any> asMatrix() = this as MatrixValue<T>

    abstract fun valueToString(): String

    fun areOfSameType(other: Value?): Boolean {
        if (other == null)
            return false
        if (this.type != other.type)
            return false

        return when(this.type) {
            DataType.ARRAY -> this.asArray<Any>().ofType == other.asArray<Any>().ofType || this.asArray<Any>().ofType == DataType.ANY
            DataType.MATRIX -> this.asMatrix<Any>().ofType == other.asMatrix<Any>().ofType || this.asMatrix<Any>().ofType == DataType.ANY
            else -> true
        }
    }
}

class PrimitiveValue<T : Any>(val value: T, type: DataType) : Value(type) {
    companion object {
        val Empty = PrimitiveValue(Any(), DataType.ANY)

        fun getTypedEmpty(type: DataType) = PrimitiveValue(Any(), type)
    }

    override fun valueToString() = value.toString()

    override fun toString(): String {
        return "PrimitiveValue(value=$value, type=$type)"
    }
}

class ArrayValue<T : Any>(val value: Array<PrimitiveValue<T>>, val ofType: DataType) : Value(DataType.ARRAY) {
    companion object {
        val Empty = ArrayValue<Any>(arrayOf(), DataType.ANY)

        fun getTypedEmpty(size: Int, ofType: DataType): ArrayValue<Any> {
            val array: Array<PrimitiveValue<Any>> = when (ofType) {
                DataType.STRING -> Array(size) { PrimitiveValue("", ofType) }
                DataType.INTEGER -> Array(size) { PrimitiveValue(0, ofType) }
                DataType.REAL -> Array(size) { PrimitiveValue(0.0, ofType) }
                else -> Array(size) { PrimitiveValue(Any(), ofType) }
            }

            return ArrayValue(array, ofType)
        }
    }

    override fun valueToString() = value.joinToString { it.valueToString() }

    override fun toString(): String {
        return "ArrayValue(value=${value.contentToString()}, ofType=$ofType)"
    }
}

class MatrixValue<T : Any>(val value: Array<Array<PrimitiveValue<T>>>, val ofType: DataType) : Value(DataType.MATRIX) {
    companion object {
        val Empty = MatrixValue<Any>(arrayOf(arrayOf()), DataType.ANY)

        fun getTypedEmpty(sizeX: Int, sizeY: Int, ofType: DataType): MatrixValue<Any> {
            val array: Array<Array<PrimitiveValue<Any>>> = when (ofType) {
                DataType.STRING -> Array(sizeX) { Array(sizeY) { PrimitiveValue("", ofType) } }
                DataType.INTEGER -> Array(sizeX) { Array(sizeY) { PrimitiveValue(0, ofType) } }
                DataType.REAL -> Array(sizeX) { Array(sizeY) { PrimitiveValue(0.0, ofType) } }
                else -> Array(sizeX) { Array(sizeY) {PrimitiveValue(Any(), ofType) } }
            }

            return MatrixValue(array, ofType)
        }
    }

    override fun valueToString() = buildString {
        value.forEach {
            appendLine(it.joinToString { it.valueToString() })
        }
    }

    override fun toString(): String {
        return "MatrixValue(value=${value.contentToString()}, ofType=$ofType)"
    }
}

fun TerminalNode.toIntValue() = PrimitiveValue(this.text.toInt(), DataType.INTEGER)
fun TerminalNode.toRealValue() = PrimitiveValue(this.text.toDouble(), DataType.REAL)
fun TerminalNode.toStringValue() = PrimitiveValue(this.text.removeSuffix("\"").removePrefix("\""), DataType.STRING)

data class Variable(var value: Value, val isConstant: Boolean = false) {
    var isInitialized = isConstant

    companion object {
        val Empty = Variable(PrimitiveValue.Empty)
    }

    fun setNewValue(value: Value) {
        this.value = value
        isInitialized = true
    }
}
