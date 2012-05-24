package chameleon.fj.model;

import chameleon.core.element.Element;
import chameleon.core.reference.CrossReference;
import chameleon.util.association.Single;

public class ConstructorInvocation extends Invocation {

	// Raw type in phase 1 because we use ElementImpl as the super class for now.
	private Single<CrossReference> _type = new Single<CrossReference>(this);
	
	public CrossReference typeReference() {
		return _type.getOtherEnd();
	}
	
	public void setTypeReference(CrossReference ref) {
		set(_type,ref);
	}
	
	@Override
	public Element clone() {
		return cloneDescendantsTo(new ConstructorInvocation());
	}

}
