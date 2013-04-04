package hub.sam.dmx;

import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.dbl.Import;
import hub.sam.dbl.Model;
import hub.sam.tef.semantics.AbstractPropertySemantics;
import hub.sam.tef.semantics.DefaultSemanticsProvider;
import hub.sam.tef.semantics.IPropertyCreationSemantics;
import hub.sam.tef.semantics.IValueCreationSemantics;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ValueBinding;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class DblSemanticsProvider extends DefaultSemanticsProvider {

	private final IPropertyCreationSemantics propertyCreationSemantics = new DblPropertyCreationSemantics();
	private final IPropertyCreationSemantics metaModelReferenceSemantics = new DblMetaModelReferenceSemantics();
	
	private IPropertyCreationSemantics fileImportSemantics;
	private final IPreProcessedDocument preProcessedDocument;
	
	private class FileImportSemantics extends AbstractPropertySemantics implements IPropertyCreationSemantics {

		@Override
		public void addValue(ParseTreeNode parseTreeNode, Object actual, Object value, IModelCreatingContext context,
				CompositeBinding binding) throws ModelCreatingException {
			if (actual instanceof Import && value instanceof String && !value.equals("")) {
				Import imprt = (Import) actual;
				String stringValue = (String) value;
				//IPath editorInputLocation = ((FileEditorInput)editor.getEditorInput()).getFile().getLocation().removeLastSegments(1);
				IPath editorInputLocation = preProcessedDocument.getLocation().removeLastSegments(1);
				URI fileURI = URI.createFileURI(editorInputLocation.append(stringValue).addFileExtension("xmi").toPortableString());
				
				for (Resource resource: preProcessedDocument.getImportedResources()) {
					if (resource.getURI() != null && resource.getURI().equals(fileURI)) {
						if (resource.getContents().size() > 0) {
							Model model = (Model) resource.getContents().get(0);
							imprt.setModel(model);
							imprt.setFile(stringValue);
							System.out.println("added model for import " + imprt.getFile());
						}
					}
				}
				
			}
		}
		
	}

	public DblSemanticsProvider(IPreProcessedDocument preProcessedDocument) {
		super(new DblIdentificationScheme(preProcessedDocument));
		this.preProcessedDocument = preProcessedDocument;
	}

	@Override
	public IValueCreationSemantics getValueCreationSemanitcs(ValueBinding binding) {
		return super.getValueCreationSemanitcs(binding);
	}

	@Override
	public IPropertyCreationSemantics getPropertyCreationSemantics(CompositeBinding binding) {
		if (binding.getProperty().getName().equals("metaModelPlatformURI")) {
			return metaModelReferenceSemantics;
		}
		else if (binding.getProperty().getName().equals("file")) {
			if (fileImportSemantics == null) {
				fileImportSemantics = new FileImportSemantics();
			}
			return fileImportSemantics;
		}
		return super.getPropertyCreationSemantics(binding);
	}

}
