package be.kuleuven.cs.distrinet.chameleon.fj1.model;

import java.util.List;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.element.ElementImpl;
import be.kuleuven.cs.distrinet.chameleon.util.association.Multi;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

/**
 * An abstract class for class members with parameters. Examples are methods
 * and constructors.
 * 
 * @author Marko van Dooren
 */
public abstract class MemberWithParameters extends ElementImpl implements Member {

	/**
	 * An association object that is connected to the signature of the member. The signature
	 * is mandatory, so 'true' is passed to the constructor of Single.
	 */
	private Single<SimpleNameSignature> _signature = new Single<SimpleNameSignature>(this,true);
	
	/**
	 * Return the signature of this member.
	 */
	public SimpleNameSignature signature() {
		return _signature.getOtherEnd();
	}
	
	/**
	 * Set the signature of this member.
	 * 
	 * @param signature The new signature of this member.
	 */
	public void setSignature(SimpleNameSignature signature) {
		set(_signature,signature);
	}
	
	
	private Multi<Parameter> _parameters = new Multi<Parameter>(this);
	
	/**
	 * Return the parameters of this member.
	 * @return
	 */
	public List<Parameter> parameters() {
		return _parameters.getOtherEnds();
	}
	
	/**
	 * Add the given parameter as the last parameter.
	 */
	public void add(Parameter parameter) {
		add(_parameters,parameter);
	}

	/**
	 * Remove the given parameter.
	 */
	public void remove(Parameter parameter) {
		remove(_parameters,parameter);
	}

}
