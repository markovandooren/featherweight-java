package chameleon.fj2.model;

import java.util.List;

import chameleon.core.declaration.Declaration;
import chameleon.core.lookup.LookupException;
import chameleon.core.lookup.LookupStrategy;
import chameleon.core.reference.CrossReferenceImpl;
import chameleon.core.reference.SimpleReference;
import chameleon.util.association.Multi;
import chameleon.util.association.Single;

/**
 * A class for invocations. An invocation points to a member with parameters and provides
 * it with the actual arguments.
 * 
 * @author Marko van Dooren
 */
public abstract class Invocation<D extends Declaration> extends CrossReferenceImpl<D> implements Expression {

	public Invocation() {
	}

	public Invocation(String name) {
		setName(name);
	}
	
	@Override
	public LookupStrategy targetContext() throws LookupException {
		return type().targetContext();
	}
	
	/** 
	 * An single association end that is connected to a cross-reference that points
	 * to the invoked method.
	 * 
	 * For Featherweight Java, we do not have to store the actual arguments of the invocation
	 * in the cross-reference because FJ does not support syntactic overloading. Therefore
	 * it suffices to know the name of the method (and the target) in order to resolve the
	 * invocation.
	 * 
	 */
	// The cross-reference is mandatory, so 'true' is passed as an actual argument to the constructor
	// of Single.
	private Single<SimpleReference<D>> _invokedMethodReference = new Single<SimpleReference<D>>(this,true);
	
	/**
	 * Return a cross-reference that points to the invoked method.
	 * 
	 * In phase 1, there is no setter yet. For method invocations, the client should not
	 * have to decide (or be able to choose) what kind of cross-reference is used. We will
	 * address this in phase 2. 
	 * 
	 * @return A cross-reference that points to the invoked method (if any).
	 */
	public SimpleReference<D> methodReference() {
		return _invokedMethodReference.getOtherEnd();
	}
	
	protected void setMethodReference(SimpleReference<D> cref) {
		set(_invokedMethodReference,cref);
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
	
	public void setName(String name) {
		setMethodReference(new SimpleReference<D>(name, declarationClass()));
	}

  public abstract Class<D> declarationClass();

}
