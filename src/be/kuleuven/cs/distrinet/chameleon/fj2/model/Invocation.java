package be.kuleuven.cs.distrinet.chameleon.fj2.model;

import java.util.List;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupStrategy;
import be.kuleuven.cs.distrinet.chameleon.core.reference.CrossReferenceImpl;
import be.kuleuven.cs.distrinet.chameleon.core.reference.SimpleReference;
import be.kuleuven.cs.distrinet.chameleon.util.association.Multi;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

/**
 * A class for invocations. An invocation points to a member with parameters and provides
 * it with the actual arguments.
 * 
 * @author Marko van Dooren
 */
public abstract class Invocation<C extends Declaration, E extends Declaration> extends CrossReferenceImpl<E> implements Expression {

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
	private Single<SimpleReference<C>> _crossReference = new Single<SimpleReference<C>>(this,true);
	
	/**
	 * Return a cross-reference that points to the invoked method.
	 * 
	 * In phase 1, there is no setter yet. For method invocations, the client should not
	 * have to decide (or be able to choose) what kind of cross-reference is used. We will
	 * address this in phase 2. 
	 * 
	 * @return A cross-reference that points to the invoked method (if any).
	 */
	public SimpleReference<C> crossReference() {
		return _crossReference.getOtherEnd();
	}
	
	protected void setCrossReference(SimpleReference<C> cref) {
		set(_crossReference,cref);
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
		setCrossReference(new SimpleReference<C>(name, declarationClass()));
	}

  public abstract Class<C> declarationClass();

}
