package cz.upce.bteja

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun main(args: Array<String>) {
//    val text = File("./example.txt").readText()
    val text = prog
    val lexer = OberonLexer(CharStreams.fromString(text))
    val tokenStream = CommonTokenStream(lexer).apply { fill() }
    val parser = OberonParser(tokenStream)
    InterpretVisitor().visit(parser.module())
}

val prog = """
MODULE e3;

CONST
    factorial = 3;

PROCEDURE recFact(f: INTEGER): INTEGER;
BEGIN
    IF f <= 1 THEN
        RETURN 1;
    ELSE
        RETURN f * recFact(f - 1);
    END;
END recFact;

BEGIN
    PRINTLN("Factorial: ", recFact(factorial));
END e3.
""".trimIndent()