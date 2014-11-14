package hub.sam.dmx;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import hub.sam.dmx.AbstractGenerator;
import java.io.Writer;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class EcoreToDblGenerator extends AbstractGenerator {
  public EcoreToDblGenerator(final IPath outputFolder) {
    super(outputFolder);
  }
  
  public void startGenerator(final String outputFile, final EPackage metamodel, final String javaPackagePrefix, final String[] imports) {
    try {
      final Writer writer = this.beginTargetFile(outputFile);
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _notEquals = (!Objects.equal(imports, null));
        if (_notEquals) {
          {
            for(final String i : imports) {
              _builder.append("#import \"");
              _builder.append(i, "");
              _builder.append("\"");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("module ");
      String _name = metamodel.getName();
      _builder.append(_name, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      writer.write(_builder.toString());
      EList<EClassifier> _eClassifiers = metamodel.getEClassifiers();
      Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
      final Procedure1<EClass> _function = new Procedure1<EClass>() {
        public void apply(final EClass it) {
          try {
            String _genEClass = EcoreToDblGenerator.this.genEClass(it, javaPackagePrefix);
            writer.write(_genEClass);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      IterableExtensions.<EClass>forEach(_filter, _function);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      writer.write(_builder_1.toString());
      this.endTargetFile(writer);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void startGenerator() {
    this.makeFolder("resources-gen");
    this.startGenerator("resources-gen/ecore.dbl", EcorePackage.eINSTANCE, "org.eclipse.emf.ecore", null);
  }
  
  public static void main(final String[] args) {
    EcoreToDblGenerator _ecoreToDblGenerator = new EcoreToDblGenerator(null);
    _ecoreToDblGenerator.startGenerator();
  }
  
  public String genFeature(final EStructuralFeature feature) {
    String _xblockexpression = null;
    {
      final EStructuralFeature it = feature;
      StringConcatenation _builder = new StringConcatenation();
      String _genAttribute = this.genAttribute(it);
      _builder.append(_genAttribute, "");
      _builder.newLineIfNotEmpty();
      {
        boolean _isChangeable = it.isChangeable();
        if (_isChangeable) {
          String _genSetter = this.genSetter(it);
          _builder.append(_genSetter, "");
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public String genAttribute(final EStructuralFeature feature) {
    String _xblockexpression = null;
    {
      final EStructuralFeature it = feature;
      String _genType = this.genType(it);
      String _plus = (_genType + " ");
      String _name = it.getName();
      String _plus_1 = (_plus + _name);
      _xblockexpression = (_plus_1 + ";");
    }
    return _xblockexpression;
  }
  
  public String genGetter(final EStructuralFeature feature) {
    String _xblockexpression = null;
    {
      final EStructuralFeature it = feature;
      String _genType = this.genType(it);
      String _plus = (_genType + " ");
      String _xifexpression = null;
      EClassifier _eType = it.getEType();
      String _name = _eType.getName();
      boolean _equals = _name.equals("EBoolean");
      if (_equals) {
        _xifexpression = "is";
      } else {
        _xifexpression = "get";
      }
      String _plus_1 = (_plus + _xifexpression);
      String _name_1 = it.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name_1);
      String _plus_2 = (_plus_1 + _firstUpper);
      _xblockexpression = (_plus_2 + "() abstract;");
    }
    return _xblockexpression;
  }
  
  public String genSetter(final EStructuralFeature feature) {
    String _xblockexpression = null;
    {
      final EStructuralFeature it = feature;
      String _xifexpression = null;
      boolean _isMany = feature.isMany();
      boolean _not = (!_isMany);
      if (_not) {
        String _name = it.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name);
        String _plus = ("void set" + _firstUpper);
        String _plus_1 = (_plus + "(");
        String _genType = this.genType(it);
        String _plus_2 = (_plus_1 + _genType);
        _xifexpression = (_plus_2 + " value) abstract;");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String genEClass(final EClass eClass, final String javaPackagePrefix) {
    String _xblockexpression = null;
    {
      final EClass it = eClass;
      String _xifexpression = null;
      String _name = it.getName();
      boolean _equals = _name.equals("EObject");
      boolean _not = (!_equals);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class ");
        String _name_1 = it.getName();
        _builder.append(_name_1, "");
        _builder.newLineIfNotEmpty();
        {
          EList<EClass> _eSuperTypes = it.getESuperTypes();
          boolean _isEmpty = _eSuperTypes.isEmpty();
          if (_isEmpty) {
            _builder.append("extends EObject");
            _builder.newLine();
          } else {
            _builder.append("extends ");
            _builder.newLine();
            {
              EList<EClass> _eSuperTypes_1 = it.getESuperTypes();
              boolean _hasElements = false;
              for(final EClass superClass : _eSuperTypes_1) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(",", "");
                }
                String _name_2 = superClass.getName();
                _builder.append(_name_2, "");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("bindings {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\"java\" -> \"");
        _builder.append(javaPackagePrefix, "\t\t");
        _builder.append(".");
        String _name_3 = it.getName();
        _builder.append(_name_3, "\t\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
        {
          EList<EStructuralFeature> _eStructuralFeatures = it.getEStructuralFeatures();
          for(final EStructuralFeature feature : _eStructuralFeatures) {
            _builder.append("\t");
            String _genFeature = this.genFeature(feature);
            _builder.append(_genFeature, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("}");
        _builder.newLine();
        _xifexpression = _builder.toString();
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("class Object {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("bindings {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\"java\" -> \"java.lang.Object\"");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Class {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("bindings {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\"java\" -> \"java.lang.Class\"");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class Enumerator {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("bindings {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\"java\" -> \"org.eclipse.emf.common.util.Enumerator\"");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class ListIterator {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("bindings {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\"java\" -> \"java.util.Iterator\"");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("boolean hasNext() abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("Object next() abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("void remove() abstract;");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class List {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("bindings {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\"java\" -> \"java.util.List\"");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("boolean add(Object e) abstract;");
        _builder_1.newLine();
        _builder_1.append("boolean add(int index, Object e) abstract;");
        _builder_1.newLine();
        _builder_1.append("void clear() abstract;");
        _builder_1.newLine();
        _builder_1.append("boolean contains(Object e) abstract;");
        _builder_1.newLine();
        _builder_1.append("int size() abstract;");
        _builder_1.newLine();
        _builder_1.append("Object get(int index) abstract;");
        _builder_1.newLine();
        _builder_1.append("int indexOf(Object e) abstract;");
        _builder_1.newLine();
        _builder_1.append("boolean isEmpty() abstract;");
        _builder_1.newLine();
        _builder_1.append("Object remove(int index) abstract;");
        _builder_1.newLine();
        _builder_1.append("boolean remove(Object e) abstract;");
        _builder_1.newLine();
        _builder_1.append("Object set(int index, Object e) abstract;");
        _builder_1.newLine();
        _builder_1.append("Object array[] toArray() abstract;");
        _builder_1.newLine();
        _builder_1.append("ListIterator iterator() abstract;");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("class EObject {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("bindings {");
        _builder_1.newLine();
        _builder_1.append("\t\t");
        _builder_1.append("\"java\" -> \"org.eclipse.emf.ecore.EObject\"");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("EClass eClass() abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("//Resource eResource() abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("EObject eContainer() abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("EStructuralFeature eContainingFeature() abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("EReference eContainmentFeature() abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("List eContents() abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("List eAllContents() abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("//boolean eIsProxy() abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("//EList eCrossReferences() abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("Object eGet(EStructuralFeature feature) abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("Object eGet(EStructuralFeature feature, boolean resolve) abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("void eSet(EStructuralFeature feature, Object newValue) abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("boolean eIsSet(EStructuralFeature feature) abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("void eUnset(EStructuralFeature feature) abstract;");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("//Object eInvoke(EOperation operation, Object array[] arguments) abstract;");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _xifexpression = _builder_1.toString();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String genType(final ETypedElement typedElement) {
    String _xblockexpression = null;
    {
      final ETypedElement it = typedElement;
      String _xifexpression = null;
      EClassifier _eType = it.getEType();
      boolean _notEquals = (!Objects.equal(_eType, null));
      if (_notEquals) {
        String _xifexpression_1 = null;
        boolean _isMany = it.isMany();
        if (_isMany) {
          _xifexpression_1 = "List";
        } else {
          String _switchResult = null;
          EClassifier _eType_1 = it.getEType();
          String _name = _eType_1.getName();
          boolean _matched = false;
          if (!_matched) {
            if (Objects.equal(_name, "EInt")) {
              _matched=true;
              _switchResult = "int";
            }
          }
          if (!_matched) {
            if (Objects.equal(_name, "EBigInteger")) {
              _matched=true;
              _switchResult = "int";
            }
          }
          if (!_matched) {
            if (Objects.equal(_name, "EDouble")) {
              _matched=true;
              _switchResult = "double";
            }
          }
          if (!_matched) {
            if (Objects.equal(_name, "EBoolean")) {
              _matched=true;
              _switchResult = "boolean";
            }
          }
          if (!_matched) {
            if (Objects.equal(_name, "EString")) {
              _matched=true;
              _switchResult = "string";
            }
          }
          if (!_matched) {
            if (Objects.equal(_name, "EJavaObject")) {
              _matched=true;
              _switchResult = "Object";
            }
          }
          if (!_matched) {
            if (Objects.equal(_name, "EJavaClass")) {
              _matched=true;
              _switchResult = "Class";
            }
          }
          if (!_matched) {
            if (Objects.equal(_name, "EEnumerator")) {
              _matched=true;
              _switchResult = "Enumerator";
            }
          }
          if (!_matched) {
            EClassifier _eType_2 = it.getEType();
            _switchResult = _eType_2.getName();
          }
          _xifexpression_1 = _switchResult;
        }
        _xifexpression = _xifexpression_1;
      } else {
        _xifexpression = "void";
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
