package be.kuleuven.cs.distrinet.chameleon.fj1.model;

import java.util.List;

import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.element.ElementImpl;
import be.kuleuven.cs.distrinet.chameleon.core.reference.CrossReference;
import be.kuleuven.cs.distrinet.chameleon.util.association.Multi;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

public class Klazz extends ElementImpl {

	public Klazz(String name) {
		setName(name());
	}
	
	// In phase 1 we use a String.
	private String _name;
	
	public String name() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}

	// Raw type in phase 1 because we use ElementImpl as the super class for now.
	private Single<CrossReference> _super = new Single<CrossReference>(this);
	
	public CrossReference superReference() {	// S

		return _super.getOtherEnd();
	}
	
	public void setSuperReference(CrossReference ref) {
		set(_super,ref);
	}
	
	private Multi<Member> _methods = new Multi<Member>(this);
	
	public List<Member> methods() {
		return _methods.getOtherEnds();
	}
	
	public void add(Member method) {
		add(_methods,method);
	}
	
	public void remove(Member method) {
		remove(_methods,method);
	}
	
	@Override
	protected Element cloneSelf() {
		return new Klazz(name());
	}
}
