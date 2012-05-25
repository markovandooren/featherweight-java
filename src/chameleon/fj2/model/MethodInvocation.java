package chameleon.fj2.model;

import chameleon.core.declaration.Declaration;
import chameleon.core.lookup.DeclarationSelector;
import chameleon.core.lookup.LookupException;
import chameleon.core.reference.SimpleReference;

/**
 * A class of method invocations. A method invocation invokes a method on an object.
 * This object is determined by the target (receiver) expression of the invocation.
 * As explained in the super class, a method invocation references a method, and has
 * arguments.
 * 
 * @author Marko van Dooren
 */
public class MethodInvocation extends Invocation<Method> {

	public MethodInvocation(){
	}
	
	public MethodInvocation(String name) {
		setName(name);
	}
	
	/*
	 * The internal object structure of a method invocation is as follows:
	 * 
	 * Invocation --- SimpleReference<Method> --- Expression
	 * 
	 * As such, the SimpleReference object actually models the cross-reference. Class
	 * MethodInvocation serves as an adapter to the Expression class of Featherweight Java.
	 */
	
	/**
	 * Return the target (receiver) of the invocation.
	 */
	public Expression target() {
		return (Expression) methodReference().getTarget();
	}
	
	/**
	 * Set the target (receiver) of this invocation.
	 * 
	 * @param target The new target of the method invocation.
	 */
	public void setTarget(Expression target) {
		// We set the target as the target of the cross-reference that points to the
		// method. This will make the latter cross-reference search for the method
		// in the target context of the expression, which is the klazz (type) of the
		// expression.
		methodReference().setTarget(target);
	}
	
	@Override
	protected void setMethodReference(SimpleReference<Method> cref) {
		// We must move the target expression from the old cross-reference to the new cross-reference/
		Expression target = target();
		super.setMethodReference(cref);
		setTarget(target);
	}
	
	@Override
	public MethodInvocation clone() {
		return cloneDescendantsTo(new MethodInvocation());
	}

	@Override
	public DeclarationSelector<Method> selector() {
		return methodReference().selector();
	}

	@Override
	protected <X extends Declaration> X getElement(DeclarationSelector<X> selector) throws LookupException {
		return methodReference().getElement(selector);
	}

	@Override
	public Klazz type() throws LookupException {
		return getElement().type();
	}

}
