package chameleon.fj2.model;

import chameleon.fj2.input.FJConfigLoader;
import chameleon.fj2.input.FJModelFactory;
import chameleon.input.ModelFactory;
import chameleon.workspace.ConfigLoader;

public class FJLanguageFactory {

	public FJ create() {
		ModelFactory factory = new FJModelFactory();
		FJ result = (FJ) factory.language();
		result.setPlugin(ConfigLoader.class, new FJConfigLoader());
		return result;
	}

}
