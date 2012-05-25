package chameleon.fj1.model;

import chameleon.core.element.Element;

/**
 * A class of constructor invocations.
 * 
 * @author Marko van Dooren
 */
public class ConstructorInvocation extends Invocation {

	@Override
	public Element clone() {
		return cloneDescendantsTo(new ConstructorInvocation());
	}

}
