package chameleon.fj.model;

import java.util.List;

import chameleon.core.element.Element;
import chameleon.util.association.Multi;

public class Constructor extends MemberWithParameters {

	public Constructor(String name) {
		super(name);
	}

	@Override
	public Element clone() {
		return cloneDescendantsTo(new Constructor(name()));
	}

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

}
