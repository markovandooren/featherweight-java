package chameleon.fj.model;

import chameleon.core.element.Element;

public class Field extends Variable {

	public Field(String name) {
		super(name);
	}

	@Override
	public Element clone() {
		return cloneDescendantsTo(new Field(name()));
	}

}