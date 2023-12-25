package cz.upce.bteja

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

fun main(args: Array<String>) {
    val text = File("./program.txt").readText()

    val semanticAnalyzer = SemanticVisitor()
    semanticAnalyzer.visit(getParser(text).module())
    semanticAnalyzer.errors.forEach(::println)

    if (!semanticAnalyzer.isValid)
        return

    try {
        InterpretVisitor().visit(getParser(text).module())
    } catch (e: OberonException) {
        println("Chyba na řádku ${e.context?.start?.line}: ${e.message}")
    }
}

fun getParser(text: String) = OberonParser(CommonTokenStream(OberonLexer(CharStreams.fromString(text))).apply { fill() })