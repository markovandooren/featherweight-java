package be.kuleuven.cs.distrinet.chameleon.fj1.model;

/**
 * A class of fields.
 * 
 * @author Marko van Dooren
 */
public class Field extends Variable implements Member {

	@Override
	protected Field cloneSelf() {
		return new Field();
	}

}
