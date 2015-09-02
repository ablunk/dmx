package hub.sam.dmx.editor.tokens;

import hub.sam.tef.rcc.Token;
import hub.sam.tef.rcc.syntax.Syntax;
import hub.sam.tef.rcc.syntax.builder.SyntaxSeparation;

public class MiddleTargetCode extends TargetCode {

	@Override
	protected String getStartSeq() {
		//return "]";
		return "(*";
	}

	@Override
	protected String getEndSeq() {
		//return "[";
		return "*)";
	}

	@Override
	public String getNonTerminalName() {
		return "CODE";
	}
	
	protected void constructScannerRules () {
		try {
			Syntax syntax = new Syntax(getCustomMultiLineBracketRules(getRCCSymbol(), getStartSeq(), getEndSeq()));
			SyntaxSeparation separation = new SyntaxSeparation(syntax);
			lexerSyntax = separation.getLexerSyntax();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static final String [][] getCustomMultiLineBracketRules(String nonterminalName, String startSeq, String endSeq)	{
		String [][] sarr0 = hub.sam.tef.rcc.lexer.StandardLexerRules.getUnicodeCharRules();
		String [][] customRules = new String [7][];
		customRules[0] = new String [] { Token.TOKEN, nonterminalName };
		customRules[1] = new String [] { nonterminalName,  "\""+startSeq+"\"", "char_minus_"+nonterminalName+"_list_opt", "\""+endSeq+"\"" };
		customRules[2] = new String [] { "char_minus_"+nonterminalName, "char", hub.sam.tef.rcc.Token.BUTNOT, "\""+endSeq+"\"" };
		customRules[3] = new String [] { "char_minus_"+nonterminalName+"_list", "char_minus_"+nonterminalName+"_list", "char_minus_"+nonterminalName };
		customRules[4] = new String [] { "char_minus_"+nonterminalName+"_list", "char_minus_"+nonterminalName };
		customRules[5] = new String [] { "char_minus_"+nonterminalName+"_list_opt", "char_minus_"+nonterminalName+"_list" };
		customRules[6] = new String [] { "char_minus_"+nonterminalName+"_list_opt" /*nothing*/ };
		return hub.sam.tef.rcc.lexer.StandardLexerRules.catenizeRules(new String [][][] { sarr0, customRules });
	}

	@Override
	public String getRCCSymbol() {
		return "code";
	}

}
