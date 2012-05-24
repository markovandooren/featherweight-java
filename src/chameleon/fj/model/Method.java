package chameleon.fj.model;

import java.util.List;

import chameleon.core.element.Element;
import chameleon.core.element.ElementImpl;
import chameleon.util.association.Multi;
import chameleon.util.association.Single;

public class Method extends ElementImpl implements Member {

	
	public Method(String name) {
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
	
	private Multi<Parameter> _parameters = new Multi<Parameter>(this);
	
	public List<Parameter> methods() {
		return _parameters.getOtherEnds();
	}
	
	public void add(Parameter method) {
		add(_parameters,method);
	}
	
	public void remove(Parameter method) {
		remove(_parameters,method);
	}

	// Raw type in phase 1 because we use ElementImpl as the super class for now.
	private Single<Expression> _expression = new Single<Expression>(this);
	
	public Expression typeReference() {
		return _expression.getOtherEnd();
	}
	
	public void setTypeReference(Expression ref) {
		set(_expression,ref);
	}
	
	@Override
	public Element clone() {
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return cloneDescendantsTo(new Method(name()));
	}

}
