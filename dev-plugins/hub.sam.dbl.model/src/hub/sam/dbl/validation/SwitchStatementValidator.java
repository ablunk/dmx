/**
 *
 * $Id$
 */
package hub.sam.dbl.validation;

import hub.sam.dbl.SwitchCase;
import hub.sam.dbl.VariableAccess;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link hub.sam.dbl.SwitchStatement}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SwitchStatementValidator {
	boolean validate();

	boolean validateVariable(VariableAccess value);
	boolean validateCases(EList<SwitchCase> value);
	boolean validateDefaultCase(SwitchCase value);
}