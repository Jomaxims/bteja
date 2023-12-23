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
MODULE Basic;

CONST
    pepa = 10;

VAR
a, b : REAL;
c : STRING;
d: ARRAY 5 OF INTEGER;
e: MATRIX 2,6 OF INTEGER;

BEGIN

a := 1+((4+7)*1+3)*2;
b := 3;
c := "aksjd okashzd xlcvkhj";
d[0] := 5;
e[0,2] := d[0];

END Basic.
""".trimIndent()