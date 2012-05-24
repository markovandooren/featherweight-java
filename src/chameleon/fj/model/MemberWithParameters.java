package chameleon.fj.model;

import java.util.List;

import chameleon.core.element.ElementImpl;
import chameleon.util.association.Multi;

public abstract class MemberWithParameters extends ElementImpl {

	public MemberWithParameters(String name) {
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

}
