package chameleon.fj2.model;

import java.util.List;

import chameleon.core.declaration.CommonDeclarationContainingDeclaration;

/**
 * An abstract class for class members with parameters. Examples are methods
 * and constructors.
 * 
 * @author Marko van Dooren
 */
public abstract class MemberWithParameters extends CommonDeclarationContainingDeclaration implements Member {

	public List<Parameter> parameters() {
		return declarations(Parameter.class);
	}
}
