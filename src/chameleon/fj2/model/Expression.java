package chameleon.fj2.model;

import chameleon.core.element.Element;
import chameleon.core.lookup.LookupException;
import chameleon.core.reference.CrossReferenceTarget;

/**
 * An abstract superclass for expressions.
 * 
 * @author Marko van Dooren
 */
public interface Expression extends Element, CrossReferenceTarget {

	public Klazz type() throws LookupException;
	
}
