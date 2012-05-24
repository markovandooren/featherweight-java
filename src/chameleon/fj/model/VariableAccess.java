package chameleon.fj.model;

import chameleon.core.element.Element;

public class VariableAccess extends Expression {

	public VariableAccess(String name) {
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
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return cloneDescendantsTo(new VariableAccess(name()));
	}

}
