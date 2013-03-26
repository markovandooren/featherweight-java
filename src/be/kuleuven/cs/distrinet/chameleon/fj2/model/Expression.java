package be.kuleuven.cs.distrinet.chameleon.fj2.model;

import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.reference.CrossReferenceTarget;

/**
 * An abstract superclass for expressions.
 * 
 * @author Marko van Dooren
 */
public interface Expression extends Element, CrossReferenceTarget {

	public Klazz type() throws LookupException;
	
}
