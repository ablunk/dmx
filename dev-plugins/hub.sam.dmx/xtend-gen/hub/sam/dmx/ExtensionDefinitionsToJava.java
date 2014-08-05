package hub.sam.dmx;

import com.google.common.base.Objects;
import hub.sam.dbl.ExtensibleElement;
import hub.sam.dbl.ExtensionDefinition;
import hub.sam.dbl.IdExpr;
import hub.sam.dbl.Import;
import hub.sam.dbl.Mapping;
import hub.sam.dbl.MappingStatement;
import hub.sam.dbl.Model;
import hub.sam.dbl.Module;
import hub.sam.dbl.NamedElement;
import hub.sam.dbl.PropertyBindingExpr;
import hub.sam.dbl.PropertyType;
import hub.sam.dbl.ReferableRhsType;
import hub.sam.dbl.StructuredPropertyType;
import hub.sam.dbl.Variable;
import hub.sam.dmx.BasicDblToJavaGenerator;
import java.io.Writer;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Generates executable Java code for all extension definitions, which are
 * used by extensions directly contained in the given model file
 * (extension definitions available by import are not considered).
 */
@SuppressWarnings("all")
public class ExtensionDefinitionsToJava extends BasicDblToJavaGenerator {
  public ExtensionDefinitionsToJava(final IPath outputFolder) {
    super(outputFolder);
  }
  
  public boolean refersToSyntaxPart(final IdExpr idExpr) {
    final IdExpr it = idExpr;
    IdExpr _parentIdExpr = it.getParentIdExpr();
    boolean _equals = Objects.equal(_parentIdExpr, null);
    if (_equals) {
      NamedElement _referencedElement = it.getReferencedElement();
      return (_referencedElement instanceof PropertyBindingExpr);
    } else {
      IdExpr _parentIdExpr_1 = it.getParentIdExpr();
      return this.refersToSyntaxPart(_parentIdExpr_1);
    }
  }
  
  public boolean hasSyntaxType(final IdExpr idExpr) {
    final IdExpr it = idExpr;
    IdExpr _parentIdExpr = it.getParentIdExpr();
    boolean _equals = Objects.equal(_parentIdExpr, null);
    if (_equals) {
      NamedElement _referencedElement = it.getReferencedElement();
      return (_referencedElement instanceof ExtensibleElement);
    } else {
      IdExpr _parentIdExpr_1 = it.getParentIdExpr();
      return this.hasSyntaxType(_parentIdExpr_1);
    }
  }
  
  public <T extends Object> T getContainerObjectOfType(final EObject object, final Class<T> type) {
    Class<? extends EObject> _class = object.getClass();
    boolean _isAssignableFrom = type.isAssignableFrom(_class);
    if (_isAssignableFrom) {
      return ((T) object);
    } else {
      EObject _eContainer = object.eContainer();
      boolean _equals = Objects.equal(_eContainer, null);
      if (_equals) {
        return null;
      } else {
        EObject _eContainer_1 = object.eContainer();
        return this.<T>getContainerObjectOfType(_eContainer_1, type);
      }
    }
  }
  
  public boolean isPartOfGenStatement(final IdExpr idExpr) {
    MappingStatement _containerObjectOfType = this.<MappingStatement>getContainerObjectOfType(idExpr, MappingStatement.class);
    return (!Objects.equal(_containerObjectOfType, null));
  }
  
  public boolean refersToSyntaxPart_ofType_StructuredPropertyType(final IdExpr idExpr) {
    boolean _xblockexpression = false;
    {
      final IdExpr it = idExpr;
      boolean _xifexpression = false;
      NamedElement _referencedElement = it.getReferencedElement();
      if ((_referencedElement instanceof PropertyBindingExpr)) {
        NamedElement _referencedElement_1 = it.getReferencedElement();
        PropertyType _propertyType = ((PropertyBindingExpr) _referencedElement_1).getPropertyType();
        return (_propertyType instanceof StructuredPropertyType);
      } else {
        _xifexpression = false;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public boolean refersToVariable_ofType_StructuredPropertyType(final IdExpr idExpr) {
    boolean _xblockexpression = false;
    {
      final IdExpr it = idExpr;
      NamedElement _referencedElement = it.getReferencedElement();
      if ((_referencedElement instanceof Variable)) {
        NamedElement _referencedElement_1 = it.getReferencedElement();
        final Variable variable = ((Variable) _referencedElement_1);
        IdExpr _classifierType = variable.getClassifierType();
        boolean _notEquals = (!Objects.equal(_classifierType, null));
        if (_notEquals) {
          IdExpr _classifierType_1 = variable.getClassifierType();
          final NamedElement type = _classifierType_1.getReferencedElement();
          return (type instanceof ReferableRhsType);
        }
      }
      _xblockexpression = (false);
    }
    return _xblockexpression;
  }
  
  public String genIdExpr(final IdExpr idExpr) {
    String _xblockexpression = null;
    {
      final IdExpr it = idExpr;
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _and = false;
        boolean _and_1 = false;
        boolean _refersToSyntaxPart = this.refersToSyntaxPart(it);
        if (!_refersToSyntaxPart) {
          _and_1 = false;
        } else {
          boolean _isPartOfGenStatement = this.isPartOfGenStatement(it);
          _and_1 = (_refersToSyntaxPart && _isPartOfGenStatement);
        }
        if (!_and_1) {
          _and = false;
        } else {
          boolean _or = false;
          boolean _refersToSyntaxPart_ofType_StructuredPropertyType = this.refersToSyntaxPart_ofType_StructuredPropertyType(it);
          if (_refersToSyntaxPart_ofType_StructuredPropertyType) {
            _or = true;
          } else {
            boolean _refersToVariable_ofType_StructuredPropertyType = this.refersToVariable_ofType_StructuredPropertyType(it);
            _or = (_refersToSyntaxPart_ofType_StructuredPropertyType || _refersToVariable_ofType_StructuredPropertyType);
          }
          _and = (_and_1 && _or);
        }
        if (_and) {
          _builder.append("((ExtensibleElement) ");
          String _genIdExpr = super.genIdExpr(idExpr);
          _builder.append(_genIdExpr, "");
          _builder.append(").getConcreteSyntax()");
          _builder.newLineIfNotEmpty();
        } else {
          String _genIdExpr_1 = super.genIdExpr(idExpr);
          _builder.append(_genIdExpr_1, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
  
  public String genIdExpr_for_PredefinedId_meLiteral() {
    return "_extensionInstance";
  }
  
  public String genIdExpr_for_PropertyBindingExpr(final IdExpr idExpr, final PropertyBindingExpr referencedElement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("getPropertyValue(_extensionInstance ,\"");
    String _name = referencedElement.getName();
    _builder.append(_name, "");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public ExtensionDefinition getImportedExtensionDefinition(final Model model, final String name) {
    ExtensionDefinition extDef = null;
    EList<Import> _imports = model.getImports();
    for (final Import imprt : _imports) {
      Model _model = imprt.getModel();
      boolean _notEquals = (!Objects.equal(_model, null));
      if (_notEquals) {
        Model _model_1 = imprt.getModel();
        EList<Module> _modules = _model_1.getModules();
        for (final Module module : _modules) {
          {
            EList<ExtensionDefinition> _extensionDefs = module.getExtensionDefs();
            final Function1<ExtensionDefinition,Boolean> _function = new Function1<ExtensionDefinition,Boolean>() {
              public Boolean apply(final ExtensionDefinition e) {
                String _name = e.getName();
                boolean _equals = Objects.equal(_name, name);
                return Boolean.valueOf(_equals);
              }
            };
            ExtensionDefinition _findFirst = IterableExtensions.<ExtensionDefinition>findFirst(_extensionDefs, _function);
            extDef = _findFirst;
            boolean _notEquals_1 = (!Objects.equal(extDef, null));
            if (_notEquals_1) {
              return extDef;
            }
          }
        }
        Model _model_2 = imprt.getModel();
        ExtensionDefinition _importedExtensionDefinition = this.getImportedExtensionDefinition(_model_2, name);
        extDef = _importedExtensionDefinition;
        boolean _notEquals_1 = (!Objects.equal(extDef, null));
        if (_notEquals_1) {
          return extDef;
        }
      }
    }
    return extDef;
  }
  
  public void genExtensionDefinition(final Model model, final String extensionDefinitionName) {
    ExtensionDefinition extensionDefinition = this.getImportedExtensionDefinition(model, extensionDefinitionName);
    boolean _notEquals = (!Objects.equal(extensionDefinition, null));
    if (_notEquals) {
      this.genExtensionDefinition(model, extensionDefinition);
    }
  }
  
  public void genExtensionDefinition(final Model model, final ExtensionDefinition extensionDefinition) {
    try {
      String _name = extensionDefinition.getName();
      String _plus = ("Generating Java code for extension definition " + _name);
      String _plus_1 = (_plus + " ... ");
      InputOutput.<String>print(_plus_1);
      EObject _eContainer = extensionDefinition.eContainer();
      final Module module = ((Module) _eContainer);
      String _name_1 = module.getName();
      final IPath moduleFolder = this.javaPackageFolder.append(_name_1);
      this.makeFolder(moduleFolder);
      final String result = this.genExtensionDefinition(extensionDefinition);
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(result, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _notEquals_1 = (!Objects.equal(result, ""));
        _and = (_notEquals && _notEquals_1);
      }
      if (_and) {
        String _name_2 = extensionDefinition.getName();
        String _plus_2 = (_name_2 + "Semantics.java");
        final Writer writer = this.beginTargetFile(moduleFolder, _plus_2);
        writer.write(result);
        this.endTargetFile(writer);
        InputOutput.<String>println("ok.");
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String genExtensionDefinition(final ExtensionDefinition extensionDefinition) {
    String _xblockexpression = null;
    {
      final ExtensionDefinition it = extensionDefinition;
      StringConcatenation _builder = new StringConcatenation();
      EObject _eContainer = extensionDefinition.eContainer();
      String _genPackageStatement = this.genPackageStatement(((Module) _eContainer));
      _builder.append(_genPackageStatement, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import hub.sam.dmx.AbstractExtensionSemantics;");
      _builder.newLine();
      _builder.append("import hub.sam.dbl.*;");
      _builder.newLine();
      _builder.append("import org.eclipse.emf.ecore.EObject;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      String _name = it.getName();
      _builder.append(_name, "");
      _builder.append("Semantics extends AbstractExtensionSemantics {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void main(String[] args) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("(new ");
      String _name_1 = it.getName();
      _builder.append(_name_1, "		");
      _builder.append("Semantics()).doGenerate(args);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void doGenerate(EObject _extensionInstance) {");
      _builder.newLine();
      _builder.append("\t\t");
      Mapping _mappingDef = it.getMappingDef();
      String _genStatement = this.genStatement(_mappingDef);
      _builder.append(_genStatement, "		");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = (_builder.toString());
    }
    return _xblockexpression;
  }
}
