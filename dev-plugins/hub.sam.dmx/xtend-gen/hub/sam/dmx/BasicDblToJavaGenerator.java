package hub.sam.dmx;

import com.google.common.base.Objects;
import hub.sam.dbl.And;
import hub.sam.dbl.ArrayDimension;
import hub.sam.dbl.Assignment;
import hub.sam.dbl.BinaryOperator;
import hub.sam.dbl.BoolType;
import hub.sam.dbl.BreakStatement;
import hub.sam.dbl.CallPart;
import hub.sam.dbl.Cast;
import hub.sam.dbl.ClassPart;
import hub.sam.dbl.Classifier;
import hub.sam.dbl.Clazz;
import hub.sam.dbl.Constructor;
import hub.sam.dbl.ContinueStatement;
import hub.sam.dbl.CreateObject;
import hub.sam.dbl.Div;
import hub.sam.dbl.DoubleLiteral;
import hub.sam.dbl.DoubleType;
import hub.sam.dbl.DynamicMappingPart;
import hub.sam.dbl.Equal;
import hub.sam.dbl.Expression;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.FalseLiteral;
import hub.sam.dbl.FixedMappingPart;
import hub.sam.dbl.ForStatement;
import hub.sam.dbl.Greater;
import hub.sam.dbl.GreaterEqual;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.IfStatement;
import hub.sam.dbl.IntLiteral;
import hub.sam.dbl.IntType;
import hub.sam.dbl.Less;
import hub.sam.dbl.LessEqual;
import hub.sam.dbl.LocalScopeStatement;
import hub.sam.dbl.MappingPart;
import hub.sam.dbl.MappingStatement;
import hub.sam.dbl.MeLiteral;
import hub.sam.dbl.Minus;
import hub.sam.dbl.Mod;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;
import hub.sam.dbl.Mul;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.NativeBinding;
import hub.sam.dbl.Neg;
import hub.sam.dbl.Not;
import hub.sam.dbl.NotEqual;
import hub.sam.dbl.NullLiteral;
import hub.sam.dbl.Or;
import hub.sam.dbl.Parameter;
import hub.sam.dbl.Plus;
import hub.sam.dbl.PredefinedId;
import hub.sam.dbl.PrimitiveType;
import hub.sam.dbl.Print;
import hub.sam.dbl.Procedure;
import hub.sam.dbl.ProcedureCall;
import hub.sam.dbl.PropertyBindingExpr;
import hub.sam.dbl.ReferableRhsType;
import hub.sam.dbl.ResetGenContextStatement;
import hub.sam.dbl.Return;
import hub.sam.dbl.SetGenContextStatement;
import hub.sam.dbl.SizeOfArray;
import hub.sam.dbl.Statement;
import hub.sam.dbl.StringLiteral;
import hub.sam.dbl.StringType;
import hub.sam.dbl.SuperClassSpecification;
import hub.sam.dbl.SuperLiteral;
import hub.sam.dbl.SwitchCase;
import hub.sam.dbl.SwitchStatement;
import hub.sam.dbl.TrueLiteral;
import hub.sam.dbl.Type;
import hub.sam.dbl.TypeAccess;
import hub.sam.dbl.TypedElement;
import hub.sam.dbl.Variable;
import hub.sam.dbl.VariableAccess;
import hub.sam.dbl.VoidType;
import hub.sam.dbl.WhileStatement;
import hub.sam.dmx.AbstractGenerator;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Generates Java code for the specified model only (i.e. imported models are not considered).
 */
@SuppressWarnings("all")
public class BasicDblToJavaGenerator extends AbstractGenerator {
  public final String javaPackagePrefix = "hub.sam.dmx.javasim.gen";
  
  public final String javaPackageFolderPrefix = new Function0<String>() {
    public String apply() {
      String _replaceAll = BasicDblToJavaGenerator.this.javaPackagePrefix.replaceAll("\\.", "/");
      return _replaceAll;
    }
  }.apply();
  
  public IPath javaPackageFolder;
  
  protected final String javaClass_for_ModuleLevelElements = "Module_";
  
  public BasicDblToJavaGenerator(final IPath outputFolder) {
    super(outputFolder);
    IPath _append = outputFolder.append(this.javaPackageFolderPrefix);
    this.javaPackageFolder = _append;
    this.makeFolder(this.javaPackageFolder);
  }
  
  public String genActiveClass(final Clazz clazz) {
    return "<! active classes are not support in basic DBL models !>";
  }
  
  public String genModuleWithMainProcedure(final Module module) {
    String _xblockexpression = null;
    {
      final Module it = module;
      StringConcatenation _builder = new StringConcatenation();
      String _genPackageStatement = this.genPackageStatement(it);
      _builder.append(_genPackageStatement, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(this.javaClass_for_ModuleLevelElements, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void startMainProcedure() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("main();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      EList<Variable> _variables = it.getVariables();
      String _genVariables = this.genVariables(_variables, true);
      _builder.append(_genVariables, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<Procedure> _procedures = it.getProcedures();
      String _genProcedures = this.genProcedures(_procedures, true);
      _builder.append(_genProcedures, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  public String getSimLibName() {
    return "";
  }
  
  public String getLanguageName() {
    return "java";
  }
  
  public String forwardGen(final EObject eObj) {
    String _xblockexpression = null;
    {
      EClass _eClass = eObj.eClass();
      String _name = _eClass.getName();
      /* ("<! unknown element " + _name); */
      _xblockexpression = (" !>");
    }
    return _xblockexpression;
  }
  
  public String javaNameQualified_for_Module(final Module element, final boolean forContentAccess) {
    String _xblockexpression = null;
    {
      final Module it = element;
      String _xifexpression = null;
      if (forContentAccess) {
        String _plus = (this.javaPackagePrefix + ".");
        String _name = it.getName();
        String _plus_1 = (_plus + _name);
        String _plus_2 = (_plus_1 + ".");
        String _plus_3 = (_plus_2 + this.javaClass_for_ModuleLevelElements);
        _xifexpression = _plus_3;
      } else {
        String _plus_4 = (this.javaPackagePrefix + ".");
        String _name_1 = it.getName();
        String _plus_5 = (_plus_4 + _name_1);
        _xifexpression = _plus_5;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected String _javaNameQualified(final ExtensionDefinition element) {
    String _xblockexpression = null;
    {
      final ExtensionDefinition it = element;
      EObject _eContainer = element.eContainer();
      final Module owner = ((Module) _eContainer);
      String _javaNameQualified_for_Module = this.javaNameQualified_for_Module(owner, false);
      String _plus = (_javaNameQualified_for_Module + ".");
      String _name = it.getName();
      String _plus_1 = (_plus + _name);
      _xblockexpression = (_plus_1);
    }
    return _xblockexpression;
  }
  
  protected String _javaNameQualified(final Clazz element) {
    String _xblockexpression = null;
    {
      final Clazz it = element;
      String _xifexpression = null;
      EList<NativeBinding> _bindings = it.getBindings();
      boolean _isEmpty = _bindings.isEmpty();
      if (_isEmpty) {
        String _xblockexpression_1 = null;
        {
          EObject _eContainer = element.eContainer();
          final Module owner = ((Module) _eContainer);
          String _javaNameQualified_for_Module = this.javaNameQualified_for_Module(owner, false);
          String _plus = (_javaNameQualified_for_Module + ".");
          String _name = it.getName();
          String _plus_1 = (_plus + _name);
          _xblockexpression_1 = (_plus_1);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        String _javaNameBound = this.javaNameBound(it);
        _xifexpression = _javaNameBound;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String javaNameBound(final Clazz clazz) {
    String _xblockexpression = null;
    {
      final Clazz it = clazz;
      EList<NativeBinding> _bindings = it.getBindings();
      final Function1<NativeBinding,Boolean> _function = new Function1<NativeBinding,Boolean>() {
        public Boolean apply(final NativeBinding it) {
          String _targetLanguage = it.getTargetLanguage();
          String _simLibName = BasicDblToJavaGenerator.this.getSimLibName();
          boolean _equals = Objects.equal(_targetLanguage, _simLibName);
          return Boolean.valueOf(_equals);
        }
      };
      NativeBinding _findFirst = IterableExtensions.<NativeBinding>findFirst(_bindings, _function);
      String _targetType = null;
      if (_findFirst!=null) {
        _targetType=_findFirst.getTargetType();
      }
      String targetType = _targetType;
      String _xifexpression = null;
      boolean _notEquals = (!Objects.equal(targetType, null));
      if (_notEquals) {
        _xifexpression = targetType;
      } else {
        String _xblockexpression_1 = null;
        {
          EList<NativeBinding> _bindings_1 = it.getBindings();
          final Function1<NativeBinding,Boolean> _function_1 = new Function1<NativeBinding,Boolean>() {
            public Boolean apply(final NativeBinding it) {
              String _targetLanguage = it.getTargetLanguage();
              String _languageName = BasicDblToJavaGenerator.this.getLanguageName();
              boolean _equals = Objects.equal(_targetLanguage, _languageName);
              return Boolean.valueOf(_equals);
            }
          };
          NativeBinding _findFirst_1 = IterableExtensions.<NativeBinding>findFirst(_bindings_1, _function_1);
          String _targetType_1 = null;
          if (_findFirst_1!=null) {
            _targetType_1=_findFirst_1.getTargetType();
          }
          targetType = _targetType_1;
          String _xifexpression_1 = null;
          boolean _notEquals_1 = (!Objects.equal(targetType, null));
          if (_notEquals_1) {
            _xifexpression_1 = targetType;
          } else {
            String _simLibName = this.getSimLibName();
            String _plus = ("<!- type binding for library " + _simLibName);
            String _plus_1 = (_plus + " is missing for type ");
            String _name = clazz.getName();
            String _plus_2 = (_plus_1 + _name);
            String _plus_3 = (_plus_2 + " !>");
            _xifexpression_1 = _plus_3;
          }
          _xblockexpression_1 = (_xifexpression_1);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected String _javaNameQualified(final Procedure element) {
    String _javaNameQualified_for_ProcedureVariable = this.javaNameQualified_for_ProcedureVariable(element);
    return _javaNameQualified_for_ProcedureVariable;
  }
  
  protected String _javaNameQualified(final Variable element) {
    String _javaNameQualified_for_ProcedureVariable = this.javaNameQualified_for_ProcedureVariable(element);
    return _javaNameQualified_for_ProcedureVariable;
  }
  
  public String javaNameQualified_for_ProcedureVariable(final NamedElement element) {
    String _xblockexpression = null;
    {
      final NamedElement it = element;
      String _xifexpression = null;
      EObject _eContainer = element.eContainer();
      if ((_eContainer instanceof Module)) {
        String _xblockexpression_1 = null;
        {
          EObject _eContainer_1 = element.eContainer();
          final Module owner = ((Module) _eContainer_1);
          String _javaNameQualified_for_Module = this.javaNameQualified_for_Module(owner, true);
          String _plus = (_javaNameQualified_for_Module + ".");
          String _name = it.getName();
          String _plus_1 = (_plus + _name);
          _xblockexpression_1 = (_plus_1);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        String _name = it.getName();
        _xifexpression = _name;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public void genModel(final Model model, final boolean mainModel) {
    try {
      Module _xifexpression = null;
      if (mainModel) {
        EList<Module> _modules = model.getModules();
        final Function1<Module,Boolean> _function = new Function1<Module,Boolean>() {
          public Boolean apply(final Module it) {
            EList<Procedure> _procedures = it.getProcedures();
            final Function1<Procedure,Boolean> _function = new Function1<Procedure,Boolean>() {
              public Boolean apply(final Procedure it) {
                String _name = it.getName();
                boolean _equals = Objects.equal(_name, "main");
                return Boolean.valueOf(_equals);
              }
            };
            boolean _exists = IterableExtensions.<Procedure>exists(_procedures, _function);
            return Boolean.valueOf(_exists);
          }
        };
        Module _findFirst = IterableExtensions.<Module>findFirst(_modules, _function);
        _xifexpression = _findFirst;
      } else {
        _xifexpression = null;
      }
      final Module moduleWithMainProcedure = _xifexpression;
      EList<Module> _modules_1 = model.getModules();
      final Procedure1<Module> _function_1 = new Procedure1<Module>() {
        public void apply(final Module module) {
          try {
            String _name = module.getName();
            final IPath moduleFolder = BasicDblToJavaGenerator.this.javaPackageFolder.append(_name);
            BasicDblToJavaGenerator.this.makeFolder(moduleFolder);
            String _plus = (BasicDblToJavaGenerator.this.javaClass_for_ModuleLevelElements + ".java");
            final Writer moduleWriter = BasicDblToJavaGenerator.this.beginTargetFile(moduleFolder, _plus);
            String _xifexpression = null;
            boolean _or = false;
            boolean _equals = Objects.equal(moduleWithMainProcedure, null);
            if (_equals) {
              _or = true;
            } else {
              boolean _notEquals = (!Objects.equal(module, moduleWithMainProcedure));
              _or = (_equals || _notEquals);
            }
            if (_or) {
              String _gen = BasicDblToJavaGenerator.this.gen(module);
              _xifexpression = _gen;
            } else {
              String _genModuleWithMainProcedure = BasicDblToJavaGenerator.this.genModuleWithMainProcedure(module);
              _xifexpression = _genModuleWithMainProcedure;
            }
            moduleWriter.write(_xifexpression);
            BasicDblToJavaGenerator.this.endTargetFile(moduleWriter);
            EList<Classifier> _classifiers = module.getClassifiers();
            final Procedure1<Classifier> _function = new Procedure1<Classifier>() {
              public void apply(final Classifier classifier) {
                try {
                  final String result = BasicDblToJavaGenerator.this.gen(classifier);
                  boolean _and = false;
                  boolean _notEquals = (!Objects.equal(result, null));
                  if (!_notEquals) {
                    _and = false;
                  } else {
                    boolean _notEquals_1 = (!Objects.equal(result, ""));
                    _and = (_notEquals && _notEquals_1);
                  }
                  if (_and) {
                    String _name = classifier.getName();
                    String _plus = (_name + ".java");
                    final Writer classifierWriter = BasicDblToJavaGenerator.this.beginTargetFile(moduleFolder, _plus);
                    classifierWriter.write(result);
                    BasicDblToJavaGenerator.this.endTargetFile(classifierWriter);
                  }
                } catch (Throwable _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
            IterableExtensions.<Classifier>forEach(_classifiers, _function);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      IterableExtensions.<Module>forEach(_modules_1, _function_1);
      if (mainModel) {
        final Writer javaMain = this.beginTargetFile(this.javaPackageFolder, "JavaMain.java");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package ");
        _builder.append(this.javaPackagePrefix, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("public class JavaMain {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public static void main(String[] args) {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("long startTime = System.nanoTime();");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        String _javaNameQualified_for_Module = this.javaNameQualified_for_Module(moduleWithMainProcedure, true);
        _builder.append(_javaNameQualified_for_Module, "		");
        _builder.append(".startMainProcedure();");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("long estimatedTime = System.nanoTime() - startTime;");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("long ms = estimatedTime / (1000 * 1000);");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("System.out.println(\"Execution time: \" + ms / 1000.0 + \" seconds\");");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("Runtime runtime = Runtime.getRuntime();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("long memory = runtime.totalMemory() - runtime.freeMemory();");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("System.out.println(\"Memory Usage: \" +  memory/1024.0/1024 + \" MB\");");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("System.exit(0);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        javaMain.write(_builder.toString());
        this.endTargetFile(javaMain);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String _gen(final Classifier c) {
    EClass _eClass = c.eClass();
    String _name = _eClass.getName();
    String _plus = ("<! unknown classifier " + _name);
    String _plus_1 = (_plus + " !>");
    return _plus_1;
  }
  
  protected String _gen(final Void e) {
    return "";
  }
  
  public boolean isMainModule(final Module module) {
    EList<Procedure> _procedures = module.getProcedures();
    final Function1<Procedure,Boolean> _function = new Function1<Procedure,Boolean>() {
      public Boolean apply(final Procedure it) {
        String _name = it.getName();
        boolean _equals = Objects.equal(_name, "main");
        return Boolean.valueOf(_equals);
      }
    };
    boolean _exists = IterableExtensions.<Procedure>exists(_procedures, _function);
    return _exists;
  }
  
  protected String _gen(final Module module) {
    String _xblockexpression = null;
    {
      final Module it = module;
      StringConcatenation _builder = new StringConcatenation();
      String _genPackageStatement = this.genPackageStatement(it);
      _builder.append(_genPackageStatement, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(this.javaClass_for_ModuleLevelElements, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      EList<Variable> _variables = it.getVariables();
      String _genVariables = this.genVariables(_variables, true);
      _builder.append(_genVariables, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<Procedure> _procedures = it.getProcedures();
      String _genProcedures = this.genProcedures(_procedures, true);
      _builder.append(_genProcedures, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  public String genVariables(final List<Variable> variables, final boolean setStatic) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Variable variable : variables) {
        _builder.append("public ");
        {
          if (setStatic) {
            _builder.append("static");
          }
        }
        _builder.append(" ");
        String _gen = this.gen(variable);
        _builder.append(_gen, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String genProcedures(final List<Procedure> procedures, final boolean setStatic) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Procedure p : procedures) {
        _builder.append("public ");
        {
          if (setStatic) {
            _builder.append("static");
          }
        }
        _builder.append(" ");
        String _gen = this.gen(p);
        _builder.append(_gen, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String _gen(final Statement stm) {
    String _genStatement = this.genStatement(stm);
    return _genStatement;
  }
  
  protected String _genStatement(final Statement stm) {
    String _forwardGen = this.forwardGen(stm);
    return _forwardGen;
  }
  
  protected String _genStatement(final ProcedureCall call) {
    IdExpr _callIdExpr = call.getCallIdExpr();
    String _genExpr = this.genExpr(_callIdExpr);
    String _plus = (_genExpr + ";");
    return _plus;
  }
  
  protected String _genStatement(final Print print) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("System.out.print(");
    _builder.newLine();
    {
      EList<Expression> _outputs = print.getOutputs();
      boolean _hasElements = false;
      for(final Expression expr : _outputs) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate("+", "");
        }
        String _genExpr = this.genExpr(expr);
        _builder.append(_genExpr, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(");");
    _builder.newLine();
    return _builder.toString();
  }
  
  protected String _genStatement(final IfStatement ifStm) {
    String _xblockexpression = null;
    {
      final IfStatement it = ifStm;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("if (");
      Expression _condition = it.getCondition();
      String _genExpr = this.genExpr(_condition);
      _builder.append(_genExpr, "");
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      Statement _trueCase = it.getTrueCase();
      String _gen = this.gen(_trueCase);
      _builder.append(_gen, "	");
      _builder.newLineIfNotEmpty();
      {
        Statement _falseCase = it.getFalseCase();
        boolean _notEquals = (!Objects.equal(_falseCase, null));
        if (_notEquals) {
          _builder.append("else");
          _builder.newLine();
          _builder.append("\t");
          Statement _falseCase_1 = it.getFalseCase();
          String _gen_1 = this.gen(_falseCase_1);
          _builder.append(_gen_1, "	");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genStatement(final LocalScopeStatement stm) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    EList<Statement> _statements = stm.getStatements();
    String _gen = this.gen(_statements);
    _builder.append(_gen, "");
    _builder.append("}");
    return _builder.toString();
  }
  
  protected String _genStatement(final Assignment stm) {
    String _genAssignment = this.genAssignment(stm, true);
    return _genAssignment;
  }
  
  public String genAssignment(final Assignment stm, final boolean genSemicolon) {
    String _xblockexpression = null;
    {
      final Assignment it = stm;
      StringConcatenation _builder = new StringConcatenation();
      VariableAccess _variable = it.getVariable();
      String _genExpr = this.genExpr(_variable);
      _builder.append(_genExpr, "");
      _builder.append(" = ");
      Expression _value = it.getValue();
      String _genExpr_1 = this.genExpr(_value);
      _builder.append(_genExpr_1, "");
      _builder.newLineIfNotEmpty();
      {
        if (genSemicolon) {
          _builder.append(";");
        }
      }
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genStatement(final Return stm) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("return ");
    Expression _value = stm.getValue();
    String _genExpr = this.genExpr(_value);
    _builder.append(_genExpr, "");
    _builder.append(";");
    return _builder.toString();
  }
  
  protected String _genStatement(final BreakStatement stm) {
    return "break;";
  }
  
  protected String _genStatement(final ContinueStatement stm) {
    return "continue;";
  }
  
  protected String _genStatement(final SwitchStatement stm) {
    String _xblockexpression = null;
    {
      final SwitchStatement it = stm;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("switch (");
      VariableAccess _variable = it.getVariable();
      String _genExpr = this.genExpr(_variable);
      _builder.append(_genExpr, "");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      {
        EList<SwitchCase> _cases = it.getCases();
        for(final SwitchCase c : _cases) {
          _builder.append("\t");
          _builder.append("case ");
          Expression _value = c.getValue();
          String _genExpr_1 = this.genExpr(_value);
          _builder.append(_genExpr_1, "	");
          _builder.append(":");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          EList<Statement> _body = c.getBody();
          String _gen = this.gen(_body);
          _builder.append(_gen, "		");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        SwitchCase _defaultCase = it.getDefaultCase();
        boolean _notEquals = (!Objects.equal(_defaultCase, null));
        if (_notEquals) {
          _builder.append("\t");
          _builder.append("default:");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          SwitchCase _defaultCase_1 = it.getDefaultCase();
          EList<Statement> _body_1 = _defaultCase_1.getBody();
          String _gen_1 = this.gen(_body_1);
          _builder.append(_gen_1, "		");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genStatement(final ForStatement stm) {
    String _xblockexpression = null;
    {
      final ForStatement it = stm;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (");
      _builder.newLine();
      _builder.append("\t");
      EList<Statement> _statements = it.getStatements();
      Statement _head = IterableExtensions.<Statement>head(_statements);
      String _gen = this.gen(_head);
      _builder.append(_gen, "	");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      Expression _termination = it.getTermination();
      String _genExpr = this.genExpr(_termination);
      _builder.append(_genExpr, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(";");
      _builder.newLine();
      _builder.append("\t");
      Assignment _increment = it.getIncrement();
      String _genAssignment = this.genAssignment(_increment, false);
      _builder.append(_genAssignment, "	");
      _builder.newLineIfNotEmpty();
      _builder.append(")");
      _builder.newLine();
      Statement _body = it.getBody();
      String _gen_1 = this.gen(_body);
      _builder.append(_gen_1, "");
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genStatement(final WhileStatement stm) {
    String _xblockexpression = null;
    {
      final WhileStatement it = stm;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("while (");
      Expression _condition = it.getCondition();
      String _genExpr = this.genExpr(_condition);
      _builder.append(_genExpr, "");
      _builder.append(")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      Statement _body = it.getBody();
      String _gen = this.gen(_body);
      _builder.append(_gen, "			");
      _builder.newLineIfNotEmpty();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genStatement(final ResetGenContextStatement stm) {
    return "resetGenContext();";
  }
  
  protected String _genStatement(final SetGenContextStatement stm) {
    String _xblockexpression = null;
    {
      final SetGenContextStatement it = stm;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("setGenContext(");
      Expression _context = it.getContext();
      String _genExpr = this.genExpr(_context);
      _builder.append(_genExpr, "");
      _builder.append(", ");
      boolean _isAddAfterContext = it.isAddAfterContext();
      _builder.append(_isAddAfterContext, "");
      _builder.append(");");
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genStatement(final MappingStatement stm) {
    String _xblockexpression = null;
    {
      final MappingStatement it = stm;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("gen(");
      _builder.newLine();
      {
        EList<MappingPart> _parts = it.getParts();
        boolean _hasElements = false;
        for(final MappingPart part : _parts) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate("+", "		");
          }
          _builder.append("\t\t");
          String _genMappingPart = this.genMappingPart(part);
          _builder.append(_genMappingPart, "		");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.append(");");
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genMappingPart(final MappingPart part) {
    return "< unknown mapping part >";
  }
  
  protected String _genMappingPart(final FixedMappingPart part) {
    String _code = part.getCode();
    String _quoteJavaString = this.quoteJavaString(_code);
    return _quoteJavaString;
  }
  
  protected String _genMappingPart(final DynamicMappingPart part) {
    Expression _expr = part.getExpr();
    String _genExpr = this.genExpr(_expr);
    return _genExpr;
  }
  
  protected String _genStatement(final Variable variable) {
    String _xblockexpression = null;
    {
      final Variable it = variable;
      StringConcatenation _builder = new StringConcatenation();
      String _genType = this.genType(it);
      _builder.append(_genType, "");
      _builder.append(" ");
      String _name = it.getName();
      _builder.append(_name, "");
      _builder.newLineIfNotEmpty();
      {
        Expression _initialValue = it.getInitialValue();
        boolean _notEquals = (!Objects.equal(_initialValue, null));
        if (_notEquals) {
          _builder.append("= ");
          Expression _initialValue_1 = it.getInitialValue();
          String _genExpr = this.genExpr(_initialValue_1);
          _builder.append(_genExpr, "");
          _builder.newLineIfNotEmpty();
        } else {
          EList<ArrayDimension> _typeArrayDimensions = it.getTypeArrayDimensions();
          boolean _isEmpty = _typeArrayDimensions.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
          } else {
            IdExpr _classifierType = it.getClassifierType();
            boolean _notEquals_1 = (!Objects.equal(_classifierType, null));
            if (_notEquals_1) {
              _builder.append("= null");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append(";");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genExpr(final Expression expr) {
    String _forwardGen = this.forwardGen(expr);
    return _forwardGen;
  }
  
  protected String _genExpr(final Void expr) {
    return "";
  }
  
  protected String _genExpr(final Or expr) {
    String _genBinaryExpr = this.genBinaryExpr(expr, "||");
    return _genBinaryExpr;
  }
  
  protected String _genExpr(final And expr) {
    String _genBinaryExpr = this.genBinaryExpr(expr, "&&");
    return _genBinaryExpr;
  }
  
  protected String _genExpr(final Equal expr) {
    String _genBinaryExpr = this.genBinaryExpr(expr, "==");
    return _genBinaryExpr;
  }
  
  protected String _genExpr(final NotEqual expr) {
    String _genBinaryExpr = this.genBinaryExpr(expr, "!=");
    return _genBinaryExpr;
  }
  
  protected String _genExpr(final Greater expr) {
    String _genBinaryExpr = this.genBinaryExpr(expr, ">");
    return _genBinaryExpr;
  }
  
  protected String _genExpr(final GreaterEqual expr) {
    String _genBinaryExpr = this.genBinaryExpr(expr, ">=");
    return _genBinaryExpr;
  }
  
  protected String _genExpr(final Less expr) {
    String _genBinaryExpr = this.genBinaryExpr(expr, "<");
    return _genBinaryExpr;
  }
  
  protected String _genExpr(final LessEqual expr) {
    String _genBinaryExpr = this.genBinaryExpr(expr, "<=");
    return _genBinaryExpr;
  }
  
  protected String _genExpr(final Plus expr) {
    String _genBinaryExpr = this.genBinaryExpr(expr, "+");
    return _genBinaryExpr;
  }
  
  protected String _genExpr(final Minus expr) {
    String _genBinaryExpr = this.genBinaryExpr(expr, "-");
    return _genBinaryExpr;
  }
  
  protected String _genExpr(final Mul expr) {
    String _genBinaryExpr = this.genBinaryExpr(expr, "*");
    return _genBinaryExpr;
  }
  
  protected String _genExpr(final Div expr) {
    String _genBinaryExpr = this.genBinaryExpr(expr, "/");
    return _genBinaryExpr;
  }
  
  protected String _genExpr(final Mod expr) {
    String _genBinaryExpr = this.genBinaryExpr(expr, "%");
    return _genBinaryExpr;
  }
  
  protected String _genExpr(final Neg expr) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(-");
    Expression _op = expr.getOp();
    String _genExpr = this.genExpr(_op);
    _builder.append(_genExpr, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _genExpr(final Not expr) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(!");
    Expression _op = expr.getOp();
    String _genExpr = this.genExpr(_op);
    _builder.append(_genExpr, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _genExpr(final Cast expr) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((");
    String _genType = this.genType(expr);
    _builder.append(_genType, "");
    _builder.append(") ");
    Expression _op = expr.getOp();
    String _genExpr = this.genExpr(_op);
    _builder.append(_genExpr, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _genExpr(final TypeAccess expr) {
    IdExpr _idExpr = expr.getIdExpr();
    String _genClassifierTypeExpr = this.genClassifierTypeExpr(_idExpr);
    return _genClassifierTypeExpr;
  }
  
  protected String _genExpr(final VariableAccess expr) {
    IdExpr _idExpr = expr.getIdExpr();
    String _genExpr = this.genExpr(_idExpr);
    return _genExpr;
  }
  
  protected String _genExpr(final StringLiteral expr) {
    String _value = expr.getValue();
    String _quoteJavaString = this.quoteJavaString(_value);
    return _quoteJavaString;
  }
  
  public String quoteJavaString(final String s) {
    String _xifexpression = null;
    boolean _contains = s.contains("\r\n");
    if (_contains) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"");
      String _replaceAll = s.replaceAll("\r\n", "\\\\r\\\\n\"+\r\n\"");
      _builder.append(_replaceAll, "");
      _builder.append("\"");
      _xifexpression = _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\"");
      String _replaceAll_1 = s.replaceAll("\n", "\\\\r\\\\n\"+\r\n\"");
      _builder_1.append(_replaceAll_1, "");
      _builder_1.append("\"");
      _xifexpression = _builder_1.toString();
    }
    return _xifexpression;
  }
  
  protected String _genExpr(final IntLiteral expr) {
    int _value = expr.getValue();
    String _string = Integer.valueOf(_value).toString();
    return _string;
  }
  
  protected String _genExpr(final TrueLiteral expr) {
    return "true";
  }
  
  protected String _genExpr(final FalseLiteral expr) {
    return "false";
  }
  
  protected String _genExpr(final DoubleLiteral expr) {
    double _value = expr.getValue();
    String _string = Double.valueOf(_value).toString();
    return _string;
  }
  
  protected String _genExpr(final NullLiteral expr) {
    return "null";
  }
  
  public String genBinaryExpr(final BinaryOperator expr, final String op) {
    String _xblockexpression = null;
    {
      final BinaryOperator it = expr;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(");
      Expression _op1 = it.getOp1();
      String _genExpr = this.genExpr(_op1);
      _builder.append(_genExpr, "");
      _builder.append(" ");
      _builder.append(op, "");
      _builder.append(" ");
      Expression _op2 = it.getOp2();
      String _genExpr_1 = this.genExpr(_op2);
      _builder.append(_genExpr_1, "");
      _builder.append(")");
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genExpr(final CreateObject expr) {
    String _xblockexpression = null;
    {
      final CreateObject it = expr;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new ");
      String _genType = this.genType(it);
      _builder.append(_genType, "	");
      _builder.append("\t\t");
      _builder.newLineIfNotEmpty();
      {
        boolean _and = false;
        boolean _and_1 = false;
        IdExpr _classifierType = it.getClassifierType();
        boolean _notEquals = (!Objects.equal(_classifierType, null));
        if (!_notEquals) {
          _and_1 = false;
        } else {
          IdExpr _classifierType_1 = it.getClassifierType();
          EList<Expression> _arrayIndex = _classifierType_1.getArrayIndex();
          boolean _isEmpty = _arrayIndex.isEmpty();
          _and_1 = (_notEquals && _isEmpty);
        }
        if (!_and_1) {
          _and = false;
        } else {
          EList<ArrayDimension> _typeArrayDimensions = it.getTypeArrayDimensions();
          boolean _isEmpty_1 = _typeArrayDimensions.isEmpty();
          _and = (_and_1 && _isEmpty_1);
        }
        if (_and) {
          _builder.append("(");
          _builder.newLine();
          {
            IdExpr _classifierType_2 = it.getClassifierType();
            CallPart _callPart = _classifierType_2.getCallPart();
            boolean _notEquals_1 = (!Objects.equal(_callPart, null));
            if (_notEquals_1) {
              {
                IdExpr _classifierType_3 = it.getClassifierType();
                CallPart _callPart_1 = _classifierType_3.getCallPart();
                EList<Expression> _callArguments = _callPart_1.getCallArguments();
                boolean _hasElements = false;
                for(final Expression arg : _callArguments) {
                  if (!_hasElements) {
                    _hasElements = true;
                  } else {
                    _builder.appendImmediate(",", "");
                  }
                  String _genExpr = this.genExpr(arg);
                  _builder.append(_genExpr, "");
                  _builder.newLineIfNotEmpty();
                }
              }
            }
          }
          _builder.append(")");
          _builder.newLine();
        }
      }
      _builder.append(")");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genExpr(final IdExpr idExpr) {
    String _genIdExpr = this.genIdExpr(idExpr);
    return _genIdExpr;
  }
  
  public String genIdExpr(final IdExpr idExpr) {
    String _xblockexpression = null;
    {
      final IdExpr it = idExpr;
      StringConcatenation _builder = new StringConcatenation();
      {
        IdExpr _parentIdExpr = it.getParentIdExpr();
        boolean _notEquals = (!Objects.equal(_parentIdExpr, null));
        if (_notEquals) {
          IdExpr _parentIdExpr_1 = it.getParentIdExpr();
          String _genIdExpr = this.genIdExpr(_parentIdExpr_1);
          _builder.append(_genIdExpr, "");
          _builder.append(".");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        NamedElement _referencedElement = it.getReferencedElement();
        boolean _notEquals_1 = (!Objects.equal(_referencedElement, null));
        if (_notEquals_1) {
          NamedElement _referencedElement_1 = it.getReferencedElement();
          String _genIdExpr_for_ReferencedElement = this.genIdExpr_for_ReferencedElement(it, _referencedElement_1);
          _builder.append(_genIdExpr_for_ReferencedElement, "");
          _builder.newLineIfNotEmpty();
        } else {
          PredefinedId _predefinedId = it.getPredefinedId();
          String _genIdExpr_for_PredefinedId = this.genIdExpr_for_PredefinedId(it, _predefinedId);
          _builder.append(_genIdExpr_for_PredefinedId, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genIdExpr_for_PredefinedId(final IdExpr idExpr, final PredefinedId predefinedId) {
    return "<! unsupported PredefinedId !>";
  }
  
  protected String _genIdExpr_for_PredefinedId(final IdExpr idExpr, final MeLiteral predefinedId) {
    String _genIdExpr_for_PredefinedId_meLiteral = this.genIdExpr_for_PredefinedId_meLiteral();
    return _genIdExpr_for_PredefinedId_meLiteral;
  }
  
  public String genIdExpr_for_PredefinedId_meLiteral() {
    return "this";
  }
  
  protected String _genIdExpr_for_PredefinedId(final IdExpr idExpr, final SuperLiteral predefinedId) {
    return "super";
  }
  
  protected String _genIdExpr_for_PredefinedId(final IdExpr idExpr, final SizeOfArray predefinedId) {
    String _xifexpression = null;
    CallPart _callPart = idExpr.getCallPart();
    boolean _equals = Objects.equal(_callPart, null);
    if (_equals) {
      _xifexpression = "length";
    } else {
      _xifexpression = "size()";
    }
    return _xifexpression;
  }
  
  protected String _genIdExpr_for_ReferencedElement(final IdExpr idExpr, final NamedElement referencedElement) {
    StringConcatenation _builder = new StringConcatenation();
    String _javaNameQualified = this.javaNameQualified(referencedElement);
    _builder.append(_javaNameQualified, "");
    _builder.newLineIfNotEmpty();
    {
      CallPart _callPart = idExpr.getCallPart();
      boolean _notEquals = (!Objects.equal(_callPart, null));
      if (_notEquals) {
        _builder.append("(");
        _builder.newLine();
        {
          CallPart _callPart_1 = idExpr.getCallPart();
          EList<Expression> _callArguments = _callPart_1.getCallArguments();
          boolean _hasElements = false;
          for(final Expression arg : _callArguments) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "");
            }
            String _genExpr = this.genExpr(arg);
            _builder.append(_genExpr, "");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append(")");
        _builder.newLine();
      }
    }
    {
      EList<Expression> _arrayIndex = idExpr.getArrayIndex();
      for(final Expression index : _arrayIndex) {
        _builder.append("[");
        String _genExpr_1 = this.genExpr(index);
        _builder.append(_genExpr_1, "");
        _builder.append("]");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  protected String _genIdExpr_for_ReferencedElement(final IdExpr idExpr, final PropertyBindingExpr referencedElement) {
    String _genIdExpr_for_PropertyBindingExpr = this.genIdExpr_for_PropertyBindingExpr(idExpr, referencedElement);
    return _genIdExpr_for_PropertyBindingExpr;
  }
  
  public String genIdExpr_for_PropertyBindingExpr(final IdExpr idExpr, final PropertyBindingExpr referencedElement) {
    return null;
  }
  
  protected String _genType(final TypedElement typedElement) {
    String _xblockexpression = null;
    {
      final TypedElement it = typedElement;
      StringConcatenation _builder = new StringConcatenation();
      {
        PrimitiveType _primitiveType = it.getPrimitiveType();
        boolean _notEquals = (!Objects.equal(_primitiveType, null));
        if (_notEquals) {
          PrimitiveType _primitiveType_1 = it.getPrimitiveType();
          String _genType = this.genType(_primitiveType_1);
          _builder.append(_genType, "");
          _builder.newLineIfNotEmpty();
        } else {
          IdExpr _classifierType = it.getClassifierType();
          String _genClassifierTypeExpr = this.genClassifierTypeExpr(_classifierType);
          _builder.append(_genClassifierTypeExpr, "");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        EList<ArrayDimension> _typeArrayDimensions = it.getTypeArrayDimensions();
        boolean _isEmpty = _typeArrayDimensions.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          {
            EList<ArrayDimension> _typeArrayDimensions_1 = it.getTypeArrayDimensions();
            for(final ArrayDimension dim : _typeArrayDimensions_1) {
              _builder.append("[");
              Expression _size = dim.getSize();
              String _genExpr = this.genExpr(_size);
              _builder.append(_genExpr, "");
              _builder.append("]");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  public String genClassifierTypeExpr(final IdExpr typeExpr) {
    NamedElement _referencedElement = typeExpr.getReferencedElement();
    String _genType = this.genType(_referencedElement);
    return _genType;
  }
  
  protected String _genType(final ReferableRhsType rhsType) {
    String _name = rhsType.getName();
    return _name;
  }
  
  public String genModulePrefix(final EObject element) {
    String _xblockexpression = null;
    {
      final EObject it = element;
      StringConcatenation _builder = new StringConcatenation();
      {
        EObject _eContainer = it.eContainer();
        if ((_eContainer instanceof Module)) {
          _builder.append(this.javaPackagePrefix, "");
          _builder.append(".");
          _builder.newLineIfNotEmpty();
          EObject _eContainer_1 = it.eContainer();
          String _name = ((Module) _eContainer_1).getName();
          _builder.append(_name, "");
          _builder.append(".");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genType(final Classifier type) {
    String _javaNameQualified = this.javaNameQualified(type);
    return _javaNameQualified;
  }
  
  protected String _genType(final Type type) {
    EClass _eClass = type.eClass();
    String _name = _eClass.getName();
    String _plus = ("<! unknown type " + _name);
    String _plus_1 = (_plus + " !>");
    return _plus_1;
  }
  
  protected String _genType(final IntType type) {
    return "int";
  }
  
  protected String _genType(final VoidType type) {
    return "void";
  }
  
  protected String _genType(final StringType type) {
    return "String";
  }
  
  protected String _genType(final BoolType type) {
    return "boolean";
  }
  
  protected String _genType(final DoubleType type) {
    return "double";
  }
  
  protected String _genWrappedType(final Type type) {
    EClass _eClass = type.eClass();
    String _name = _eClass.getName();
    String _plus = ("<! unknown type " + _name);
    String _plus_1 = (_plus + " !>");
    return _plus_1;
  }
  
  protected String _genWrappedType(final IntType type) {
    return "Long";
  }
  
  protected String _genWrappedType(final VoidType type) {
    return "void";
  }
  
  protected String _genWrappedType(final StringType type) {
    return "String";
  }
  
  protected String _genWrappedType(final BoolType type) {
    return "Boolean";
  }
  
  protected String _genWrappedType(final DoubleType type) {
    return "Double";
  }
  
  protected String _gen(final List<Statement> statements) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Statement stm : statements) {
        String _genStatement = this.genStatement(stm);
        _builder.append(_genStatement, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String removeAllNewLinesAndTrim(final String str) {
    String _quoteReplacement = Matcher.quoteReplacement("\n");
    String _replaceAll = str.replaceAll(_quoteReplacement, "");
    return _replaceAll;
  }
  
  protected String _gen(final Procedure procedure) {
    String _xblockexpression = null;
    {
      final Procedure it = procedure;
      StringConcatenation _builder = new StringConcatenation();
      String _genType = this.genType(it);
      _builder.append(_genType, "");
      _builder.append(" ");
      String _name = it.getName();
      _builder.append(_name, "");
      _builder.append("(");
      _builder.newLineIfNotEmpty();
      {
        EList<Parameter> _parameters = it.getParameters();
        boolean _hasElements = false;
        for(final Parameter param : _parameters) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "");
          }
          String _genType_1 = this.genType(param);
          _builder.append(_genType_1, "");
          _builder.append(" ");
          String _name_1 = param.getName();
          _builder.append(_name_1, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append(") {");
      _builder.newLine();
      _builder.append("\t");
      EList<Statement> _statements = it.getStatements();
      String _gen = this.gen(_statements);
      _builder.append(_gen, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _gen(final Clazz clazz) {
    String _xblockexpression = null;
    {
      final Clazz it = clazz;
      String _xifexpression = null;
      EList<NativeBinding> _bindings = clazz.getBindings();
      boolean _isEmpty = _bindings.isEmpty();
      if (_isEmpty) {
        String _xifexpression_1 = null;
        boolean _isActive = clazz.isActive();
        if (_isActive) {
          String _genActiveClass = this.genActiveClass(it);
          _xifexpression_1 = _genActiveClass;
        } else {
          String _genPassiveClass = this.genPassiveClass(it);
          _xifexpression_1 = _genPassiveClass;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String genPackageStatement(final Module module) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _javaNameQualified_for_Module = this.javaNameQualified_for_Module(module, false);
    _builder.append(_javaNameQualified_for_Module, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String genPackageStatement(final Clazz clazz) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    EObject _eContainer = clazz.eContainer();
    String _javaNameQualified_for_Module = this.javaNameQualified_for_Module(((Module) _eContainer), false);
    _builder.append(_javaNameQualified_for_Module, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public String genPassiveClass(final Clazz clazz) {
    String _xblockexpression = null;
    {
      final Clazz it = clazz;
      StringConcatenation _builder = new StringConcatenation();
      String _genPackageStatement = this.genPackageStatement(it);
      _builder.append(_genPackageStatement, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public class ");
      String _name = it.getName();
      _builder.append(_name, "");
      _builder.newLineIfNotEmpty();
      {
        EList<SuperClassSpecification> _superClasses = it.getSuperClasses();
        int _size = _superClasses.size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          _builder.append("<! multiple inheritance is not supported for Java as a target language at the moment !>");
          _builder.newLine();
        } else {
          EList<SuperClassSpecification> _superClasses_1 = it.getSuperClasses();
          int _size_1 = _superClasses_1.size();
          boolean _equals = (_size_1 == 1);
          if (_equals) {
            _builder.append("extends ");
            EList<SuperClassSpecification> _superClasses_2 = it.getSuperClasses();
            SuperClassSpecification _head = IterableExtensions.<SuperClassSpecification>head(_superClasses_2);
            Clazz _clazz = _head.getClazz();
            String _genType = this.genType(_clazz);
            _builder.append(_genType, "");
            _builder.newLineIfNotEmpty();
          }
        }
      }
      _builder.append("{");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      String _name_1 = it.getName();
      _builder.append(_name_1, "	");
      _builder.append("(");
      _builder.newLineIfNotEmpty();
      {
        Constructor _constructor = it.getConstructor();
        boolean _notEquals = (!Objects.equal(_constructor, null));
        if (_notEquals) {
          {
            Constructor _constructor_1 = it.getConstructor();
            EList<Parameter> _parameters = _constructor_1.getParameters();
            boolean _hasElements = false;
            for(final Parameter cparam : _parameters) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "	");
              }
              _builder.append("\t");
              String _gen = this.gen(cparam);
              _builder.append(_gen, "	");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append(") {");
      _builder.newLine();
      _builder.append("\t\t");
      ClassPart _initialBlock = it.getInitialBlock();
      EList<Statement> _statements = null;
      if (_initialBlock!=null) {
        _statements=_initialBlock.getStatements();
      }
      String _gen_1 = this.gen(_statements);
      _builder.append(_gen_1, "		");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<Variable> _attributes = it.getAttributes();
      String _genVariables = this.genVariables(_attributes, false);
      _builder.append(_genVariables, "	");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      EList<Procedure> _methods = it.getMethods();
      String _genProcedures = this.genProcedures(_methods, false);
      _builder.append(_genProcedures, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  public String javaNameQualified(final NamedElement element) {
    if (element instanceof Variable) {
      return _javaNameQualified((Variable)element);
    } else if (element instanceof Clazz) {
      return _javaNameQualified((Clazz)element);
    } else if (element instanceof ExtensionDefinition) {
      return _javaNameQualified((ExtensionDefinition)element);
    } else if (element instanceof Procedure) {
      return _javaNameQualified((Procedure)element);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element).toString());
    }
  }
  
  public String gen(final Object clazz) {
    if (clazz instanceof Clazz) {
      return _gen((Clazz)clazz);
    } else if (clazz instanceof Classifier) {
      return _gen((Classifier)clazz);
    } else if (clazz instanceof Statement) {
      return _gen((Statement)clazz);
    } else if (clazz instanceof Module) {
      return _gen((Module)clazz);
    } else if (clazz instanceof Procedure) {
      return _gen((Procedure)clazz);
    } else if (clazz instanceof List) {
      return _gen((List<Statement>)clazz);
    } else if (clazz == null) {
      return _gen((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(clazz).toString());
    }
  }
  
  public String genStatement(final Statement stm) {
    if (stm instanceof Assignment) {
      return _genStatement((Assignment)stm);
    } else if (stm instanceof BreakStatement) {
      return _genStatement((BreakStatement)stm);
    } else if (stm instanceof ContinueStatement) {
      return _genStatement((ContinueStatement)stm);
    } else if (stm instanceof ForStatement) {
      return _genStatement((ForStatement)stm);
    } else if (stm instanceof LocalScopeStatement) {
      return _genStatement((LocalScopeStatement)stm);
    } else if (stm instanceof Print) {
      return _genStatement((Print)stm);
    } else if (stm instanceof ProcedureCall) {
      return _genStatement((ProcedureCall)stm);
    } else if (stm instanceof ResetGenContextStatement) {
      return _genStatement((ResetGenContextStatement)stm);
    } else if (stm instanceof Return) {
      return _genStatement((Return)stm);
    } else if (stm instanceof SetGenContextStatement) {
      return _genStatement((SetGenContextStatement)stm);
    } else if (stm instanceof SwitchStatement) {
      return _genStatement((SwitchStatement)stm);
    } else if (stm instanceof Variable) {
      return _genStatement((Variable)stm);
    } else if (stm instanceof WhileStatement) {
      return _genStatement((WhileStatement)stm);
    } else if (stm instanceof IfStatement) {
      return _genStatement((IfStatement)stm);
    } else if (stm instanceof MappingStatement) {
      return _genStatement((MappingStatement)stm);
    } else if (stm != null) {
      return _genStatement(stm);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(stm).toString());
    }
  }
  
  public String genMappingPart(final MappingPart part) {
    if (part instanceof DynamicMappingPart) {
      return _genMappingPart((DynamicMappingPart)part);
    } else if (part instanceof FixedMappingPart) {
      return _genMappingPart((FixedMappingPart)part);
    } else if (part != null) {
      return _genMappingPart(part);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(part).toString());
    }
  }
  
  public String genExpr(final Expression expr) {
    if (expr instanceof And) {
      return _genExpr((And)expr);
    } else if (expr instanceof Cast) {
      return _genExpr((Cast)expr);
    } else if (expr instanceof CreateObject) {
      return _genExpr((CreateObject)expr);
    } else if (expr instanceof Div) {
      return _genExpr((Div)expr);
    } else if (expr instanceof DoubleLiteral) {
      return _genExpr((DoubleLiteral)expr);
    } else if (expr instanceof Equal) {
      return _genExpr((Equal)expr);
    } else if (expr instanceof FalseLiteral) {
      return _genExpr((FalseLiteral)expr);
    } else if (expr instanceof Greater) {
      return _genExpr((Greater)expr);
    } else if (expr instanceof GreaterEqual) {
      return _genExpr((GreaterEqual)expr);
    } else if (expr instanceof IdExpr) {
      return _genExpr((IdExpr)expr);
    } else if (expr instanceof IntLiteral) {
      return _genExpr((IntLiteral)expr);
    } else if (expr instanceof Less) {
      return _genExpr((Less)expr);
    } else if (expr instanceof LessEqual) {
      return _genExpr((LessEqual)expr);
    } else if (expr instanceof Minus) {
      return _genExpr((Minus)expr);
    } else if (expr instanceof Mod) {
      return _genExpr((Mod)expr);
    } else if (expr instanceof Mul) {
      return _genExpr((Mul)expr);
    } else if (expr instanceof Neg) {
      return _genExpr((Neg)expr);
    } else if (expr instanceof Not) {
      return _genExpr((Not)expr);
    } else if (expr instanceof NotEqual) {
      return _genExpr((NotEqual)expr);
    } else if (expr instanceof NullLiteral) {
      return _genExpr((NullLiteral)expr);
    } else if (expr instanceof Or) {
      return _genExpr((Or)expr);
    } else if (expr instanceof Plus) {
      return _genExpr((Plus)expr);
    } else if (expr instanceof StringLiteral) {
      return _genExpr((StringLiteral)expr);
    } else if (expr instanceof TrueLiteral) {
      return _genExpr((TrueLiteral)expr);
    } else if (expr instanceof TypeAccess) {
      return _genExpr((TypeAccess)expr);
    } else if (expr instanceof VariableAccess) {
      return _genExpr((VariableAccess)expr);
    } else if (expr != null) {
      return _genExpr(expr);
    } else if (expr == null) {
      return _genExpr((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expr).toString());
    }
  }
  
  public String genIdExpr_for_PredefinedId(final IdExpr idExpr, final PredefinedId predefinedId) {
    if (predefinedId instanceof MeLiteral) {
      return _genIdExpr_for_PredefinedId(idExpr, (MeLiteral)predefinedId);
    } else if (predefinedId instanceof SizeOfArray) {
      return _genIdExpr_for_PredefinedId(idExpr, (SizeOfArray)predefinedId);
    } else if (predefinedId instanceof SuperLiteral) {
      return _genIdExpr_for_PredefinedId(idExpr, (SuperLiteral)predefinedId);
    } else if (predefinedId != null) {
      return _genIdExpr_for_PredefinedId(idExpr, predefinedId);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(idExpr, predefinedId).toString());
    }
  }
  
  public String genIdExpr_for_ReferencedElement(final IdExpr idExpr, final NamedElement referencedElement) {
    if (referencedElement instanceof PropertyBindingExpr) {
      return _genIdExpr_for_ReferencedElement(idExpr, (PropertyBindingExpr)referencedElement);
    } else if (referencedElement != null) {
      return _genIdExpr_for_ReferencedElement(idExpr, referencedElement);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(idExpr, referencedElement).toString());
    }
  }
  
  public String genType(final EObject type) {
    if (type instanceof BoolType) {
      return _genType((BoolType)type);
    } else if (type instanceof Classifier) {
      return _genType((Classifier)type);
    } else if (type instanceof DoubleType) {
      return _genType((DoubleType)type);
    } else if (type instanceof IntType) {
      return _genType((IntType)type);
    } else if (type instanceof StringType) {
      return _genType((StringType)type);
    } else if (type instanceof VoidType) {
      return _genType((VoidType)type);
    } else if (type instanceof ReferableRhsType) {
      return _genType((ReferableRhsType)type);
    } else if (type instanceof Type) {
      return _genType((Type)type);
    } else if (type instanceof TypedElement) {
      return _genType((TypedElement)type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
  
  public String genWrappedType(final Type type) {
    if (type instanceof BoolType) {
      return _genWrappedType((BoolType)type);
    } else if (type instanceof DoubleType) {
      return _genWrappedType((DoubleType)type);
    } else if (type instanceof IntType) {
      return _genWrappedType((IntType)type);
    } else if (type instanceof StringType) {
      return _genWrappedType((StringType)type);
    } else if (type instanceof VoidType) {
      return _genWrappedType((VoidType)type);
    } else if (type != null) {
      return _genWrappedType(type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
}
