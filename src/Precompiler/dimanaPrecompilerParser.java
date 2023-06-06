// Generated from dimanaPrecompiler.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class dimanaPrecompilerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, STRING=3, SYMBOLS=4, LETTER=5, SPACE=6, NEWLINE=7, LINE_COMMENT=8;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_preprocessorDirective = 2, 
		RULE_code = 3, RULE_filename = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "preprocessorDirective", "code", "filename"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'use'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "STRING", "SYMBOLS", "LETTER", "SPACE", "NEWLINE", 
			"LINE_COMMENT"
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
	public String getGrammarFileName() { return "dimanaPrecompiler.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public dimanaPrecompilerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(dimanaPrecompilerParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dimanaPrecompilerListener ) ((dimanaPrecompilerListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dimanaPrecompilerListener ) ((dimanaPrecompilerListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dimanaPrecompilerVisitor ) return ((dimanaPrecompilerVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 506L) != 0)) {
				{
				{
				setState(10);
				statement();
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(16);
			match(EOF);
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
		public PreprocessorDirectiveContext preprocessorDirective() {
			return getRuleContext(PreprocessorDirectiveContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dimanaPrecompilerListener ) ((dimanaPrecompilerListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dimanaPrecompilerListener ) ((dimanaPrecompilerListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dimanaPrecompilerVisitor ) return ((dimanaPrecompilerVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(20);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				preprocessorDirective();
				}
				break;
			case STRING:
			case SYMBOLS:
			case LETTER:
			case SPACE:
			case NEWLINE:
			case LINE_COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				code();
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
	public static class PreprocessorDirectiveContext extends ParserRuleContext {
		public FilenameContext filename() {
			return getRuleContext(FilenameContext.class,0);
		}
		public List<TerminalNode> SPACE() { return getTokens(dimanaPrecompilerParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(dimanaPrecompilerParser.SPACE, i);
		}
		public PreprocessorDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preprocessorDirective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dimanaPrecompilerListener ) ((dimanaPrecompilerListener)listener).enterPreprocessorDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dimanaPrecompilerListener ) ((dimanaPrecompilerListener)listener).exitPreprocessorDirective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dimanaPrecompilerVisitor ) return ((dimanaPrecompilerVisitor<? extends T>)visitor).visitPreprocessorDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreprocessorDirectiveContext preprocessorDirective() throws RecognitionException {
		PreprocessorDirectiveContext _localctx = new PreprocessorDirectiveContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_preprocessorDirective);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(T__0);
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SPACE) {
				{
				{
				setState(23);
				match(SPACE);
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			filename();
			setState(30);
			match(T__1);
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
	public static class CodeContext extends ParserRuleContext {
		public Token semicolon;
		public TerminalNode LINE_COMMENT() { return getToken(dimanaPrecompilerParser.LINE_COMMENT, 0); }
		public TerminalNode LETTER() { return getToken(dimanaPrecompilerParser.LETTER, 0); }
		public TerminalNode SYMBOLS() { return getToken(dimanaPrecompilerParser.SYMBOLS, 0); }
		public TerminalNode STRING() { return getToken(dimanaPrecompilerParser.STRING, 0); }
		public TerminalNode SPACE() { return getToken(dimanaPrecompilerParser.SPACE, 0); }
		public TerminalNode NEWLINE() { return getToken(dimanaPrecompilerParser.NEWLINE, 0); }
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dimanaPrecompilerListener ) ((dimanaPrecompilerListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dimanaPrecompilerListener ) ((dimanaPrecompilerListener)listener).exitCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dimanaPrecompilerVisitor ) return ((dimanaPrecompilerVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_code);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 504L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(33);
				((CodeContext)_localctx).semicolon = match(T__1);
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
	public static class FilenameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(dimanaPrecompilerParser.STRING, 0); }
		public FilenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof dimanaPrecompilerListener ) ((dimanaPrecompilerListener)listener).enterFilename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof dimanaPrecompilerListener ) ((dimanaPrecompilerListener)listener).exitFilename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof dimanaPrecompilerVisitor ) return ((dimanaPrecompilerVisitor<? extends T>)visitor).visitFilename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilenameContext filename() throws RecognitionException {
		FilenameContext _localctx = new FilenameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_filename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(STRING);
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
		"\u0004\u0001\b\'\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0005\u0000\f\b\u0000\n\u0000\f\u0000\u000f\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001\u0015\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0005\u0002\u0019\b\u0002\n\u0002\f\u0002\u001c\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0003\u0003#\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0000\u0000\u0005\u0000\u0002"+
		"\u0004\u0006\b\u0000\u0001\u0001\u0000\u0003\b%\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0002\u0014\u0001\u0000\u0000\u0000\u0004\u0016\u0001\u0000\u0000"+
		"\u0000\u0006 \u0001\u0000\u0000\u0000\b$\u0001\u0000\u0000\u0000\n\f\u0003"+
		"\u0002\u0001\u0000\u000b\n\u0001\u0000\u0000\u0000\f\u000f\u0001\u0000"+
		"\u0000\u0000\r\u000b\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000"+
		"\u0000\u000e\u0010\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000"+
		"\u0010\u0011\u0005\u0000\u0000\u0001\u0011\u0001\u0001\u0000\u0000\u0000"+
		"\u0012\u0015\u0003\u0004\u0002\u0000\u0013\u0015\u0003\u0006\u0003\u0000"+
		"\u0014\u0012\u0001\u0000\u0000\u0000\u0014\u0013\u0001\u0000\u0000\u0000"+
		"\u0015\u0003\u0001\u0000\u0000\u0000\u0016\u001a\u0005\u0001\u0000\u0000"+
		"\u0017\u0019\u0005\u0006\u0000\u0000\u0018\u0017\u0001\u0000\u0000\u0000"+
		"\u0019\u001c\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000"+
		"\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u001d\u0001\u0000\u0000\u0000"+
		"\u001c\u001a\u0001\u0000\u0000\u0000\u001d\u001e\u0003\b\u0004\u0000\u001e"+
		"\u001f\u0005\u0002\u0000\u0000\u001f\u0005\u0001\u0000\u0000\u0000 \""+
		"\u0007\u0000\u0000\u0000!#\u0005\u0002\u0000\u0000\"!\u0001\u0000\u0000"+
		"\u0000\"#\u0001\u0000\u0000\u0000#\u0007\u0001\u0000\u0000\u0000$%\u0005"+
		"\u0003\u0000\u0000%\t\u0001\u0000\u0000\u0000\u0004\r\u0014\u001a\"";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}