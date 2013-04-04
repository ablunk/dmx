/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Include Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.IncludePattern#getPattern <em>Pattern</em>}</li>
 *   <li>{@link hub.sam.dbl.IncludePattern#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getIncludePattern()
 * @model
 * @generated
 */
public interface IncludePattern extends Statement {
	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' reference.
	 * @see #setPattern(Pattern)
	 * @see hub.sam.dbl.DblPackage#getIncludePattern_Pattern()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Pattern getPattern();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.IncludePattern#getPattern <em>Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(Pattern value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' containment reference.
	 * @see #setContext(Expression)
	 * @see hub.sam.dbl.DblPackage#getIncludePattern_Context()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Expression getContext();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.IncludePattern#getContext <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' containment reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(Expression value);

} // IncludePattern
