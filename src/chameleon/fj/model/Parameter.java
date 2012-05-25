package chameleon.fj.model;


/**
 * A class of formal parameters.
 * 
 * @author Marko van Dooren
 */
public class Parameter extends Variable {

	@Override
	public Parameter clone() {
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return cloneDescendantsTo(new Parameter());
	}
}
