package hub.sam.dmx.editor.semantics;

import java.util.logging.Logger;

import hub.sam.dbl.Import;
import hub.sam.dbl.Model;
import hub.sam.dmx.editor.DblPreProcessor;
import hub.sam.dmx.editor.IModelContainer;
import hub.sam.dmx.editor.IPreProcessedDocument;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.modelcreating.ModelCreatingException;
import hub.sam.tef.modelcreating.ParseTreeNode;
import hub.sam.tef.semantics.AbstractPropertySemantics;
import hub.sam.tef.semantics.DefaultSemanticsProvider;
import hub.sam.tef.semantics.IPropertyCreationSemantics;
import hub.sam.tef.semantics.IValueCreationSemantics;
import hub.sam.tef.tsl.CompositeBinding;
import hub.sam.tef.tsl.ValueBinding;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class DblSemanticsProvider extends DefaultSemanticsProvider {
	
	private static final Logger logger = Logger.getLogger(DblSemanticsProvider.class.getName());

	//private final IPropertyCreationSemantics propertyCreationSemantics = new DblPropertyCreationSemantics();
	private final IPropertyCreationSemantics metaModelReferenceSemantics = new DblMetaModelReferenceSemantics();
	
	private IPropertyCreationSemantics fileImportSemantics;
	private final IPreProcessedDocument preProcessedDocument;
	
	private class FileImportSemantics extends AbstractPropertySemantics implements IPropertyCreationSemantics {

		@Override
		public void addValue(ParseTreeNode parseTreeNode, Object actual, Object value, IModelCreatingContext context,
				CompositeBinding binding) throws ModelCreatingException
		{
			if (actual instanceof Import && value instanceof String && !value.equals("")) {
				final Import imprt = (Import) actual;
				String fileString = (String) value;
				URI fileUri = DblPreProcessor.getPlatformResourceURI(preProcessedDocument.getPath().append(fileString).addFileExtension("xmi"));
				
				for (IModelContainer modelContainer: preProcessedDocument.getImportsModels()) {
					final Resource resource = modelContainer.getResource();
					if (resource != null && resource.getURI() != null && resource.getURI().trimFileExtension().equals(fileUri.trimFileExtension())) {
						if (resource.getContents().size() > 0) {
							Model model = (Model) resource.getContents().get(0);
							
							imprt.setModel(model);
							imprt.setFile(fileString);
							
							logger.info("added model referenced by import of " + imprt.getFile());
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
