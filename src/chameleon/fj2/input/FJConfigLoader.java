package chameleon.fj2.input;

import java.io.File;

import chameleon.core.language.Language;
import chameleon.core.namespace.LazyRootNamespace;
import chameleon.plugin.Plugin;
import chameleon.plugin.PluginImpl;
import chameleon.workspace.ConfigElement;
import chameleon.workspace.ConfigException;
import chameleon.workspace.ConfigLoader;
import chameleon.workspace.FileInputSourceFactory;
import chameleon.workspace.View;

public class FJConfigLoader extends PluginImpl implements ConfigLoader {

	@Override
	public ConfigElement createConfigElement(Language language, String projectName, File root) throws ConfigException {
		View view = new View(new LazyRootNamespace(), language);
		return new FJProjectConfig(view, new FileInputSourceFactory(), projectName, root);
	}

	@Override
	public Plugin clone() {
		return new FJConfigLoader();
	}

}
