package cz.upce.bteja

class IllegalTypeException(message: String? = null) : Exception(message)
class NonExistentVariableException(message: String? = null) : Exception(message)
class VariableNotInitializedException(message: String? = null) : Exception(message)
class AssignmentToConstantException(message: String? = null) : Exception(message)
class InvalidDimensionsException(message: String? = null) : Exception(message)
class IllegalRelationException(message: String? = null) : Exception(message)