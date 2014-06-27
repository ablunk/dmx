/**
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Id Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.IdExpr#getParentIdExpr <em>Parent Id Expr</em>}</li>
 *   <li>{@link hub.sam.dbl.IdExpr#getReferencedElement <em>Referenced Element</em>}</li>
 *   <li>{@link hub.sam.dbl.IdExpr#getPredefinedId <em>Predefined Id</em>}</li>
 *   <li>{@link hub.sam.dbl.IdExpr#getArrayIndex <em>Array Index</em>}</li>
 *   <li>{@link hub.sam.dbl.IdExpr#getCallPart <em>Call Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getIdExpr()
 * @model
 * @generated
 */
public interface IdExpr extends L1Expr {
	/**
	 * Returns the value of the '<em><b>Parent Id Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Id Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Id Expr</em>' containment reference.
	 * @see #setParentIdExpr(IdExpr)
	 * @see hub.sam.dbl.DblPackage#getIdExpr_ParentIdExpr()
	 * @model containment="true"
	 * @generated
	 */
	IdExpr getParentIdExpr();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.IdExpr#getParentIdExpr <em>Parent Id Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Id Expr</em>' containment reference.
	 * @see #getParentIdExpr()
	 * @generated
	 */
	void setParentIdExpr(IdExpr value);

	/**
	 * Returns the value of the '<em><b>Referenced Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Element</em>' reference.
	 * @see #setReferencedElement(NamedElement)
	 * @see hub.sam.dbl.DblPackage#getIdExpr_ReferencedElement()
	 * @model
	 * @generated
	 */
	NamedElement getReferencedElement();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.IdExpr#getReferencedElement <em>Referenced Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Element</em>' reference.
	 * @see #getReferencedElement()
	 * @generated
	 */
	void setReferencedElement(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Predefined Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Id</em>' containment reference.
	 * @see #setPredefinedId(PredefinedId)
	 * @see hub.sam.dbl.DblPackage#getIdExpr_PredefinedId()
	 * @model containment="true"
	 * @generated
	 */
	PredefinedId getPredefinedId();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.IdExpr#getPredefinedId <em>Predefined Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Id</em>' containment reference.
	 * @see #getPredefinedId()
	 * @generated
	 */
	void setPredefinedId(PredefinedId value);

	/**
	 * Returns the value of the '<em><b>Array Index</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Index</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Index</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getIdExpr_ArrayIndex()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getArrayIndex();

	/**
	 * Returns the value of the '<em><b>Call Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Part</em>' containment reference.
	 * @see #setCallPart(CallPart)
	 * @see hub.sam.dbl.DblPackage#getIdExpr_CallPart()
	 * @model containment="true"
	 * @generated
	 */
	CallPart getCallPart();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.IdExpr#getCallPart <em>Call Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Part</em>' containment reference.
	 * @see #getCallPart()
	 * @generated
	 */
	void setCallPart(CallPart value);

} // IdExpr
