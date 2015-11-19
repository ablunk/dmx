/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plain Symbol Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.PlainSymbolReference#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link hub.sam.dbl.PlainSymbolReference#getOwnedClassifier <em>Owned Classifier</em>}</li>
 *   <li>{@link hub.sam.dbl.PlainSymbolReference#getReferencedClassifier <em>Referenced Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getPlainSymbolReference()
 * @model
 * @generated
 */
public interface PlainSymbolReference extends L1SyntaxExpression {
	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' reference.
	 * @see hub.sam.dbl.DblPackage#getPlainSymbolReference_Classifier()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	SyntaxSymbolClassifier getClassifier();

	/**
	 * Returns the value of the '<em><b>Owned Classifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Classifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Classifier</em>' containment reference.
	 * @see #setOwnedClassifier(SyntaxSymbolClassifier)
	 * @see hub.sam.dbl.DblPackage#getPlainSymbolReference_OwnedClassifier()
	 * @model containment="true"
	 * @generated
	 */
	SyntaxSymbolClassifier getOwnedClassifier();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.PlainSymbolReference#getOwnedClassifier <em>Owned Classifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Classifier</em>' containment reference.
	 * @see #getOwnedClassifier()
	 * @generated
	 */
	void setOwnedClassifier(SyntaxSymbolClassifier value);

	/**
	 * Returns the value of the '<em><b>Referenced Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Classifier</em>' reference.
	 * @see #setReferencedClassifier(SyntaxSymbolClassifier)
	 * @see hub.sam.dbl.DblPackage#getPlainSymbolReference_ReferencedClassifier()
	 * @model
	 * @generated
	 */
	SyntaxSymbolClassifier getReferencedClassifier();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.PlainSymbolReference#getReferencedClassifier <em>Referenced Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Classifier</em>' reference.
	 * @see #getReferencedClassifier()
	 * @generated
	 */
	void setReferencedClassifier(SyntaxSymbolClassifier value);

} // PlainSymbolReference
