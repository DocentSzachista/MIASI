// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CalculatorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VARIABLE=1, SCIENTIFIC_NUMBER=2, LPAREN=3, RPAREN=4, PLUS=5, MINUS=6, 
		TIMES=7, DIV=8, EQ=9, POINT=10, POW=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VARIABLE", "VALID_ID_START", "VALID_ID_CHAR", "SCIENTIFIC_NUMBER", "NUMBER", 
			"UNSIGNED_INTEGER", "E", "SIGN", "LPAREN", "RPAREN", "PLUS", "MINUS", 
			"TIMES", "DIV", "EQ", "POINT", "POW", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'='", "'.'", 
			"'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VARIABLE", "SCIENTIFIC_NUMBER", "LPAREN", "RPAREN", "PLUS", "MINUS", 
			"TIMES", "DIV", "EQ", "POINT", "POW", "WS"
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


	public CalculatorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calculator.g4"; }

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
		"\u0004\u0000\fk\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001"+
		"\u0000\u0001\u0000\u0005\u0000(\b\u0000\n\u0000\f\u0000+\t\u0000\u0001"+
		"\u0001\u0003\u0001.\b\u0001\u0001\u0002\u0001\u0002\u0003\u00022\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00037\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003;\b\u0003\u0001\u0004\u0004\u0004>\b\u0004\u000b"+
		"\u0004\f\u0004?\u0001\u0004\u0001\u0004\u0004\u0004D\b\u0004\u000b\u0004"+
		"\f\u0004E\u0003\u0004H\b\u0004\u0001\u0005\u0004\u0005K\b\u0005\u000b"+
		"\u0005\f\u0005L\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0004\u0011f\b\u0011\u000b\u0011"+
		"\f\u0011g\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0001\u0001\u0003"+
		"\u0000\u0005\u0000\u0007\u0002\t\u0000\u000b\u0000\r\u0000\u000f\u0000"+
		"\u0011\u0003\u0013\u0004\u0015\u0005\u0017\u0006\u0019\u0007\u001b\b\u001d"+
		"\t\u001f\n!\u000b#\f\u0001\u0000\u0004\u0003\u0000AZ__az\u0002\u0000E"+
		"Eee\u0002\u0000++--\u0003\u0000\t\n\r\r  m\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0001%\u0001\u0000\u0000\u0000\u0003-"+
		"\u0001\u0000\u0000\u0000\u00051\u0001\u0000\u0000\u0000\u00073\u0001\u0000"+
		"\u0000\u0000\t=\u0001\u0000\u0000\u0000\u000bJ\u0001\u0000\u0000\u0000"+
		"\rN\u0001\u0000\u0000\u0000\u000fP\u0001\u0000\u0000\u0000\u0011R\u0001"+
		"\u0000\u0000\u0000\u0013T\u0001\u0000\u0000\u0000\u0015V\u0001\u0000\u0000"+
		"\u0000\u0017X\u0001\u0000\u0000\u0000\u0019Z\u0001\u0000\u0000\u0000\u001b"+
		"\\\u0001\u0000\u0000\u0000\u001d^\u0001\u0000\u0000\u0000\u001f`\u0001"+
		"\u0000\u0000\u0000!b\u0001\u0000\u0000\u0000#e\u0001\u0000\u0000\u0000"+
		"%)\u0003\u0003\u0001\u0000&(\u0003\u0005\u0002\u0000\'&\u0001\u0000\u0000"+
		"\u0000(+\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000)*\u0001\u0000"+
		"\u0000\u0000*\u0002\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000"+
		",.\u0007\u0000\u0000\u0000-,\u0001\u0000\u0000\u0000.\u0004\u0001\u0000"+
		"\u0000\u0000/2\u0003\u0003\u0001\u000002\u000209\u00001/\u0001\u0000\u0000"+
		"\u000010\u0001\u0000\u0000\u00002\u0006\u0001\u0000\u0000\u00003:\u0003"+
		"\t\u0004\u000046\u0003\r\u0006\u000057\u0003\u000f\u0007\u000065\u0001"+
		"\u0000\u0000\u000067\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u0000"+
		"89\u0003\u000b\u0005\u00009;\u0001\u0000\u0000\u0000:4\u0001\u0000\u0000"+
		"\u0000:;\u0001\u0000\u0000\u0000;\b\u0001\u0000\u0000\u0000<>\u000209"+
		"\u0000=<\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?=\u0001\u0000"+
		"\u0000\u0000?@\u0001\u0000\u0000\u0000@G\u0001\u0000\u0000\u0000AC\u0005"+
		".\u0000\u0000BD\u000209\u0000CB\u0001\u0000\u0000\u0000DE\u0001\u0000"+
		"\u0000\u0000EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FH\u0001"+
		"\u0000\u0000\u0000GA\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000"+
		"H\n\u0001\u0000\u0000\u0000IK\u000209\u0000JI\u0001\u0000\u0000\u0000"+
		"KL\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000"+
		"\u0000M\f\u0001\u0000\u0000\u0000NO\u0007\u0001\u0000\u0000O\u000e\u0001"+
		"\u0000\u0000\u0000PQ\u0007\u0002\u0000\u0000Q\u0010\u0001\u0000\u0000"+
		"\u0000RS\u0005(\u0000\u0000S\u0012\u0001\u0000\u0000\u0000TU\u0005)\u0000"+
		"\u0000U\u0014\u0001\u0000\u0000\u0000VW\u0005+\u0000\u0000W\u0016\u0001"+
		"\u0000\u0000\u0000XY\u0005-\u0000\u0000Y\u0018\u0001\u0000\u0000\u0000"+
		"Z[\u0005*\u0000\u0000[\u001a\u0001\u0000\u0000\u0000\\]\u0005/\u0000\u0000"+
		"]\u001c\u0001\u0000\u0000\u0000^_\u0005=\u0000\u0000_\u001e\u0001\u0000"+
		"\u0000\u0000`a\u0005.\u0000\u0000a \u0001\u0000\u0000\u0000bc\u0005^\u0000"+
		"\u0000c\"\u0001\u0000\u0000\u0000df\u0007\u0003\u0000\u0000ed\u0001\u0000"+
		"\u0000\u0000fg\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001"+
		"\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0006\u0011\u0000\u0000"+
		"j$\u0001\u0000\u0000\u0000\u000b\u0000)-16:?EGLg\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}