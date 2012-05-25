package chameleon.fj2.model;

import chameleon.core.declaration.SimpleNameSignature;


/**
 * A class of fields.
 * 
 * @author Marko van Dooren
 */
public class Field extends Variable implements Member {

	public Field(String name) {
		setSignature(new SimpleNameSignature(name));
	}
	
	public Field() {
	}
	
	@Override
	public Field clone() {
		return cloneDescendantsTo(new Field());
	}

}
