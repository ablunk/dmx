package hub.sam.dmx;

import com.google.common.base.Objects;
import hub.sam.dbl.ActivateObject;
import hub.sam.dbl.ActiveLiteral;
import hub.sam.dbl.Advance;
import hub.sam.dbl.Constructor;
import hub.sam.dbl.Expression;
import hub.sam.dbl.Function;
import hub.sam.dbl.LocalScope;
import hub.sam.dbl.Module;
import hub.sam.dbl.Parameter;
import hub.sam.dbl.Reactivate;
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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DblToDesmojJavaGenerator extends BasicDblToJavaGenerator {
  public DblToDesmojJavaGenerator(final IPath outputFolder) {
    super(outputFolder);
  }
  
  public String genModuleWithMainProcedure(final Module module) {
    String _xblockexpression = null;
    {
      final Module it = module;
      EList<Function> _functions = it.getFunctions();
      final Function1<Function, Boolean> _function = new Function1<Function, Boolean>() {
        public Boolean apply(final Function it) {
          String _name = it.getName();
          return Boolean.valueOf(Objects.equal(_name, "main"));
        }
      };
      final Function mainProcedure = IterableExtensions.<Function>findFirst(_functions, _function);
      StringConcatenation _builder = new StringConcatenation();
      String _genPackageStatement = this.genPackageStatement(it);
      _builder.append(_genPackageStatement, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import hub.sam.dmx.javasim.desmoj.SimulationProcess;");
      _builder.newLine();
      _builder.append("import hub.sam.dmx.javasim.desmoj.DefaultSimulation;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(this.javaClass_for_ModuleLevelElements, "");
      _builder.append(" extends SimulationProcess {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(this.javaClass_for_ModuleLevelElements, "\t");
      _builder.append("() {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super(\"Main procedure in module \'");
      String _name = it.getName();
      _builder.append(_name, "\t\t");
      _builder.append("\'\");");
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
      _builder.append(this.javaClass_for_ModuleLevelElements, "\t\t");
      _builder.append(" mainProcess = new ");
      _builder.append(this.javaClass_for_ModuleLevelElements, "\t\t");
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
      _builder.append(_genVariables, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      EList<Function> _functions_1 = it.getFunctions();
      final Function1<Function, Boolean> _function_1 = new Function1<Function, Boolean>() {
        public Boolean apply(final Function p) {
          return Boolean.valueOf((!Objects.equal(p, mainProcedure)));
        }
      };
      Iterable<Function> _filter = IterableExtensions.<Function>filter(_functions_1, _function_1);
      List<Function> _list = IterableExtensions.<Function>toList(_filter);
      String _genFunctions = this.genFunctions(_list, true);
      _builder.append(_genFunctions, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      String _gen = this.gen(mainProcedure);
      _builder.append(_gen, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public String getSimLibName() {
    return "desmoj";
  }
  
  public String genActiveClass(final hub.sam.dbl.Class clazz) {
    String _xblockexpression = null;
    {
      final hub.sam.dbl.Class it = clazz;
      StringConcatenation _builder = new StringConcatenation();
      String _genPackageStatement = this.genPackageStatement(it);
      _builder.append(_genPackageStatement, "");
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
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          _builder.append("<! inheritance is not supported for ACTIVE classes at the moment !>");
          _builder.newLine();
        } else {
          boolean _isActive = it.isActive();
          if (_isActive) {
            _builder.append("extends SimulationProcess");
            _builder.newLine();
          }
        }
      }
      _builder.append("{");
      _builder.newLine();
      _builder.newLine();
      {
        EList<Constructor> _constructors = it.getConstructors();
        for(final Constructor constructor : _constructors) {
          _builder.append("\t");
          _builder.append("public ");
          String _name_1 = it.getName();
          _builder.append(_name_1, "\t");
          _builder.append("(");
          _builder.newLineIfNotEmpty();
          {
            EList<Parameter> _parameters = constructor.getParameters();
            boolean _hasElements = false;
            for(final Parameter cparam : _parameters) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "\t");
              }
              _builder.append("\t");
              String _gen = this.gen(cparam);
              _builder.append(_gen, "\t");
              _builder.newLineIfNotEmpty();
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
              EList<SuperClassSpecification> _superClasses_1 = it.getSuperClasses();
              boolean _isEmpty = _superClasses_1.isEmpty();
              _and = _isEmpty;
            }
            if (_and) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("super(\"");
              String _name_2 = it.getName();
              _builder.append(_name_2, "\t\t");
              _builder.append("\");");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          EList<Statement> _statements = constructor.getStatements();
          String _gen_1 = this.gen(_statements);
          _builder.append(_gen_1, "\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      {
        boolean _isActive_2 = it.isActive();
        if (_isActive_2) {
          _builder.append("\t");
          _builder.append("public void base_actions() {");
          _builder.newLine();
          {
            LocalScope _actionsBlock = it.getActionsBlock();
            boolean _notEquals = (!Objects.equal(_actionsBlock, null));
            if (_notEquals) {
              _builder.append("\t");
              _builder.append("\t");
              LocalScope _actionsBlock_1 = it.getActionsBlock();
              EList<Statement> _statements_1 = _actionsBlock_1.getStatements();
              String _gen_2 = this.gen(_statements_1);
              _builder.append(_gen_2, "\t\t");
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
      _builder.append(_genVariables, "\t");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      EList<Function> _methods = it.getMethods();
      String _genFunctions = this.genFunctions(_methods, false);
      _builder.append(_genFunctions, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public String forwardGen(final EObject eObj) {
    String _xifexpression = null;
    if ((eObj instanceof Statement)) {
      _xifexpression = this.genSimStatement(((Statement) eObj));
    } else {
      String _xifexpression_1 = null;
      if ((eObj instanceof Expression)) {
        _xifexpression_1 = this.genSimExpr(((Expression) eObj));
      } else {
        EClass _eClass = eObj.eClass();
        String _name = _eClass.getName();
        String _plus = ("<! unknown element " + _name);
        _xifexpression_1 = (_plus + " !>");
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected String _genSimStatement(final Statement stm) {
    return null;
  }
  
  protected String _genSimStatement(final Yield stm) {
    return "hub.sam.dmx.javasim.desmoj.DefaultSimulation.DEFAULT.getCurrentProcess().base_yield();";
  }
  
  protected String _genSimStatement(final Wait stm) {
    return "hub.sam.dmx.javasim.desmoj.DefaultSimulation.DEFAULT.getCurrentProcess().passivate();";
  }
  
  protected String _genSimStatement(final ActivateObject stm) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((hub.sam.dmx.javasim.desmoj.SimulationProcess) ");
    Expression _objectAccess = stm.getObjectAccess();
    String _genExpr = this.genExpr(_objectAccess);
    _builder.append(_genExpr, "");
    _builder.append(").base_activate();");
    return _builder.toString();
  }
  
  protected String _genSimStatement(final Reactivate stm) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((hub.sam.dmx.javasim.desmoj.SimulationProcess) ");
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
    return "hub.sam.dmx.javasim.desmoj.DefaultSimulation.DEFAULT.getPresentTime()";
  }
  
  protected String _genSimExpr(final ActiveLiteral stm) {
    return "hub.sam.dmx.javasim.desmoj.DefaultSimulation.DEFAULT.getCurrentProcess()";
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
