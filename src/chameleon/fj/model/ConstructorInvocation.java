package chameleon.fj.model;

import chameleon.core.element.Element;

public class ConstructorInvocation extends Invocation {

	@Override
	public Element clone() {
		return cloneDescendantsTo(new ConstructorInvocation());
	}

}
