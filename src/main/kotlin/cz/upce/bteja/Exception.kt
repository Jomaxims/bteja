package cz.upce.bteja

import org.antlr.v4.runtime.ParserRuleContext

sealed class OberonException(message: String? = null, var context: ParserRuleContext? = null) : Exception(message)

class IllegalTypeException(message: String? = null, context: ParserRuleContext? = null) :
    OberonException(message, context)

class IllegalRelationException(message: String? = null, context: ParserRuleContext? = null) :
    OberonException(message, context)

class ProcedureReturnedException(val value: Value? = null, message: String? = null) : Exception(message)
class ProgramExitException(message: String? = null) : OberonException(message)