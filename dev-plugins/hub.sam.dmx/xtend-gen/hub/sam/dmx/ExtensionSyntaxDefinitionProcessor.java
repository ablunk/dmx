package hub.sam.dmx;

import com.google.common.base.Objects;
import hub.sam.dbl.BooleanPropertyType;
import hub.sam.dbl.CompositePropertyType;
import hub.sam.dbl.DblPackage;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.IdPropertyType;
import hub.sam.dbl.IntPropertyType;
import hub.sam.dbl.L1RhsExpr;
import hub.sam.dbl.LanguageConceptClassifier;
import hub.sam.dbl.LanguageConstructClassifier;
import hub.sam.dbl.PropertyBindingExpr;
import hub.sam.dbl.PropertyType;
import hub.sam.dbl.ReferencePropertyType;
import hub.sam.dbl.RhsClassifierExpr;
import hub.sam.dbl.RhsExpression;
import hub.sam.dbl.SequenceExpr;
import hub.sam.dbl.StringPropertyType;
import hub.sam.dbl.TerminalExpr;
import hub.sam.dbl.TextualSyntaxDef;
import hub.sam.dbl.TsRule;
import hub.sam.dmx.DuplicatedRulesContainer;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ConstantBinding;
import hub.sam.tef.tsl.ElementBinding;
import hub.sam.tef.tsl.FixTerminal;
import hub.sam.tef.tsl.NonTerminal;
import hub.sam.tef.tsl.PropertyBinding;
import hub.sam.tef.tsl.ReferenceBinding;
import hub.sam.tef.tsl.Rule;
import hub.sam.tef.tsl.SimpleRule;
import hub.sam.tef.tsl.Symbol;
import hub.sam.tef.tsl.Syntax;
import hub.sam.tef.tsl.TslFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ExtensionSyntaxDefinitionProcessor {
  private final Collection<Rule> addedRules = new HashSet<Rule>();
  
  private final Collection<EClass> addedMetaClasses = new HashSet<EClass>();
  
  private final Map<String, EClass> allMetaClasses = new HashMap<String, EClass>();
  
  private final Collection<TsRule> processedRules = new HashSet<TsRule>();
  
  private final Map<String, DuplicatedRulesContainer> duplicatedRules = new HashMap<String, DuplicatedRulesContainer>();
  
  private final Collection<TsRule> completelyProcessedRules = new HashSet<TsRule>();
  
  private ExtensionDefinition extensionDefinition;
  
  private Syntax _syntax;
  
  private DblPackage _dblMetaModel;
  
  private EClass _extendedConceptMetaClass;
  
  private EClass _instantiableDblEClass;
  
  private final Logger logger = Logger.getLogger(ExtensionSyntaxDefinitionProcessor.class.getName());
  
  public ExtensionSyntaxDefinitionProcessor(final ExtensionDefinition extensionDefinition, final Syntax syntax, final DblPackage dblMetaModel) {
    this.extensionDefinition = extensionDefinition;
    this._syntax = syntax;
    this._dblMetaModel = dblMetaModel;
  }
  
  private Syntax getSyntax() {
    return this._syntax;
  }
  
  private DblPackage getDblMetaModel() {
    return this._dblMetaModel;
  }
  
  public boolean addToDbl() {
    TextualSyntaxDef _textualSyntaxDef = this.extensionDefinition.getTextualSyntaxDef();
    TsRule _startRule = _textualSyntaxDef.getStartRule();
    boolean _notEquals = (!Objects.equal(_startRule, null));
    if (_notEquals) {
      TextualSyntaxDef _textualSyntaxDef_1 = this.extensionDefinition.getTextualSyntaxDef();
      final TsRule startRule = _textualSyntaxDef_1.getStartRule();
      final SimpleRule startTslRule = TslFactory.eINSTANCE.createSimpleRule();
      LanguageConceptClassifier _extendedConcept = this.extensionDefinition.getExtendedConcept();
      final NonTerminal startNonTerminal = this.createNonTerminal(_extendedConcept);
      startTslRule.setLhs(startNonTerminal);
      EList<Symbol> _rhs = startTslRule.getRhs();
      NonTerminal _createNonTerminal = this.createNonTerminal(startRule);
      _rhs.add(_createNonTerminal);
      Syntax _syntax = this.getSyntax();
      EList<Rule> _rules = _syntax.getRules();
      _rules.add(startTslRule);
      this.addedRules.add(startTslRule);
      final Stack<TsRule> ruleStack = new Stack<TsRule>();
      TextualSyntaxDef _textualSyntaxDef_2 = this.extensionDefinition.getTextualSyntaxDef();
      EList<TsRule> _rules_1 = _textualSyntaxDef_2.getRules();
      TsRule _get = _rules_1.get(0);
      this.processAllRulesWithSameName(_get, null, ruleStack);
      do {
        {
          final Map<String, DuplicatedRulesContainer> processingDuplicatedRules = new HashMap<String, DuplicatedRulesContainer>(this.duplicatedRules);
          this.duplicatedRules.clear();
          Set<String> _keySet = processingDuplicatedRules.keySet();
          for (final String ruleName : _keySet) {
            {
              TextualSyntaxDef _textualSyntaxDef_3 = this.extensionDefinition.getTextualSyntaxDef();
              EList<TsRule> _rules_2 = _textualSyntaxDef_3.getRules();
              DuplicatedRulesContainer _get_1 = processingDuplicatedRules.get(ruleName);
              _rules_2.addAll(_get_1.rules);
              DuplicatedRulesContainer _get_2 = processingDuplicatedRules.get(ruleName);
              this.processAllRulesWithSameName(ruleName, _get_2.metaClass, ruleStack);
            }
          }
        }
      } while((this.duplicatedRules.size() > 0));
      return true;
    }
    return false;
  }
  
  public void revert() {
    for (final Rule rule : this.addedRules) {
      EObject _eContainer = rule.eContainer();
      EList<Rule> _rules = ((Syntax) _eContainer).getRules();
      _rules.remove(rule);
    }
    for (final EClass metaClass : this.addedMetaClasses) {
      EPackage _ePackage = metaClass.getEPackage();
      EList<EClassifier> _eClassifiers = _ePackage.getEClassifiers();
      _eClassifiers.remove(metaClass);
    }
  }
  
  private NonTerminal _createNonTerminal(final EObject object) {
    throw new RuntimeException();
  }
  
  private NonTerminal _createNonTerminal(final TsRule rule) {
    final NonTerminal nonTerminal = TslFactory.eINSTANCE.createNonTerminal();
    String _syntaxRuleName = this.getSyntaxRuleName(rule);
    nonTerminal.setName(_syntaxRuleName);
    return nonTerminal;
  }
  
  private NonTerminal _createNonTerminal(final ExtensionDefinition extDef) {
    final NonTerminal nonTerminal = TslFactory.eINSTANCE.createNonTerminal();
    String _syntaxRuleName = this.getSyntaxRuleName(extDef);
    nonTerminal.setName(_syntaxRuleName);
    return nonTerminal;
  }
  
  private NonTerminal _createNonTerminal(final hub.sam.dbl.Class clazz) {
    final NonTerminal nonTerminal = TslFactory.eINSTANCE.createNonTerminal();
    String _syntaxRuleName = this.getSyntaxRuleName(clazz);
    nonTerminal.setName(_syntaxRuleName);
    return nonTerminal;
  }
  
  private String _getSyntaxRuleName(final EObject object) {
    throw new RuntimeException();
  }
  
  private String _getSyntaxRuleName(final TsRule rule) {
    EObject _eContainer = rule.eContainer();
    EObject _eContainer_1 = null;
    if (((TextualSyntaxDef) _eContainer)!=null) {
      _eContainer_1=((TextualSyntaxDef) _eContainer).eContainer();
    }
    final ExtensionDefinition extDef = ((ExtensionDefinition) _eContainer_1);
    String _xifexpression = null;
    boolean _notEquals = (!Objects.equal(extDef, null));
    if (_notEquals) {
      _xifexpression = extDef.getName();
    } else {
      _xifexpression = this.extensionDefinition.getName();
    }
    String _plus = (_xifexpression + "_");
    String _name = rule.getName();
    String _plus_1 = (_plus + _name);
    return (_plus_1 + "_extension");
  }
  
  private String _getSyntaxRuleName(final ExtensionDefinition referencedExtDef) {
    return ExtensionSyntaxDefinitionProcessor.getExtensionDefinitionSyntaxRuleName(referencedExtDef);
  }
  
  public static String getExtensionDefinitionSyntaxRuleName(final ExtensionDefinition extDef) {
    String _name = extDef.getName();
    String _plus = (_name + "_");
    TextualSyntaxDef _textualSyntaxDef = extDef.getTextualSyntaxDef();
    TsRule _startRule = _textualSyntaxDef.getStartRule();
    String _name_1 = _startRule.getName();
    String _plus_1 = (_plus + _name_1);
    return (_plus_1 + "_extension");
  }
  
  private String _getSyntaxRuleName(final hub.sam.dbl.Class clazz) {
    return clazz.getName();
  }
  
  private void processAllRulesWithSameName(final TsRule newRule, final EClass metaClass, final Stack<TsRule> ruleStack) {
    String _name = newRule.getName();
    this.processAllRulesWithSameName(_name, metaClass, ruleStack);
  }
  
  private void processAllRulesWithSameName(final String ruleName, final EClass metaClass, final Stack<TsRule> ruleStack) {
    TextualSyntaxDef _textualSyntaxDef = this.extensionDefinition.getTextualSyntaxDef();
    EList<TsRule> _rules = _textualSyntaxDef.getRules();
    for (final TsRule otherRule : _rules) {
      boolean _and = false;
      String _name = otherRule.getName();
      boolean _equals = _name.equals(ruleName);
      if (!_equals) {
        _and = false;
      } else {
        boolean _contains = this.completelyProcessedRules.contains(otherRule);
        boolean _not = (!_contains);
        _and = _not;
      }
      if (_and) {
        this.processSingleRule(otherRule, metaClass, ruleStack);
        this.completelyProcessedRules.add(otherRule);
      }
    }
  }
  
  private SimpleRule createTslRule(final TsRule rule) {
    final NonTerminal nonTerminal = this.createNonTerminal(rule);
    final SimpleRule tslRule = TslFactory.eINSTANCE.createSimpleRule();
    tslRule.setLhs(nonTerminal);
    Syntax _syntax = this.getSyntax();
    EList<Rule> _rules = _syntax.getRules();
    _rules.add(tslRule);
    this.addedRules.add(tslRule);
    this.processedRules.add(rule);
    return tslRule;
  }
  
  private EClass getExtendedConceptMetaClass() {
    boolean _equals = Objects.equal(this._extendedConceptMetaClass, null);
    if (_equals) {
      LanguageConceptClassifier _extendedConcept = this.extensionDefinition.getExtendedConcept();
      EClass _metaClass = this.getMetaClass(_extendedConcept);
      this._extendedConceptMetaClass = _metaClass;
    }
    return this._extendedConceptMetaClass;
  }
  
  private EClass getInstantiableDblEClass() {
    boolean _equals = Objects.equal(this._instantiableDblEClass, null);
    if (_equals) {
      LanguageConceptClassifier conceptClassifier = this.extensionDefinition.getExtendedConcept();
      while ((conceptClassifier instanceof ExtensionDefinition)) {
        LanguageConceptClassifier _extendedConcept = ((ExtensionDefinition) conceptClassifier).getExtendedConcept();
        conceptClassifier = _extendedConcept;
      }
      EClass _metaClass = this.getMetaClass(((hub.sam.dbl.Class) conceptClassifier));
      this._instantiableDblEClass = _metaClass;
    }
    return this._instantiableDblEClass;
  }
  
  private EClass _getMetaClass(final hub.sam.dbl.Class conceptClassifier) {
    String _syntaxRuleName = this.getSyntaxRuleName(conceptClassifier);
    return this._getMetaClass_general(_syntaxRuleName, conceptClassifier);
  }
  
  private EClass _getMetaClass(final ExtensionDefinition conceptClassifier) {
    String _syntaxRuleName = this.getSyntaxRuleName(conceptClassifier);
    return this._getMetaClass_general(_syntaxRuleName, conceptClassifier);
  }
  
  private EClass _getMetaClass(final TsRule rule) {
    String _syntaxRuleName = this.getSyntaxRuleName(rule);
    return this._getMetaClass_general(_syntaxRuleName, rule);
  }
  
  private EClass _getMetaClass_general(final String name, final LanguageConstructClassifier langConstructClassifier) {
    boolean _containsKey = this.allMetaClasses.containsKey(name);
    if (_containsKey) {
      return this.allMetaClasses.get(name);
    } else {
      EClass metaClass = null;
      DblPackage _dblMetaModel = this.getDblMetaModel();
      final EClassifier metaClassifier = _dblMetaModel.getEClassifier(name);
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(metaClassifier, null));
      if (!_notEquals) {
        _and = false;
      } else {
        _and = (metaClassifier instanceof EClass);
      }
      if (_and) {
        metaClass = ((EClass) metaClassifier);
        int _classifierID = metaClass.getClassifierID();
        String _plus = ("using existing meta-class with classifier-ID " + Integer.valueOf(_classifierID));
        this.logger.info(_plus);
      } else {
        this.logger.info(("creating new meta-class " + name));
        EClass _createEClass = EcoreFactory.eINSTANCE.createEClass();
        metaClass = _createEClass;
        metaClass.setName(name);
        if ((langConstructClassifier instanceof ExtensionDefinition)) {
          LanguageConceptClassifier conceptClassifier = ((ExtensionDefinition) langConstructClassifier).getExtendedConcept();
          while ((conceptClassifier instanceof ExtensionDefinition)) {
            LanguageConceptClassifier _extendedConcept = ((ExtensionDefinition) conceptClassifier).getExtendedConcept();
            conceptClassifier = _extendedConcept;
          }
          EList<EClass> _eSuperTypes = metaClass.getESuperTypes();
          EClass _metaClass = this.getMetaClass(((hub.sam.dbl.Class) conceptClassifier));
          _eSuperTypes.add(_metaClass);
        } else {
          EList<EClass> _eSuperTypes_1 = metaClass.getESuperTypes();
          EClass _instantiableDblEClass = this.getInstantiableDblEClass();
          _eSuperTypes_1.add(_instantiableDblEClass);
        }
        EList<EClass> _eSuperTypes_2 = metaClass.getESuperTypes();
        EClass _extendedConceptMetaClass = this.getExtendedConceptMetaClass();
        _eSuperTypes_2.add(_extendedConceptMetaClass);
        final EClass fMetaClass = metaClass;
        TextualSyntaxDef _textualSyntaxDef = this.extensionDefinition.getTextualSyntaxDef();
        EList<TsRule> _rules = _textualSyntaxDef.getRules();
        final Function1<TsRule, Boolean> _function = new Function1<TsRule, Boolean>() {
          public Boolean apply(final TsRule it) {
            boolean _and = false;
            boolean _and_1 = false;
            RhsExpression _rhs = it.getRhs();
            if (!(_rhs instanceof SequenceExpr)) {
              _and_1 = false;
            } else {
              RhsExpression _rhs_1 = it.getRhs();
              EList<RhsExpression> _sequence = ((SequenceExpr) _rhs_1).getSequence();
              int _size = _sequence.size();
              boolean _equals = (_size == 1);
              _and_1 = _equals;
            }
            if (!_and_1) {
              _and = false;
            } else {
              RhsExpression _rhs_2 = it.getRhs();
              EList<RhsExpression> _sequence_1 = ((SequenceExpr) _rhs_2).getSequence();
              RhsExpression _get = _sequence_1.get(0);
              _and = (_get instanceof RhsClassifierExpr);
            }
            return Boolean.valueOf(_and);
          }
        };
        Iterable<TsRule> _filter = IterableExtensions.<TsRule>filter(_rules, _function);
        final Procedure1<TsRule> _function_1 = new Procedure1<TsRule>() {
          public void apply(final TsRule directReductionRule) {
            RhsExpression _rhs = directReductionRule.getRhs();
            EList<RhsExpression> _sequence = ((SequenceExpr) _rhs).getSequence();
            RhsExpression _get = _sequence.get(0);
            final LanguageConstructClassifier directReductionConstructClassifier = ((RhsClassifierExpr) _get).getClassifier();
            String _name = directReductionConstructClassifier.getName();
            boolean _equals = _name.equals(name);
            if (_equals) {
              final EClass superMetaClass = ExtensionSyntaxDefinitionProcessor.this.getMetaClass(directReductionRule);
              EList<EClass> _eSuperTypes = fMetaClass.getESuperTypes();
              _eSuperTypes.add(superMetaClass);
              ExtensionSyntaxDefinitionProcessor.this.logger.info(((("added super-class " + superMetaClass) + " to meta-class ") + name));
            }
          }
        };
        IterableExtensions.<TsRule>forEach(_filter, _function_1);
        DblPackage _dblMetaModel_1 = this.getDblMetaModel();
        EList<EClassifier> _eClassifiers = _dblMetaModel_1.getEClassifiers();
        _eClassifiers.add(metaClass);
        this.addedMetaClasses.add(metaClass);
      }
      this.allMetaClasses.put(name, metaClass);
      return metaClass;
    }
  }
  
  private void _processRhsExpr(final TerminalExpr rhsExpr, final SimpleRule tslRule, final EClass metaClass, final Stack<TsRule> ruleStack) {
    final FixTerminal fixTerminal = TslFactory.eINSTANCE.createFixTerminal();
    String _terminal = rhsExpr.getTerminal();
    fixTerminal.setTerminal(_terminal);
    EList<Symbol> _rhs = tslRule.getRhs();
    _rhs.add(fixTerminal);
  }
  
  private void _processRhsExpr(final RhsClassifierExpr rhsExpr, final SimpleRule tslRule, final EClass _metaClass, final Stack<TsRule> ruleStack) {
    final LanguageConstructClassifier type = rhsExpr.getClassifier();
    EClass metaClass = _metaClass;
    boolean _matched = false;
    if (!_matched) {
      if (type instanceof ExtensionDefinition) {
        _matched=true;
        EList<Symbol> _rhs = tslRule.getRhs();
        NonTerminal _createNonTerminal = this.createNonTerminal(type);
        _rhs.add(_createNonTerminal);
      }
    }
    if (!_matched) {
      if (type instanceof hub.sam.dbl.Class) {
        _matched=true;
        Syntax _syntax = this.getSyntax();
        EList<Rule> _rules = _syntax.getRules();
        final Function1<Rule, Boolean> _function = new Function1<Rule, Boolean>() {
          public Boolean apply(final Rule it) {
            NonTerminal _lhs = it.getLhs();
            String _name = _lhs.getName();
            String _name_1 = ((hub.sam.dbl.Class)type).getName();
            return Boolean.valueOf(_name.equals(_name_1));
          }
        };
        final Rule firstRuleWithClassName = IterableExtensions.<Rule>findFirst(_rules, _function);
        if ((firstRuleWithClassName instanceof SimpleRule)) {
          SimpleRule actualRule = ((SimpleRule) firstRuleWithClassName);
          boolean _and = false;
          boolean _and_1 = false;
          EList<Symbol> _rhs = actualRule.getRhs();
          int _size = _rhs.size();
          boolean _equals = (_size == 1);
          if (!_equals) {
            _and_1 = false;
          } else {
            EList<Symbol> _rhs_1 = actualRule.getRhs();
            Symbol _head = IterableExtensions.<Symbol>head(_rhs_1);
            _and_1 = (_head instanceof NonTerminal);
          }
          if (!_and_1) {
            _and = false;
          } else {
            EList<Symbol> _rhs_2 = actualRule.getRhs();
            Symbol _head_1 = IterableExtensions.<Symbol>head(_rhs_2);
            PropertyBinding _propertyBinding = _head_1.getPropertyBinding();
            boolean _equals_1 = Objects.equal(_propertyBinding, null);
            _and = _equals_1;
          }
          if (_and) {
            final SimpleRule fActualRule = actualRule;
            Syntax _syntax_1 = this.getSyntax();
            EList<Rule> _rules_1 = _syntax_1.getRules();
            final Function1<Rule, Boolean> _function_1 = new Function1<Rule, Boolean>() {
              public Boolean apply(final Rule it) {
                NonTerminal _lhs = it.getLhs();
                String _name = _lhs.getName();
                EList<Symbol> _rhs = fActualRule.getRhs();
                Symbol _head = IterableExtensions.<Symbol>head(_rhs);
                String _name_1 = ((NonTerminal) _head).getName();
                return Boolean.valueOf(_name.equals(_name_1));
              }
            };
            Rule _findFirst = IterableExtensions.<Rule>findFirst(_rules_1, _function_1);
            actualRule = ((SimpleRule) _findFirst);
          }
          final EcoreUtil.Copier copier = new EcoreUtil.Copier();
          EList<Symbol> _rhs_3 = actualRule.getRhs();
          final Collection<Symbol> rhsCopy = copier.<Symbol>copyAll(_rhs_3);
          copier.copyReferences();
          EList<Symbol> _rhs_4 = tslRule.getRhs();
          _rhs_4.addAll(rhsCopy);
        }
      }
    }
    if (!_matched) {
      if (type instanceof TsRule) {
        _matched=true;
        TsRule rule = ((TsRule)type);
        final EObject rhsContainer = rhsExpr.eContainer();
        if ((rhsContainer instanceof SequenceExpr)) {
          final SequenceExpr sequenceExpr = ((SequenceExpr) rhsContainer);
          EList<RhsExpression> _sequence = sequenceExpr.getSequence();
          int _size = _sequence.size();
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            boolean _and = false;
            boolean _contains = this.processedRules.contains(rule);
            if (!_contains) {
              _and = false;
            } else {
              boolean _contains_1 = ruleStack.contains(rule);
              boolean _not = (!_contains_1);
              _and = _not;
            }
            if (_and) {
              String _syntaxRuleName = this.getSyntaxRuleName(type);
              String _plus = (_syntaxRuleName + "_");
              String _name = metaClass.getName();
              final String dupRuleName = (_plus + _name);
              final Function1<TsRule, Boolean> _function = new Function1<TsRule, Boolean>() {
                public Boolean apply(final TsRule it) {
                  String _name = it.getName();
                  return Boolean.valueOf(_name.equals(dupRuleName));
                }
              };
              final TsRule dupRule = IterableExtensions.<TsRule>findFirst(this.processedRules, _function);
              boolean _notEquals = (!Objects.equal(dupRule, null));
              if (_notEquals) {
                EList<Symbol> _rhs = tslRule.getRhs();
                NonTerminal _createNonTerminal = this.createNonTerminal(dupRule);
                _rhs.add(_createNonTerminal);
              } else {
                final DuplicatedRulesContainer duplicatedRules = new DuplicatedRulesContainer();
                duplicatedRules.metaClass = metaClass;
                final TsRule fRule = rule;
                TextualSyntaxDef _textualSyntaxDef = this.extensionDefinition.getTextualSyntaxDef();
                EList<TsRule> _rules = _textualSyntaxDef.getRules();
                final Function1<TsRule, Boolean> _function_1 = new Function1<TsRule, Boolean>() {
                  public Boolean apply(final TsRule it) {
                    String _name = it.getName();
                    String _name_1 = fRule.getName();
                    return Boolean.valueOf(_name.equals(_name_1));
                  }
                };
                final Iterable<TsRule> sameNameRules = IterableExtensions.<TsRule>filter(_rules, _function_1);
                TsRule ruleDefDuplicate = null;
                for (final TsRule ruleDef : sameNameRules) {
                  {
                    TsRule _copy = EcoreUtil.<TsRule>copy(ruleDef);
                    ruleDefDuplicate = _copy;
                    ruleDefDuplicate.setName(dupRuleName);
                    duplicatedRules.rules.add(ruleDefDuplicate);
                    this.processedRules.add(ruleDefDuplicate);
                    String _name_1 = ruleDefDuplicate.getName();
                    String _plus_1 = ("created duplicate rule: " + _name_1);
                    this.logger.info(_plus_1);
                  }
                }
                this.duplicatedRules.put(dupRuleName, duplicatedRules);
                rule = ruleDefDuplicate;
              }
            }
          } else {
            EList<RhsExpression> _sequence_1 = sequenceExpr.getSequence();
            int _size_1 = _sequence_1.size();
            boolean _equals = (_size_1 == 1);
            if (_equals) {
              tslRule.setValueBinding(null);
              metaClass = null;
            }
          }
          EList<Symbol> _rhs_1 = tslRule.getRhs();
          NonTerminal _createNonTerminal_1 = this.createNonTerminal(rule);
          _rhs_1.add(_createNonTerminal_1);
          this.processAllRulesWithSameName(rule, metaClass, ruleStack);
        }
      }
    }
  }
  
  private void _processRhsExpr(final PropertyBindingExpr rhsExpr, final SimpleRule tslRule, final EClass metaClass, final Stack<TsRule> ruleStack) {
    PropertyType _propertyType = rhsExpr.getPropertyType();
    this.processPropertyType(_propertyType, tslRule, rhsExpr, metaClass, ruleStack);
  }
  
  private void _processPropertyType(final BooleanPropertyType propertyType, final SimpleRule tslRule, final PropertyBindingExpr bindingExpr, final EClass metaClass, final Stack<TsRule> ruleStack) {
    String _name = bindingExpr.getName();
    final EAttribute metaClassAttribute = this.createAttribute(_name, metaClass);
    metaClassAttribute.setEType(EcorePackage.Literals.EBOOLEAN);
    String _name_1 = this.extensionDefinition.getName();
    String _plus = (_name_1 + "_");
    NonTerminal _lhs = tslRule.getLhs();
    String _name_2 = _lhs.getName();
    String _plus_1 = (_plus + _name_2);
    String _plus_2 = (_plus_1 + "_");
    String _name_3 = bindingExpr.getName();
    final String constantRuleName = (_plus_2 + _name_3);
    final ConstantBinding constantBinding = TslFactory.eINSTANCE.createConstantBinding();
    constantBinding.setType("EBoolean");
    constantBinding.setValue("true");
    final NonTerminal lhsNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
    lhsNonTerminal.setName(constantRuleName);
    final SimpleRule constantRule = TslFactory.eINSTANCE.createSimpleRule();
    constantRule.setLhs(lhsNonTerminal);
    constantRule.setValueBinding(constantBinding);
    Syntax _syntax = this.getSyntax();
    EList<Rule> _rules = _syntax.getRules();
    _rules.add(constantRule);
    this.addedRules.add(constantRule);
    final FixTerminal rhsNonTerminal = TslFactory.eINSTANCE.createFixTerminal();
    String _terminal = propertyType.getTerminal();
    rhsNonTerminal.setTerminal(_terminal);
    EList<Symbol> _rhs = constantRule.getRhs();
    _rhs.add(rhsNonTerminal);
    final CompositeBinding tslCompositeBinding = TslFactory.eINSTANCE.createCompositeBinding();
    tslCompositeBinding.setProperty(metaClassAttribute);
    final NonTerminal sourceNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
    sourceNonTerminal.setPropertyBinding(tslCompositeBinding);
    sourceNonTerminal.setName(constantRuleName);
    EList<Symbol> _rhs_1 = tslRule.getRhs();
    _rhs_1.add(sourceNonTerminal);
  }
  
  private void _processPropertyType(final IntPropertyType propertyType, final SimpleRule tslRule, final PropertyBindingExpr bindingExpr, final EClass metaClass, final Stack<TsRule> ruleStack) {
    final NonTerminal nonTerminal = this.createNonTerminal_for_PrimitivePropertyBinding(bindingExpr, EcorePackage.Literals.EINT, "INTEGER", metaClass);
    EList<Symbol> _rhs = tslRule.getRhs();
    _rhs.add(nonTerminal);
  }
  
  private void _processPropertyType(final StringPropertyType propertyType, final SimpleRule tslRule, final PropertyBindingExpr bindingExpr, final EClass metaClass, final Stack<TsRule> ruleStack) {
    final NonTerminal nonTerminal = this.createNonTerminal_for_PrimitivePropertyBinding(bindingExpr, EcorePackage.Literals.ESTRING, "STRINGDEF", metaClass);
    EList<Symbol> _rhs = tslRule.getRhs();
    _rhs.add(nonTerminal);
  }
  
  private void _processPropertyType(final IdPropertyType propertyType, final SimpleRule tslRule, final PropertyBindingExpr bindingExpr, final EClass metaClass, final Stack<TsRule> ruleStack) {
    EStructuralFeature metaClassFeature = null;
    EList<EStructuralFeature> _eAllStructuralFeatures = metaClass.getEAllStructuralFeatures();
    boolean _contains = _eAllStructuralFeatures.contains(DblPackage.Literals.NAMED_ELEMENT__NAME);
    boolean _not = (!_contains);
    if (_not) {
      EList<EClass> _eSuperTypes = metaClass.getESuperTypes();
      _eSuperTypes.add(DblPackage.Literals.NAMED_ELEMENT);
    }
    metaClassFeature = DblPackage.Literals.NAMED_ELEMENT__NAME;
    final CompositeBinding tslPropertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
    tslPropertyBinding.setProperty(metaClassFeature);
    final NonTerminal propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
    propertyNonTerminal.setPropertyBinding(tslPropertyBinding);
    propertyNonTerminal.setName("IDENTIFIER");
    EList<Symbol> _rhs = tslRule.getRhs();
    _rhs.add(propertyNonTerminal);
  }
  
  private void _processPropertyType(final ReferencePropertyType propertyType, final SimpleRule tslRule, final PropertyBindingExpr bindingExpr, final EClass metaClass, final Stack<TsRule> ruleStack) {
    boolean _isRawReference = propertyType.isRawReference();
    if (_isRawReference) {
      EList<Symbol> _rhs = tslRule.getRhs();
      LanguageConstructClassifier _type = propertyType.getType();
      NonTerminal _createNonTerminal_for_RawReferencePropertyBinding = this.createNonTerminal_for_RawReferencePropertyBinding(bindingExpr, _type, metaClass);
      _rhs.add(_createNonTerminal_for_RawReferencePropertyBinding);
    } else {
      EList<Symbol> _rhs_1 = tslRule.getRhs();
      NonTerminal _createNonTerminal_for_ReferencePropertyBinding = this.createNonTerminal_for_ReferencePropertyBinding(bindingExpr, propertyType, metaClass);
      _rhs_1.add(_createNonTerminal_for_ReferencePropertyBinding);
    }
  }
  
  private void _processPropertyType(final CompositePropertyType propertyType, final SimpleRule tslRule, final PropertyBindingExpr bindingExpr, final EClass metaClass, final Stack<TsRule> ruleStack) {
    EList<Symbol> _rhs = tslRule.getRhs();
    NonTerminal _createNonTerminal_for_CompositePropertyBinding = this.createNonTerminal_for_CompositePropertyBinding(bindingExpr, propertyType, metaClass);
    _rhs.add(_createNonTerminal_for_CompositePropertyBinding);
    LanguageConstructClassifier _type = propertyType.getType();
    if ((_type instanceof TsRule)) {
      LanguageConstructClassifier _type_1 = propertyType.getType();
      this.processAllRulesWithSameName(((TsRule) _type_1), null, ruleStack);
    }
  }
  
  private NonTerminal createNonTerminal_for_RawReferencePropertyBinding(final PropertyBindingExpr bindingExpr, final LanguageConstructClassifier type, final EClass metaClass) {
    String _name = bindingExpr.getName();
    final EReference reference = this.createReference(_name, metaClass);
    reference.setContainment(false);
    final EClass bindingMetaClass = this.getMetaClass(type);
    reference.setEType(bindingMetaClass);
    final NonTerminal propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
    final ReferenceBinding propertyBinding = TslFactory.eINSTANCE.createReferenceBinding();
    propertyBinding.setProperty(reference);
    propertyNonTerminal.setPropertyBinding(propertyBinding);
    String _syntaxRuleName = this.getSyntaxRuleName(type);
    final String refNonTerminalName = (_syntaxRuleName + "Ref");
    propertyNonTerminal.setName(refNonTerminalName);
    Syntax _syntax = this.getSyntax();
    EList<Rule> _rules = _syntax.getRules();
    final Function1<Rule, Boolean> _function = new Function1<Rule, Boolean>() {
      public Boolean apply(final Rule it) {
        NonTerminal _lhs = it.getLhs();
        String _name = _lhs.getName();
        return Boolean.valueOf(_name.equals(refNonTerminalName));
      }
    };
    Iterable<Rule> _filter = IterableExtensions.<Rule>filter(_rules, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(_filter);
    if (_isEmpty) {
      final NonTerminal refNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
      refNonTerminal.setName(refNonTerminalName);
      final SimpleRule refNonTerminalRule = TslFactory.eINSTANCE.createSimpleRule();
      refNonTerminalRule.setLhs(refNonTerminal);
      Syntax _syntax_1 = this.getSyntax();
      EList<Rule> _rules_1 = _syntax_1.getRules();
      _rules_1.add(refNonTerminalRule);
      this.addedRules.add(refNonTerminalRule);
      final NonTerminal idNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
      idNonTerminal.setName("IDENTIFIER");
      final CompositeBinding nameBinding = TslFactory.eINSTANCE.createCompositeBinding();
      EList<EAttribute> _eAllAttributes = bindingMetaClass.getEAllAttributes();
      final Function1<EAttribute, Boolean> _function_1 = new Function1<EAttribute, Boolean>() {
        public Boolean apply(final EAttribute it) {
          String _name = it.getName();
          return Boolean.valueOf(_name.equals("name"));
        }
      };
      Iterable<EAttribute> _filter_1 = IterableExtensions.<EAttribute>filter(_eAllAttributes, _function_1);
      final EAttribute nameAttribute = IterableExtensions.<EAttribute>head(_filter_1);
      boolean _notEquals = (!Objects.equal(nameAttribute, null));
      if (_notEquals) {
        nameBinding.setProperty(nameAttribute);
      } else {
        nameBinding.setProperty(DblPackage.Literals.NAMED_ELEMENT__NAME);
      }
      idNonTerminal.setPropertyBinding(nameBinding);
      EList<Symbol> _rhs = refNonTerminalRule.getRhs();
      _rhs.add(idNonTerminal);
      final ElementBinding propertyTypeBinding = TslFactory.eINSTANCE.createElementBinding();
      propertyTypeBinding.setMetaclass(bindingMetaClass);
      refNonTerminalRule.setValueBinding(propertyTypeBinding);
    }
    return propertyNonTerminal;
  }
  
  private NonTerminal createNonTerminal_for_ReferencePropertyBinding(final PropertyBindingExpr bindingExpr, final ReferencePropertyType type, final EClass metaClass) {
    String _name = bindingExpr.getName();
    final EReference reference = this.createReference(_name, metaClass);
    reference.setLowerBound(0);
    reference.setUpperBound(1);
    reference.setContainment(true);
    final EClass propertyType = DblPackage.Literals.ID_EXPR;
    final NonTerminal propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
    propertyNonTerminal.setName("IdExpr");
    EClassifier _eType = reference.getEType();
    boolean _equals = Objects.equal(_eType, null);
    if (_equals) {
      reference.setEType(propertyType);
    }
    final CompositeBinding propertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
    propertyBinding.setProperty(reference);
    propertyNonTerminal.setPropertyBinding(propertyBinding);
    return propertyNonTerminal;
  }
  
  private NonTerminal createNonTerminal_for_CompositePropertyBinding(final PropertyBindingExpr bindingExpr, final CompositePropertyType propertyType, final EClass metaClass) {
    String _name = bindingExpr.getName();
    final EReference property = this.createReference(_name, metaClass);
    property.setLowerBound(0);
    property.setUpperBound(1);
    property.setContainment(true);
    LanguageConstructClassifier _type = propertyType.getType();
    final NonTerminal propertyNonTerminal = this.createNonTerminal(_type);
    boolean _isList = propertyType.isList();
    if (_isList) {
      property.setUpperBound((-1));
    }
    LanguageConstructClassifier _type_1 = propertyType.getType();
    final EClass bindingMetaClass = this.getMetaClass(_type_1);
    EClassifier _eType = property.getEType();
    boolean _equals = Objects.equal(_eType, null);
    if (_equals) {
      property.setEType(bindingMetaClass);
    }
    final CompositeBinding propertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
    propertyBinding.setProperty(property);
    propertyNonTerminal.setPropertyBinding(propertyBinding);
    return propertyNonTerminal;
  }
  
  private NonTerminal createNonTerminal_for_PrimitivePropertyBinding(final PropertyBindingExpr bindingExpr, final EDataType propertyType, final String tslValueTypeName, final EClass metaClass) {
    String _name = bindingExpr.getName();
    final EAttribute metaClassAttribute = this.createAttribute(_name, metaClass);
    metaClassAttribute.setEType(propertyType);
    final CompositeBinding tslPropertyBinding = TslFactory.eINSTANCE.createCompositeBinding();
    tslPropertyBinding.setProperty(metaClassAttribute);
    final NonTerminal propertyNonTerminal = TslFactory.eINSTANCE.createNonTerminal();
    propertyNonTerminal.setPropertyBinding(tslPropertyBinding);
    propertyNonTerminal.setName(tslValueTypeName);
    return propertyNonTerminal;
  }
  
  private EAttribute createAttribute(final String name, final EClass metaClass) {
    final EStructuralFeature structuralFeature = this.findStructuralFeature(name, metaClass);
    boolean _notEquals = (!Objects.equal(structuralFeature, null));
    if (_notEquals) {
      if ((structuralFeature instanceof EAttribute)) {
        return ((EAttribute) structuralFeature);
      } else {
        throw new RuntimeException();
      }
    }
    final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
    attribute.setName(name);
    EList<EStructuralFeature> _eStructuralFeatures = metaClass.getEStructuralFeatures();
    _eStructuralFeatures.add(attribute);
    String _name = metaClass.getName();
    String _plus = ((("adding attribute \'" + name) + "\' to meta-class \'") + _name);
    String _plus_1 = (_plus + "\'");
    this.logger.info(_plus_1);
    return attribute;
  }
  
  private EReference createReference(final String name, final EClass metaClass) {
    final EStructuralFeature structuralFeature = this.findStructuralFeature(name, metaClass);
    boolean _notEquals = (!Objects.equal(structuralFeature, null));
    if (_notEquals) {
      if ((structuralFeature instanceof EReference)) {
        return ((EReference) structuralFeature);
      } else {
        throw new RuntimeException();
      }
    }
    final EReference reference = EcoreFactory.eINSTANCE.createEReference();
    reference.setName(name);
    EList<EStructuralFeature> _eStructuralFeatures = metaClass.getEStructuralFeatures();
    _eStructuralFeatures.add(reference);
    String _name = metaClass.getName();
    String _plus = ((("adding reference \'" + name) + "\' to meta-class \'") + _name);
    String _plus_1 = (_plus + "\'");
    this.logger.info(_plus_1);
    return reference;
  }
  
  private EStructuralFeature findStructuralFeature(final String name, final EClass metaClass) {
    EList<EStructuralFeature> _eAllStructuralFeatures = metaClass.getEAllStructuralFeatures();
    for (final EStructuralFeature feature : _eAllStructuralFeatures) {
      String _name = feature.getName();
      boolean _equals = _name.equals(name);
      if (_equals) {
        return feature;
      }
    }
    return null;
  }
  
  private void processSingleRule(final TsRule newRule, final EClass passedDownMetaClass, final Stack<TsRule> ruleStack) {
    boolean _contains = ruleStack.contains(newRule);
    boolean _not = (!_contains);
    if (_not) {
      this.processedRules.add(newRule);
      ruleStack.push(newRule);
      String _name = newRule.getName();
      String _plus = ("processing rule " + _name);
      this.logger.info(_plus);
      final SimpleRule tslRule = this.createTslRule(newRule);
      EClass bindingMetaClass = passedDownMetaClass;
      boolean _equals = Objects.equal(bindingMetaClass, null);
      if (_equals) {
        EClass _metaClass = this.getMetaClass(newRule);
        bindingMetaClass = _metaClass;
        final ElementBinding metaClassBinding = TslFactory.eINSTANCE.createElementBinding();
        metaClassBinding.setMetaclass(bindingMetaClass);
        tslRule.setValueBinding(metaClassBinding);
      }
      final RhsExpression rhs = newRule.getRhs();
      if ((rhs instanceof SequenceExpr)) {
        final SequenceExpr sequenceExpr = ((SequenceExpr) rhs);
        EList<RhsExpression> _sequence = sequenceExpr.getSequence();
        for (final RhsExpression sequencePart : _sequence) {
          {
            this.processRhsExpr(((L1RhsExpr) sequencePart), tslRule, bindingMetaClass, ruleStack);
            if ((sequencePart instanceof PropertyBindingExpr)) {
              final PropertyBindingExpr propertyBindingExpr = ((PropertyBindingExpr) sequencePart);
              PropertyType _propertyType = propertyBindingExpr.getPropertyType();
              if ((_propertyType instanceof CompositePropertyType)) {
                PropertyType _propertyType_1 = propertyBindingExpr.getPropertyType();
                final CompositePropertyType compositePropertyType = ((CompositePropertyType) _propertyType_1);
                LanguageConstructClassifier _type = compositePropertyType.getType();
                if ((_type instanceof TsRule)) {
                  LanguageConstructClassifier _type_1 = compositePropertyType.getType();
                  this.processAllRulesWithSameName(((TsRule) _type_1), null, ruleStack);
                }
              }
            }
          }
        }
      }
      ruleStack.pop();
      String _string = tslRule.toString();
      this.logger.info(_string);
    }
  }
  
  private NonTerminal createNonTerminal(final EObject clazz) {
    if (clazz instanceof hub.sam.dbl.Class) {
      return _createNonTerminal((hub.sam.dbl.Class)clazz);
    } else if (clazz instanceof ExtensionDefinition) {
      return _createNonTerminal((ExtensionDefinition)clazz);
    } else if (clazz instanceof TsRule) {
      return _createNonTerminal((TsRule)clazz);
    } else if (clazz != null) {
      return _createNonTerminal(clazz);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(clazz).toString());
    }
  }
  
  private String getSyntaxRuleName(final EObject clazz) {
    if (clazz instanceof hub.sam.dbl.Class) {
      return _getSyntaxRuleName((hub.sam.dbl.Class)clazz);
    } else if (clazz instanceof ExtensionDefinition) {
      return _getSyntaxRuleName((ExtensionDefinition)clazz);
    } else if (clazz instanceof TsRule) {
      return _getSyntaxRuleName((TsRule)clazz);
    } else if (clazz != null) {
      return _getSyntaxRuleName(clazz);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(clazz).toString());
    }
  }
  
  private EClass getMetaClass(final LanguageConstructClassifier conceptClassifier) {
    if (conceptClassifier instanceof hub.sam.dbl.Class) {
      return _getMetaClass((hub.sam.dbl.Class)conceptClassifier);
    } else if (conceptClassifier instanceof ExtensionDefinition) {
      return _getMetaClass((ExtensionDefinition)conceptClassifier);
    } else if (conceptClassifier instanceof TsRule) {
      return _getMetaClass((TsRule)conceptClassifier);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(conceptClassifier).toString());
    }
  }
  
  private void processRhsExpr(final L1RhsExpr rhsExpr, final SimpleRule tslRule, final EClass metaClass, final Stack<TsRule> ruleStack) {
    if (rhsExpr instanceof PropertyBindingExpr) {
      _processRhsExpr((PropertyBindingExpr)rhsExpr, tslRule, metaClass, ruleStack);
      return;
    } else if (rhsExpr instanceof RhsClassifierExpr) {
      _processRhsExpr((RhsClassifierExpr)rhsExpr, tslRule, metaClass, ruleStack);
      return;
    } else if (rhsExpr instanceof TerminalExpr) {
      _processRhsExpr((TerminalExpr)rhsExpr, tslRule, metaClass, ruleStack);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(rhsExpr, tslRule, metaClass, ruleStack).toString());
    }
  }
  
  private void processPropertyType(final PropertyType propertyType, final SimpleRule tslRule, final PropertyBindingExpr bindingExpr, final EClass metaClass, final Stack<TsRule> ruleStack) {
    if (propertyType instanceof CompositePropertyType) {
      _processPropertyType((CompositePropertyType)propertyType, tslRule, bindingExpr, metaClass, ruleStack);
      return;
    } else if (propertyType instanceof ReferencePropertyType) {
      _processPropertyType((ReferencePropertyType)propertyType, tslRule, bindingExpr, metaClass, ruleStack);
      return;
    } else if (propertyType instanceof BooleanPropertyType) {
      _processPropertyType((BooleanPropertyType)propertyType, tslRule, bindingExpr, metaClass, ruleStack);
      return;
    } else if (propertyType instanceof IdPropertyType) {
      _processPropertyType((IdPropertyType)propertyType, tslRule, bindingExpr, metaClass, ruleStack);
      return;
    } else if (propertyType instanceof IntPropertyType) {
      _processPropertyType((IntPropertyType)propertyType, tslRule, bindingExpr, metaClass, ruleStack);
      return;
    } else if (propertyType instanceof StringPropertyType) {
      _processPropertyType((StringPropertyType)propertyType, tslRule, bindingExpr, metaClass, ruleStack);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(propertyType, tslRule, bindingExpr, metaClass, ruleStack).toString());
    }
  }
}
