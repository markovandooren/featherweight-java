package chameleon.fj.model;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.element.ElementImpl;
import chameleon.core.reference.CrossReference;
import chameleon.util.association.Single;

public abstract class Variable extends ElementImpl {

	// Raw type in phase 1 because we use ElementImpl as the super class for now.
	private Single<SimpleNameSignature> _signature = new Single<SimpleNameSignature>(this);
	
	public SimpleNameSignature signature() {
		return _signature.getOtherEnd();
	}
	
	public void setSignature(SimpleNameSignature signature) {
		set(_signature,signature);
	}
	
	// Raw type in phase 1 because we use ElementImpl as the super class for now.
	private Single<CrossReference> _type = new Single<CrossReference>(this);
	
	public CrossReference typeReference() {
		return _type.getOtherEnd();
	}
	
	public void setTypeReference(CrossReference ref) {
		set(_type,ref);
	}
	
}
