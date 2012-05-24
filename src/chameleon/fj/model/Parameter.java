package chameleon.fj.model;


public class Parameter extends Variable {

	public Parameter(String name) {
		super(name);
	}	

	@Override
	public Parameter clone() {
		return cloneDescendantsTo(new Parameter(name()));
	}
}
