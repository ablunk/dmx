/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package hub.sam.dbl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Similar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ClassSimilar#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link hub.sam.dbl.ClassSimilar#getMethods <em>Methods</em>}</li>
 *   <li>{@link hub.sam.dbl.ClassSimilar#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link hub.sam.dbl.ClassSimilar#getImplementedInterfaces <em>Implemented Interfaces</em>}</li>
 *   <li>{@link hub.sam.dbl.ClassSimilar#getInitialBlock <em>Initial Block</em>}</li>
 *   <li>{@link hub.sam.dbl.ClassSimilar#getFinalBlock <em>Final Block</em>}</li>
 *   <li>{@link hub.sam.dbl.ClassSimilar#getActionsBlock <em>Actions Block</em>}</li>
 *   <li>{@link hub.sam.dbl.ClassSimilar#getReportBlock <em>Report Block</em>}</li>
 *   <li>{@link hub.sam.dbl.ClassSimilar#getClearBlock <em>Clear Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getClassSimilar()
 * @model abstract="true"
 * @generated
 */
public interface ClassSimilar extends EmbeddableExtensionsContainer, ModifierExtensionsContainer {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getAttributes();

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.Procedure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_Methods()
	 * @model containment="true"
	 * @generated
	 */
	EList<Procedure> getMethods();

	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' reference.
	 * @see #setSuperClass(Clazz)
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_SuperClass()
	 * @model ordered="false"
	 * @generated
	 */
	Clazz getSuperClass();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ClassSimilar#getSuperClass <em>Super Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class</em>' reference.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(Clazz value);

	/**
	 * Returns the value of the '<em><b>Implemented Interfaces</b></em>' reference list.
	 * The list contents are of type {@link hub.sam.dbl.Interface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implemented Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implemented Interfaces</em>' reference list.
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_ImplementedInterfaces()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Interface> getImplementedInterfaces();

	/**
	 * Returns the value of the '<em><b>Initial Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Block</em>' containment reference.
	 * @see #setInitialBlock(StartCodeBlock)
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_InitialBlock()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	StartCodeBlock getInitialBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ClassSimilar#getInitialBlock <em>Initial Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Block</em>' containment reference.
	 * @see #getInitialBlock()
	 * @generated
	 */
	void setInitialBlock(StartCodeBlock value);

	/**
	 * Returns the value of the '<em><b>Final Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final Block</em>' containment reference.
	 * @see #setFinalBlock(StartCodeBlock)
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_FinalBlock()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	StartCodeBlock getFinalBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ClassSimilar#getFinalBlock <em>Final Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final Block</em>' containment reference.
	 * @see #getFinalBlock()
	 * @generated
	 */
	void setFinalBlock(StartCodeBlock value);

	/**
	 * Returns the value of the '<em><b>Actions Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions Block</em>' containment reference.
	 * @see #setActionsBlock(StartCodeBlock)
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_ActionsBlock()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	StartCodeBlock getActionsBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ClassSimilar#getActionsBlock <em>Actions Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actions Block</em>' containment reference.
	 * @see #getActionsBlock()
	 * @generated
	 */
	void setActionsBlock(StartCodeBlock value);

	/**
	 * Returns the value of the '<em><b>Report Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Report Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Report Block</em>' containment reference.
	 * @see #setReportBlock(StartCodeBlock)
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_ReportBlock()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	StartCodeBlock getReportBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ClassSimilar#getReportBlock <em>Report Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Report Block</em>' containment reference.
	 * @see #getReportBlock()
	 * @generated
	 */
	void setReportBlock(StartCodeBlock value);

	/**
	 * Returns the value of the '<em><b>Clear Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clear Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Block</em>' containment reference.
	 * @see #setClearBlock(StartCodeBlock)
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_ClearBlock()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	StartCodeBlock getClearBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ClassSimilar#getClearBlock <em>Clear Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear Block</em>' containment reference.
	 * @see #getClearBlock()
	 * @generated
	 */
	void setClearBlock(StartCodeBlock value);

} // ClassSimilar
