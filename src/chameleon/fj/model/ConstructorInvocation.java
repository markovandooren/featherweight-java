package chameleon.fj.model;

import chameleon.core.element.Element;

public class ConstructorInvocation extends Invocation {

	public ConstructorInvocation(String name) {
		super(name);
	}

	@Override
	public Element clone() {
		return cloneDescendantsTo(new ConstructorInvocation(name()));
	}

}
