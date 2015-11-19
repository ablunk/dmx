package hub.sam.dmx.editor.semantics;

import hub.sam.dbl.MetaSymbol;
import hub.sam.dbl.PlainSymbolReference;
import hub.sam.dbl.StructuralSymbolReference;
import hub.sam.dbl.SymbolSequence;
import hub.sam.dbl.SyntaxDefinition;
import hub.sam.dbl.SyntaxExpression;
import hub.sam.dbl.SyntaxSymbolClassifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PullUpAttributesToBaseHelper {
	
	private SyntaxDefinition syntaxDefinition;
	private Map<String, List<MetaSymbol>> allSymbols;
	private Map<String, List<MetaSymbol>> baseSymbols = new HashMap<>();
	
	public PullUpAttributesToBaseHelper(SyntaxDefinition syntaxDefinition) {
		this.syntaxDefinition = syntaxDefinition;
		
		allSymbols = syntaxDefinition.getSymbols().stream().collect(Collectors.groupingBy(metaSymbol -> metaSymbol.getName()));

		allSymbols.entrySet().stream()
				.filter(entry -> entry.getValue().stream()
						.allMatch(symbol -> {
							if (symbol.getPossibleSyntax() instanceof SymbolSequence) {
								SymbolSequence symbolSequence = (SymbolSequence) symbol.getPossibleSyntax();
								if (symbolSequence.getSequence().size() == 1) {
									SyntaxExpression singleItem = symbolSequence.getSequence().get(0);
									return singleItem instanceof PlainSymbolReference
											&& !(singleItem instanceof StructuralSymbolReference)
											&& ((PlainSymbolReference) singleItem).getClassifier() instanceof MetaSymbol;
								}
							}
							return false;
						}
					)).forEach(entry -> baseSymbols.put(entry.getKey(), entry.getValue()));
	}
	
	public void pullAttributesToBase() {
		Map<String, List<String>> structuralSymbolRefNameOccurencesInMetaSymbolNames = new HashMap<>();
		syntaxDefinition.getSymbols().stream()
			.forEach(symbol -> addStructuralSymbolRefs(symbol.getPossibleSyntax(), structuralSymbolRefNameOccurencesInMetaSymbolNames));
	}
	
	public void addStructuralSymbolRefs(SyntaxExpression syntaxExpr, Map<String, List<String>> structuralSymbolRefNameOccurences) {
		if (syntaxExpr instanceof SymbolSequence) {
			SymbolSequence symbolSequence = (SymbolSequence) syntaxExpr;
			symbolSequence.getSequence().stream().forEach(subExpr -> addStructuralSymbolRefs(subExpr, structuralSymbolRefNameOccurences));
		}
		else if (syntaxExpr instanceof PlainSymbolReference) {
			PlainSymbolReference plainSymbolRef = (PlainSymbolReference) syntaxExpr;
			SyntaxSymbolClassifier classifier = plainSymbolRef.getClassifier();
			if (classifier instanceof MetaSymbol) {
				MetaSymbol referencedMetaSymbol = (MetaSymbol) classifier;
				// TODO
			}
			addStructuralSymbolRefs(syntaxExpr, structuralSymbolRefNameOccurences);
		}
	}
}
