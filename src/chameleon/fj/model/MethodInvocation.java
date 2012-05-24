package chameleon.fj.model;

import java.util.List;

import chameleon.core.element.Element;
import chameleon.util.association.Multi;

public class MethodInvocation extends Expression {

	public MethodInvocation(String name) {
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
	
	@Override
	public Element clone() {
		return cloneDescendantsTo(new MethodInvocation(name()));
	}

}
