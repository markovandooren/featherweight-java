package chameleon.fj.model;

import chameleon.core.element.Element;

public class MethodInvocation extends Invocation {

	@Override
	public Element clone() {
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return cloneDescendantsTo(new MethodInvocation());
	}

}
