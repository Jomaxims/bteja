// Generated from D:/UPCE/5S/BTEJA/sem/interpreter/Oberon.g4 by ANTLR 4.13.1
package cz.upce.bteja;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class OberonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		ARRAY=10, MATRIX=11, OF=12, END=13, TO=14, PROCEDURE=15, DIV=16, MULT=17, 
		MOD=18, PLUS=19, MINUS=20, EQUALS=21, LESS_THAN=22, MORE_THAN=23, LESS_THAN_EQUALS=24, 
		MORE_THAN_EQUALS=25, IF=26, THEN=27, ELSIF=28, ELSE=29, FOR=30, DO=31, 
		BY=32, BEGIN=33, RETURN=34, CONST=35, VAR=36, MODULE=37, STRING=38, IDENT=39, 
		LETTER=40, INTEGER=41, REAL=42, WS=43;
	public static final int
		RULE_module = 0, RULE_ident = 1, RULE_constDeclaration = 2, RULE_type = 3, 
		RULE_arrayType = 4, RULE_matrixType = 5, RULE_length = 6, RULE_identList = 7, 
		RULE_variableDeclaration = 8, RULE_expression = 9, RULE_boolExpression = 10, 
		RULE_relation = 11, RULE_simpleExpression = 12, RULE_addOperator = 13, 
		RULE_term = 14, RULE_mulOperator = 15, RULE_factor = 16, RULE_designator = 17, 
		RULE_expList = 18, RULE_actualParameters = 19, RULE_statement = 20, RULE_assignment = 21, 
		RULE_procedureCall = 22, RULE_statementSequence = 23, RULE_ifStatement = 24, 
		RULE_forStatement = 25, RULE_returnStatement = 26, RULE_procedureDeclaration = 27, 
		RULE_procedureHeading = 28, RULE_procedureBody = 29, RULE_declarationSequence = 30, 
		RULE_procedureParameters = 31, RULE_fPSection = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"module", "ident", "constDeclaration", "type", "arrayType", "matrixType", 
			"length", "identList", "variableDeclaration", "expression", "boolExpression", 
			"relation", "simpleExpression", "addOperator", "term", "mulOperator", 
			"factor", "designator", "expList", "actualParameters", "statement", "assignment", 
			"procedureCall", "statementSequence", "ifStatement", "forStatement", 
			"returnStatement", "procedureDeclaration", "procedureHeading", "procedureBody", 
			"declarationSequence", "procedureParameters", "fPSection"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "','", "':'", "'('", "')'", "'['", "']'", "':='", 
			"'ARRAY'", "'MATRIX'", "'OF'", "'END'", "'TO'", "'PROCEDURE'", "'/'", 
			"'*'", "'MOD'", "'+'", "'-'", "'='", "'<'", "'>'", "'<='", "'>='", "'IF'", 
			"'THEN'", "'ELSIF'", "'ELSE'", "'FOR'", "'DO'", "'BY'", "'BEGIN'", "'RETURN'", 
			"'CONST'", "'VAR'", "'MODULE'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "ARRAY", 
			"MATRIX", "OF", "END", "TO", "PROCEDURE", "DIV", "MULT", "MOD", "PLUS", 
			"MINUS", "EQUALS", "LESS_THAN", "MORE_THAN", "LESS_THAN_EQUALS", "MORE_THAN_EQUALS", 
			"IF", "THEN", "ELSIF", "ELSE", "FOR", "DO", "BY", "BEGIN", "RETURN", 
			"CONST", "VAR", "MODULE", "STRING", "IDENT", "LETTER", "INTEGER", "REAL", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Oberon.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OberonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(OberonParser.MODULE, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public DeclarationSequenceContext declarationSequence() {
			return getRuleContext(DeclarationSequenceContext.class,0);
		}
		public TerminalNode END() { return getToken(OberonParser.END, 0); }
		public TerminalNode BEGIN() { return getToken(OberonParser.BEGIN, 0); }
		public StatementSequenceContext statementSequence() {
			return getRuleContext(StatementSequenceContext.class,0);
		}
		public TerminalNode EOF() { return getToken(OberonParser.EOF, 0); }
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitModule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitModule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_module);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(MODULE);
			setState(67);
			ident();
			setState(68);
			match(T__0);
			setState(69);
			declarationSequence();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BEGIN) {
				{
				setState(70);
				match(BEGIN);
				setState(71);
				statementSequence();
				}
			}

			setState(74);
			match(END);
			setState(75);
			ident();
			setState(76);
			match(T__1);
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(77);
				match(EOF);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(OberonParser.IDENT, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstDeclarationContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(OberonParser.EQUALS, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public ConstDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterConstDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitConstDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitConstDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclarationContext constDeclaration() throws RecognitionException {
		ConstDeclarationContext _localctx = new ConstDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			ident();
			setState(83);
			match(EQUALS);
			setState(84);
			simpleExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public MatrixTypeContext matrixType() {
			return getRuleContext(MatrixTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				ident();
				}
				break;
			case ARRAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				arrayType();
				}
				break;
			case MATRIX:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				matrixType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(OberonParser.ARRAY, 0); }
		public TerminalNode OF() { return getToken(OberonParser.OF, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(ARRAY);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7146827153440L) != 0)) {
				{
				setState(92);
				length();
				}
			}

			setState(95);
			match(OF);
			setState(96);
			ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatrixTypeContext extends ParserRuleContext {
		public TerminalNode MATRIX() { return getToken(OberonParser.MATRIX, 0); }
		public TerminalNode OF() { return getToken(OberonParser.OF, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public List<LengthContext> length() {
			return getRuleContexts(LengthContext.class);
		}
		public LengthContext length(int i) {
			return getRuleContext(LengthContext.class,i);
		}
		public MatrixTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterMatrixType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitMatrixType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitMatrixType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrixTypeContext matrixType() throws RecognitionException {
		MatrixTypeContext _localctx = new MatrixTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_matrixType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(MATRIX);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7146827153440L) != 0)) {
				{
				setState(99);
				length();
				setState(100);
				match(T__2);
				setState(101);
				length();
				}
			}

			setState(105);
			match(OF);
			setState(106);
			ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LengthContext extends ParserRuleContext {
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public LengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_length; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitLength(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitLength(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LengthContext length() throws RecognitionException {
		LengthContext _localctx = new LengthContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			simpleExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentListContext extends ParserRuleContext {
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public IdentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterIdentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitIdentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitIdentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentListContext identList() throws RecognitionException {
		IdentListContext _localctx = new IdentListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_identList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			ident();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(111);
				match(T__2);
				setState(112);
				ident();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public IdentListContext identList() {
			return getRuleContext(IdentListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			identList();
			setState(119);
			match(T__3);
			setState(120);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public TerminalNode STRING() { return getToken(OberonParser.STRING, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case PLUS:
			case MINUS:
			case IDENT:
			case INTEGER:
			case REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				simpleExpression();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolExpressionContext extends ParserRuleContext {
		public SimpleExpressionContext left;
		public SimpleExpressionContext right;
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public BoolExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterBoolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitBoolExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitBoolExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExpressionContext boolExpression() throws RecognitionException {
		BoolExpressionContext _localctx = new BoolExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_boolExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			((BoolExpressionContext)_localctx).left = simpleExpression();
			setState(127);
			relation();
			setState(128);
			((BoolExpressionContext)_localctx).right = simpleExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(OberonParser.EQUALS, 0); }
		public TerminalNode LESS_THAN() { return getToken(OberonParser.LESS_THAN, 0); }
		public TerminalNode LESS_THAN_EQUALS() { return getToken(OberonParser.LESS_THAN_EQUALS, 0); }
		public TerminalNode MORE_THAN() { return getToken(OberonParser.MORE_THAN, 0); }
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_relation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<AddOperatorContext> addOperator() {
			return getRuleContexts(AddOperatorContext.class);
		}
		public AddOperatorContext addOperator(int i) {
			return getRuleContext(AddOperatorContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(OberonParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(OberonParser.MINUS, 0); }
		public SimpleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterSimpleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitSimpleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitSimpleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleExpressionContext simpleExpression() throws RecognitionException {
		SimpleExpressionContext _localctx = new SimpleExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_simpleExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLUS || _la==MINUS) {
				{
				setState(132);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(135);
			term();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(136);
				addOperator();
				setState(137);
				term();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddOperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(OberonParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(OberonParser.MINUS, 0); }
		public AddOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterAddOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitAddOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitAddOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOperatorContext addOperator() throws RecognitionException {
		AddOperatorContext _localctx = new AddOperatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_addOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<MulOperatorContext> mulOperator() {
			return getRuleContexts(MulOperatorContext.class);
		}
		public MulOperatorContext mulOperator(int i) {
			return getRuleContext(MulOperatorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			factor();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 458752L) != 0)) {
				{
				{
				setState(147);
				mulOperator();
				setState(148);
				factor();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulOperatorContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(OberonParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(OberonParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(OberonParser.MOD, 0); }
		public MulOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterMulOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitMulOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitMulOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulOperatorContext mulOperator() throws RecognitionException {
		MulOperatorContext _localctx = new MulOperatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_mulOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 458752L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(OberonParser.INTEGER, 0); }
		public TerminalNode REAL() { return getToken(OberonParser.REAL, 0); }
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ProcedureCallContext procedureCall() {
			return getRuleContext(ProcedureCallContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_factor);
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(INTEGER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(REAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				designator();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				match(T__4);
				setState(161);
				expression();
				setState(162);
				match(T__5);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(164);
				procedureCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DesignatorContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterDesignator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitDesignator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitDesignator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignatorContext designator() throws RecognitionException {
		DesignatorContext _localctx = new DesignatorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_designator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			ident();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(168);
				match(T__6);
				setState(169);
				expression();
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(170);
					match(T__2);
					setState(171);
					expression();
					}
				}

				setState(174);
				match(T__7);
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterExpList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitExpList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitExpList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpListContext expList() throws RecognitionException {
		ExpListContext _localctx = new ExpListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			expression();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(182);
				match(T__2);
				setState(183);
				expression();
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActualParametersContext extends ParserRuleContext {
		public ExpListContext expList() {
			return getRuleContext(ExpListContext.class,0);
		}
		public ActualParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterActualParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitActualParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitActualParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualParametersContext actualParameters() throws RecognitionException {
		ActualParametersContext _localctx = new ActualParametersContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_actualParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(T__4);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7421705060384L) != 0)) {
				{
				setState(190);
				expList();
				}
			}

			setState(193);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ProcedureCallContext procedureCall() {
			return getRuleContext(ProcedureCallContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(195);
				assignment();
				}
				break;
			case 2:
				{
				setState(196);
				procedureCall();
				}
				break;
			case 3:
				{
				setState(197);
				ifStatement();
				}
				break;
			case 4:
				{
				setState(198);
				forStatement();
				}
				break;
			case 5:
				{
				setState(199);
				returnStatement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			designator();
			setState(203);
			match(T__8);
			setState(204);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureCallContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ActualParametersContext actualParameters() {
			return getRuleContext(ActualParametersContext.class,0);
		}
		public ProcedureCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterProcedureCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitProcedureCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitProcedureCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureCallContext procedureCall() throws RecognitionException {
		ProcedureCallContext _localctx = new ProcedureCallContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_procedureCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			ident();
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(207);
				actualParameters();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementSequenceContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterStatementSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitStatementSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitStatementSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementSequenceContext statementSequence() throws RecognitionException {
		StatementSequenceContext _localctx = new StatementSequenceContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_statementSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			statement();
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(211);
				match(T__0);
				setState(212);
				statement();
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public BoolExpressionContext ifExpression;
		public StatementSequenceContext ifStatementSequence;
		public BoolExpressionContext elseIfExpression;
		public StatementSequenceContext elseIfStatementSequence;
		public StatementSequenceContext elseStatementSequence;
		public TerminalNode IF() { return getToken(OberonParser.IF, 0); }
		public List<TerminalNode> THEN() { return getTokens(OberonParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(OberonParser.THEN, i);
		}
		public TerminalNode END() { return getToken(OberonParser.END, 0); }
		public List<BoolExpressionContext> boolExpression() {
			return getRuleContexts(BoolExpressionContext.class);
		}
		public BoolExpressionContext boolExpression(int i) {
			return getRuleContext(BoolExpressionContext.class,i);
		}
		public List<StatementSequenceContext> statementSequence() {
			return getRuleContexts(StatementSequenceContext.class);
		}
		public StatementSequenceContext statementSequence(int i) {
			return getRuleContext(StatementSequenceContext.class,i);
		}
		public List<TerminalNode> ELSIF() { return getTokens(OberonParser.ELSIF); }
		public TerminalNode ELSIF(int i) {
			return getToken(OberonParser.ELSIF, i);
		}
		public TerminalNode ELSE() { return getToken(OberonParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(IF);
			setState(219);
			((IfStatementContext)_localctx).ifExpression = boolExpression();
			setState(220);
			match(THEN);
			setState(221);
			((IfStatementContext)_localctx).ifStatementSequence = statementSequence();
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSIF) {
				{
				{
				setState(222);
				match(ELSIF);
				setState(223);
				((IfStatementContext)_localctx).elseIfExpression = boolExpression();
				setState(224);
				match(THEN);
				setState(225);
				((IfStatementContext)_localctx).elseIfStatementSequence = statementSequence();
				}
				}
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(232);
				match(ELSE);
				setState(233);
				((IfStatementContext)_localctx).elseStatementSequence = statementSequence();
				}
			}

			setState(236);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public SimpleExpressionContext counterExpression;
		public SimpleExpressionContext toExpression;
		public SimpleExpressionContext byExpression;
		public TerminalNode FOR() { return getToken(OberonParser.FOR, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode TO() { return getToken(OberonParser.TO, 0); }
		public TerminalNode DO() { return getToken(OberonParser.DO, 0); }
		public StatementSequenceContext statementSequence() {
			return getRuleContext(StatementSequenceContext.class,0);
		}
		public TerminalNode END() { return getToken(OberonParser.END, 0); }
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public TerminalNode BY() { return getToken(OberonParser.BY, 0); }
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(FOR);
			setState(239);
			ident();
			setState(240);
			match(T__8);
			setState(241);
			((ForStatementContext)_localctx).counterExpression = simpleExpression();
			setState(242);
			match(TO);
			setState(243);
			((ForStatementContext)_localctx).toExpression = simpleExpression();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BY) {
				{
				setState(244);
				match(BY);
				setState(245);
				((ForStatementContext)_localctx).byExpression = simpleExpression();
				}
			}

			setState(248);
			match(DO);
			setState(249);
			statementSequence();
			setState(250);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(OberonParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(RETURN);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7421705060384L) != 0)) {
				{
				setState(253);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureDeclarationContext extends ParserRuleContext {
		public ProcedureHeadingContext procedureHeading() {
			return getRuleContext(ProcedureHeadingContext.class,0);
		}
		public ProcedureBodyContext procedureBody() {
			return getRuleContext(ProcedureBodyContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ProcedureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterProcedureDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitProcedureDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitProcedureDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureDeclarationContext procedureDeclaration() throws RecognitionException {
		ProcedureDeclarationContext _localctx = new ProcedureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_procedureDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			procedureHeading();
			setState(257);
			match(T__0);
			setState(258);
			procedureBody();
			setState(259);
			ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureHeadingContext extends ParserRuleContext {
		public TerminalNode PROCEDURE() { return getToken(OberonParser.PROCEDURE, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ProcedureParametersContext procedureParameters() {
			return getRuleContext(ProcedureParametersContext.class,0);
		}
		public ProcedureHeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureHeading; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterProcedureHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitProcedureHeading(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitProcedureHeading(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureHeadingContext procedureHeading() throws RecognitionException {
		ProcedureHeadingContext _localctx = new ProcedureHeadingContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_procedureHeading);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(PROCEDURE);
			setState(262);
			ident();
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(263);
				procedureParameters();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureBodyContext extends ParserRuleContext {
		public DeclarationSequenceContext declarationSequence() {
			return getRuleContext(DeclarationSequenceContext.class,0);
		}
		public TerminalNode END() { return getToken(OberonParser.END, 0); }
		public TerminalNode BEGIN() { return getToken(OberonParser.BEGIN, 0); }
		public StatementSequenceContext statementSequence() {
			return getRuleContext(StatementSequenceContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ProcedureBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterProcedureBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitProcedureBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitProcedureBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureBodyContext procedureBody() throws RecognitionException {
		ProcedureBodyContext _localctx = new ProcedureBodyContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_procedureBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			declarationSequence();
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BEGIN) {
				{
				setState(267);
				match(BEGIN);
				setState(268);
				statementSequence();
				}
			}

			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(271);
				returnStatement();
				}
			}

			setState(274);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationSequenceContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(OberonParser.CONST, 0); }
		public TerminalNode VAR() { return getToken(OberonParser.VAR, 0); }
		public List<ProcedureDeclarationContext> procedureDeclaration() {
			return getRuleContexts(ProcedureDeclarationContext.class);
		}
		public ProcedureDeclarationContext procedureDeclaration(int i) {
			return getRuleContext(ProcedureDeclarationContext.class,i);
		}
		public List<ConstDeclarationContext> constDeclaration() {
			return getRuleContexts(ConstDeclarationContext.class);
		}
		public ConstDeclarationContext constDeclaration(int i) {
			return getRuleContext(ConstDeclarationContext.class,i);
		}
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public DeclarationSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterDeclarationSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitDeclarationSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitDeclarationSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSequenceContext declarationSequence() throws RecognitionException {
		DeclarationSequenceContext _localctx = new DeclarationSequenceContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_declarationSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(276);
				match(CONST);
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENT) {
					{
					{
					setState(277);
					constDeclaration();
					setState(278);
					match(T__0);
					}
					}
					setState(284);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(287);
				match(VAR);
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==IDENT) {
					{
					{
					setState(288);
					variableDeclaration();
					setState(289);
					match(T__0);
					}
					}
					setState(295);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROCEDURE) {
				{
				{
				setState(298);
				procedureDeclaration();
				setState(299);
				match(T__0);
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureParametersContext extends ParserRuleContext {
		public List<FPSectionContext> fPSection() {
			return getRuleContexts(FPSectionContext.class);
		}
		public FPSectionContext fPSection(int i) {
			return getRuleContext(FPSectionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ProcedureParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterProcedureParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitProcedureParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitProcedureParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureParametersContext procedureParameters() throws RecognitionException {
		ProcedureParametersContext _localctx = new ProcedureParametersContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_procedureParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(T__4);
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(307);
				fPSection();
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(308);
					match(T__0);
					setState(309);
					fPSection();
					}
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(317);
			match(T__5);
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(318);
				match(T__3);
				setState(319);
				type();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FPSectionContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FPSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fPSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).enterFPSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OberonListener ) ((OberonListener)listener).exitFPSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OberonVisitor ) return ((OberonVisitor<? extends T>)visitor).visitFPSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FPSectionContext fPSection() throws RecognitionException {
		FPSectionContext _localctx = new FPSectionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_fPSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			ident();
			setState(323);
			match(T__3);
			setState(324);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001+\u0147\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000I\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000O\b\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003Z\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0003\u0004^\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005h\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007r\b\u0007\n\u0007\f\u0007u\t\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t}\b\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0003\f\u0086"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u008c\b\f\n\f\f\f\u008f\t"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u0097\b\u000e\n\u000e\f\u000e\u009a\t\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u00a6\b\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00ad\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u00b1\b\u0011\n\u0011\f\u0011\u00b4\t\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00b9\b\u0012\n\u0012\f\u0012"+
		"\u00bc\t\u0012\u0001\u0013\u0001\u0013\u0003\u0013\u00c0\b\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u00c9\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u00d1\b\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u00d6\b\u0017\n\u0017\f\u0017\u00d9\t\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u00e4\b\u0018\n\u0018"+
		"\f\u0018\u00e7\t\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u00eb\b\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u00f7\b\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u00ff\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0109\b\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u010e\b\u001d\u0001\u001d"+
		"\u0003\u001d\u0111\b\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0005\u001e\u0119\b\u001e\n\u001e\f\u001e\u011c"+
		"\t\u001e\u0003\u001e\u011e\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0005\u001e\u0124\b\u001e\n\u001e\f\u001e\u0127\t\u001e\u0003"+
		"\u001e\u0129\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u012e"+
		"\b\u001e\n\u001e\f\u001e\u0131\t\u001e\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0005\u001f\u0137\b\u001f\n\u001f\f\u001f\u013a\t\u001f\u0003"+
		"\u001f\u013c\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0141"+
		"\b\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0000\u0000!\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02468:<>@\u0000\u0003\u0001\u0000\u0015\u0018\u0001\u0000\u0013"+
		"\u0014\u0001\u0000\u0010\u0012\u014e\u0000B\u0001\u0000\u0000\u0000\u0002"+
		"P\u0001\u0000\u0000\u0000\u0004R\u0001\u0000\u0000\u0000\u0006Y\u0001"+
		"\u0000\u0000\u0000\b[\u0001\u0000\u0000\u0000\nb\u0001\u0000\u0000\u0000"+
		"\fl\u0001\u0000\u0000\u0000\u000en\u0001\u0000\u0000\u0000\u0010v\u0001"+
		"\u0000\u0000\u0000\u0012|\u0001\u0000\u0000\u0000\u0014~\u0001\u0000\u0000"+
		"\u0000\u0016\u0082\u0001\u0000\u0000\u0000\u0018\u0085\u0001\u0000\u0000"+
		"\u0000\u001a\u0090\u0001\u0000\u0000\u0000\u001c\u0092\u0001\u0000\u0000"+
		"\u0000\u001e\u009b\u0001\u0000\u0000\u0000 \u00a5\u0001\u0000\u0000\u0000"+
		"\"\u00a7\u0001\u0000\u0000\u0000$\u00b5\u0001\u0000\u0000\u0000&\u00bd"+
		"\u0001\u0000\u0000\u0000(\u00c8\u0001\u0000\u0000\u0000*\u00ca\u0001\u0000"+
		"\u0000\u0000,\u00ce\u0001\u0000\u0000\u0000.\u00d2\u0001\u0000\u0000\u0000"+
		"0\u00da\u0001\u0000\u0000\u00002\u00ee\u0001\u0000\u0000\u00004\u00fc"+
		"\u0001\u0000\u0000\u00006\u0100\u0001\u0000\u0000\u00008\u0105\u0001\u0000"+
		"\u0000\u0000:\u010a\u0001\u0000\u0000\u0000<\u011d\u0001\u0000\u0000\u0000"+
		">\u0132\u0001\u0000\u0000\u0000@\u0142\u0001\u0000\u0000\u0000BC\u0005"+
		"%\u0000\u0000CD\u0003\u0002\u0001\u0000DE\u0005\u0001\u0000\u0000EH\u0003"+
		"<\u001e\u0000FG\u0005!\u0000\u0000GI\u0003.\u0017\u0000HF\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0005"+
		"\r\u0000\u0000KL\u0003\u0002\u0001\u0000LN\u0005\u0002\u0000\u0000MO\u0005"+
		"\u0000\u0000\u0001NM\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000"+
		"O\u0001\u0001\u0000\u0000\u0000PQ\u0005\'\u0000\u0000Q\u0003\u0001\u0000"+
		"\u0000\u0000RS\u0003\u0002\u0001\u0000ST\u0005\u0015\u0000\u0000TU\u0003"+
		"\u0018\f\u0000U\u0005\u0001\u0000\u0000\u0000VZ\u0003\u0002\u0001\u0000"+
		"WZ\u0003\b\u0004\u0000XZ\u0003\n\u0005\u0000YV\u0001\u0000\u0000\u0000"+
		"YW\u0001\u0000\u0000\u0000YX\u0001\u0000\u0000\u0000Z\u0007\u0001\u0000"+
		"\u0000\u0000[]\u0005\n\u0000\u0000\\^\u0003\f\u0006\u0000]\\\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0005"+
		"\f\u0000\u0000`a\u0003\u0002\u0001\u0000a\t\u0001\u0000\u0000\u0000bg"+
		"\u0005\u000b\u0000\u0000cd\u0003\f\u0006\u0000de\u0005\u0003\u0000\u0000"+
		"ef\u0003\f\u0006\u0000fh\u0001\u0000\u0000\u0000gc\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0005\f\u0000\u0000"+
		"jk\u0003\u0002\u0001\u0000k\u000b\u0001\u0000\u0000\u0000lm\u0003\u0018"+
		"\f\u0000m\r\u0001\u0000\u0000\u0000ns\u0003\u0002\u0001\u0000op\u0005"+
		"\u0003\u0000\u0000pr\u0003\u0002\u0001\u0000qo\u0001\u0000\u0000\u0000"+
		"ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000t\u000f\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0003"+
		"\u000e\u0007\u0000wx\u0005\u0004\u0000\u0000xy\u0003\u0006\u0003\u0000"+
		"y\u0011\u0001\u0000\u0000\u0000z}\u0003\u0018\f\u0000{}\u0005&\u0000\u0000"+
		"|z\u0001\u0000\u0000\u0000|{\u0001\u0000\u0000\u0000}\u0013\u0001\u0000"+
		"\u0000\u0000~\u007f\u0003\u0018\f\u0000\u007f\u0080\u0003\u0016\u000b"+
		"\u0000\u0080\u0081\u0003\u0018\f\u0000\u0081\u0015\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0007\u0000\u0000\u0000\u0083\u0017\u0001\u0000\u0000\u0000"+
		"\u0084\u0086\u0007\u0001\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000"+
		"\u0087\u008d\u0003\u001c\u000e\u0000\u0088\u0089\u0003\u001a\r\u0000\u0089"+
		"\u008a\u0003\u001c\u000e\u0000\u008a\u008c\u0001\u0000\u0000\u0000\u008b"+
		"\u0088\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d"+
		"\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e"+
		"\u0019\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0007\u0001\u0000\u0000\u0091\u001b\u0001\u0000\u0000\u0000\u0092"+
		"\u0098\u0003 \u0010\u0000\u0093\u0094\u0003\u001e\u000f\u0000\u0094\u0095"+
		"\u0003 \u0010\u0000\u0095\u0097\u0001\u0000\u0000\u0000\u0096\u0093\u0001"+
		"\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001"+
		"\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u001d\u0001"+
		"\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009b\u009c\u0007"+
		"\u0002\u0000\u0000\u009c\u001f\u0001\u0000\u0000\u0000\u009d\u00a6\u0005"+
		")\u0000\u0000\u009e\u00a6\u0005*\u0000\u0000\u009f\u00a6\u0003\"\u0011"+
		"\u0000\u00a0\u00a1\u0005\u0005\u0000\u0000\u00a1\u00a2\u0003\u0012\t\u0000"+
		"\u00a2\u00a3\u0005\u0006\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a6\u0003,\u0016\u0000\u00a5\u009d\u0001\u0000\u0000\u0000\u00a5"+
		"\u009e\u0001\u0000\u0000\u0000\u00a5\u009f\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6"+
		"!\u0001\u0000\u0000\u0000\u00a7\u00b2\u0003\u0002\u0001\u0000\u00a8\u00a9"+
		"\u0005\u0007\u0000\u0000\u00a9\u00ac\u0003\u0012\t\u0000\u00aa\u00ab\u0005"+
		"\u0003\u0000\u0000\u00ab\u00ad\u0003\u0012\t\u0000\u00ac\u00aa\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0005\b\u0000\u0000\u00af\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b0\u00a8\u0001\u0000\u0000\u0000\u00b1\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b3#\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b5\u00ba\u0003\u0012\t\u0000\u00b6\u00b7\u0005\u0003\u0000\u0000\u00b7"+
		"\u00b9\u0003\u0012\t\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bc"+
		"\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb"+
		"\u0001\u0000\u0000\u0000\u00bb%\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001"+
		"\u0000\u0000\u0000\u00bd\u00bf\u0005\u0005\u0000\u0000\u00be\u00c0\u0003"+
		"$\u0012\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005\u0006"+
		"\u0000\u0000\u00c2\'\u0001\u0000\u0000\u0000\u00c3\u00c9\u0003*\u0015"+
		"\u0000\u00c4\u00c9\u0003,\u0016\u0000\u00c5\u00c9\u00030\u0018\u0000\u00c6"+
		"\u00c9\u00032\u0019\u0000\u00c7\u00c9\u00034\u001a\u0000\u00c8\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c4\u0001\u0000\u0000\u0000\u00c8\u00c5\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9)\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cb\u0003\"\u0011\u0000\u00cb\u00cc\u0005\t\u0000"+
		"\u0000\u00cc\u00cd\u0003\u0012\t\u0000\u00cd+\u0001\u0000\u0000\u0000"+
		"\u00ce\u00d0\u0003\u0002\u0001\u0000\u00cf\u00d1\u0003&\u0013\u0000\u00d0"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1"+
		"-\u0001\u0000\u0000\u0000\u00d2\u00d7\u0003(\u0014\u0000\u00d3\u00d4\u0005"+
		"\u0001\u0000\u0000\u00d4\u00d6\u0003(\u0014\u0000\u00d5\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d9\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8/\u0001\u0000\u0000"+
		"\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u001a\u0000"+
		"\u0000\u00db\u00dc\u0003\u0014\n\u0000\u00dc\u00dd\u0005\u001b\u0000\u0000"+
		"\u00dd\u00e5\u0003.\u0017\u0000\u00de\u00df\u0005\u001c\u0000\u0000\u00df"+
		"\u00e0\u0003\u0014\n\u0000\u00e0\u00e1\u0005\u001b\u0000\u0000\u00e1\u00e2"+
		"\u0003.\u0017\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00de\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e7\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00ea\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005"+
		"\u001d\u0000\u0000\u00e9\u00eb\u0003.\u0017\u0000\u00ea\u00e8\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ed\u0005\r\u0000\u0000\u00ed1\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ef\u0005\u001e\u0000\u0000\u00ef\u00f0\u0003\u0002\u0001"+
		"\u0000\u00f0\u00f1\u0005\t\u0000\u0000\u00f1\u00f2\u0003\u0018\f\u0000"+
		"\u00f2\u00f3\u0005\u000e\u0000\u0000\u00f3\u00f6\u0003\u0018\f\u0000\u00f4"+
		"\u00f5\u0005 \u0000\u0000\u00f5\u00f7\u0003\u0018\f\u0000\u00f6\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00f8"+
		"\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005\u001f\u0000\u0000\u00f9\u00fa"+
		"\u0003.\u0017\u0000\u00fa\u00fb\u0005\r\u0000\u0000\u00fb3\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fe\u0005\"\u0000\u0000\u00fd\u00ff\u0003\u0012\t"+
		"\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000"+
		"\u0000\u00ff5\u0001\u0000\u0000\u0000\u0100\u0101\u00038\u001c\u0000\u0101"+
		"\u0102\u0005\u0001\u0000\u0000\u0102\u0103\u0003:\u001d\u0000\u0103\u0104"+
		"\u0003\u0002\u0001\u0000\u01047\u0001\u0000\u0000\u0000\u0105\u0106\u0005"+
		"\u000f\u0000\u0000\u0106\u0108\u0003\u0002\u0001\u0000\u0107\u0109\u0003"+
		">\u001f\u0000\u0108\u0107\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000"+
		"\u0000\u0000\u01099\u0001\u0000\u0000\u0000\u010a\u010d\u0003<\u001e\u0000"+
		"\u010b\u010c\u0005!\u0000\u0000\u010c\u010e\u0003.\u0017\u0000\u010d\u010b"+
		"\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u0110"+
		"\u0001\u0000\u0000\u0000\u010f\u0111\u00034\u001a\u0000\u0110\u010f\u0001"+
		"\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0112\u0001"+
		"\u0000\u0000\u0000\u0112\u0113\u0005\r\u0000\u0000\u0113;\u0001\u0000"+
		"\u0000\u0000\u0114\u011a\u0005#\u0000\u0000\u0115\u0116\u0003\u0004\u0002"+
		"\u0000\u0116\u0117\u0005\u0001\u0000\u0000\u0117\u0119\u0001\u0000\u0000"+
		"\u0000\u0118\u0115\u0001\u0000\u0000\u0000\u0119\u011c\u0001\u0000\u0000"+
		"\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000"+
		"\u0000\u011b\u011e\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000"+
		"\u0000\u011d\u0114\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000"+
		"\u0000\u011e\u0128\u0001\u0000\u0000\u0000\u011f\u0125\u0005$\u0000\u0000"+
		"\u0120\u0121\u0003\u0010\b\u0000\u0121\u0122\u0005\u0001\u0000\u0000\u0122"+
		"\u0124\u0001\u0000\u0000\u0000\u0123\u0120\u0001\u0000\u0000\u0000\u0124"+
		"\u0127\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125"+
		"\u0126\u0001\u0000\u0000\u0000\u0126\u0129\u0001\u0000\u0000\u0000\u0127"+
		"\u0125\u0001\u0000\u0000\u0000\u0128\u011f\u0001\u0000\u0000\u0000\u0128"+
		"\u0129\u0001\u0000\u0000\u0000\u0129\u012f\u0001\u0000\u0000\u0000\u012a"+
		"\u012b\u00036\u001b\u0000\u012b\u012c\u0005\u0001\u0000\u0000\u012c\u012e"+
		"\u0001\u0000\u0000\u0000\u012d\u012a\u0001\u0000\u0000\u0000\u012e\u0131"+
		"\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130"+
		"\u0001\u0000\u0000\u0000\u0130=\u0001\u0000\u0000\u0000\u0131\u012f\u0001"+
		"\u0000\u0000\u0000\u0132\u013b\u0005\u0005\u0000\u0000\u0133\u0138\u0003"+
		"@ \u0000\u0134\u0135\u0005\u0001\u0000\u0000\u0135\u0137\u0003@ \u0000"+
		"\u0136\u0134\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000"+
		"\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000"+
		"\u0139\u013c\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000"+
		"\u013b\u0133\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000"+
		"\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u0140\u0005\u0006\u0000\u0000"+
		"\u013e\u013f\u0005\u0004\u0000\u0000\u013f\u0141\u0003\u0006\u0003\u0000"+
		"\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000"+
		"\u0141?\u0001\u0000\u0000\u0000\u0142\u0143\u0003\u0002\u0001\u0000\u0143"+
		"\u0144\u0005\u0004\u0000\u0000\u0144\u0145\u0003\u0006\u0003\u0000\u0145"+
		"A\u0001\u0000\u0000\u0000!HNY]gs|\u0085\u008d\u0098\u00a5\u00ac\u00b2"+
		"\u00ba\u00bf\u00c8\u00d0\u00d7\u00e5\u00ea\u00f6\u00fe\u0108\u010d\u0110"+
		"\u011a\u011d\u0125\u0128\u012f\u0138\u013b\u0140";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}