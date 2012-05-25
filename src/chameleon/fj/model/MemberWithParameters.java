package chameleon.fj.model;

import java.util.List;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.ElementImpl;
import chameleon.util.association.Multi;
import chameleon.util.association.Single;

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
	
	public void add(Parameter parameter) {
		add(_parameters,parameter);
	}
	
	public void remove(Parameter parameter) {
		remove(_parameters,parameter);
	}

}
