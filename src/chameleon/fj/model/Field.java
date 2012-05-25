package chameleon.fj.model;

import chameleon.core.element.Element;

public class Field extends Variable {

	@Override
	public Element clone() {
		return cloneDescendantsTo(new Field());
	}

}
