package chameleon.fj.model;

import chameleon.core.element.Element;
import chameleon.core.reference.CrossReference;
import chameleon.util.association.Single;

/**
 * A class of expressions for accessing variables.
 * 
 * @author Marko van Dooren
 */
public class VariableAccess extends Expression {

	/** 
	 * An single association end that is connected to a cross-reference that points
	 * to the accessed variable.
	 * 
	 * In phase 1 we use CrossReference as a raw type because we use ElementImpl as the super class
	 * for now. Therefore we cannot use Variable as the actual type parameter of CrossReference, which 
	 * uses Declaration as its type bound.
	 */
	// The cross-reference is mandatory, so 'true' is passed as an actual argument.
	private Single<CrossReference> _accessVariable = new Single<CrossReference>(this,true);
	
	/**
	 * Return a cross-reference that points to the accessed variable.
	 * 
	 * In phase 1, there is no setter yet. For variable accesses, the client should not
	 * have to decide (or be able to choose) what kind of cross-reference is used. We will
	 * address this in phase 2. 
	 * 
	 * @return A cross-reference that points to the invoked method (if any).
	 */
	public CrossReference variableReference() {
		return _accessVariable.getOtherEnd();
	}
	
	@Override
	public Element clone() {
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return cloneDescendantsTo(new VariableAccess());
	}

}
