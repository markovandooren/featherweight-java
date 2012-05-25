package chameleon.fj1.model;

/**
 * A class of fields.
 * 
 * @author Marko van Dooren
 */
public class Field extends Variable implements Member {

	@Override
	public Field clone() {
		return cloneDescendantsTo(new Field());
	}

}
