/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rhs Classifier Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hub.sam.dbl.RhsClassifierExpr#getClassifier <em>Classifier</em>}</li>
 * </ul>
 *
 * @see hub.sam.dbl.DblPackage#getRhsClassifierExpr()
 * @model
 * @generated
 */
public interface RhsClassifierExpr extends L1RhsExpr {
	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' reference.
	 * @see #setClassifier(LanguageConstructClassifier)
	 * @see hub.sam.dbl.DblPackage#getRhsClassifierExpr_Classifier()
	 * @model required="true"
	 * @generated
	 */
	LanguageConstructClassifier getClassifier();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.RhsClassifierExpr#getClassifier <em>Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier</em>' reference.
	 * @see #getClassifier()
	 * @generated
	 */
	void setClassifier(LanguageConstructClassifier value);

} // RhsClassifierExpr
