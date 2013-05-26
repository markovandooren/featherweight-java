package be.kuleuven.cs.distrinet.chameleon.fj2.model;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.reference.CrossReference;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

public class Method extends MemberWithParameters {

	public Method(){
	}
	
	public Method(String name) {
		setSignature(new SimpleNameSignature(name));
	}
	
	private Single<Expression> _expression = new Single<Expression>(this);
	
	public Expression expression() {
		return _expression.getOtherEnd();
	}
	
	public void setExpression(Expression ref) {
		set(_expression,ref);
	}
	
	@Override
	protected Method cloneSelf() {
		return new Method();
	}

	private Single<CrossReference<Klazz>> _tref = new Single<CrossReference<Klazz>>(this);
	
	public CrossReference<Klazz> returnTypeReference() {
		return _tref.getOtherEnd();
	}
	
	public void setReturnTypeReference(CrossReference<Klazz> ref) {
		set(_tref,ref);
	}
	
	public Klazz type() throws LookupException {
		return returnTypeReference().getElement();
	}

}
