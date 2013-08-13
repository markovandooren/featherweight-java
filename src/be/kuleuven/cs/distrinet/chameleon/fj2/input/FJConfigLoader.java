package be.kuleuven.cs.distrinet.chameleon.fj2.input;

import be.kuleuven.cs.distrinet.chameleon.workspace.ConfigException;
import be.kuleuven.cs.distrinet.chameleon.workspace.ExtensionPredicate;
import be.kuleuven.cs.distrinet.chameleon.workspace.FileInputSourceFactory;
import be.kuleuven.cs.distrinet.chameleon.workspace.ProjectConfiguration;
import be.kuleuven.cs.distrinet.chameleon.workspace.ProjectConfigurator;
import be.kuleuven.cs.distrinet.chameleon.workspace.ProjectConfiguratorImpl;
import be.kuleuven.cs.distrinet.chameleon.workspace.View;
import be.kuleuven.cs.distrinet.rejuse.action.Nothing;
import be.kuleuven.cs.distrinet.rejuse.predicate.False;
import be.kuleuven.cs.distrinet.rejuse.predicate.Predicate;
import be.kuleuven.cs.distrinet.rejuse.predicate.SafePredicate;

public class FJConfigLoader extends ProjectConfiguratorImpl implements ProjectConfigurator {

	@Override
	public FJConfigLoader clone() {
		return new FJConfigLoader();
	}

	@Override
	public SafePredicate<? super String> sourceFileFilter() {
		return new ExtensionPredicate("fj");
	}

	@Override
	public Predicate<? super String,Nothing> binaryFileFilter() {
		return new False();
	}

	@Override
	protected ProjectConfiguration createProjectConfig(View view) throws ConfigException {
		return new FJProjectConfig(view, new FileInputSourceFactory());
	}

}
