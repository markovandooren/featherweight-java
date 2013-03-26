package be.kuleuven.cs.distrinet.chameleon.fj1.model;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.element.ElementImpl;
import be.kuleuven.cs.distrinet.chameleon.core.reference.CrossReference;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

/**
 * A class for variables. A variable has a signature (name) and a reference to a klazz.
 * @author Marko van Dooren
 *
 */
public abstract class Variable extends ElementImpl {

	/**
	 * An association object that is connected to the signature of the variable. The signature
	 * is mandatory, so 'true' is passed to the constructor of Single.
	 */
	private Single<SimpleNameSignature> _signature = new Single<SimpleNameSignature>(this,true);
	
	/**
	 * Return the signature of this variable.
	 */
	public SimpleNameSignature signature() {
		return _signature.getOtherEnd();
	}
	
	/**
	 * Set the signature of this variable.
	 * 
	 * @param signature The new signature of this variable.
	 */
	public void setSignature(SimpleNameSignature signature) {
		set(_signature,signature);
	}
	
	/**
	 * An association object that is connected to a cross-reference that points to the type
	 * of the variable. The cross-reference is mandatory, so 'true' is passed to the constructor of Single.
	 */
	private Single<CrossReference> _type = new Single<CrossReference>(this,true);
	
	/**
	 * Return a cross-reference that points to the klazz of this variable.
	 * 
	 * A setter is not provide in phase 1 because clients should not have to be responsible
	 * for using the correct type of cross-reference.
	 */
	public CrossReference typeReference() {
		return _type.getOtherEnd();
	}
	
}
