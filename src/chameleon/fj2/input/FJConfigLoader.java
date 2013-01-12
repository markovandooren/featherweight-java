package chameleon.fj2.input;

import java.io.File;

import chameleon.core.namespace.LazyRootNamespace;
import chameleon.plugin.LanguagePluginImpl;
import chameleon.workspace.ConfigException;
import chameleon.workspace.FileInputSourceFactory;
import chameleon.workspace.ProjectConfigurator;
import chameleon.workspace.ProjectInitialisationListener;
import chameleon.workspace.View;
import chameleon.workspace.BootstrapProjectConfig.BaseLibraryConfiguration;

public class FJConfigLoader extends LanguagePluginImpl implements ProjectConfigurator {

	@Override
	public FJProjectConfig createConfigElement(String projectName, File root, ProjectInitialisationListener listener, BaseLibraryConfiguration baseLibraryConfiguration) throws ConfigException {
		View view = new View(new LazyRootNamespace(), language());
		if(listener != null) {listener.viewAdded(view);}
		return new FJProjectConfig(view, new FileInputSourceFactory(), projectName, root);
	}

	@Override
	public FJConfigLoader clone() {
		return new FJConfigLoader();
	}

}
