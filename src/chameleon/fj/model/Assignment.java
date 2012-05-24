package chameleon.fj.model;

import chameleon.core.element.Element;
import chameleon.core.element.ElementImpl;

public class Assignment extends ElementImpl {

	public Assignment(String lhs, String rhs) {
		setLhs(lhs);
		setRhs(rhs);
	}
	
	// In phase 1 we use a String.
	private String _left;
	
	public String lhs() {
		return _left;
	}
	
	public void setLhs(String lhs) {
		_left = lhs;
	}
	
	// In phase 1 we use a String.
	private String _rhs;
	
	public String rhs() {
		return _rhs;
	}
	
	public void setRhs(String rhs) {
		_rhs = rhs;
	}
	

	
	@Override
	public Element clone() {
		return cloneDescendantsTo(new Assignment(lhs(),rhs()));
	}

	
	
}
