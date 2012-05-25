package chameleon.fj.model;

import chameleon.core.element.Element;
import chameleon.util.association.Single;

public class MethodInvocation extends Invocation {

	/**
	 *  An association object that is connected to the target (receiver) of the invocation. 
	 */
	private Single<Expression> _target = new Single<Expression>(this);
	
	public Expression target() {
		return _target.getOtherEnd();
	}
	
	/**
	 * Set the target (receiver) of this invocation.
	 * @param target
	 */
	public void setTarget(Expression target) {
		set(_target,target);
	}

	@Override
	public Element clone() {
		// cloneDescendantsTo can only clone children referenced through association objects.
		// Therefore we need a constructor that takes the name as the argument.
		return cloneDescendantsTo(new MethodInvocation());
	}

}
