package chameleon.fj.model;

import java.util.List;

import chameleon.core.reference.CrossReference;
import chameleon.util.association.Multi;
import chameleon.util.association.Single;

/**
 * A class for invocations. An invocation points to a member with parameters and provides
 * it with the actual arguments.
 * 
 * @author Marko van Dooren
 */
public abstract class Invocation extends Expression {

	/** 
	 * An single association end that is connected to a cross-reference that points
	 * to the invoked method.
	 * 
	 * For Featherweight Java, we do not have to store the actual arguments of the invocation
	 * in the cross-reference because FJ does not support syntactic overloading. Therefore
	 * it suffices to know the name of the method (and the target) in order to resolve the
	 * invocation.
	 * 
	 * In phase 1 we use CrossReference as a raw type because we use ElementImpl as the super class
	 * for now. Therefore we cannot use Method as the actual type parameter of CrossReference, which 
	 * uses Declaration as its type bound.
	 */
	// The cross-reference is mandatory, so 'true' is passed as an actual argument.
	private Single<CrossReference> _invokedMethodReference = new Single<CrossReference>(this,true);
	
	/**
	 * Return a cross-reference that points to the invoked method.
	 * 
	 * In phase 1, there is no setter yet. For method invocations, the client should not
	 * have to decide (or be able to choose) what kind of cross-reference is used. We will
	 * address this in phase 2. 
	 * 
	 * @return A cross-reference that points to the invoked method (if any).
	 */
	public CrossReference methodReference() {
		return _invokedMethodReference.getOtherEnd();
	}
	
	/**
	 *  A multi association end that is connected to the actual arguments of the invocation.
	 */
	private Multi<Expression> _arguments = new Multi<Expression>(this);
	
	/**
	 * Return the actual arguments of the invocation.
	 * @return A list containing the actual arguments of the method invocation in order.
	 */
	public List<Expression> arguments() {
		return _arguments.getOtherEnds();
	}
	
	/**
	 * Add the given expression as an argument to this invocation. The
	 * expression is added as the last argument.
	 * 
	 * @param argument The argument to be added.
	 */
	public void add(Expression argument) {
		// The add() helper method take care of 'null' references.
		add(_arguments,argument);
	}
	
	/**
	 * Remove the given argument from this invocation.
	 * 
	 * @param argument The argument to be removed.
	 */
	public void remove(Expression argument) {
		// The remove() helper method take care of 'null' references.
		remove(_arguments,argument);
	}

}
