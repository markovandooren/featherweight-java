package be.kuleuven.cs.distrinet.chameleon.fj2.model;

import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.element.ElementImpl;
import be.kuleuven.cs.distrinet.chameleon.core.reference.CrossReference;
import be.kuleuven.cs.distrinet.chameleon.core.reference.SimpleReference;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

/**
 * A class of assignments. The left-hand side is a cross-reference to the
 * variable to which the assignment is done. The left-hand side is an
 * expression that determines that value that will be stored in that variable.
 * 
 * @author Marko van Dooren
 */
public class Assignment extends ElementImpl {

	public Assignment(String name, Expression value) {
		setName(name);
		setValue(value);
	}
	
	public Assignment() {
	}
	
	/** 
	 * An single association end that is connected to a cross-reference that points
	 * to the invoked method.
	 */
	// The cross-reference is mandatory, so 'true' is passed as an actual argument.
	private Single<CrossReference<Variable>> _accessVariable = new Single<CrossReference<Variable>>(this,true);
	
	/**
	 * Return a cross-reference that points to the invoked method.
	 * 
	 * @return A cross-reference that points to the invoked method (if any).
	 */
	public CrossReference<Variable> variableReference() {
		return _accessVariable.getOtherEnd();
	}
	
	/**
	 * Set the name of the variable
	 * @param name
	 */
	public void setName(String name) {
		setVariableReference(new SimpleReference<Variable>(name,Variable.class));
	}
	

	/**
	 * This method is needed such that the parser can add metadata to the cross
	 * reference to mark its position.
	 * 
	 * @param variableReference A cross-reference that possibly points to a variable.
	 */
	public void setVariableReference(CrossReference<Variable> variableReference) {
		set(_accessVariable,variableReference);
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
	protected Assignment cloneSelf() {
		return new Assignment();
	}
	
}
