package chameleon.fj2.model;

import chameleon.core.declaration.CommonDeclarationContainingDeclaration;
import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.reference.CrossReference;
import chameleon.util.association.Single;

public class Klazz extends CommonDeclarationContainingDeclaration {

	public Klazz() {
		
	}
	
	public Klazz(String name) {
		setSignature(new SimpleNameSignature(name));
	}
	
	// Raw type in phase 1 because we use ElementImpl as the super class for now.
	private Single<CrossReference<Klazz>> _super = new Single<CrossReference<Klazz>>(this);
	
	public CrossReference superReference() {
		return _super.getOtherEnd();
	}
	
	public void setSuperReference(CrossReference<Klazz> ref) {
		set(_super,ref);
	}
	
	@Override
	public Klazz clone() {
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return cloneDescendantsTo(new Klazz());
	}
}
