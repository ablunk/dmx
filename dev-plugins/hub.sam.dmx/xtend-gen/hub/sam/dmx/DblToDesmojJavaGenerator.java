package hub.sam.dmx;

import com.google.common.base.Objects;
import hub.sam.dbl.ActivateObject;
import hub.sam.dbl.ActiveLiteral;
import hub.sam.dbl.Advance;
import hub.sam.dbl.Clazz;
import hub.sam.dbl.Constructor;
import hub.sam.dbl.Expression;
import hub.sam.dbl.Module;
import hub.sam.dbl.Parameter;
import hub.sam.dbl.Procedure;
import hub.sam.dbl.Reactivate;
import hub.sam.dbl.StartCodeBlock;
import hub.sam.dbl.Statement;
import hub.sam.dbl.SuperClassSpecification;
import hub.sam.dbl.TimeLiteral;
import hub.sam.dbl.Variable;
import hub.sam.dbl.Wait;
import hub.sam.dbl.Yield;
import hub.sam.dmx.BasicDblToJavaGenerator;
import java.util.Arrays;
import java.util.List;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DblToDesmojJavaGenerator extends BasicDblToJavaGenerator {
  public DblToDesmojJavaGenerator(final Resource modelResource, final IPath outputFolder) {
    super(modelResource, outputFolder);
  }
  
  public String genModuleWithMainProcedure(final Module module) {
    String _xblockexpression = null;
    {
      final Module it = module;
      EList<Procedure> _procedures = it.getProcedures();
      final Function1<Procedure,Boolean> _function = new Function1<Procedure,Boolean>() {
        public Boolean apply(final Procedure it) {
          String _name = it.getName();
          boolean _equals = Objects.equal(_name, "main");
          return Boolean.valueOf(_equals);
        }
      };
      final Procedure mainProcedure = IterableExtensions.<Procedure>findFirst(_procedures, _function);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(this.javaPackagePrefix, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import hub.sam.dmx.javasim.desmoj.SimulationProcess;");
      _builder.newLine();
      _builder.append("import hub.sam.dmx.javasim.desmoj.DefaultSimulation;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      String _name = it.getName();
      _builder.append(_name, "");
      _builder.append(" extends SimulationProcess {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      String _name_1 = it.getName();
      _builder.append(_name_1, "	");
      _builder.append("() {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(\"");
      String _name_2 = it.getName();
      _builder.append(_name_2, "		");
      _builder.append("\");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void base_actions() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("main();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// simulations are stopped when main terminates");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("getModel().getExperiment().stop();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void startMainProcedure() {");
      _builder.newLine();
      _builder.append("\t\t");
      String _name_3 = it.getName();
      _builder.append(_name_3, "		");
      _builder.append(" mainProcess = new ");
      String _name_4 = it.getName();
      _builder.append(_name_4, "		");
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("DefaultSimulation.DEFAULT.addInitialProcess(mainProcess);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("DefaultSimulation.DEFAULT.start(0);");
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
      EList<Procedure> _procedures_1 = it.getProcedures();
      final Function1<Procedure,Boolean> _function_1 = new Function1<Procedure,Boolean>() {
        public Boolean apply(final Procedure p) {
          boolean _notEquals = (!Objects.equal(p, mainProcedure));
          return Boolean.valueOf(_notEquals);
        }
      };
      Iterable<Procedure> _filter = IterableExtensions.<Procedure>filter(_procedures_1, _function_1);
      List<Procedure> _list = IterableExtensions.<Procedure>toList(_filter);
      String _genProcedures = this.genProcedures(_list, true);
      _builder.append(_genProcedures, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      String _gen = this.gen(mainProcedure);
      _builder.append(_gen, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  public String getSimLibName() {
    return "desmoj";
  }
  
  public String genActiveClass(final Clazz clazz) {
    String _xblockexpression = null;
    {
      final Clazz it = clazz;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(this.javaPackagePrefix, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import hub.sam.dmx.javasim.desmoj.SimulationProcess;");
      _builder.newLine();
      _builder.append("import hub.sam.dmx.javasim.desmoj.DefaultSimulation;");
      _builder.newLine();
      _builder.append("\t");
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
          } else {
            boolean _isActive = it.isActive();
            if (_isActive) {
              _builder.append("extends SimulationProcess");
              _builder.newLine();
            }
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
      {
        boolean _and = false;
        boolean _isActive_1 = it.isActive();
        if (!_isActive_1) {
          _and = false;
        } else {
          EList<SuperClassSpecification> _superClasses_3 = it.getSuperClasses();
          boolean _isEmpty = _superClasses_3.isEmpty();
          _and = (_isActive_1 && _isEmpty);
        }
        if (_and) {
          _builder.append("\t\t");
          _builder.append("super(\"");
          String _name_2 = it.getName();
          _builder.append(_name_2, "		");
          _builder.append("\");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
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
      {
        boolean _isActive_2 = it.isActive();
        if (_isActive_2) {
          _builder.append("\t");
          _builder.append("public void base_actions() {");
          _builder.newLine();
          {
            StartCodeBlock _actionsBlock = it.getActionsBlock();
            boolean _notEquals_1 = (!Objects.equal(_actionsBlock, null));
            if (_notEquals_1) {
              _builder.append("\t");
              _builder.append("\t");
              StartCodeBlock _actionsBlock_1 = it.getActionsBlock();
              EList<Statement> _statements_1 = _actionsBlock_1.getStatements();
              String _gen_2 = this.gen(_statements_1);
              _builder.append(_gen_2, "		");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
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
  
  public String forwardGen(final EObject eObj) {
    String _xifexpression = null;
    if ((eObj instanceof Statement)) {
      String _genSimStatement = this.genSimStatement(((Statement) eObj));
      _xifexpression = _genSimStatement;
    } else {
      String _xifexpression_1 = null;
      if ((eObj instanceof Expression)) {
        String _genSimExpr = this.genSimExpr(((Expression) eObj));
        _xifexpression_1 = _genSimExpr;
      } else {
        EClass _eClass = eObj.eClass();
        String _name = _eClass.getName();
        String _plus = ("<! unknown element " + _name);
        String _plus_1 = (_plus + " !>");
        _xifexpression_1 = _plus_1;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected String _genSimStatement(final Statement stm) {
    return null;
  }
  
  protected String _genSimStatement(final Yield stm) {
    return "DefaultSimulation.DEFAULT.getCurrentProcess().base_yield();";
  }
  
  protected String _genSimStatement(final Wait stm) {
    return "DefaultSimulation.DEFAULT.getCurrentProcess().passivate();";
  }
  
  protected String _genSimStatement(final ActivateObject stm) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((SimulationProcess) ");
    Expression _objectAccess = stm.getObjectAccess();
    String _genExpr = this.genExpr(_objectAccess);
    _builder.append(_genExpr, "");
    _builder.append(").base_activate();");
    return _builder.toString();
  }
  
  protected String _genSimStatement(final Reactivate stm) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((SimulationProcess) ");
    Expression _objectAccess = stm.getObjectAccess();
    String _genExpr = this.genExpr(_objectAccess);
    _builder.append(_genExpr, "");
    _builder.append(").base_reactivate();");
    return _builder.toString();
  }
  
  protected String _genSimStatement(final Advance stm) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("base_advance(");
    Expression _time = stm.getTime();
    String _genExpr = this.genExpr(_time);
    _builder.append(_genExpr, "");
    _builder.append(");");
    return _builder.toString();
  }
  
  protected String _genSimExpr(final Expression expr) {
    return null;
  }
  
  protected String _genSimExpr(final TimeLiteral stm) {
    return "DefaultSimulation.DEFAULT.getPresentTime()";
  }
  
  protected String _genSimExpr(final ActiveLiteral stm) {
    return "DefaultSimulation.DEFAULT.getCurrentProcess()";
  }
  
  public String genSimStatement(final Statement stm) {
    if (stm instanceof ActivateObject) {
      return _genSimStatement((ActivateObject)stm);
    } else if (stm instanceof Advance) {
      return _genSimStatement((Advance)stm);
    } else if (stm instanceof Reactivate) {
      return _genSimStatement((Reactivate)stm);
    } else if (stm instanceof Wait) {
      return _genSimStatement((Wait)stm);
    } else if (stm instanceof Yield) {
      return _genSimStatement((Yield)stm);
    } else if (stm != null) {
      return _genSimStatement(stm);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(stm).toString());
    }
  }
  
  public String genSimExpr(final Expression stm) {
    if (stm instanceof ActiveLiteral) {
      return _genSimExpr((ActiveLiteral)stm);
    } else if (stm instanceof TimeLiteral) {
      return _genSimExpr((TimeLiteral)stm);
    } else if (stm != null) {
      return _genSimExpr(stm);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(stm).toString());
    }
  }
}
