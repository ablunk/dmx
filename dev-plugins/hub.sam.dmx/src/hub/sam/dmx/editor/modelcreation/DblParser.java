package hub.sam.dmx.editor.modelcreation;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.Model;
import hub.sam.dbl.provider.DblItemProviderAdapterFactory;
import hub.sam.dmx.Activator;
import hub.sam.dmx.editor.IModelContainer;
import hub.sam.dmx.editor.IPreProcessedDocument;
import hub.sam.dmx.editor.IPreProcessor;
import hub.sam.dmx.editor.SimpleDblPreProcessor;
import hub.sam.dmx.editor.semantics.DblSemanticsProvider;
import hub.sam.tef.modelcreating.HeadlessEclipseParser;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.semantics.ISemanticsProvider;

import java.util.Collection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.osgi.framework.Bundle;

public class DblParser extends HeadlessEclipseParser {
	
	public static final String SYNTAX_DEFINITION_FILE = "/resources/dbl.etslt";

	public DblParser(IPath inputPath, String filename) {
		super(inputPath, filename);
		initPreProcessor();
	}

	@Override
	public IModelCreatingContext createModelCreatingContext() {
		return new DblModelCreationContext(getMetaModelPackages(), getSemanticsProvider(),
				new ResourceImpl(), resourceSet, getCurrentText());
	}
	
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { DblPackage.eINSTANCE };
	}
	
	private DblPackage dblMetaModel;
	
	public DblPackage getDblMetaModel() {
		if (dblMetaModel == null) {
			for (EPackage pkg: getMetaModelPackages()) {
				if (pkg instanceof DblPackage) {
					dblMetaModel = (DblPackage) pkg;
					break;
				}
			}			
		}
		return dblMetaModel;
	}

	@Override
	protected AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { new DblItemProviderAdapterFactory() };
	}
	
	@Override
	protected String getSyntaxPath() {
		return SYNTAX_DEFINITION_FILE;
	}

	@Override
	protected Bundle getPluginBundle() {
		Activator activator = Activator.getDefault();
		if (activator != null) {
			return activator.getBundle();
		} else {
			return null;
		}
	}
	
	@Override
	protected ISemanticsProvider createSemanticsProvider() {
		return new DblSemanticsProvider(new IPreProcessedDocument() {
			
			@Override
			public IPath getPath() {
				return inputPath;
			}

			@Override
			public Collection<IModelContainer> getImportsModels() {
				return getPreProcessor().getImportedModels();
			}

			@Override
			public Model getModel() {
				if (getLastModelCreationContext() != null) {
					return (Model) getLastModelCreationContext().getResource().getContents().get(0);
				}
				else {
					return null;
				}
			}
		});
	}
	
	protected IPreProcessor _preProcessor;
	
	protected IPreProcessor getPreProcessor() {
		return _preProcessor;
	}
	
	protected void initPreProcessor() {
		_preProcessor = new SimpleDblPreProcessor();
	}

	@Override
	protected void preProcess(String inputText, IPath inputPath) {
		getPreProcessor().preProcess(inputText, inputPath);
	}

}
