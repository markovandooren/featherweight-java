package chameleon.fj.model;

import java.util.List;

import chameleon.core.element.Element;
import chameleon.util.association.Multi;

/**
 * A class of constructors. A constructor has arguments and a signature,
 * as explained in the super class. In addition, a constructor has a list
 * of assignments to initialize the fields of the klazz.
 * 
 * @author Marko van Dooren
 */
public class Constructor extends MemberWithParameters {

	private Multi<Assignment> _assignments = new Multi<Assignment>(this);
	
	public List<Assignment> assignments() {
		return _assignments.getOtherEnds();
	}
	
	public void add(Assignment assignment) {
		add(_assignments,assignment);
	}
	
	public void remove(Assignment assignment) {
		remove(_assignments,assignment);
	}

	@Override
	public Element clone() {
		return cloneDescendantsTo(new Constructor());
	}
}
