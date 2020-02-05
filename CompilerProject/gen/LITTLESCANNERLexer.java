// Generated from C:/Users/rusty/Documents/GitHub/CSCI468-Compiler-Project/CompilerProject/src\LITTLESCANNER.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LITTLESCANNERLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, IDENTIFIER=2, INTLITERAL=3, FLOATLITERAL=4, STRINGLITERAL=5, 
		COMMENT=6, OPERATOR=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"KEYWORD", "IDENTIFIER", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", 
			"COMMENT", "OPERATOR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KEYWORD", "IDENTIFIER", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", 
			"COMMENT", "OPERATOR"
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


	public LITTLESCANNERLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LITTLESCANNER.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t\u00aa\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\5\2o\n\2\3\3\6\3r\n\3\r\3\16\3s\3\3\7\3w\n\3\f\3\16\3z\13\3\3\4\6\4"+
		"}\n\4\r\4\16\4~\3\5\7\5\u0082\n\5\f\5\16\5\u0085\13\5\3\5\3\5\6\5\u0089"+
		"\n\5\r\5\16\5\u008a\3\6\3\6\7\6\u008f\n\6\f\6\16\6\u0092\13\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\7\7\u009a\n\7\f\7\16\7\u009d\13\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u00a9\n\b\2\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\3\2\t\4\2C\\c|\5\2\62;C\\c|\3\2\62;\3\2$$\3\2\f\f\6\2,-//\61\61??\6\2"+
		"*+..=>@@\2\u00c6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3n\3\2\2\2\5q\3\2\2\2\7|\3\2\2\2\t\u0083"+
		"\3\2\2\2\13\u008c\3\2\2\2\r\u0095\3\2\2\2\17\u00a8\3\2\2\2\21\22\7R\2"+
		"\2\22\23\7T\2\2\23\24\7Q\2\2\24\25\7I\2\2\25\26\7T\2\2\26\27\7C\2\2\27"+
		"o\7O\2\2\30\31\7D\2\2\31\32\7G\2\2\32\33\7I\2\2\33\34\7K\2\2\34o\7P\2"+
		"\2\35\36\7G\2\2\36\37\7P\2\2\37o\7F\2\2 !\7H\2\2!\"\7W\2\2\"#\7P\2\2#"+
		"$\7E\2\2$%\7V\2\2%&\7K\2\2&\'\7Q\2\2\'o\7P\2\2()\7T\2\2)*\7G\2\2*+\7C"+
		"\2\2+o\7F\2\2,-\7Y\2\2-.\7T\2\2./\7K\2\2/\60\7V\2\2\60o\7G\2\2\61\62\7"+
		"K\2\2\62o\7H\2\2\63\64\7G\2\2\64\65\7N\2\2\65\66\7U\2\2\66o\7G\2\2\67"+
		"8\7G\2\289\7P\2\29:\7F\2\2:;\7K\2\2;o\7H\2\2<=\7Y\2\2=>\7J\2\2>?\7K\2"+
		"\2?@\7N\2\2@o\7G\2\2AB\7G\2\2BC\7P\2\2CD\7F\2\2DE\7Y\2\2EF\7J\2\2FG\7"+
		"K\2\2GH\7N\2\2Ho\7G\2\2IJ\7E\2\2JK\7Q\2\2KL\7P\2\2LM\7V\2\2MN\7K\2\2N"+
		"O\7P\2\2OP\7W\2\2Po\7G\2\2QR\7D\2\2RS\7T\2\2ST\7G\2\2TU\7C\2\2Uo\7M\2"+
		"\2VW\7T\2\2WX\7G\2\2XY\7V\2\2YZ\7W\2\2Z[\7T\2\2[o\7P\2\2\\]\7K\2\2]^\7"+
		"P\2\2^o\7V\2\2_`\7X\2\2`a\7Q\2\2ab\7K\2\2bo\7F\2\2cd\7U\2\2de\7V\2\2e"+
		"f\7T\2\2fg\7K\2\2gh\7P\2\2ho\7I\2\2ij\7H\2\2jk\7N\2\2kl\7Q\2\2lm\7C\2"+
		"\2mo\7V\2\2n\21\3\2\2\2n\30\3\2\2\2n\35\3\2\2\2n \3\2\2\2n(\3\2\2\2n,"+
		"\3\2\2\2n\61\3\2\2\2n\63\3\2\2\2n\67\3\2\2\2n<\3\2\2\2nA\3\2\2\2nI\3\2"+
		"\2\2nQ\3\2\2\2nV\3\2\2\2n\\\3\2\2\2n_\3\2\2\2nc\3\2\2\2ni\3\2\2\2o\4\3"+
		"\2\2\2pr\t\2\2\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tx\3\2\2\2uw\t"+
		"\3\2\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\6\3\2\2\2zx\3\2\2\2{}"+
		"\t\4\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\b\3\2\2\2\u0080"+
		"\u0082\t\4\2\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2"+
		"\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0088\7\60\2\2\u0087\u0089\t\4\2\2\u0088\u0087\3\2\2\2\u0089\u008a\3"+
		"\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\n\3\2\2\2\u008c\u0090"+
		"\7$\2\2\u008d\u008f\n\5\2\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2"+
		"\2\2\u0093\u0094\7$\2\2\u0094\f\3\2\2\2\u0095\u0096\7/\2\2\u0096\u0097"+
		"\7/\2\2\u0097\u009b\3\2\2\2\u0098\u009a\n\6\2\2\u0099\u0098\3\2\2\2\u009a"+
		"\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\16\3\2\2"+
		"\2\u009d\u009b\3\2\2\2\u009e\u009f\7<\2\2\u009f\u00a9\7?\2\2\u00a0\u00a9"+
		"\t\7\2\2\u00a1\u00a2\7#\2\2\u00a2\u00a9\7?\2\2\u00a3\u00a9\t\b\2\2\u00a4"+
		"\u00a5\7>\2\2\u00a5\u00a9\7?\2\2\u00a6\u00a7\7@\2\2\u00a7\u00a9\7?\2\2"+
		"\u00a8\u009e\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a1\3\2\2\2\u00a8\u00a3"+
		"\3\2\2\2\u00a8\u00a4\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\20\3\2\2\2\16\2"+
		"nqsvx~\u0083\u008a\u0090\u009b\u00a8\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}