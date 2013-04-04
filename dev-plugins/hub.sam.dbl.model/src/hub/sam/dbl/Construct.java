/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Construct</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.Construct#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getConstruct()
 * @model
 * @generated
 */
public interface Construct extends NamedExtension {
	/**
	 * Returns the value of the '<em><b>Concrete Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Syntax</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Syntax</em>' attribute.
	 * @see #setConcreteSyntax(String)
	 * @see hub.sam.dbl.DblPackage#getConstruct_ConcreteSyntax()
	 * @model ordered="false"
	 * @generated
	 */
	String getConcreteSyntax();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.Construct#getConcreteSyntax <em>Concrete Syntax</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concrete Syntax</em>' attribute.
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	void setConcreteSyntax(String value);

} // Construct
