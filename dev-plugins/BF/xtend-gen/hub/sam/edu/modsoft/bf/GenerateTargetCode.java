package hub.sam.edu.modsoft.bf;

import hub.sam.edu.modsoft.bfmodel.bf.BfFactory;
import hub.sam.edu.modsoft.bfmodel.bf.BfPackage;
import hub.sam.edu.modsoft.bfmodel.bf.Box;
import hub.sam.edu.modsoft.bfmodel.bf.Flow;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class GenerateTargetCode {
  public static void main(final String[] args) {
    final ResourceSet resourceSet = new ResourceSetImpl();
    Resource.Factory.Registry _resourceFactoryRegistry = resourceSet.getResourceFactoryRegistry();
    Map<String, Object> _extensionToFactoryMap = _resourceFactoryRegistry.getExtensionToFactoryMap();
    XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
    _extensionToFactoryMap.put("bf", _xMIResourceFactoryImpl);
    EPackage.Registry _packageRegistry = resourceSet.getPackageRegistry();
    _packageRegistry.put(BfPackage.eNS_URI, BfPackage.eINSTANCE);
    File _file = new File("resources/test.bf");
    String _absolutePath = _file.getAbsolutePath();
    final URI fileURI = URI.createFileURI(_absolutePath);
    final Resource res = resourceSet.createResource(fileURI);
    final Box box = BfFactory.eINSTANCE.createBox();
    box.setName("A");
    EList<EObject> _contents = res.getContents();
    _contents.add(box);
    final Flow flow = BfFactory.eINSTANCE.createFlow();
    EList<Flow> _flows = box.getFlows();
    _flows.add(flow);
    flow.setSourceBox(box);
    flow.setTargetBox(box);
    final EClass itemClass = EcoreFactory.eINSTANCE.createEClass();
    itemClass.setName("Item");
    EList<EClassifier> _eClassifiers = BfPackage.eINSTANCE.getEClassifiers();
    _eClassifiers.add(itemClass);
    final EAttribute nameAttribute = EcoreFactory.eINSTANCE.createEAttribute();
    final EAttribute it = nameAttribute;
    it.setName("itemName");
    EDataType _eString = EcorePackage.eINSTANCE.getEString();
    it.setEType(_eString);
    EList<EStructuralFeature> _eStructuralFeatures = itemClass.getEStructuralFeatures();
    _eStructuralFeatures.add(nameAttribute);
    EList<EClass> _eSuperTypes = itemClass.getESuperTypes();
    EClass _box = BfPackage.eINSTANCE.getBox();
    _eSuperTypes.add(_box);
    EObject _createEObject = EcoreFactory.eINSTANCE.createEObject();
    final EObjectImpl item = ((EObjectImpl) _createEObject);
    item.eSetClass(itemClass);
    EList<EObject> _contents_1 = res.getContents();
    _contents_1.add(item);
    item.eSet(nameAttribute, "blub");
    EList<EStructuralFeature> _eAllStructuralFeatures = itemClass.getEAllStructuralFeatures();
    final Function1<EStructuralFeature, Boolean> _function = new Function1<EStructuralFeature, Boolean>() {
      public Boolean apply(final EStructuralFeature sf) {
        String _name = sf.getName();
        return Boolean.valueOf(_name.equals("name"));
      }
    };
    EStructuralFeature _findFirst = IterableExtensions.<EStructuralFeature>findFirst(_eAllStructuralFeatures, _function);
    item.eSet(_findFirst, "boing");
    EClass _box_1 = BfPackage.eINSTANCE.getBox();
    boolean _isSuperTypeOf = _box_1.isSuperTypeOf(itemClass);
    InputOutput.<Boolean>println(Boolean.valueOf(_isSuperTypeOf));
    try {
      res.save(Collections.EMPTY_MAP);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    GenerateTargetCode _generateTargetCode = new GenerateTargetCode();
    _generateTargetCode.generate(res);
  }
  
  public void generate(final Resource res) {
    EList<EObject> _contents = res.getContents();
    final Procedure1<EObject> _function = new Procedure1<EObject>() {
      public void apply(final EObject eObject) {
        CharSequence _compile = GenerateTargetCode.this.compile(eObject);
        InputOutput.<CharSequence>println(_compile);
      }
    };
    IterableExtensions.<EObject>forEach(_contents, _function);
  }
  
  public CharSequence _compile(final EObject eObject) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      EClass _eClass = eObject.eClass();
      String _name = _eClass.getName();
      boolean _equals = _name.equals("Item");
      if (_equals) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Item");
        _builder.newLine();
        _builder.append("\t");
        EClass _eClass_1 = eObject.eClass();
        EList<EStructuralFeature> _eAllStructuralFeatures = _eClass_1.getEAllStructuralFeatures();
        final Function1<EStructuralFeature, Boolean> _function = new Function1<EStructuralFeature, Boolean>() {
          public Boolean apply(final EStructuralFeature sf) {
            String _name = sf.getName();
            return Boolean.valueOf(_name.equals("itemName"));
          }
        };
        EStructuralFeature _findFirst = IterableExtensions.<EStructuralFeature>findFirst(_eAllStructuralFeatures, _function);
        Object _eGet = eObject.eGet(_findFirst);
        _builder.append(_eGet, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        EClass _eClass_2 = eObject.eClass();
        EList<EStructuralFeature> _eAllStructuralFeatures_1 = _eClass_2.getEAllStructuralFeatures();
        final Function1<EStructuralFeature, Boolean> _function_1 = new Function1<EStructuralFeature, Boolean>() {
          public Boolean apply(final EStructuralFeature sf) {
            String _name = sf.getName();
            return Boolean.valueOf(_name.equals("name"));
          }
        };
        EStructuralFeature _findFirst_1 = IterableExtensions.<EStructuralFeature>findFirst(_eAllStructuralFeatures_1, _function_1);
        Object _eGet_1 = eObject.eGet(_findFirst_1);
        _builder.append(_eGet_1, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append(".");
        _builder.newLine();
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      _switchResult = "<unknown eobject>";
    }
    return _switchResult;
  }
  
  public CharSequence _compile(final Box box) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Box ");
    String _name = box.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    StringConcatenation _builder_1 = new StringConcatenation();
    {
      EList<Flow> _flows = box.getFlows();
      boolean _isEmpty = _flows.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder_1.append("with");
        _builder_1.newLineIfNotEmpty();
        {
          EList<Flow> _flows_1 = box.getFlows();
          boolean _hasElements = false;
          for(final Flow flow : _flows_1) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder_1.appendImmediate(", ", "\t");
            }
            _builder_1.append("\t");
            _builder_1.append("flow from ");
            Box _sourceBox = flow.getSourceBox();
            String _name_1 = _sourceBox.getName();
            _builder_1.append(_name_1, "\t");
            _builder_1.append(" to ");
            Box _targetBox = flow.getTargetBox();
            String _name_2 = _targetBox.getName();
            _builder_1.append(_name_2, "\t");
            _builder_1.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder_1.append(".");
    _builder_1.newLineIfNotEmpty();
    String _string = _builder_1.toString();
    String _trim = _string.trim();
    return (_builder.toString() + _trim);
  }
  
  public CharSequence compile(final EObject box) {
    if (box instanceof Box) {
      return _compile((Box)box);
    } else if (box != null) {
      return _compile(box);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(box).toString());
    }
  }
}
