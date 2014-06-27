/**
 */
package hub.sam.dbl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Augment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hub.sam.dbl.ClassAugment#getAugmentedClass <em>Augmented Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see hub.sam.dbl.DblPackage#getClassAugment()
 * @model
 * @generated
 */
public interface ClassAugment extends ClassSimilar {
	/**
	 * Returns the value of the '<em><b>Augmented Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Augmented Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Augmented Class</em>' reference.
	 * @see #setAugmentedClass(Clazz)
	 * @see hub.sam.dbl.DblPackage#getClassAugment_AugmentedClass()
	 * @model required="true"
	 * @generated
	 */
	Clazz getAugmentedClass();

	/**
	 * Sets the value of the '{@link hub.sam.dbl.ClassAugment#getAugmentedClass <em>Augmented Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Augmented Class</em>' reference.
	 * @see #getAugmentedClass()
	 * @generated
	 */
	void setAugmentedClass(Clazz value);

} // ClassAugment
