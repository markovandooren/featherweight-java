package chameleon.fj2.model;

import chameleon.fj2.input.FJModelFactory;
import chameleon.input.ModelFactory;

public class FJLanguageFactory {

	public FJ create() {
		ModelFactory factory = new FJModelFactory();
		FJ result = (FJ) factory.language();
		return result;
	}

}
