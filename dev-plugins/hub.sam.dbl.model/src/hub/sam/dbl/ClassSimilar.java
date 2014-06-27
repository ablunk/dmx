/**
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
 *   <li>{@link hub.sam.dbl.ClassSimilar#getSuperClasses <em>Super Classes</em>}</li>
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
	 * Returns the value of the '<em><b>Super Classes</b></em>' containment reference list.
	 * The list contents are of type {@link hub.sam.dbl.SuperClassSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Classes</em>' containment reference list.
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_SuperClasses()
	 * @model containment="true"
	 * @generated
	 */
	EList<SuperClassSpecification> getSuperClasses();

	/**
	 * Returns the value of the '<em><b>Initial Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Block</em>' containment reference.
	 * @see #setInitialBlock(ClassPart)
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_InitialBlock()
	 * @model containment="true"
	 * @generated
	 */
	ClassPart getInitialBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ClassSimilar#getInitialBlock <em>Initial Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Block</em>' containment reference.
	 * @see #getInitialBlock()
	 * @generated
	 */
	void setInitialBlock(ClassPart value);

	/**
	 * Returns the value of the '<em><b>Final Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final Block</em>' containment reference.
	 * @see #setFinalBlock(ClassPart)
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_FinalBlock()
	 * @model containment="true"
	 * @generated
	 */
	ClassPart getFinalBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ClassSimilar#getFinalBlock <em>Final Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final Block</em>' containment reference.
	 * @see #getFinalBlock()
	 * @generated
	 */
	void setFinalBlock(ClassPart value);

	/**
	 * Returns the value of the '<em><b>Actions Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions Block</em>' containment reference.
	 * @see #setActionsBlock(ClassPart)
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_ActionsBlock()
	 * @model containment="true"
	 * @generated
	 */
	ClassPart getActionsBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ClassSimilar#getActionsBlock <em>Actions Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actions Block</em>' containment reference.
	 * @see #getActionsBlock()
	 * @generated
	 */
	void setActionsBlock(ClassPart value);

	/**
	 * Returns the value of the '<em><b>Report Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Report Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Report Block</em>' containment reference.
	 * @see #setReportBlock(ClassPart)
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_ReportBlock()
	 * @model containment="true"
	 * @generated
	 */
	ClassPart getReportBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ClassSimilar#getReportBlock <em>Report Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Report Block</em>' containment reference.
	 * @see #getReportBlock()
	 * @generated
	 */
	void setReportBlock(ClassPart value);

	/**
	 * Returns the value of the '<em><b>Clear Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clear Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Block</em>' containment reference.
	 * @see #setClearBlock(ClassPart)
	 * @see hub.sam.dbl.DblPackage#getClassSimilar_ClearBlock()
	 * @model containment="true"
	 * @generated
	 */
	ClassPart getClearBlock();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ClassSimilar#getClearBlock <em>Clear Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear Block</em>' containment reference.
	 * @see #getClearBlock()
	 * @generated
	 */
	void setClearBlock(ClassPart value);

} // ClassSimilar
