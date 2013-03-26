package be.kuleuven.cs.distrinet.chameleon.fj2.model;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;

/**
 * A class of formal parameters.
 * 
 * @author Marko van Dooren
 */
public class Parameter extends Variable {

	public Parameter(){
	}
	
	public Parameter(String name) {
		setSignature(new SimpleNameSignature(name));
	}
	
	@Override
	public Parameter clone() {
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return cloneDescendantsTo(new Parameter());
	}
}
