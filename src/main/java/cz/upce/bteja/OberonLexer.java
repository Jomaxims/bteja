// Generated from D:/UPCE/5S/BTEJA/sem/interpreter/Oberon.g4 by ANTLR 4.13.1
package cz.upce.bteja;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class OberonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		ARRAY=10, MATRIX=11, OF=12, END=13, TO=14, PROCEDURE=15, DIV=16, MULT=17, 
		MOD=18, PLUS=19, MINUS=20, EQUALS=21, LESS_THAN=22, MORE_THAN=23, LESS_THAN_EQUALS=24, 
		MORE_THAN_EQUALS=25, IF=26, THEN=27, ELSIF=28, ELSE=29, FOR=30, DO=31, 
		BY=32, BEGIN=33, RETURN=34, CONST=35, VAR=36, MODULE=37, EXIT=38, STRING=39, 
		IDENT=40, LETTER=41, INTEGER=42, REAL=43, WS=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"ARRAY", "MATRIX", "OF", "END", "TO", "PROCEDURE", "DIV", "MULT", "MOD", 
			"PLUS", "MINUS", "EQUALS", "LESS_THAN", "MORE_THAN", "LESS_THAN_EQUALS", 
			"MORE_THAN_EQUALS", "IF", "THEN", "ELSIF", "ELSE", "FOR", "DO", "BY", 
			"BEGIN", "RETURN", "CONST", "VAR", "MODULE", "EXIT", "STRING", "IDENT", 
			"LETTER", "INTEGER", "REAL", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "','", "':'", "'('", "')'", "'['", "']'", "':='", 
			"'ARRAY'", "'MATRIX'", "'OF'", "'END'", "'TO'", "'PROCEDURE'", "'/'", 
			"'*'", "'MOD'", "'+'", "'-'", "'='", "'<'", "'>'", "'<='", "'>='", "'IF'", 
			"'THEN'", "'ELSIF'", "'ELSE'", "'FOR'", "'DO'", "'BY'", "'BEGIN'", "'RETURN'", 
			"'CONST'", "'VAR'", "'MODULE'", "'EXIT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "ARRAY", 
			"MATRIX", "OF", "END", "TO", "PROCEDURE", "DIV", "MULT", "MOD", "PLUS", 
			"MINUS", "EQUALS", "LESS_THAN", "MORE_THAN", "LESS_THAN_EQUALS", "MORE_THAN_EQUALS", 
			"IF", "THEN", "ELSIF", "ELSE", "FOR", "DO", "BY", "BEGIN", "RETURN", 
			"CONST", "VAR", "MODULE", "EXIT", "STRING", "IDENT", "LETTER", "INTEGER", 
			"REAL", "WS"
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


	public OberonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Oberon.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000,\u0106\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0005"+
		"&\u00e8\b&\n&\f&\u00eb\t&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0005\'\u00f3\b\'\n\'\f\'\u00f6\t\'\u0001(\u0001(\u0001)\u0004)\u00fb"+
		"\b)\u000b)\f)\u00fc\u0001*\u0001*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001"+
		"+\u0001\u00e9\u0000,\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"+
		"\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f"+
		"\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014"+
		")\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e"+
		"=\u001f? A!C\"E#G$I%K&M\'O(Q)S*U+W,\u0001\u0000\u0003\u0002\u0000AZaz"+
		"\u0001\u000009\u0003\u0000\t\n\r\r  \u010a\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001"+
		"\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000"+
		"\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000"+
		"\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?"+
		"\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000"+
		"\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000"+
		"\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M"+
		"\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000"+
		"\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000"+
		"\u0000W\u0001\u0000\u0000\u0000\u0001Y\u0001\u0000\u0000\u0000\u0003["+
		"\u0001\u0000\u0000\u0000\u0005]\u0001\u0000\u0000\u0000\u0007_\u0001\u0000"+
		"\u0000\u0000\ta\u0001\u0000\u0000\u0000\u000bc\u0001\u0000\u0000\u0000"+
		"\re\u0001\u0000\u0000\u0000\u000fg\u0001\u0000\u0000\u0000\u0011i\u0001"+
		"\u0000\u0000\u0000\u0013l\u0001\u0000\u0000\u0000\u0015r\u0001\u0000\u0000"+
		"\u0000\u0017y\u0001\u0000\u0000\u0000\u0019|\u0001\u0000\u0000\u0000\u001b"+
		"\u0080\u0001\u0000\u0000\u0000\u001d\u0083\u0001\u0000\u0000\u0000\u001f"+
		"\u008d\u0001\u0000\u0000\u0000!\u008f\u0001\u0000\u0000\u0000#\u0091\u0001"+
		"\u0000\u0000\u0000%\u0095\u0001\u0000\u0000\u0000\'\u0097\u0001\u0000"+
		"\u0000\u0000)\u0099\u0001\u0000\u0000\u0000+\u009b\u0001\u0000\u0000\u0000"+
		"-\u009d\u0001\u0000\u0000\u0000/\u009f\u0001\u0000\u0000\u00001\u00a2"+
		"\u0001\u0000\u0000\u00003\u00a5\u0001\u0000\u0000\u00005\u00a8\u0001\u0000"+
		"\u0000\u00007\u00ad\u0001\u0000\u0000\u00009\u00b3\u0001\u0000\u0000\u0000"+
		";\u00b8\u0001\u0000\u0000\u0000=\u00bc\u0001\u0000\u0000\u0000?\u00bf"+
		"\u0001\u0000\u0000\u0000A\u00c2\u0001\u0000\u0000\u0000C\u00c8\u0001\u0000"+
		"\u0000\u0000E\u00cf\u0001\u0000\u0000\u0000G\u00d5\u0001\u0000\u0000\u0000"+
		"I\u00d9\u0001\u0000\u0000\u0000K\u00e0\u0001\u0000\u0000\u0000M\u00e5"+
		"\u0001\u0000\u0000\u0000O\u00ee\u0001\u0000\u0000\u0000Q\u00f7\u0001\u0000"+
		"\u0000\u0000S\u00fa\u0001\u0000\u0000\u0000U\u00fe\u0001\u0000\u0000\u0000"+
		"W\u0102\u0001\u0000\u0000\u0000YZ\u0005;\u0000\u0000Z\u0002\u0001\u0000"+
		"\u0000\u0000[\\\u0005.\u0000\u0000\\\u0004\u0001\u0000\u0000\u0000]^\u0005"+
		",\u0000\u0000^\u0006\u0001\u0000\u0000\u0000_`\u0005:\u0000\u0000`\b\u0001"+
		"\u0000\u0000\u0000ab\u0005(\u0000\u0000b\n\u0001\u0000\u0000\u0000cd\u0005"+
		")\u0000\u0000d\f\u0001\u0000\u0000\u0000ef\u0005[\u0000\u0000f\u000e\u0001"+
		"\u0000\u0000\u0000gh\u0005]\u0000\u0000h\u0010\u0001\u0000\u0000\u0000"+
		"ij\u0005:\u0000\u0000jk\u0005=\u0000\u0000k\u0012\u0001\u0000\u0000\u0000"+
		"lm\u0005A\u0000\u0000mn\u0005R\u0000\u0000no\u0005R\u0000\u0000op\u0005"+
		"A\u0000\u0000pq\u0005Y\u0000\u0000q\u0014\u0001\u0000\u0000\u0000rs\u0005"+
		"M\u0000\u0000st\u0005A\u0000\u0000tu\u0005T\u0000\u0000uv\u0005R\u0000"+
		"\u0000vw\u0005I\u0000\u0000wx\u0005X\u0000\u0000x\u0016\u0001\u0000\u0000"+
		"\u0000yz\u0005O\u0000\u0000z{\u0005F\u0000\u0000{\u0018\u0001\u0000\u0000"+
		"\u0000|}\u0005E\u0000\u0000}~\u0005N\u0000\u0000~\u007f\u0005D\u0000\u0000"+
		"\u007f\u001a\u0001\u0000\u0000\u0000\u0080\u0081\u0005T\u0000\u0000\u0081"+
		"\u0082\u0005O\u0000\u0000\u0082\u001c\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0005P\u0000\u0000\u0084\u0085\u0005R\u0000\u0000\u0085\u0086\u0005O"+
		"\u0000\u0000\u0086\u0087\u0005C\u0000\u0000\u0087\u0088\u0005E\u0000\u0000"+
		"\u0088\u0089\u0005D\u0000\u0000\u0089\u008a\u0005U\u0000\u0000\u008a\u008b"+
		"\u0005R\u0000\u0000\u008b\u008c\u0005E\u0000\u0000\u008c\u001e\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0005/\u0000\u0000\u008e \u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0005*\u0000\u0000\u0090\"\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0005M\u0000\u0000\u0092\u0093\u0005O\u0000\u0000\u0093\u0094\u0005"+
		"D\u0000\u0000\u0094$\u0001\u0000\u0000\u0000\u0095\u0096\u0005+\u0000"+
		"\u0000\u0096&\u0001\u0000\u0000\u0000\u0097\u0098\u0005-\u0000\u0000\u0098"+
		"(\u0001\u0000\u0000\u0000\u0099\u009a\u0005=\u0000\u0000\u009a*\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0005<\u0000\u0000\u009c,\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0005>\u0000\u0000\u009e.\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\u0005<\u0000\u0000\u00a0\u00a1\u0005=\u0000\u0000\u00a10\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0005>\u0000\u0000\u00a3\u00a4\u0005=\u0000"+
		"\u0000\u00a42\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005I\u0000\u0000\u00a6"+
		"\u00a7\u0005F\u0000\u0000\u00a74\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005"+
		"T\u0000\u0000\u00a9\u00aa\u0005H\u0000\u0000\u00aa\u00ab\u0005E\u0000"+
		"\u0000\u00ab\u00ac\u0005N\u0000\u0000\u00ac6\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ae\u0005E\u0000\u0000\u00ae\u00af\u0005L\u0000\u0000\u00af\u00b0\u0005"+
		"S\u0000\u0000\u00b0\u00b1\u0005I\u0000\u0000\u00b1\u00b2\u0005F\u0000"+
		"\u0000\u00b28\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005E\u0000\u0000\u00b4"+
		"\u00b5\u0005L\u0000\u0000\u00b5\u00b6\u0005S\u0000\u0000\u00b6\u00b7\u0005"+
		"E\u0000\u0000\u00b7:\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005F\u0000"+
		"\u0000\u00b9\u00ba\u0005O\u0000\u0000\u00ba\u00bb\u0005R\u0000\u0000\u00bb"+
		"<\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005D\u0000\u0000\u00bd\u00be\u0005"+
		"O\u0000\u0000\u00be>\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005B\u0000"+
		"\u0000\u00c0\u00c1\u0005Y\u0000\u0000\u00c1@\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0005B\u0000\u0000\u00c3\u00c4\u0005E\u0000\u0000\u00c4\u00c5\u0005"+
		"G\u0000\u0000\u00c5\u00c6\u0005I\u0000\u0000\u00c6\u00c7\u0005N\u0000"+
		"\u0000\u00c7B\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005R\u0000\u0000\u00c9"+
		"\u00ca\u0005E\u0000\u0000\u00ca\u00cb\u0005T\u0000\u0000\u00cb\u00cc\u0005"+
		"U\u0000\u0000\u00cc\u00cd\u0005R\u0000\u0000\u00cd\u00ce\u0005N\u0000"+
		"\u0000\u00ceD\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005C\u0000\u0000\u00d0"+
		"\u00d1\u0005O\u0000\u0000\u00d1\u00d2\u0005N\u0000\u0000\u00d2\u00d3\u0005"+
		"S\u0000\u0000\u00d3\u00d4\u0005T\u0000\u0000\u00d4F\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d6\u0005V\u0000\u0000\u00d6\u00d7\u0005A\u0000\u0000\u00d7"+
		"\u00d8\u0005R\u0000\u0000\u00d8H\u0001\u0000\u0000\u0000\u00d9\u00da\u0005"+
		"M\u0000\u0000\u00da\u00db\u0005O\u0000\u0000\u00db\u00dc\u0005D\u0000"+
		"\u0000\u00dc\u00dd\u0005U\u0000\u0000\u00dd\u00de\u0005L\u0000\u0000\u00de"+
		"\u00df\u0005E\u0000\u0000\u00dfJ\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005"+
		"E\u0000\u0000\u00e1\u00e2\u0005X\u0000\u0000\u00e2\u00e3\u0005I\u0000"+
		"\u0000\u00e3\u00e4\u0005T\u0000\u0000\u00e4L\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e9\u0005\"\u0000\u0000\u00e6\u00e8\t\u0000\u0000\u0000\u00e7\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00ea\u00ec"+
		"\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed"+
		"\u0005\"\u0000\u0000\u00edN\u0001\u0000\u0000\u0000\u00ee\u00f4\u0003"+
		"Q(\u0000\u00ef\u00f3\u0003Q(\u0000\u00f0\u00f3\u0003S)\u0000\u00f1\u00f3"+
		"\u0005_\u0000\u0000\u00f2\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f5P\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f8\u0007\u0000\u0000\u0000\u00f8R\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fb\u0007\u0001\u0000\u0000\u00fa\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fdT\u0001\u0000\u0000\u0000"+
		"\u00fe\u00ff\u0003S)\u0000\u00ff\u0100\u0005.\u0000\u0000\u0100\u0101"+
		"\u0003S)\u0000\u0101V\u0001\u0000\u0000\u0000\u0102\u0103\u0007\u0002"+
		"\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0105\u0006+\u0000"+
		"\u0000\u0105X\u0001\u0000\u0000\u0000\u0005\u0000\u00e9\u00f2\u00f4\u00fc"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}