package be.kuleuven.cs.distrinet.chameleon.fj2.model;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Signature;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.DeclarationCollector;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.DeclarationSelector;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.SelectorWithoutOrder;

/**
 * A class of constructor invocations.
 * 
 * @author Marko van Dooren
 */
public class ConstructorInvocation extends Invocation<Klazz,Constructor> {
	
	public ConstructorInvocation(String name) {
		super(name);
	}
	
	public ConstructorInvocation() {
		
	}

	@Override
	protected ConstructorInvocation cloneSelf() {
		return new ConstructorInvocation();
	}

	@Override
	public DeclarationSelector<Constructor> selector() {
		return new SelectorWithoutOrder<Constructor>(Constructor.class){
			@Override
			public Signature signature() {
				SimpleNameSignature signature = new SimpleNameSignature(crossReference().name());
				signature.setUniParent(ConstructorInvocation.this);
				return signature;
			}
		};
	}

	@Override
	protected <X extends Declaration> X getElement(DeclarationSelector<X> selector) throws LookupException {
		DeclarationCollector<X> collector = new DeclarationCollector<X>(selector);
		type().targetContext().lookUp(collector);
  	return collector.result();
	}

	@Override
	public Klazz type() throws LookupException {
		return crossReference().getElement();
	}

	@Override
	public Class<Klazz> declarationClass() {
		return Klazz.class;
	}
	

}
