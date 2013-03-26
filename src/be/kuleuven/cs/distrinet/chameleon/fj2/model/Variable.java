package be.kuleuven.cs.distrinet.chameleon.fj2.model;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.CommonDeclaration;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.reference.CrossReference;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

/**
 * A class for variables. A variable has a signature (name) and a reference to a klazz.
 * @author Marko van Dooren
 */
public abstract class Variable extends CommonDeclaration {

	/**
	 * An association object that is connected to a cross-reference that points to the type
	 * of the variable. The cross-reference is mandatory, so 'true' is passed to the constructor of Single.
	 */
	private Single<CrossReference<Klazz>> _type = new Single<CrossReference<Klazz>>(this,true);
	
	/**
	 * Return a cross-reference that points to the klazz of this variable.
	 */
	public CrossReference<Klazz> typeReference() {
		return _type.getOtherEnd();
	}
	
	public Klazz type() throws LookupException {
		return typeReference().getElement();
	}
	
	public void setTypeReference(CrossReference<Klazz> cref) {
		set(_type, cref);
	}
	
}
