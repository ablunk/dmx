/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Symbol Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.StructuralSymbolReference#isList <em>List</em>}</li>
 *   <li>{@link hub.sam.dbl.StructuralSymbolReference#isComposite <em>Composite</em>}</li>
 *   <li>{@link hub.sam.dbl.StructuralSymbolReference#isLocalScopedReference <em>Local Scoped Reference</em>}</li>
 *   <li>{@link hub.sam.dbl.StructuralSymbolReference#isGlobalScopedReference <em>Global Scoped Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getStructuralSymbolReference()
 * @model
 * @generated
 */
public interface StructuralSymbolReference extends NamedElement, PlainSymbolReference {
	/**
	 * Returns the value of the '<em><b>List</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List</em>' attribute.
	 * @see #setList(boolean)
	 * @see hub.sam.dbl.DblPackage#getStructuralSymbolReference_List()
	 * @model default="false" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='PlainSymbolReference' unique='false' upper='*'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='PlainSymbolReference' unique='false' upper='*'"
	 * @generated
	 */
	boolean isList();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.StructuralSymbolReference#isList <em>List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List</em>' attribute.
	 * @see #isList()
	 * @generated
	 */
	void setList(boolean value);

	/**
	 * Returns the value of the '<em><b>Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite</em>' attribute.
	 * @see hub.sam.dbl.DblPackage#getStructuralSymbolReference_Composite()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='PlainSymbolReference'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='PlainSymbolReference'"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot derivation='not localScopedReference and not globalScopedReference'"
	 * @generated
	 */
	boolean isComposite();

	/**
	 * Returns the value of the '<em><b>Local Scoped Reference</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Scoped Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Scoped Reference</em>' attribute.
	 * @see #setLocalScopedReference(boolean)
	 * @see hub.sam.dbl.DblPackage#getStructuralSymbolReference_LocalScopedReference()
	 * @model default="false" required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='PlainSymbolReference' unique='false' upper='*'"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='PlainSymbolReference' unique='false' upper='*'"
	 * @generated
	 */
	boolean isLocalScopedReference();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.StructuralSymbolReference#isLocalScopedReference <em>Local Scoped Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Scoped Reference</em>' attribute.
	 * @see #isLocalScopedReference()
	 * @generated
	 */
	void setLocalScopedReference(boolean value);

	/**
	 * Returns the value of the '<em><b>Global Scoped Reference</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Scoped Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Scoped Reference</em>' attribute.
	 * @see #setGlobalScopedReference(boolean)
	 * @see hub.sam.dbl.DblPackage#getStructuralSymbolReference_GlobalScopedReference()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isGlobalScopedReference();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.StructuralSymbolReference#isGlobalScopedReference <em>Global Scoped Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Scoped Reference</em>' attribute.
	 * @see #isGlobalScopedReference()
	 * @generated
	 */
	void setGlobalScopedReference(boolean value);

} // StructuralSymbolReference
