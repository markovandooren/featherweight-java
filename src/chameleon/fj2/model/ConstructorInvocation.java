package chameleon.fj2.model;

import chameleon.core.declaration.Declaration;
import chameleon.core.lookup.DeclarationSelector;
import chameleon.core.lookup.LookupException;

/**
 * A class of constructor invocations.
 * 
 * @author Marko van Dooren
 */
public class ConstructorInvocation extends Invocation<Constructor> {
	
	public ConstructorInvocation(String name) {
		super(name);
	}
	
	public ConstructorInvocation() {
		
	}

	@Override
	public ConstructorInvocation clone() {
		return cloneDescendantsTo(new ConstructorInvocation());
	}

	@Override
	public DeclarationSelector<Constructor> selector() {
		return methodReference().selector();
	}

	@Override
	protected <X extends Declaration> X getElement(DeclarationSelector<X> selector) throws LookupException {
		return methodReference().getElement(selector);
	}

	@Override
	public Klazz type() throws LookupException {
		return getElement().nearestAncestor(Klazz.class);
	}

	@Override
	public Class<Constructor> declarationClass() {
		return Constructor.class;
	}
	

}
