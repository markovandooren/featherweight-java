package chameleon.fj.model;


public class Parameter extends Variable {

	public Parameter() {
	}	

	@Override
	public Parameter clone() {
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return cloneDescendantsTo(new Parameter());
	}
}
