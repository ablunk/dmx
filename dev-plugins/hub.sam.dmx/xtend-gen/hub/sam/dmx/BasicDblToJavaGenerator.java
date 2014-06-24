package hub.sam.dmx;

import com.google.common.base.Objects;
import hub.sam.dbl.AddToSet;
import hub.sam.dbl.AfterInSet;
import hub.sam.dbl.And;
import hub.sam.dbl.ArgumentExpression;
import hub.sam.dbl.ArrayDimension;
import hub.sam.dbl.Assignment;
import hub.sam.dbl.BeforeInSet;
import hub.sam.dbl.BinaryOperator;
import hub.sam.dbl.BoolType;
import hub.sam.dbl.BreakStatement;
import hub.sam.dbl.Cast;
import hub.sam.dbl.Classifier;
import hub.sam.dbl.Clazz;
import hub.sam.dbl.CodeBlock;
import hub.sam.dbl.Constructor;
import hub.sam.dbl.Contains;
import hub.sam.dbl.ContinueStatement;
import hub.sam.dbl.CreateObject;
import hub.sam.dbl.Div;
import hub.sam.dbl.DoubleLiteral;
import hub.sam.dbl.DoubleType;
import hub.sam.dbl.EmptySet;
import hub.sam.dbl.Equal;
import hub.sam.dbl.Expression;
import hub.sam.dbl.FalseLiteral;
import hub.sam.dbl.FirstInSet;
import hub.sam.dbl.ForStatement;
import hub.sam.dbl.Greater;
import hub.sam.dbl.GreaterEqual;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.IfStatement;
import hub.sam.dbl.IndexOf;
import hub.sam.dbl.IntLiteral;
import hub.sam.dbl.IntType;
import hub.sam.dbl.LastInSet;
import hub.sam.dbl.Less;
import hub.sam.dbl.LessEqual;
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
import hub.sam.dbl.ObjectAt;
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
import hub.sam.dbl.RemoveFromSet;
import hub.sam.dbl.ResetGenContextStatement;
import hub.sam.dbl.Return;
import hub.sam.dbl.SetGenContextStatement;
import hub.sam.dbl.SizeOfSet;
import hub.sam.dbl.StartCodeBlock;
import hub.sam.dbl.Statement;
import hub.sam.dbl.StringLiteral;
import hub.sam.dbl.StringType;
import hub.sam.dbl.SuperClassSpecification;
import hub.sam.dbl.SuperLiteral;
import hub.sam.dbl.TrueLiteral;
import hub.sam.dbl.Type;
import hub.sam.dbl.TypeAccess;
import hub.sam.dbl.TypedElement;
import hub.sam.dbl.Variable;
import hub.sam.dbl.VariableAccess;
import hub.sam.dbl.VoidType;
import hub.sam.dbl.WhileStatement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class BasicDblToJavaGenerator {
  private final Resource modelResource;
  
  private final IPath outputFolder;
  
  public final String javaPackagePrefix = "hub.sam.dmx.javasim.gen";
  
  public final String javaPackageFolderPrefix = new Function0<String>() {
    public String apply() {
      String _replaceAll = BasicDblToJavaGenerator.this.javaPackagePrefix.replaceAll("\\.", "/");
      return _replaceAll;
    }
  }.apply();
  
  private IPath javaPackageFolder;
  
  public BasicDblToJavaGenerator(final Resource modelResource, final IPath outputFolder) {
    this.modelResource = modelResource;
    this.outputFolder = outputFolder;
  }
  
  public String genActiveClass(final Clazz clazz) {
    return "<! active classes are not support in basic DBL models !>";
  }
  
  public String genModuleWithMainProcedure(final Module module) {
    String _xblockexpression = null;
    {
      final Module it = module;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(this.javaPackagePrefix, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public class ");
      String _name = it.getName();
      _builder.append(_name, "");
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
  
  public Module getModuleWithMainProcedure(final Model model) {
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
    return _findFirst;
  }
  
  public void startGenerator() {
    try {
      EList<EObject> _contents = this.modelResource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      final Model model = ((Model) _head);
      final Module moduleWithMainProcedure = this.getModuleWithMainProcedure(model);
      IPath _append = this.outputFolder.append(this.javaPackageFolderPrefix);
      this.javaPackageFolder = _append;
      String _string = this.javaPackageFolder.toString();
      File _file = new File(_string);
      final File javaPackageFolder_fileObject = _file;
      boolean _and = false;
      boolean _exists = javaPackageFolder_fileObject.exists();
      boolean _not = (!_exists);
      if (!_not) {
        _and = false;
      } else {
        boolean _mkdirs = javaPackageFolder_fileObject.mkdirs();
        boolean _not_1 = (!_mkdirs);
        _and = (_not && _not_1);
      }
      if (_and) {
        RuntimeException _runtimeException = new RuntimeException("could not create java package folder structure.");
        throw _runtimeException;
      }
      EList<Module> _modules = model.getModules();
      final Procedure1<Module> _function = new Procedure1<Module>() {
        public void apply(final Module module) {
          try {
            String _name = module.getName();
            String _plus = (_name + ".java");
            final Writer moduleWriter = BasicDblToJavaGenerator.this.beginTargetFile(BasicDblToJavaGenerator.this.javaPackageFolder, _plus);
            String _xifexpression = null;
            boolean _notEquals = (!Objects.equal(module, moduleWithMainProcedure));
            if (_notEquals) {
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
                    final Writer classifierWriter = BasicDblToJavaGenerator.this.beginTargetFile(BasicDblToJavaGenerator.this.javaPackageFolder, _plus);
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
      IterableExtensions.<Module>forEach(_modules, _function);
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
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      String _name = moduleWithMainProcedure.getName();
      _builder.append(_name, "		");
      _builder.append(".startMainProcedure();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
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
      _builder.append("package ");
      _builder.append(this.javaPackagePrefix, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public class ");
      String _name = it.getName();
      _builder.append(_name, "");
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
    Expression _procedureAccess = call.getProcedureAccess();
    String _genExpr = this.genExpr(_procedureAccess);
    return _genExpr;
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
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      CodeBlock _ifCaseBlock = it.getIfCaseBlock();
      EList<Statement> _statements = _ifCaseBlock.getStatements();
      String _gen = this.gen(_statements);
      _builder.append(_gen, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      {
        EList<CodeBlock> _elifCaseBlock = it.getElifCaseBlock();
        for(final CodeBlock elseIfBlock : _elifCaseBlock) {
          _builder.append("else if (");
          EList<Expression> _elifCondition = it.getElifCondition();
          EList<CodeBlock> _elifCaseBlock_1 = it.getElifCaseBlock();
          int _indexOf = _elifCaseBlock_1.indexOf(elseIfBlock);
          Expression _get = _elifCondition.get(_indexOf);
          _builder.append(_get, "");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          EList<Statement> _statements_1 = elseIfBlock.getStatements();
          String _gen_1 = this.gen(_statements_1);
          _builder.append(_gen_1, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("else {");
      _builder.newLine();
      {
        CodeBlock _elseCaseBlock = it.getElseCaseBlock();
        boolean _notEquals = (!Objects.equal(_elseCaseBlock, null));
        if (_notEquals) {
          CodeBlock _elseCaseBlock_1 = it.getElseCaseBlock();
          EList<Statement> _statements_2 = _elseCaseBlock_1.getStatements();
          String _gen_2 = this.gen(_statements_2);
          _builder.append(_gen_2, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
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
  
  protected String _genStatement(final AddToSet stm) {
    String _xblockexpression = null;
    {
      final AddToSet it = stm;
      StringConcatenation _builder = new StringConcatenation();
      Expression _set = it.getSet();
      String _genExpr = this.genExpr(_set);
      _builder.append(_genExpr, "");
      _builder.append(".add(");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      {
        ArgumentExpression _atIndex = it.getAtIndex();
        boolean _notEquals = (!Objects.equal(_atIndex, null));
        if (_notEquals) {
          _builder.append("(int) ");
          ArgumentExpression _atIndex_1 = it.getAtIndex();
          String _genExpr_1 = this.genExpr(_atIndex_1);
          _builder.append(_genExpr_1, "	");
          _builder.append(", ");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      Expression _object = it.getObject();
      String _genExpr_2 = this.genExpr(_object);
      _builder.append(_genExpr_2, "	");
      _builder.newLineIfNotEmpty();
      _builder.append(");");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genStatement(final RemoveFromSet stm) {
    String _xblockexpression = null;
    {
      final RemoveFromSet it = stm;
      StringConcatenation _builder = new StringConcatenation();
      Expression _set = it.getSet();
      String _genExpr = this.genExpr(_set);
      _builder.append(_genExpr, "");
      _builder.append(".remove(");
      Expression _object = it.getObject();
      String _genExpr_1 = this.genExpr(_object);
      _builder.append(_genExpr_1, "");
      _builder.append(");");
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genStatement(final EmptySet stm) {
    String _xblockexpression = null;
    {
      final EmptySet it = stm;
      StringConcatenation _builder = new StringConcatenation();
      Expression _set = it.getSet();
      String _genExpr = this.genExpr(_set);
      _builder.append(_genExpr, "");
      _builder.append(".clear();");
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  protected String _genStatement(final BreakStatement stm) {
    return "break;";
  }
  
  protected String _genStatement(final ContinueStatement stm) {
    return "continue;";
  }
  
  protected String _genStatement(final ForStatement stm) {
    String _xblockexpression = null;
    {
      final ForStatement it = stm;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("for (");
      _builder.newLine();
      {
        Variable _countVariableDefinition = it.getCountVariableDefinition();
        boolean _notEquals = (!Objects.equal(_countVariableDefinition, null));
        if (_notEquals) {
          _builder.append("\t");
          Variable _countVariableDefinition_1 = it.getCountVariableDefinition();
          String _genType = this.genType(_countVariableDefinition_1);
          _builder.append(_genType, "	");
          _builder.append(" ");
          Variable _countVariableDefinition_2 = it.getCountVariableDefinition();
          String _name = _countVariableDefinition_2.getName();
          _builder.append(_name, "	");
          _builder.newLineIfNotEmpty();
        } else {
          Assignment _countVariableReference = it.getCountVariableReference();
          boolean _notEquals_1 = (!Objects.equal(_countVariableReference, null));
          if (_notEquals_1) {
            _builder.append("\t");
            Assignment _countVariableReference_1 = it.getCountVariableReference();
            String _genAssignment = this.genAssignment(_countVariableReference_1, false);
            _builder.append(_genAssignment, "	");
            _builder.newLineIfNotEmpty();
          }
        }
      }
      _builder.append("\t");
      _builder.append(";");
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
      String _genAssignment_1 = this.genAssignment(_increment, false);
      _builder.append(_genAssignment_1, "	");
      _builder.newLineIfNotEmpty();
      _builder.append(") {");
      _builder.newLine();
      _builder.append("\t");
      CodeBlock _body = it.getBody();
      EList<Statement> _statements = _body.getStatements();
      String _gen = this.gen(_statements);
      _builder.append(_gen, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
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
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      CodeBlock _whileBlock = it.getWhileBlock();
      EList<Statement> _statements = _whileBlock.getStatements();
      String _gen = this.gen(_statements);
      _builder.append(_gen, "			");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("}");
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
      {
        EList<MappingPart> _parts = it.getParts();
        boolean _hasElements = false;
        for(final MappingPart part : _parts) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate("+", "");
          }
          _builder.newLineIfNotEmpty();
          _builder.append("// TODO");
          _builder.newLine();
          _builder.append("\t\t");
        }
      }
      _builder.append(");");
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
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
          EList<ArrayDimension> _arrayDimensions = it.getArrayDimensions();
          boolean _isEmpty = _arrayDimensions.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
          } else {
            IdExpr _classifierTypeExpr = it.getClassifierTypeExpr();
            boolean _notEquals_1 = (!Objects.equal(_classifierTypeExpr, null));
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
    String _plus = (_string + "L");
    return _plus;
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
  
  protected String _genExpr(final ArgumentExpression expr) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Expression> _arguments = expr.getArguments();
      boolean _hasElements = false;
      for(final Expression e : _arguments) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        _builder.newLineIfNotEmpty();
        String _genExpr = this.genExpr(e);
        _builder.append(_genExpr, "");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
      }
    }
    return _builder.toString();
  }
  
  protected String _genExpr(final CreateObject expr) {
    String _genType = this.genType(expr);
    String _plus = ("(new " + _genType);
    String _plus_1 = (_plus + "(");
    IdExpr _classifierTypeExpr = null;
    if (expr!=null) {
      _classifierTypeExpr=expr.getClassifierTypeExpr();
    }
    ArgumentExpression _arguments = null;
    if (_classifierTypeExpr!=null) {
      _arguments=_classifierTypeExpr.getArguments();
    }
    String _genExpr = this.genExpr(_arguments);
    String _plus_2 = (_plus_1 + _genExpr);
    String _plus_3 = (_plus_2 + "))");
    return _plus_3;
  }
  
  public boolean refersToSyntaxPart(final IdExpr idExpr) {
    final IdExpr it = idExpr;
    IdExpr _parentIdExpr = it.getParentIdExpr();
    boolean _equals = Objects.equal(_parentIdExpr, null);
    if (_equals) {
      boolean _and = false;
      NamedElement _referencedElement = it.getReferencedElement();
      boolean _notEquals = (!Objects.equal(_referencedElement, null));
      if (!_notEquals) {
        _and = false;
      } else {
        NamedElement _referencedElement_1 = it.getReferencedElement();
        _and = (_notEquals && (_referencedElement_1 instanceof PropertyBindingExpr));
      }
      return _and;
    } else {
      IdExpr _parentIdExpr_1 = it.getParentIdExpr();
      return this.refersToSyntaxPart(_parentIdExpr_1);
    }
  }
  
  public boolean refersToSyntaxPart_ofType_StructuredType(final IdExpr idExpr) {
    return false;
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
          {
            boolean _and = false;
            PredefinedId _predefinedId = it.getPredefinedId();
            boolean _notEquals_1 = (!Objects.equal(_predefinedId, null));
            if (!_notEquals_1) {
              _and = false;
            } else {
              PredefinedId _predefinedId_1 = it.getPredefinedId();
              _and = (_notEquals_1 && (_predefinedId_1 instanceof IndexOf));
            }
            if (_and) {
              _builder.append("(");
              _builder.newLine();
            }
          }
          _builder.newLine();
          IdExpr _parentIdExpr_1 = it.getParentIdExpr();
          String _genIdExpr = this.genIdExpr(_parentIdExpr_1);
          _builder.append(_genIdExpr, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        NamedElement _referencedElement = it.getReferencedElement();
        boolean _notEquals_2 = (!Objects.equal(_referencedElement, null));
        if (_notEquals_2) {
          NamedElement _referencedElement_1 = it.getReferencedElement();
          String _genIdExpr_for_ReferencedElement = this.genIdExpr_for_ReferencedElement(it, _referencedElement_1);
          _builder.append(_genIdExpr_for_ReferencedElement, "");
          _builder.newLineIfNotEmpty();
        } else {
          PredefinedId _predefinedId_2 = it.getPredefinedId();
          String _genIdExpr_for_PredefinedId = this.genIdExpr_for_PredefinedId(it, _predefinedId_2);
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
  
  protected String _genIdExpr_for_PredefinedId(final IdExpr idExpr, final SizeOfSet predefinedId) {
    return "size()";
  }
  
  protected String _genIdExpr_for_PredefinedId(final IdExpr idExpr, final FirstInSet predefinedId) {
    return "get(0)";
  }
  
  protected String _genIdExpr_for_PredefinedId(final IdExpr idExpr, final LastInSet predefinedId) {
    IdExpr _parentIdExpr = idExpr.getParentIdExpr();
    String _genIdExpr = this.genIdExpr(_parentIdExpr);
    String _plus = ("get(" + _genIdExpr);
    String _plus_1 = (_plus + ".size() - 1)");
    return _plus_1;
  }
  
  protected String _genIdExpr_for_PredefinedId(final IdExpr idExpr, final Contains predefinedId) {
    ArgumentExpression _arguments = idExpr.getArguments();
    String _genExpr = this.genExpr(_arguments);
    String _plus = ("contains(" + _genExpr);
    String _plus_1 = (_plus + ")");
    return _plus_1;
  }
  
  protected String _genIdExpr_for_PredefinedId(final IdExpr idExpr, final IndexOf predefinedId) {
    ArgumentExpression _arguments = idExpr.getArguments();
    String _genExpr = this.genExpr(_arguments);
    String _plus = ("indexOf(" + _genExpr);
    String _plus_1 = (_plus + ")");
    return _plus_1;
  }
  
  protected String _genIdExpr_for_PredefinedId(final IdExpr idExpr, final ObjectAt predefinedId) {
    ArgumentExpression _arguments = idExpr.getArguments();
    String _genExpr = this.genExpr(_arguments);
    String _plus = ("get((int) " + _genExpr);
    String _plus_1 = (_plus + ")");
    return _plus_1;
  }
  
  protected String _genIdExpr_for_PredefinedId(final IdExpr idExpr, final AfterInSet predefinedId) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get( ");
    IdExpr _parentIdExpr = idExpr.getParentIdExpr();
    String _genIdExpr = this.genIdExpr(_parentIdExpr);
    _builder.append(_genIdExpr, "");
    _builder.append(".indexOf(");
    ArgumentExpression _arguments = idExpr.getArguments();
    String _genExpr = this.genExpr(_arguments);
    _builder.append(_genExpr, "");
    _builder.append(") + 1)");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _genIdExpr_for_PredefinedId(final IdExpr idExpr, final BeforeInSet predefinedId) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get( ");
    IdExpr _parentIdExpr = idExpr.getParentIdExpr();
    String _genIdExpr = this.genIdExpr(_parentIdExpr);
    _builder.append(_genIdExpr, "");
    _builder.append(".indexOf(");
    ArgumentExpression _arguments = idExpr.getArguments();
    String _genExpr = this.genExpr(_arguments);
    _builder.append(_genExpr, "");
    _builder.append(") - 1)");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _genIdExpr_for_ReferencedElement(final IdExpr idExpr, final NamedElement referencedElement) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EObject _eContainer = referencedElement.eContainer();
      if ((_eContainer instanceof Module)) {
        EObject _eContainer_1 = referencedElement.eContainer();
        String _name = ((Module) _eContainer_1).getName();
        _builder.append(_name, "");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
      }
    }
    String _name_1 = referencedElement.getName();
    _builder.append(_name_1, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _genIdExpr_for_ReferencedElement(final IdExpr idExpr, final Procedure referencedElement) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EObject _eContainer = referencedElement.eContainer();
      if ((_eContainer instanceof Module)) {
        EObject _eContainer_1 = referencedElement.eContainer();
        String _name = ((Module) _eContainer_1).getName();
        _builder.append(_name, "");
        _builder.append(".");
        _builder.newLineIfNotEmpty();
      }
    }
    String _name_1 = referencedElement.getName();
    _builder.append(_name_1, "");
    _builder.append("(");
    _builder.newLineIfNotEmpty();
    {
      ArgumentExpression _arguments = idExpr.getArguments();
      EList<Expression> _arguments_1 = _arguments.getArguments();
      boolean _hasElements = false;
      for(final Expression arg : _arguments_1) {
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
    return _builder.toString();
  }
  
  protected String _genIdExpr_for_ReferencedElement(final IdExpr idExpr, final PropertyBindingExpr referencedElement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("get");
    String _name = referencedElement.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  protected String _genType(final TypedElement typedElement) {
    String _xblockexpression = null;
    {
      final TypedElement it = typedElement;
      String _xifexpression = null;
      EList<ArrayDimension> _arrayDimensions = it.getArrayDimensions();
      boolean _isEmpty = _arrayDimensions.isEmpty();
      if (_isEmpty) {
        String _genTypeNoWrapOfListPrimitives = this.genTypeNoWrapOfListPrimitives(it);
        _xifexpression = _genTypeNoWrapOfListPrimitives;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String genTypeWrapListPrimitives(final TypedElement typedElement) {
    String _xblockexpression = null;
    {
      final TypedElement it = typedElement;
      PrimitiveType _primitiveType = it.getPrimitiveType();
      if (_primitiveType!=null) {
        this.genWrappedType(_primitiveType);
      }
      String _genClassifierTypeExpr = null;
      IdExpr _classifierTypeExpr = it.getClassifierTypeExpr();
      if (_classifierTypeExpr!=null) {
        _genClassifierTypeExpr=this.genClassifierTypeExpr(_classifierTypeExpr);
      }
      _xblockexpression = (_genClassifierTypeExpr);
    }
    return _xblockexpression;
  }
  
  public String genTypeNoWrapOfListPrimitives(final TypedElement typedElement) {
    final TypedElement it = typedElement;
    PrimitiveType _primitiveType = it.getPrimitiveType();
    boolean _notEquals = (!Objects.equal(_primitiveType, null));
    if (_notEquals) {
      PrimitiveType _primitiveType_1 = it.getPrimitiveType();
      return this.genType(_primitiveType_1);
    } else {
      IdExpr _classifierTypeExpr = it.getClassifierTypeExpr();
      return this.genClassifierTypeExpr(_classifierTypeExpr);
    }
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
  
  protected String _genType(final Classifier type) {
    String _xblockexpression = null;
    {
      final Classifier it = type;
      String _xifexpression = null;
      EList<NativeBinding> _bindings = it.getBindings();
      boolean _isEmpty = _bindings.isEmpty();
      if (_isEmpty) {
        String _name = it.getName();
        _xifexpression = _name;
      } else {
        String _xblockexpression_1 = null;
        {
          EList<NativeBinding> _bindings_1 = it.getBindings();
          final Function1<NativeBinding,Boolean> _function = new Function1<NativeBinding,Boolean>() {
            public Boolean apply(final NativeBinding it) {
              String _targetLanguage = it.getTargetLanguage();
              String _simLibName = BasicDblToJavaGenerator.this.getSimLibName();
              boolean _equals = Objects.equal(_targetLanguage, _simLibName);
              return Boolean.valueOf(_equals);
            }
          };
          NativeBinding _findFirst = IterableExtensions.<NativeBinding>findFirst(_bindings_1, _function);
          final String targetType = _findFirst.getTargetType();
          String _xifexpression_1 = null;
          boolean _notEquals = (!Objects.equal(targetType, null));
          if (_notEquals) {
            _xifexpression_1 = targetType;
          } else {
            String _simLibName = this.getSimLibName();
            String _plus = ("<!- type binding for library " + _simLibName);
            String _plus_1 = (_plus + " is missing for type ");
            String _name_1 = type.getName();
            String _plus_2 = (_plus_1 + _name_1);
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
  
  protected String _genType(final Type type) {
    EClass _eClass = type.eClass();
    String _name = _eClass.getName();
    String _plus = ("<! unknown type " + _name);
    String _plus_1 = (_plus + " !>");
    return _plus_1;
  }
  
  protected String _genType(final IntType type) {
    return "long";
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
  
  public String genPassiveClass(final Clazz clazz) {
    String _xblockexpression = null;
    {
      final Clazz it = clazz;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(this.javaPackagePrefix, "");
      _builder.append(";");
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
      StartCodeBlock _initialBlock = it.getInitialBlock();
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
      _builder.append("public ");
      EList<Variable> _attributes = it.getAttributes();
      String _genVariables = this.genVariables(_attributes, false);
      _builder.append(_genVariables, "	");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
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
  
  private Writer beginTargetFile(final IPath folder, final String fileName) {
    try {
      IPath _append = folder.append(fileName);
      String _string = _append.toString();
      File _file = new File(_string);
      final File file = _file;
      boolean _exists = file.exists();
      boolean _not = (!_exists);
      if (_not) {
        file.createNewFile();
      }
      File _absoluteFile = file.getAbsoluteFile();
      FileWriter _fileWriter = new FileWriter(_absoluteFile);
      final FileWriter fileWriter = _fileWriter;
      BufferedWriter _bufferedWriter = new BufferedWriter(fileWriter);
      final BufferedWriter bufferedWriter = _bufferedWriter;
      return bufferedWriter;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void endTargetFile(final Writer targerWriter) {
    try {
      targerWriter.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String gen(final Object clazz) {
    if (clazz instanceof Clazz) {
      return _gen((Clazz)clazz);
    } else if (clazz instanceof Procedure) {
      return _gen((Procedure)clazz);
    } else if (clazz instanceof Classifier) {
      return _gen((Classifier)clazz);
    } else if (clazz instanceof Statement) {
      return _gen((Statement)clazz);
    } else if (clazz instanceof Module) {
      return _gen((Module)clazz);
    } else if (clazz instanceof List) {
      return _gen((List<Statement>)clazz);
    } else if (clazz == null) {
      return _gen((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(clazz).toString());
    }
  }
  
  public String genStatement(final EObject stm) {
    if (stm instanceof AddToSet) {
      return _genStatement((AddToSet)stm);
    } else if (stm instanceof EmptySet) {
      return _genStatement((EmptySet)stm);
    } else if (stm instanceof RemoveFromSet) {
      return _genStatement((RemoveFromSet)stm);
    } else if (stm instanceof Assignment) {
      return _genStatement((Assignment)stm);
    } else if (stm instanceof BreakStatement) {
      return _genStatement((BreakStatement)stm);
    } else if (stm instanceof ContinueStatement) {
      return _genStatement((ContinueStatement)stm);
    } else if (stm instanceof ForStatement) {
      return _genStatement((ForStatement)stm);
    } else if (stm instanceof IfStatement) {
      return _genStatement((IfStatement)stm);
    } else if (stm instanceof Print) {
      return _genStatement((Print)stm);
    } else if (stm instanceof ResetGenContextStatement) {
      return _genStatement((ResetGenContextStatement)stm);
    } else if (stm instanceof Return) {
      return _genStatement((Return)stm);
    } else if (stm instanceof SetGenContextStatement) {
      return _genStatement((SetGenContextStatement)stm);
    } else if (stm instanceof WhileStatement) {
      return _genStatement((WhileStatement)stm);
    } else if (stm instanceof MappingStatement) {
      return _genStatement((MappingStatement)stm);
    } else if (stm instanceof Variable) {
      return _genStatement((Variable)stm);
    } else if (stm instanceof Statement) {
      return _genStatement((Statement)stm);
    } else if (stm instanceof ProcedureCall) {
      return _genStatement((ProcedureCall)stm);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(stm).toString());
    }
  }
  
  public String genExpr(final EObject expr) {
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
    } else if (expr instanceof Expression) {
      return _genExpr((Expression)expr);
    } else if (expr instanceof ArgumentExpression) {
      return _genExpr((ArgumentExpression)expr);
    } else if (expr == null) {
      return _genExpr((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expr).toString());
    }
  }
  
  public String genIdExpr_for_PredefinedId(final IdExpr idExpr, final PredefinedId predefinedId) {
    if (predefinedId instanceof AfterInSet) {
      return _genIdExpr_for_PredefinedId(idExpr, (AfterInSet)predefinedId);
    } else if (predefinedId instanceof BeforeInSet) {
      return _genIdExpr_for_PredefinedId(idExpr, (BeforeInSet)predefinedId);
    } else if (predefinedId instanceof Contains) {
      return _genIdExpr_for_PredefinedId(idExpr, (Contains)predefinedId);
    } else if (predefinedId instanceof FirstInSet) {
      return _genIdExpr_for_PredefinedId(idExpr, (FirstInSet)predefinedId);
    } else if (predefinedId instanceof IndexOf) {
      return _genIdExpr_for_PredefinedId(idExpr, (IndexOf)predefinedId);
    } else if (predefinedId instanceof LastInSet) {
      return _genIdExpr_for_PredefinedId(idExpr, (LastInSet)predefinedId);
    } else if (predefinedId instanceof ObjectAt) {
      return _genIdExpr_for_PredefinedId(idExpr, (ObjectAt)predefinedId);
    } else if (predefinedId instanceof SizeOfSet) {
      return _genIdExpr_for_PredefinedId(idExpr, (SizeOfSet)predefinedId);
    } else if (predefinedId instanceof MeLiteral) {
      return _genIdExpr_for_PredefinedId(idExpr, (MeLiteral)predefinedId);
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
    if (referencedElement instanceof Procedure) {
      return _genIdExpr_for_ReferencedElement(idExpr, (Procedure)referencedElement);
    } else if (referencedElement instanceof PropertyBindingExpr) {
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
