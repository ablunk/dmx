/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.ocl.internal.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Name CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.SimpleNameCS#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.SimpleNameCS#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getSimpleNameCS()
 * @model
 * @generated
 */
public interface SimpleNameCS extends OCLExpressionCS {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getSimpleNameCS_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.SimpleNameCS#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.ocl.internal.cst.SimpleTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.emf.ocl.internal.cst.SimpleTypeEnum
	 * @see #setType(SimpleTypeEnum)
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getSimpleNameCS_Type()
	 * @model
	 * @generated
	 */
	SimpleTypeEnum getType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.SimpleNameCS#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.emf.ocl.internal.cst.SimpleTypeEnum
	 * @see #getType()
	 * @generated
	 */
	void setType(SimpleTypeEnum value);

} // SimpleNameCS
