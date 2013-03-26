package be.kuleuven.cs.distrinet.chameleon.fj2.model;

import be.kuleuven.cs.distrinet.chameleon.input.ModelFactory;
import be.kuleuven.cs.distrinet.chameleon.workspace.ProjectConfigurator;
import be.kuleuven.cs.distrinet.chameleon.fj2.input.FJConfigLoader;
import be.kuleuven.cs.distrinet.chameleon.fj2.input.FJModelFactory;

public class FJLanguageFactory {

	public FJ create() {
		ModelFactory factory = new FJModelFactory();
		FJ result = (FJ) factory.language();
		result.setPlugin(ProjectConfigurator.class, new FJConfigLoader());
		return result;
	}

}
