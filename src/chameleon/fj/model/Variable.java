package chameleon.fj.model;

import chameleon.core.element.Element;
import chameleon.core.element.ElementImpl;
import chameleon.core.reference.CrossReference;
import chameleon.util.association.Single;

public abstract class Variable extends ElementImpl {

	public Variable(String name) {
		setName(name);
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
	private Single<CrossReference> _type = new Single<CrossReference>(this);
	
	public CrossReference typeReference() {
		return _type.getOtherEnd();
	}
	
	public void setTypeReference(CrossReference ref) {
		set(_type,ref);
	}
	
}
