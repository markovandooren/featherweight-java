package be.kuleuven.cs.distrinet.chameleon.fj2.model;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;


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
