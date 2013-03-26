package be.kuleuven.cs.distrinet.chameleon.fj1.model;

import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

public class Method extends MemberWithParameters {

	// Raw type in phase 1 because we use ElementImpl as the super class for now.
	private Single<Expression> _expression = new Single<Expression>(this);
	
	public Expression typeReference() {
		return _expression.getOtherEnd();
	}
	
	public void setTypeReference(Expression ref) {
		set(_expression,ref);
	}
	
	@Override
	public Element clone() {
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return cloneDescendantsTo(new Method());
	}

}
