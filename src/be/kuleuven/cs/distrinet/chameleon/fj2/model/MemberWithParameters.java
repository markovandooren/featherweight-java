package be.kuleuven.cs.distrinet.chameleon.fj2.model;

import java.util.List;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.CommonDeclarationContainingDeclaration;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;

/**
 * An abstract class for class members with parameters. Examples are methods
 * and constructors.
 * 
 * @author Marko van Dooren
 */
public abstract class MemberWithParameters extends CommonDeclarationContainingDeclaration implements Member {

	public List<Parameter> parameters() throws LookupException {
		return declarations(Parameter.class);
	}
}
