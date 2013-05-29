package be.kuleuven.cs.distrinet.chameleon.fj1.model;

import be.kuleuven.cs.distrinet.chameleon.core.element.Element;


/**
 * A class of constructor invocations.
 * 
 * @author Marko van Dooren
 */
public class ConstructorInvocation extends Invocation {

	@Override
	protected Element cloneSelf() {
		return new ConstructorInvocation();
	}

}
