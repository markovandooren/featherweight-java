package be.kuleuven.cs.distrinet.chameleon.fj2.input;

import java.io.File;

import be.kuleuven.cs.distrinet.chameleon.core.namespace.LazyRootNamespace;
import be.kuleuven.cs.distrinet.chameleon.plugin.LanguagePluginImpl;
import be.kuleuven.cs.distrinet.chameleon.workspace.BootstrapProjectConfig.BaseLibraryConfiguration;
import be.kuleuven.cs.distrinet.chameleon.workspace.ConfigException;
import be.kuleuven.cs.distrinet.chameleon.workspace.ExtensionPredicate;
import be.kuleuven.cs.distrinet.chameleon.workspace.FileInputSourceFactory;
import be.kuleuven.cs.distrinet.chameleon.workspace.ProjectConfigurator;
import be.kuleuven.cs.distrinet.chameleon.workspace.ProjectInitialisationListener;
import be.kuleuven.cs.distrinet.chameleon.workspace.View;
import be.kuleuven.cs.distrinet.chameleon.workspace.Workspace;
import be.kuleuven.cs.distrinet.rejuse.predicate.False;
import be.kuleuven.cs.distrinet.rejuse.predicate.SafePredicate;

public class FJConfigLoader extends LanguagePluginImpl implements ProjectConfigurator {

	@Override
	public FJProjectConfig createConfigElement(String projectName, File root, Workspace workspace, ProjectInitialisationListener listener, BaseLibraryConfiguration baseLibraryConfiguration) throws ConfigException {
		View view = new View(new LazyRootNamespace(), language());
		if(listener != null) {listener.viewAdded(view);}
		return new FJProjectConfig(projectName, root, view, workspace, new FileInputSourceFactory());
	}

	@Override
	public FJConfigLoader clone() {
		return new FJConfigLoader();
	}

	@Override
	public SafePredicate<? super String> sourceFileFilter() {
		return new ExtensionPredicate("fj");
	}

	@Override
	public SafePredicate<? super String> binaryFileFilter() {
		return new False<String>();
	}

}
