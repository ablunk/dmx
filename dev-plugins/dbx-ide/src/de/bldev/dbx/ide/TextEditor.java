package de.bldev.dbx.ide;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;

import de.bldev.dbx.ide.Activator;

import de.bldev.dbx.lang.ecore.dbx.DbxPackage;
import de.bldev.dbx.lang.ecore.dbx.provider.DbxItemProviderAdapterFactory;

public class TextEditor extends hub.sam.tef.editor.text.TextEditor {

	@Override
	public EPackage[] createMetaModelPackages() {
		return new EPackage[] { DbxPackage.eINSTANCE };
	}

	@Override
	protected Bundle getPluginBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected String getSyntaxPath() {
		return "/resources/language-definition/dbx.etslt";
	}

	@Override
	public AdapterFactory[] createItemProviderAdapterFactories() {
		return new AdapterFactory[] { new DbxItemProviderAdapterFactory() };
	}
}