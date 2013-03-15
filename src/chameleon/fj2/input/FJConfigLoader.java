package chameleon.fj2.input;

import java.io.File;

import be.kuleuven.cs.distrinet.rejuse.predicate.False;
import be.kuleuven.cs.distrinet.rejuse.predicate.SafePredicate;
import chameleon.core.namespace.LazyRootNamespace;
import chameleon.plugin.LanguagePluginImpl;
import chameleon.workspace.BootstrapProjectConfig.BaseLibraryConfiguration;
import chameleon.workspace.ConfigException;
import chameleon.workspace.ExtensionPredicate;
import chameleon.workspace.FileInputSourceFactory;
import chameleon.workspace.ProjectConfigurator;
import chameleon.workspace.ProjectInitialisationListener;
import chameleon.workspace.View;
import chameleon.workspace.Workspace;

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
