package chameleon.fj2.model;

import java.util.List;

import chameleon.core.declaration.CommonDeclarationContainingDeclaration;
import chameleon.core.declaration.Declaration;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.Element;
import chameleon.core.lookup.DeclarationSelector;
import chameleon.core.lookup.LookupException;
import chameleon.core.lookup.LookupStrategy;
import chameleon.core.reference.CrossReference;
import chameleon.core.reference.SimpleReference;
import chameleon.util.association.Single;

public class Klazz extends CommonDeclarationContainingDeclaration {

	public Klazz() {
		
	}
	
	public Klazz(String name) {
		setSignature(new SimpleNameSignature(name));
	}
	
	// Raw type in phase 1 because we use ElementImpl as the super class for now.
	private Single<CrossReference<Klazz>> _super = new Single<CrossReference<Klazz>>(this);
	
	public CrossReference<Klazz> superReference() {
		return _super.getOtherEnd();
	}
	
	public void setSuperReference(CrossReference<Klazz> ref) {
		set(_super,ref);
	}
	
	public void setSuperKlazz(String fqn) {
		setSuperReference(new SimpleReference<Klazz>(fqn, Klazz.class));
	}
	
	public Klazz superKlazz() throws LookupException {
		CrossReference<Klazz> superReference = superReference();
		return superReference == null ? null : superReference.getElement();
	}
	
	@Override
	public Klazz clone() {
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return cloneDescendantsTo(new Klazz());
	}
	
	@Override
	public <D extends Declaration> List<D> declarations(DeclarationSelector<D> selector) throws LookupException {
		// 1. Search locally
		List<D> result = super.declarations(selector);
		// 2.If nothing was found, search in the super class.
		//   Remember that FJ has no syntactic overloading, so unlike in real Java
		//   the super class does not have to be searched to look for a better match.
		Klazz superKlazz = superKlazz();
		if(result.isEmpty() && superKlazz != null) {
			result = superKlazz.declarations(selector);
		}
		return result;
	}
	
	@Override
	public LookupStrategy lexicalLookupStrategy(Element child) throws LookupException {
		if(child.sameAs(superReference())) {
			return parent().lexicalLookupStrategy(this);
		} else {
			return super.lexicalLookupStrategy(child);
		}
	}
}
