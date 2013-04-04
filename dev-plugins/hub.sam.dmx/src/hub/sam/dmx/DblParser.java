package hub.sam.dmx;

import hub.sam.dbl.DblPackage;
import hub.sam.dbl.provider.DblItemProviderAdapterFactory;
import hub.sam.tef.modelcreating.HeadlessEclipseParser;
import hub.sam.tef.modelcreating.IModelCreatingContext;
import hub.sam.tef.semantics.ISemanticsProvider;

import java.util.Collection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.osgi.framework.Bundle;

public class DblParser extends HeadlessEclipseParser {
	
	public DblParser(IPath inputLocation) {
		super(inputLocation);
	}

	@Override
	public IModelCreatingContext createModelCreatingContext() {
		return new DblModelCreationContext(getMetaModelPackages(), getSemanticsProvider(),
				new ResourceImpl(), resourceSet, getCurrentText());
	}
	
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { DblPackage.eINSTANCE };
	}

	@Override
	protected AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { new DblItemProviderAdapterFactory() };
	}
	
	@Override
	protected String getSyntaxPath() {
		return "/resources/dbl.etslt";
	}

	@Override
	protected Bundle getPluginBundle() {
		return Activator.getDefault().getBundle();
	}
	
	@Override
	protected ISemanticsProvider createSemanticsProvider() {
		return new DblSemanticsProvider(new IPreProcessedDocument() {
			
			@Override
			public IPath getLocation() {
				return inputLocation;
			}
			
			@Override
			public Collection<Resource> getImportedResources() {
				return preProcessor.getImportedResources();
			}
			
			@Override
			public Resource getCurrentModel() {
				if (getLastModelCreationContext() != null) {
					return getLastModelCreationContext().getResource();
				}
				else {
					return null;
				}
			}
		});
	}
	
	private DblPreProcessor preProcessor = new DblPreProcessor();

	@Override
	protected void preProcess(String inputText, IPath inputLocation) {
		preProcessor.preProcess(inputText, inputLocation);
	}

}
