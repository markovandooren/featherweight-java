package chameleon.fj2.model;

import org.rejuse.junit.BasicRevision;

import chameleon.core.language.Language;
import chameleon.core.language.LanguageImpl;

public class FJ extends LanguageImpl {

	public FJ() {
		super("Featherweight Java", new BasicRevision(1,0,0));
	}

	@Override
	public Language clone() {
		return new FJ();
	}

}
