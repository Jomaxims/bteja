package cz.upce.bteja

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import java.io.File

fun main(args: Array<String>) {
//    val text = File("./example.txt").readText()
    val text = prog
    val lexer = OberonLexer(CharStreams.fromString(text))
    val tokenStream = CommonTokenStream(lexer).apply { fill() }
    val parser = OberonParser(tokenStream)
//    ParseTreeWalker.DEFAULT.walk(TreeListener(parser), parser.module())
    val visitor = TreeVisitor()
    val result = visitor.visit(parser.module())

//    tokenStream.tokens.forEach { println("${lexer.vocabulary.getDisplayName(it.type)}: ${it.text}") }
}

val prog = """
MODULE e2;

CONST
    a = 10;

VAR
    b: INTEGER;
    res: STRING;

BEGIN
    b := 10;

    IF a > b THEN
        res := "a > b";
    ELSIF a < b THEN
        res := "a < b";
    ELSE
        res := "a = b";
    END;
END e2.

""".trimIndent()