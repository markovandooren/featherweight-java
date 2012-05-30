package chameleon.fj2.model;

import java.util.List;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.util.association.Multi;

/**
 * A class of constructors. A constructor has arguments and a signature,
 * as explained in the super class. In addition, a constructor has a list
 * of assignments to initialize the fields of the klazz.
 * 
 * @author Marko van Dooren
 */
public class Constructor extends MemberWithParameters {

	public Constructor(){
	}
	
	public Constructor(String name) {
		setSignature(new SimpleNameSignature(name));
	}
	
	/**
	 *  A multi association end that is connected to the assignments of the constructor.
	 */
	private Multi<Assignment> _assignments = new Multi<Assignment>(this);
	
	/**
	 * Return the assignments of this constructor.
	 */
	public List<Assignment> assignments() {
		return _assignments.getOtherEnds();
	}

	/**
	 * Add the given assignment as the last assignment.
	 */
	public void add(Assignment assignment) {
		add(_assignments,assignment);
	}
	
	/**
	 * Remove the given assignment.
	 */
	public void remove(Assignment assignment) {
		remove(_assignments,assignment);
	}

	@Override
	public Constructor clone() {
		return cloneDescendantsTo(new Constructor());
	}
}