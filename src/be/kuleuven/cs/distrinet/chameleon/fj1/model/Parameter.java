package be.kuleuven.cs.distrinet.chameleon.fj1.model;


/**
 * A class of formal parameters.
 * 
 * @author Marko van Dooren
 */
public class Parameter extends Variable {

	@Override
	protected Parameter cloneSelf() {
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return new Parameter();
	}
}
