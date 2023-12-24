/*
BSD License

Copyright (c) 2020, Tom Everett
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. Neither the name of Tom Everett nor the names of its contributors
   may be used to endorse or promote products derived from this software
   without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/*
* https://people.inf.ethz.ch/wirth/Oberon/Oberon07.Report.pdf
*/
grammar Oberon;

module
   : MODULE ident ';' declarationSequence (BEGIN statementSequence)? END ident '.' EOF?
   ;

ident
   : IDENT
   ;

//integer
//   : INTEGER
//   ;
//
//real
//   : REAL
//   ;
//
//number
//   : integer
//   | real
//   ;

constDeclaration
   : ident '=' simpleExpression
   ;

//typeDeclaration
//   : ident '=' type
//   ;

type
   : ident
   | arrayType
   | matrixType
   ;

arrayType
   : ARRAY (length)? OF ident
   ;

matrixType
   : MATRIX (length ',' length)? OF ident
   ;

length
   : expression
   ;

identList
   : ident (',' ident)*
   ;

variableDeclaration
   : identList ':' type
   ;

expression
   : (simpleExpression (relation simpleExpression)?)
   | STRING
   ;

boolExpression
   : left=simpleExpression relation right=simpleExpression
   ;

relation
   : EQUALS
   | LESS_THAN
   | LESS_THAN_EQUALS
   | MORE_THAN
   | MORE_THAN
   ;

simpleExpression
   : (PLUS | MINUS)? term (addOperator term)*
   ;

addOperator
   : PLUS
   | MINUS
   ;

term
   : factor (mulOperator factor)*
   ;

mulOperator
   : MULT
   | DIV
   | MOD
   ;

factor
   : INTEGER
   | REAL
   | designator
   | '(' expression ')'
   | procedureCall
   ;

designator
   : ident ('[' expression (',' expression)? ']')*
   ;

expList
   : expression (',' expression)*
   ;

actualParameters
   : '(' expList? ')'
   ;

statement
   : (assignment | procedureCall | ifStatement | forStatement | exitStatement | returnStatement)?
   ;

assignment
   : designator ':=' expression
   ;

procedureCall
   : ident actualParameters?
   ;

statementSequence
   : statement (';' statement)*
   ;

ifStatement
   : IF ifExpression=boolExpression THEN ifStatementSequence=statementSequence (ELSIF elseIfExpression=boolExpression THEN elseIfStatementSequence=statementSequence)* (ELSE elseStatementSequence=statementSequence)? END
   ;

forStatement
   : FOR ident ':=' counterExpression=simpleExpression TO toExpression=simpleExpression (BY byExpression=simpleExpression)? DO statementSequence END
   ;

exitStatement
   : EXIT
   ;

returnStatement
   : RETURN expression
   ;

procedureDeclaration
   : procedureHeading ';' procedureBody ident
   ;

procedureHeading
   : PROCEDURE ident procedureParameters?
   ;

procedureBody
   : declarationSequence (BEGIN statementSequence)? (returnStatement)? END
   ;

declarationSequence
   : (CONST (constDeclaration ';')*)? (VAR (variableDeclaration ';')*)? (procedureDeclaration ';')*
   ;

procedureParameters
   : '(' (fPSection (';' fPSection)*)? ')' (':' ident)?
   ;

fPSection
   : VAR? ident ':' type
   ;

ARRAY
   : 'ARRAY'
   ;

MATRIX
   : 'MATRIX'
   ;

OF
   : 'OF'
   ;

END
   : 'END'
   ;

TO
   : 'TO'
   ;

PROCEDURE
   : 'PROCEDURE'
   ;

DIV
   : '/'
   ;

MULT
   : '*'
   ;

MOD
   : 'MOD'
   ;

PLUS
   : '+'
   ;

MINUS
   : '-'
   ;

EQUALS
   : '='
   ;

LESS_THAN
   : '<'
   ;

MORE_THAN
   : '>'
   ;

LESS_THAN_EQUALS
   : '<='
   ;

MORE_THAN_EQUALS
   : '>='
   ;

IF
   : 'IF'
   ;

THEN
   : 'THEN'
   ;

ELSIF
   : 'ELSIF'
   ;

ELSE
   : 'ELSE'
   ;

FOR
   : 'FOR'
   ;

DO
   : 'DO'
   ;

BY
   : 'BY'
   ;

BEGIN
   : 'BEGIN'
   ;

RETURN
   : 'RETURN'
   ;

CONST
   : 'CONST'
   ;

VAR
   : 'VAR'
   ;

MODULE
   : 'MODULE'
   ;

EXIT
   : 'EXIT'
   ;

STRING
   : ('"' .*? '"')
   ;

IDENT
   : LETTER (LETTER | INTEGER | '_')*
   ;

LETTER
   : [a-zA-Z]
   ;

//DIGIT
//   : [0-9]
//   ;

INTEGER
   : [0-9]+
   ;

REAL
   : INTEGER '.' INTEGER
   ;

WS
   : [ \t\r\n] -> skip
   ;