package chameleon.fj.model;

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
