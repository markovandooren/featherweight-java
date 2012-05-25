package chameleon.fj2.model;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.language.Language;
import chameleon.core.language.LanguageImpl;
import chameleon.core.namespace.RootNamespace;

public class FJ extends LanguageImpl {

	public FJ() {
		super("Featherweight Java");
		new RootNamespace(new SimpleNameSignature(""), this);
	}

	@Override
	protected Language cloneThis() {
		return new FJ();
	}

}
