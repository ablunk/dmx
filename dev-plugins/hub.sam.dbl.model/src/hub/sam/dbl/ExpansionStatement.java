/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expansion Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.ExpansionStatement#isClassContext <em>Class Context</em>}</li>
 *   <li>{@link hub.sam.dbl.ExpansionStatement#isFunctionContext <em>Function Context</em>}</li>
 *   <li>{@link hub.sam.dbl.ExpansionStatement#isVariableContext <em>Variable Context</em>}</li>
 *   <li>{@link hub.sam.dbl.ExpansionStatement#getDifferingContext <em>Differing Context</em>}</li>
 *   <li>{@link hub.sam.dbl.ExpansionStatement#getParts <em>Parts</em>}</li>
 *   <li>{@link hub.sam.dbl.ExpansionStatement#getExprs <em>Exprs</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getExpansionStatement()
 * @model
 * @generated
 */
public interface ExpansionStatement extends SimpleStatement {
	/**
	 * Returns the value of the '<em><b>Class Context</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Context</em>' attribute.
	 * @see #setClassContext(boolean)
	 * @see hub.sam.dbl.DblPackage#getExpansionStatement_ClassContext()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isClassContext();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExpansionStatement#isClassContext <em>Class Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Context</em>' attribute.
	 * @see #isClassContext()
	 * @generated
	 */
	void setClassContext(boolean value);

	/**
	 * Returns the value of the '<em><b>Function Context</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Context</em>' attribute.
	 * @see #setFunctionContext(boolean)
	 * @see hub.sam.dbl.DblPackage#getExpansionStatement_FunctionContext()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isFunctionContext();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExpansionStatement#isFunctionContext <em>Function Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Context</em>' attribute.
	 * @see #isFunctionContext()
	 * @generated
	 */
	void setFunctionContext(boolean value);

	/**
	 * Returns the value of the '<em><b>Variable Context</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Context</em>' attribute.
	 * @see #setVariableContext(boolean)
	 * @see hub.sam.dbl.DblPackage#getExpansionStatement_VariableContext()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isVariableContext();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExpansionStatement#isVariableContext <em>Variable Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Context</em>' attribute.
	 * @see #isVariableContext()
	 * @generated
	 */
	void setVariableContext(boolean value);

	/**
	 * Returns the value of the '<em><b>Differing Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Differing Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Differing Context</em>' containment reference.
	 * @see #setDifferingContext(IdExpr)
	 * @see hub.sam.dbl.DblPackage#getExpansionStatement_DifferingContext()
	 * @model containment="true"
	 * @generated
	 */
	IdExpr getDifferingContext();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ExpansionStatement#getDifferingContext <em>Differing Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Differing Context</em>' containment reference.
	 * @see #getDifferingContext()
	 * @generated
	 */
	void setDifferingContext(IdExpr value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.ExpansionPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getExpansionStatement_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpansionPart> getParts();

	/**
	 * Returns the value of the '<em><b>Exprs</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exprs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exprs</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getExpansionStatement_Exprs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getExprs();

} // ExpansionStatement
