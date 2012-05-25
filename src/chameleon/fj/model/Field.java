package chameleon.fj.model;

import chameleon.core.element.Element;

/**
 * A class of fields.
 * 
 * @author Marko van Dooren
 */
public class Field extends Variable {

	@Override
	public Element clone() {
		return cloneDescendantsTo(new Field());
	}

}
