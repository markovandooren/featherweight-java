package chameleon.fj.model;

import java.util.List;

import chameleon.util.association.Multi;

public abstract class Invocation extends Expression {

	public Invocation(String name) {
		setName(name);
	}
	
	// In phase 1 we use a String.
	private String _name;
	
	public String name() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	private Multi<Expression> _arguments = new Multi<Expression>(this);
	
	public List<Expression> arguments() {
		return _arguments.getOtherEnds();
	}
	
	public void add(Expression argument) {
		add(_arguments,argument);
	}
	
	public void remove(Expression argument) {
		remove(_arguments,argument);
	}
	

}
