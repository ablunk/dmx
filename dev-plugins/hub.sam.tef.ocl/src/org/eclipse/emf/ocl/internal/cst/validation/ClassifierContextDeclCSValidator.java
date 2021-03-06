/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ocl.internal.cst.validation;

import org.eclipse.emf.ocl.internal.cst.InvOrDefCS;
import org.eclipse.emf.ocl.internal.cst.PathNameCS;

/**
 * A sample validator interface for {@link org.eclipse.emf.ocl.internal.cst.ClassifierContextDeclCS}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ClassifierContextDeclCSValidator {
	boolean validate();

	boolean validatePathNameCS(PathNameCS value);
	boolean validateInvOrDefCS(InvOrDefCS value);
}
