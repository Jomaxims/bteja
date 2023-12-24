package cz.upce.bteja

class IllegalTypeException(message: String? = null) : Exception(message)
class NonExistentVariableException(message: String? = null) : Exception(message)
class VariableNotInitializedException(message: String? = null) : Exception(message)
class AssignmentToConstantException(message: String? = null) : Exception(message)
class InvalidDimensionsException(message: String? = null) : Exception(message)
class IllegalRelationException(message: String? = null) : Exception(message)
class NonExistentProcedureException(message: String? = null) : Exception(message)
class WrongNumberOfParametersException(message: String? = null) : Exception(message)
class ProcedureReturnedException(val value: Value? = null, message: String? = null) : Exception(message)