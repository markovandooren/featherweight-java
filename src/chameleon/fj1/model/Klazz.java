package chameleon.fj1.model;

import java.util.List;

import chameleon.core.element.Element;
import chameleon.core.element.ElementImpl;
import chameleon.core.reference.CrossReference;
import chameleon.util.association.Multi;
import chameleon.util.association.Single;

public class Klazz extends ElementImpl {

	public Klazz(String name) {
		setName(name());
	}
	
	// In phase 1 we use a String.
	private String _name;
	
	public String name() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}

	// Raw type in phase 1 because we use ElementImpl as the super class for now.
	private Single<CrossReference> _super = new Single<CrossReference>(this);
	
	public CrossReference superReference() {	// S

		return _super.getOtherEnd();
	}
	
	public void setSuperReference(CrossReference ref) {
		set(_super,ref);
	}
	
	private Multi<Member> _methods = new Multi<Member>(this);
	
	public List<Member> methods() {
		return _methods.getOtherEnds();
	}
	
	public void add(Member method) {
		add(_methods,method);
	}
	
	public void remove(Member method) {
		remove(_methods,method);
	}
	
	@Override
	public Element clone() {
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return cloneDescendantsTo(new Klazz(name()));
	}
}
