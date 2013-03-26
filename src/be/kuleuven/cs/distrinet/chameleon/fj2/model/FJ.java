package be.kuleuven.cs.distrinet.chameleon.fj2.model;

import be.kuleuven.cs.distrinet.chameleon.core.language.Language;
import be.kuleuven.cs.distrinet.chameleon.core.language.LanguageImpl;
import be.kuleuven.cs.distrinet.rejuse.junit.BasicRevision;

public class FJ extends LanguageImpl {

	public FJ() {
		super("Featherweight Java", new BasicRevision(1,0,0));
	}

	@Override
	public Language clone() {
		return new FJ();
	}

}
