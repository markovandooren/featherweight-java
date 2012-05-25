package chameleon.fj2.model;

import chameleon.core.declaration.Declaration;
import chameleon.core.element.Element;
import chameleon.core.lookup.DeclarationSelector;
import chameleon.core.lookup.LookupException;
import chameleon.core.reference.CrossReference;
import chameleon.core.reference.CrossReferenceImpl;
import chameleon.core.reference.SimpleReference;
import chameleon.util.association.Single;

/**
 * A class of expressions for accessing variables.
 * 
 * @author Marko van Dooren
 */
public class VariableAccess extends CrossReferenceImpl<Variable> implements Expression {

	public VariableAccess() {
		
	}
	
	public VariableAccess(String name) {
		setName(name);
	}
	/** 
	 * An single association end that is connected to a cross-reference that points
	 * to the accessed variable.
	 * 
	 */
	// The cross-reference is mandatory, so 'true' is passed as an actual argument.
	private Single<SimpleReference<Variable>> _accessVariable = new Single<SimpleReference<Variable>>(this,true);
	
	/**
	 * Return a cross-reference that points to the accessed variable.
	 * 
	 * @return A cross-reference that points to the invoked method (if any).
	 */
	public SimpleReference<Variable> variableReference() {
		return _accessVariable.getOtherEnd();
	}
	
	public Variable variable() throws LookupException {
		return variableReference().getElement();
	}
	
	@Override
	public VariableAccess clone() {
		return cloneDescendantsTo(new VariableAccess());
	}

	@Override
	public Klazz type() throws LookupException {
		return variable().type();
	}

	/**
	 * Return the target (receiver) of the invocation.
	 */
	public Expression target() {
		SimpleReference<Variable> variableReference = variableReference();
		return (Expression) (variableReference == null ? null : variableReference.getTarget());
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
		variableReference().setTarget(target);
	}
	
	protected void setVariableReference(SimpleReference<Variable> cref) {
		// We must move the target expression from the old cross-reference to the new cross-reference/
		Expression target = target();
		set(_accessVariable,cref);
		setTarget(target);
	}

	public void setName(String name) {
		setVariableReference(new SimpleReference<Variable>(name, Variable.class));
	}

	@Override
	public DeclarationSelector<Variable> selector() {
		return variableReference().selector();
	}

	@Override
	protected <X extends Declaration> X getElement(DeclarationSelector<X> selector) throws LookupException {
		return variableReference().getElement(selector);
	}


}
