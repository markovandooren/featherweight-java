package be.kuleuven.cs.distrinet.chameleon.fj1.model;

import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.element.ElementImpl;
import be.kuleuven.cs.distrinet.chameleon.core.reference.CrossReference;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

/**
 * A class of assignments. The left-hand side is a cross-reference to the
 * variable to which the assignment is done. The left-hand side is an
 * expression that determines that value that will be stored in that variable.
 * 
 * @author Marko van Dooren
 */
public class Assignment extends ElementImpl {

	/** 
	 * An single association end that is connected to a cross-reference that points
	 * to the invoked method.
	 * 
	 * In phase 1 we use CrossReference as a raw type because we use ElementImpl as the super class
	 * for now. Therefore we cannot use Variable as the actual type parameter of CrossReference, which 
	 * uses Declaration as its type bound.
	 */
	// The cross-reference is mandatory, so 'true' is passed as an actual argument.
	private Single<CrossReference> _accessVariable = new Single<CrossReference>(this,true);
	
	/**
	 * Return a cross-reference that points to the invoked method.
	 * 
	 * In phase 1, there is no setter yet. For method invocations, the client should not
	 * have to decide (or be able to choose) what kind of cross-reference is used. We will
	 * address this in phase 2. 
	 * 
	 * @return A cross-reference that points to the invoked method (if any).
	 */
	public CrossReference variableReference() {
		return _accessVariable.getOtherEnd();
	}
	
	/**
	 *  An association object that is connected to an expression that determines
	 *  the value of the assignment.
	 *  
	 *  The target is mandatory, so we pass 'true' to the constructor of Single.
	 */
	private Single<Expression> _value = new Single<Expression>(this,true);
	
	/**
	 * Return the value of the assignment.
	 */
	public Expression value() {
		return _value.getOtherEnd();
	}
	
	/**
	 * Set the value of this assignment.
	 * 
	 * @param value The new value of the assignment.
	 */
	public void setValue(Expression value) {
		set(_value,value);
	}

	@Override
	protected Element cloneSelf() {
		return new Assignment();
	}
	
}
