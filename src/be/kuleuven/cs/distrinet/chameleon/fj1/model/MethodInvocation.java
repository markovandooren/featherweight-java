package be.kuleuven.cs.distrinet.chameleon.fj1.model;

import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

/**
 * A class of method invocations. A method invocation invokes a method on an object.
 * This object is determined by the target (receiver) expression of the invocation.
 * As explained in the super class, a method invocation references a method, and has
 * arguments.
 * 
 * @author Marko van Dooren
 */
public class MethodInvocation extends Invocation {

	/**
	 *  An association object that is connected to the target (receiver) of the invocation.
	 *  
	 *  The target is mandatory, so we pass 'true' to the constructor of Single.
	 */
	private Single<Expression> _target = new Single<Expression>(this,true);
	
	/**
	 * Return the target (receiver) of the invocation.
	 */
	public Expression target() {
		return _target.getOtherEnd();
	}
	
	/**
	 * Set the target (receiver) of this invocation.
	 * 
	 * @param target The new target of the method invocation.
	 */
	public void setTarget(Expression target) {
		set(_target,target);
	}

	@Override
	public Element clone() {
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return cloneDescendantsTo(new MethodInvocation());
	}

}
