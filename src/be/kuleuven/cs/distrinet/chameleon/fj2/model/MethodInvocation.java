package be.kuleuven.cs.distrinet.chameleon.fj2.model;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.DeclarationSelector;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.reference.CrossReferenceTarget;
import be.kuleuven.cs.distrinet.chameleon.core.reference.SimpleReference;

/**
 * A class of method invocations. A method invocation invokes a method on an object.
 * This object is determined by the target (receiver) expression of the invocation.
 * As explained in the super class, a method invocation references a method, and has
 * arguments.
 * 
 * @author Marko van Dooren
 */
public class MethodInvocation extends Invocation<Method,Method> {

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
	public CrossReferenceTarget target() {
		SimpleReference<Method> methodReference = crossReference();
		return (CrossReferenceTarget) methodReference != null ? methodReference.getTarget() : null;
	}
	
	/**
	 * Set the target (receiver) of this invocation.
	 * 
	 * @param target The new target of the method invocation.
	 */
	public void setTarget(CrossReferenceTarget target) {
		// We set the target as the target of the cross-reference that points to the
		// method. This will make the latter cross-reference search for the method
		// in the target context of the expression, which is the klazz (type) of the
		// expression.
		crossReference().setTarget(target);
	}
	
	@Override
	protected void setCrossReference(SimpleReference<Method> cref) {
		// We must move the target expression from the old cross-reference to the new cross-reference/
		CrossReferenceTarget target = target();
		super.setCrossReference(cref);
		setTarget(target);
	}
	
	@Override
	protected MethodInvocation cloneSelf() {
		return new MethodInvocation();
	}

	@Override
	public DeclarationSelector<Method> selector() {
		return crossReference().selector();
	}

	@Override
	protected <X extends Declaration> X getElement(DeclarationSelector<X> selector) throws LookupException {
		return crossReference().getElement(selector);
	}

	@Override
	public Klazz type() throws LookupException {
		return getElement().type();
	}

	@Override
	public Class<Method> declarationClass() {
		return Method.class;
	}

}
