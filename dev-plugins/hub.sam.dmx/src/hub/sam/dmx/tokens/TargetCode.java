/*
 * Textual Editing Framework (TEF)
 * Copyright (C) 2008, 2009 Dirk Fahland
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; 
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 */

package hub.sam.dmx.tokens;

import hub.sam.tef.contentassist.ContentAssistContext;
import hub.sam.tef.contentassist.ContentAssistProposal;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.prettyprinting.PrettyPrintState;
import hub.sam.tef.prettyprinting.PrettyPrinter;
import hub.sam.tef.primitivetypes.PrimitiveTypeDescriptor;
import hub.sam.tef.rcc.syntax.Rule;
import hub.sam.tef.rcc.syntax.Syntax;
import hub.sam.tef.semantics.IContentAssistSemantics;
import hub.sam.tef.semantics.IValueCreationSemantics;
import hub.sam.tef.semantics.IValuePrintSemantics;
import hub.sam.tef.tokens.StandardLexerRules;
import hub.sam.tef.tsl.ValueBinding;

import java.util.Collection;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public abstract class TargetCode extends PrimitiveTypeDescriptor {
	
	private final IValueCreationSemantics valueCreationSemantics = new IValueCreationSemantics() {
		public Object createValue(ParseTreeNode parseTreeNode,
				IModelCreatingContext context, ValueBinding binding)
				throws ModelCreatingException {
			
			String stringValue = parseTreeNode.getNodeText();
			if (stringValue.equals("")) {
				return null;
			} else {
				return stringValue.substring(getStartSeq().length(), stringValue.length() - getEndSeq().length());
			}
		}		
	};
	
	@Override
	public IValueCreationSemantics getValueCreationSemantics() {
		return valueCreationSemantics;
	}
	
	protected Syntax lexerSyntax = null;
	
	protected abstract String getStartSeq();
	protected abstract String getEndSeq();

	/**
	 * construct scanner rules from external syntax file EtslActionParamtere.syntax
	 * 
	 * TODO create java class that construct scanner rules
	 */
	protected void constructScannerRules () {
		try {
			lexerSyntax = new Syntax(StandardLexerRules.getCustomMultiLineBracketRules(getNonTerminalName(), getStartSeq(), getEndSeq()));
			//SyntaxSeparation separation = new SyntaxSeparation(syntax);
			//lexerSyntax = separation.getLexerSyntax();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * construct scanner rules and return array of the rules
	 */
	@Override
	protected Rule[] getAdditionalRCCRules() {
		constructScannerRules();
		
		Rule[] rules = new Rule[lexerSyntax.size()];
		for (int i=0;i<lexerSyntax.size();i++)
			rules[i] = lexerSyntax.getRule(i);
		
		return rules;
	}
	
	@Override
	public IContentAssistSemantics getContentAssistSemantics() {
		return new IContentAssistSemantics() {			
			public Collection<ContentAssistProposal> createProposals(
					ContentAssistContext context) {
				return ContentAssistProposal.createProposals(
						new String[] { getStartSeq() + " ... " + getEndSeq() }, context,  
						null, ContentAssistProposal.PRIMITIVE_IMAGE, ContentAssistProposal.PRIMITIVE);
			}			
		};
	}
	
	@Override
	public IValuePrintSemantics getValuePrintSemantics() {
		return new IValuePrintSemantics() {
			public boolean printValue(Object modelValue, ValueBinding binding, 
					PrettyPrintState state, PrettyPrinter printer) throws ModelCreatingException {
				if (modelValue != null) {
					state.append(getStartSeq() + modelValue.toString() + getEndSeq());
					return true;
				} else {
					return false;
				}
			}					
		};
	}

	@Override
	public IRule getHighlightRule() {
		return new MultiLineRule(getStartSeq(), getEndSeq(), new Token(new TextAttribute(
				new Color(Display.getCurrent(), new RGB(63,63,191)),
				new Color(Display.getCurrent(),new RGB(230,230,230)), 
				SWT.NORMAL)));
	}

}
