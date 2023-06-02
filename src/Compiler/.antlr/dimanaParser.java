// Generated from /home/mendes/Desktop/C/comp-2023-dimana-01/src/Compiler/dimana.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class dimanaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, ID=42, INT=43, REAL=44, STRING=45, BOOL=46, 
		WS=47, LINE_COMMENT=48, ERROR=49;
	public static final int
		RULE_program = 0, RULE_statList = 1, RULE_statement = 2, RULE_variableDeclaration = 3, 
		RULE_readToArray = 4, RULE_assignment = 5, RULE_inputStatement = 6, RULE_outputStatement = 7, 
		RULE_outputFormat = 8, RULE_write_expr = 9, RULE_loopStatement = 10, RULE_length = 11, 
		RULE_headerFile = 12, RULE_prefixUnit = 13, RULE_unit = 14, RULE_alternativeUnit = 15, 
		RULE_listDeclaration = 16, RULE_condicional = 17, RULE_expression = 18, 
		RULE_dataType = 19, RULE_castTypes = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statList", "statement", "variableDeclaration", "readToArray", 
			"assignment", "inputStatement", "outputStatement", "outputFormat", "write_expr", 
			"loopStatement", "length", "headerFile", "prefixUnit", "unit", "alternativeUnit", 
			"listDeclaration", "condicional", "expression", "dataType", "castTypes"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'('", "'read'", "')'", "'*'", "'>>'", "','", "'string'", 
			"'write'", "'writeln'", "'for'", "'to'", "'do'", "'end'", "'length'", 
			"'use'", "'prefix'", "'1e'", "'-'", "'dimension'", "'['", "']'", "'unit'", 
			"'list'", "'new'", "'if'", "'{'", "'}'", "'else'", "'/'", "'+'", "'=='", 
			"'!='", "'<'", "'>'", "'>='", "'<='", "'integer'", "'real'", "'bool'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "ID", "INT", "REAL", "STRING", "BOOL", 
			"WS", "LINE_COMMENT", "ERROR"
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
	public String getGrammarFileName() { return "dimana.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public dimanaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public StatListContext statList() {
			return getRuleContext(StatListContext.class,0);
		}
		public TerminalNode EOF() { return getToken(dimanaParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			statList();
			setState(43);
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

	public static class StatListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statList; }
	}

	public final StatListContext statList() throws RecognitionException {
		StatListContext _localctx = new StatListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__16) | (1L << T__17) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << ID))) != 0)) {
				{
				{
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__16) | (1L << T__17) | (1L << T__20) | (1L << T__23) | (1L << T__24) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << ID))) != 0)) {
					{
					setState(45);
					statement();
					}
				}

				setState(48);
				match(T__0);
				}
				}
				setState(53);
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

	public static class StatementContext extends ParserRuleContext {
		public InputStatementContext inputStatement() {
			return getRuleContext(InputStatementContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ReadToArrayContext readToArray() {
			return getRuleContext(ReadToArrayContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public OutputStatementContext outputStatement() {
			return getRuleContext(OutputStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public HeaderFileContext headerFile() {
			return getRuleContext(HeaderFileContext.class,0);
		}
		public PrefixUnitContext prefixUnit() {
			return getRuleContext(PrefixUnitContext.class,0);
		}
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public AlternativeUnitContext alternativeUnit() {
			return getRuleContext(AlternativeUnitContext.class,0);
		}
		public ListDeclarationContext listDeclaration() {
			return getRuleContext(ListDeclarationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				inputStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				readToArray();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				variableDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(58);
				outputStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(59);
				loopStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(60);
				headerFile();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(61);
				prefixUnit();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(62);
				unit();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(63);
				alternativeUnit();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(64);
				listDeclaration();
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(dimanaParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			dataType();
			setState(68);
			match(ID);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(69);
				match(T__1);
				setState(70);
				expression(0);
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

	public static class ReadToArrayContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(dimanaParser.STRING, 0); }
		public List<TerminalNode> ID() { return getTokens(dimanaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(dimanaParser.ID, i);
		}
		public CastTypesContext castTypes() {
			return getRuleContext(CastTypesContext.class,0);
		}
		public ReadToArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readToArray; }
	}

	public final ReadToArrayContext readToArray() throws RecognitionException {
		ReadToArrayContext _localctx = new ReadToArrayContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_readToArray);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__38 || _la==T__39) {
				{
				setState(73);
				castTypes();
				}
			}

			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(76);
				match(T__2);
				}
			}

			setState(79);
			match(T__3);
			setState(80);
			match(STRING);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(81);
				match(T__4);
				}
			}

			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(84);
				match(T__5);
				setState(85);
				match(ID);
				}
			}

			setState(88);
			match(T__6);
			setState(89);
			match(ID);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(dimanaParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(ID);
			setState(92);
			match(T__1);
			setState(93);
			expression(0);
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

	public static class InputStatementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(dimanaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(dimanaParser.ID, i);
		}
		public TerminalNode STRING() { return getToken(dimanaParser.STRING, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public InputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStatement; }
	}

	public final InputStatementContext inputStatement() throws RecognitionException {
		InputStatementContext _localctx = new InputStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inputStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(ID);
			setState(96);
			match(T__1);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__24) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << ID))) != 0)) {
				{
				setState(97);
				dataType();
				}
			}

			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(100);
				match(T__2);
				}
			}

			setState(103);
			match(T__3);
			setState(104);
			match(STRING);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(105);
				match(T__4);
				}
			}

			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(108);
				match(T__5);
				setState(109);
				match(ID);
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

	public static class OutputStatementContext extends ParserRuleContext {
		public Write_exprContext write_expr() {
			return getRuleContext(Write_exprContext.class,0);
		}
		public List<OutputFormatContext> outputFormat() {
			return getRuleContexts(OutputFormatContext.class);
		}
		public OutputFormatContext outputFormat(int i) {
			return getRuleContext(OutputFormatContext.class,i);
		}
		public OutputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputStatement; }
	}

	public final OutputStatementContext outputStatement() throws RecognitionException {
		OutputStatementContext _localctx = new OutputStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_outputStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			write_expr();
			setState(113);
			outputFormat();
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(114);
					match(T__7);
					setState(115);
					outputFormat();
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class OutputFormatContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(dimanaParser.INT, 0); }
		public TerminalNode ID() { return getToken(dimanaParser.ID, 0); }
		public TerminalNode STRING() { return getToken(dimanaParser.STRING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OutputFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputFormat; }
	}

	public final OutputFormatContext outputFormat() throws RecognitionException {
		OutputFormatContext _localctx = new OutputFormatContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_outputFormat);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(121);
				match(T__8);
				setState(122);
				match(T__2);
				setState(126);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(123);
					match(ID);
					}
					break;
				case 2:
					{
					setState(124);
					match(STRING);
					}
					break;
				case 3:
					{
					setState(125);
					expression(0);
					}
					break;
				}
				setState(128);
				match(T__7);
				setState(129);
				match(INT);
				setState(130);
				match(T__4);
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(131);
				match(STRING);
				setState(132);
				match(T__7);
				setState(133);
				match(ID);
				}
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(134);
				match(ID);
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

	public static class Write_exprContext extends ParserRuleContext {
		public Write_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_expr; }
	}

	public final Write_exprContext write_expr() throws RecognitionException {
		Write_exprContext _localctx = new Write_exprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_write_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==T__10) ) {
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

	public static class LoopStatementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(dimanaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(dimanaParser.ID, i);
		}
		public List<TerminalNode> INT() { return getTokens(dimanaParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(dimanaParser.INT, i);
		}
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_loopStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(T__11);
			setState(140);
			match(ID);
			setState(141);
			match(T__1);
			setState(142);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(143);
			match(T__12);
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(144);
				match(INT);
				}
				break;
			case ID:
				{
				setState(145);
				match(ID);
				}
				break;
			case T__15:
				{
				setState(146);
				length();
				setState(147);
				match(T__2);
				setState(148);
				match(ID);
				setState(149);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(153);
			match(T__13);
			{
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__24) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << ID) | (1L << INT) | (1L << REAL) | (1L << STRING) | (1L << BOOL))) != 0)) {
				{
				{
				setState(154);
				expression(0);
				setState(155);
				match(T__0);
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(162);
			match(T__14);
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

	public static class LengthContext extends ParserRuleContext {
		public LengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_length; }
	}

	public final LengthContext length() throws RecognitionException {
		LengthContext _localctx = new LengthContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(T__15);
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

	public static class HeaderFileContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(dimanaParser.STRING, 0); }
		public HeaderFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerFile; }
	}

	public final HeaderFileContext headerFile() throws RecognitionException {
		HeaderFileContext _localctx = new HeaderFileContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_headerFile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__16);
			setState(167);
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

	public static class PrefixUnitContext extends ParserRuleContext {
		public Token minus;
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(dimanaParser.ID, 0); }
		public TerminalNode INT() { return getToken(dimanaParser.INT, 0); }
		public PrefixUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixUnit; }
	}

	public final PrefixUnitContext prefixUnit() throws RecognitionException {
		PrefixUnitContext _localctx = new PrefixUnitContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_prefixUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__17);
			setState(170);
			dataType();
			setState(171);
			match(ID);
			setState(172);
			match(T__1);
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(173);
				match(INT);
				}
				break;
			case T__18:
				{
				setState(174);
				match(T__18);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(175);
					((PrefixUnitContext)_localctx).minus = match(T__19);
					}
				}

				setState(178);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class UnitContext extends ParserRuleContext {
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
	 
		public UnitContext() { }
		public void copyFrom(UnitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IndependentUnitContext extends UnitContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(dimanaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(dimanaParser.ID, i);
		}
		public IndependentUnitContext(UnitContext ctx) { copyFrom(ctx); }
	}
	public static class DependantUnitContext extends UnitContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(dimanaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(dimanaParser.ID, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DependantUnitContext(UnitContext ctx) { copyFrom(ctx); }
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unit);
		int _la;
		try {
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new IndependentUnitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(T__20);
				setState(182);
				dataType();
				setState(183);
				match(ID);
				{
				setState(184);
				match(T__21);
				setState(185);
				match(ID);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(186);
					match(T__7);
					setState(187);
					match(ID);
					}
				}

				setState(190);
				match(T__22);
				}
				}
				break;
			case 2:
				_localctx = new DependantUnitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				match(T__20);
				setState(193);
				dataType();
				setState(194);
				match(ID);
				{
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(195);
					match(T__21);
					setState(196);
					match(ID);
					{
					setState(197);
					match(T__7);
					setState(198);
					match(ID);
					}
					setState(200);
					match(T__22);
					}
				}

				setState(203);
				match(T__1);
				setState(204);
				expression(0);
				}
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

	public static class AlternativeUnitContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(dimanaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(dimanaParser.ID, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AlternativeUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alternativeUnit; }
	}

	public final AlternativeUnitContext alternativeUnit() throws RecognitionException {
		AlternativeUnitContext _localctx = new AlternativeUnitContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_alternativeUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(T__23);
			setState(209);
			match(ID);
			setState(210);
			match(T__21);
			setState(211);
			match(ID);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(212);
				match(T__7);
				setState(213);
				match(ID);
				}
			}

			setState(216);
			match(T__22);
			setState(217);
			match(T__1);
			setState(218);
			expression(0);
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

	public static class ListDeclarationContext extends ParserRuleContext {
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public TerminalNode ID() { return getToken(dimanaParser.ID, 0); }
		public ListDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDeclaration; }
	}

	public final ListDeclarationContext listDeclaration() throws RecognitionException {
		ListDeclarationContext _localctx = new ListDeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_listDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(T__24);
			setState(221);
			match(T__21);
			setState(222);
			dataType();
			setState(223);
			match(T__22);
			setState(224);
			match(ID);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(225);
				match(T__1);
				setState(226);
				match(T__25);
				setState(227);
				match(T__24);
				setState(228);
				match(T__21);
				setState(229);
				dataType();
				setState(230);
				match(T__22);
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

	public static class CondicionalContext extends ParserRuleContext {
		public StatListContext trueBlock;
		public StatListContext falseBlock;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatListContext> statList() {
			return getRuleContexts(StatListContext.class);
		}
		public StatListContext statList(int i) {
			return getRuleContext(StatListContext.class,i);
		}
		public CondicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicional; }
	}

	public final CondicionalContext condicional() throws RecognitionException {
		CondicionalContext _localctx = new CondicionalContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_condicional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(T__26);
			setState(235);
			match(T__2);
			setState(236);
			expression(0);
			setState(237);
			match(T__4);
			setState(238);
			match(T__27);
			setState(239);
			((CondicionalContext)_localctx).trueBlock = statList();
			setState(240);
			match(T__28);
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(241);
				match(T__29);
				setState(242);
				match(T__27);
				setState(243);
				((CondicionalContext)_localctx).falseBlock = statList();
				setState(244);
				match(T__28);
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

	public static class ExpressionContext extends ParserRuleContext {
		public String varName;
		public String dimension;
		public String type;
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this.varName = ctx.varName;
			this.dimension = ctx.dimension;
			this.type = ctx.type;
		}
	}
	public static class OutputExpressionContext extends ExpressionContext {
		public OutputStatementContext outputStatement() {
			return getRuleContext(OutputStatementContext.class,0);
		}
		public OutputExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ConditionalExpressionContext extends ExpressionContext {
		public ExpressionContext e1;
		public Token op;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ConditionalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class IndexExpressionContext extends ExpressionContext {
		public List<TerminalNode> ID() { return getTokens(dimanaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(dimanaParser.ID, i);
		}
		public TerminalNode INT() { return getToken(dimanaParser.INT, 0); }
		public IndexExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class InputExpressionContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(dimanaParser.STRING, 0); }
		public InputExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class AddSubExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddSubExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class RealLiteralContext extends ExpressionContext {
		public TerminalNode REAL() { return getToken(dimanaParser.REAL, 0); }
		public RealLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class TypeConversionContext extends ExpressionContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeConversionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class StringLiteralContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(dimanaParser.STRING, 0); }
		public StringLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class BoolLiteralContext extends ExpressionContext {
		public TerminalNode BOOL() { return getToken(dimanaParser.BOOL, 0); }
		public BoolLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class IdExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(dimanaParser.ID, 0); }
		public IdExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class IntLiteralContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(dimanaParser.INT, 0); }
		public IntLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class InputTypeExpressionContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(dimanaParser.STRING, 0); }
		public List<TerminalNode> ID() { return getTokens(dimanaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(dimanaParser.ID, i);
		}
		public CastTypesContext castTypes() {
			return getRuleContext(CastTypesContext.class,0);
		}
		public InputTypeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class MulDivExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MulDivExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				_localctx = new InputExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(249);
				match(T__3);
				setState(250);
				match(STRING);
				}
				break;
			case 2:
				{
				_localctx = new InputTypeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__38 || _la==T__39) {
					{
					setState(251);
					castTypes();
					}
				}

				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(254);
					match(T__2);
					}
				}

				setState(257);
				match(T__3);
				setState(258);
				match(STRING);
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(259);
					match(T__4);
					}
				}

				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(262);
					match(T__5);
					setState(263);
					match(ID);
					}
				}

				setState(266);
				match(T__6);
				setState(267);
				match(ID);
				}
				break;
			case 3:
				{
				_localctx = new ParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
				match(T__2);
				setState(269);
				expression(0);
				setState(270);
				match(T__4);
				}
				break;
			case 4:
				{
				_localctx = new OutputExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272);
				outputStatement();
				}
				break;
			case 5:
				{
				_localctx = new IndexExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273);
				match(ID);
				setState(274);
				match(T__21);
				setState(275);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==INT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(276);
				match(T__22);
				}
				break;
			case 6:
				{
				_localctx = new IdExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277);
				match(ID);
				}
				break;
			case 7:
				{
				_localctx = new TypeConversionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278);
				dataType();
				setState(279);
				match(T__2);
				setState(280);
				expression(0);
				setState(281);
				match(T__4);
				}
				break;
			case 8:
				{
				_localctx = new RealLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(283);
				match(REAL);
				}
				break;
			case 9:
				{
				_localctx = new IntLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(284);
				match(INT);
				}
				break;
			case 10:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				match(STRING);
				}
				break;
			case 11:
				{
				_localctx = new BoolLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(286);
				match(BOOL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(300);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(298);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(289);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(290);
						((MulDivExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__30) ) {
							((MulDivExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(291);
						expression(13);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(292);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(293);
						((AddSubExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__31) ) {
							((AddSubExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(294);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ConditionalExpressionContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(295);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(296);
						((ConditionalExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
							((ConditionalExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(297);
						((ConditionalExpressionContext)_localctx).e2 = expression(11);
						}
						break;
					}
					} 
				}
				setState(302);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DataTypeContext extends ParserRuleContext {
		public String type;
		public TerminalNode ID() { return getToken(dimanaParser.ID, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_dataType);
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__38:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				match(T__38);
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				match(T__39);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				match(T__8);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 4);
				{
				setState(306);
				match(T__24);
				setState(307);
				match(T__21);
				setState(308);
				match(ID);
				setState(309);
				match(T__22);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 5);
				{
				setState(310);
				match(T__40);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 6);
				{
				setState(311);
				match(ID);
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

	public static class CastTypesContext extends ParserRuleContext {
		public CastTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castTypes; }
	}

	public final CastTypesContext castTypes() throws RecognitionException {
		CastTypesContext _localctx = new CastTypesContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_castTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_la = _input.LA(1);
			if ( !(_la==T__38 || _la==T__39) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u013f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\3\5\3\61\n\3\3"+
		"\3\7\3\64\n\3\f\3\16\3\67\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4D\n\4\3\5\3\5\3\5\3\5\5\5J\n\5\3\6\5\6M\n\6\3\6\5\6P\n\6\3\6\3"+
		"\6\3\6\5\6U\n\6\3\6\3\6\5\6Y\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\5\be\n\b\3\b\5\bh\n\b\3\b\3\b\3\b\5\bm\n\b\3\b\3\b\5\bq\n\b\3\t\3\t"+
		"\3\t\3\t\7\tw\n\t\f\t\16\tz\13\t\3\n\3\n\3\n\3\n\3\n\5\n\u0081\n\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u008a\n\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u009a\n\f\3\f\3\f\3\f\3\f\7\f\u00a0\n\f"+
		"\f\f\16\f\u00a3\13\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00b3\n\17\3\17\5\17\u00b6\n\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\5\20\u00bf\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00cc\n\20\3\20\3\20\3\20\5\20\u00d1\n\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\5\21\u00d9\n\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00eb\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00f9"+
		"\n\23\3\24\3\24\3\24\3\24\5\24\u00ff\n\24\3\24\5\24\u0102\n\24\3\24\3"+
		"\24\3\24\5\24\u0107\n\24\3\24\3\24\5\24\u010b\n\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0122\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\7\24\u012d\n\24\f\24\16\24\u0130\13\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u013b\n\25\3\26\3\26\3\26\2\3&\27\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\b\3\2\f\r\3\2,-\4\2\b\b!!\4\2\26"+
		"\26\"\"\3\2#(\3\2)*\2\u0164\2,\3\2\2\2\4\65\3\2\2\2\6C\3\2\2\2\bE\3\2"+
		"\2\2\nL\3\2\2\2\f]\3\2\2\2\16a\3\2\2\2\20r\3\2\2\2\22\u0089\3\2\2\2\24"+
		"\u008b\3\2\2\2\26\u008d\3\2\2\2\30\u00a6\3\2\2\2\32\u00a8\3\2\2\2\34\u00ab"+
		"\3\2\2\2\36\u00d0\3\2\2\2 \u00d2\3\2\2\2\"\u00de\3\2\2\2$\u00ec\3\2\2"+
		"\2&\u0121\3\2\2\2(\u013a\3\2\2\2*\u013c\3\2\2\2,-\5\4\3\2-.\7\2\2\3.\3"+
		"\3\2\2\2/\61\5\6\4\2\60/\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\64\7\3"+
		"\2\2\63\60\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\5\3\2"+
		"\2\2\67\65\3\2\2\28D\5\16\b\29D\5\f\7\2:D\5\n\6\2;D\5\b\5\2<D\5\20\t\2"+
		"=D\5\26\f\2>D\5\32\16\2?D\5\34\17\2@D\5\36\20\2AD\5 \21\2BD\5\"\22\2C"+
		"8\3\2\2\2C9\3\2\2\2C:\3\2\2\2C;\3\2\2\2C<\3\2\2\2C=\3\2\2\2C>\3\2\2\2"+
		"C?\3\2\2\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2D\7\3\2\2\2EF\5(\25\2FI\7,\2\2"+
		"GH\7\4\2\2HJ\5&\24\2IG\3\2\2\2IJ\3\2\2\2J\t\3\2\2\2KM\5*\26\2LK\3\2\2"+
		"\2LM\3\2\2\2MO\3\2\2\2NP\7\5\2\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7\6\2"+
		"\2RT\7/\2\2SU\7\7\2\2TS\3\2\2\2TU\3\2\2\2UX\3\2\2\2VW\7\b\2\2WY\7,\2\2"+
		"XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7\t\2\2[\\\7,\2\2\\\13\3\2\2\2]^\7,\2"+
		"\2^_\7\4\2\2_`\5&\24\2`\r\3\2\2\2ab\7,\2\2bd\7\4\2\2ce\5(\25\2dc\3\2\2"+
		"\2de\3\2\2\2eg\3\2\2\2fh\7\5\2\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2ij\7\6\2"+
		"\2jl\7/\2\2km\7\7\2\2lk\3\2\2\2lm\3\2\2\2mp\3\2\2\2no\7\b\2\2oq\7,\2\2"+
		"pn\3\2\2\2pq\3\2\2\2q\17\3\2\2\2rs\5\24\13\2sx\5\22\n\2tu\7\n\2\2uw\5"+
		"\22\n\2vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\21\3\2\2\2zx\3\2\2\2"+
		"{|\7\13\2\2|\u0080\7\5\2\2}\u0081\7,\2\2~\u0081\7/\2\2\177\u0081\5&\24"+
		"\2\u0080}\3\2\2\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2"+
		"\u0082\u0083\7\n\2\2\u0083\u0084\7-\2\2\u0084\u008a\7\7\2\2\u0085\u0086"+
		"\7/\2\2\u0086\u0087\7\n\2\2\u0087\u008a\7,\2\2\u0088\u008a\7,\2\2\u0089"+
		"{\3\2\2\2\u0089\u0085\3\2\2\2\u0089\u0088\3\2\2\2\u008a\23\3\2\2\2\u008b"+
		"\u008c\t\2\2\2\u008c\25\3\2\2\2\u008d\u008e\7\16\2\2\u008e\u008f\7,\2"+
		"\2\u008f\u0090\7\4\2\2\u0090\u0091\t\3\2\2\u0091\u0099\7\17\2\2\u0092"+
		"\u009a\7-\2\2\u0093\u009a\7,\2\2\u0094\u0095\5\30\r\2\u0095\u0096\7\5"+
		"\2\2\u0096\u0097\7,\2\2\u0097\u0098\7\7\2\2\u0098\u009a\3\2\2\2\u0099"+
		"\u0092\3\2\2\2\u0099\u0093\3\2\2\2\u0099\u0094\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\u00a1\7\20\2\2\u009c\u009d\5&\24\2\u009d\u009e\7\3\2\2\u009e"+
		"\u00a0\3\2\2\2\u009f\u009c\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a5\7\21\2\2\u00a5\27\3\2\2\2\u00a6\u00a7\7\22\2\2\u00a7\31\3\2\2\2"+
		"\u00a8\u00a9\7\23\2\2\u00a9\u00aa\7/\2\2\u00aa\33\3\2\2\2\u00ab\u00ac"+
		"\7\24\2\2\u00ac\u00ad\5(\25\2\u00ad\u00ae\7,\2\2\u00ae\u00b5\7\4\2\2\u00af"+
		"\u00b6\7-\2\2\u00b0\u00b2\7\25\2\2\u00b1\u00b3\7\26\2\2\u00b2\u00b1\3"+
		"\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\7-\2\2\u00b5"+
		"\u00af\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b6\35\3\2\2\2\u00b7\u00b8\7\27\2"+
		"\2\u00b8\u00b9\5(\25\2\u00b9\u00ba\7,\2\2\u00ba\u00bb\7\30\2\2\u00bb\u00be"+
		"\7,\2\2\u00bc\u00bd\7\n\2\2\u00bd\u00bf\7,\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\7\31\2\2\u00c1\u00d1\3"+
		"\2\2\2\u00c2\u00c3\7\27\2\2\u00c3\u00c4\5(\25\2\u00c4\u00cb\7,\2\2\u00c5"+
		"\u00c6\7\30\2\2\u00c6\u00c7\7,\2\2\u00c7\u00c8\7\n\2\2\u00c8\u00c9\7,"+
		"\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\7\31\2\2\u00cb\u00c5\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\7\4\2\2\u00ce\u00cf\5&"+
		"\24\2\u00cf\u00d1\3\2\2\2\u00d0\u00b7\3\2\2\2\u00d0\u00c2\3\2\2\2\u00d1"+
		"\37\3\2\2\2\u00d2\u00d3\7\32\2\2\u00d3\u00d4\7,\2\2\u00d4\u00d5\7\30\2"+
		"\2\u00d5\u00d8\7,\2\2\u00d6\u00d7\7\n\2\2\u00d7\u00d9\7,\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\7\31\2\2"+
		"\u00db\u00dc\7\4\2\2\u00dc\u00dd\5&\24\2\u00dd!\3\2\2\2\u00de\u00df\7"+
		"\33\2\2\u00df\u00e0\7\30\2\2\u00e0\u00e1\5(\25\2\u00e1\u00e2\7\31\2\2"+
		"\u00e2\u00ea\7,\2\2\u00e3\u00e4\7\4\2\2\u00e4\u00e5\7\34\2\2\u00e5\u00e6"+
		"\7\33\2\2\u00e6\u00e7\7\30\2\2\u00e7\u00e8\5(\25\2\u00e8\u00e9\7\31\2"+
		"\2\u00e9\u00eb\3\2\2\2\u00ea\u00e3\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb#"+
		"\3\2\2\2\u00ec\u00ed\7\35\2\2\u00ed\u00ee\7\5\2\2\u00ee\u00ef\5&\24\2"+
		"\u00ef\u00f0\7\7\2\2\u00f0\u00f1\7\36\2\2\u00f1\u00f2\5\4\3\2\u00f2\u00f8"+
		"\7\37\2\2\u00f3\u00f4\7 \2\2\u00f4\u00f5\7\36\2\2\u00f5\u00f6\5\4\3\2"+
		"\u00f6\u00f7\7\37\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00f3\3\2\2\2\u00f8\u00f9"+
		"\3\2\2\2\u00f9%\3\2\2\2\u00fa\u00fb\b\24\1\2\u00fb\u00fc\7\6\2\2\u00fc"+
		"\u0122\7/\2\2\u00fd\u00ff\5*\26\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2"+
		"\2\2\u00ff\u0101\3\2\2\2\u0100\u0102\7\5\2\2\u0101\u0100\3\2\2\2\u0101"+
		"\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\7\6\2\2\u0104\u0106\7/"+
		"\2\2\u0105\u0107\7\7\2\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\u010a\3\2\2\2\u0108\u0109\7\b\2\2\u0109\u010b\7,\2\2\u010a\u0108\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\7\t\2\2\u010d"+
		"\u0122\7,\2\2\u010e\u010f\7\5\2\2\u010f\u0110\5&\24\2\u0110\u0111\7\7"+
		"\2\2\u0111\u0122\3\2\2\2\u0112\u0122\5\20\t\2\u0113\u0114\7,\2\2\u0114"+
		"\u0115\7\30\2\2\u0115\u0116\t\3\2\2\u0116\u0122\7\31\2\2\u0117\u0122\7"+
		",\2\2\u0118\u0119\5(\25\2\u0119\u011a\7\5\2\2\u011a\u011b\5&\24\2\u011b"+
		"\u011c\7\7\2\2\u011c\u0122\3\2\2\2\u011d\u0122\7.\2\2\u011e\u0122\7-\2"+
		"\2\u011f\u0122\7/\2\2\u0120\u0122\7\60\2\2\u0121\u00fa\3\2\2\2\u0121\u00fe"+
		"\3\2\2\2\u0121\u010e\3\2\2\2\u0121\u0112\3\2\2\2\u0121\u0113\3\2\2\2\u0121"+
		"\u0117\3\2\2\2\u0121\u0118\3\2\2\2\u0121\u011d\3\2\2\2\u0121\u011e\3\2"+
		"\2\2\u0121\u011f\3\2\2\2\u0121\u0120\3\2\2\2\u0122\u012e\3\2\2\2\u0123"+
		"\u0124\f\16\2\2\u0124\u0125\t\4\2\2\u0125\u012d\5&\24\17\u0126\u0127\f"+
		"\r\2\2\u0127\u0128\t\5\2\2\u0128\u012d\5&\24\16\u0129\u012a\f\f\2\2\u012a"+
		"\u012b\t\6\2\2\u012b\u012d\5&\24\r\u012c\u0123\3\2\2\2\u012c\u0126\3\2"+
		"\2\2\u012c\u0129\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\'\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u013b\7)\2\2"+
		"\u0132\u013b\7*\2\2\u0133\u013b\7\13\2\2\u0134\u0135\7\33\2\2\u0135\u0136"+
		"\7\30\2\2\u0136\u0137\7,\2\2\u0137\u013b\7\31\2\2\u0138\u013b\7+\2\2\u0139"+
		"\u013b\7,\2\2\u013a\u0131\3\2\2\2\u013a\u0132\3\2\2\2\u013a\u0133\3\2"+
		"\2\2\u013a\u0134\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u0139\3\2\2\2\u013b"+
		")\3\2\2\2\u013c\u013d\t\7\2\2\u013d+\3\2\2\2#\60\65CILOTXdglpx\u0080\u0089"+
		"\u0099\u00a1\u00b2\u00b5\u00be\u00cb\u00d0\u00d8\u00ea\u00f8\u00fe\u0101"+
		"\u0106\u010a\u0121\u012c\u012e\u013a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}