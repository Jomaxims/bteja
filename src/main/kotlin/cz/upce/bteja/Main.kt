package cz.upce.bteja

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun main(args: Array<String>) {
//    val text = File("./example.txt").readText()
    val text = prog
    val lexer = OberonLexer(CharStreams.fromString(text))
    val tokenStream = CommonTokenStream(lexer).apply { fill() }
    val parser = OberonParser(tokenStream)
//    ParseTreeWalker.DEFAULT.walk(TreeListener(parser), parser.module())
    val visitor = InterpretVisitor()
    val result = visitor.visit(parser.module())

//    tokenStream.tokens.forEach { println("${lexer.vocabulary.getDisplayName(it.type)}: ${it.text}") }
}

val prog = """
MODULE e1;

CONST
    matrixSize = 4;

VAR
    res: INTEGER;

BEGIN
    res := 0;
    FOR j := 0 TO matrixSize BY 2 DO
        res := res + j;
    END;
END e1.
""".trimIndent()