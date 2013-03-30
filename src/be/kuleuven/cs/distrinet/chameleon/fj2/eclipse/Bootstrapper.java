package be.kuleuven.cs.distrinet.chameleon.fj2.eclipse;

import be.kuleuven.cs.distrinet.chameleon.core.language.Language;
import be.kuleuven.cs.distrinet.chameleon.eclipse.connector.EclipseBootstrapper;
import be.kuleuven.cs.distrinet.chameleon.eclipse.connector.EclipseEditorExtension;
import be.kuleuven.cs.distrinet.chameleon.fj2.model.FJLanguageFactory;

public class Bootstrapper extends EclipseBootstrapper {

	public final static String PLUGIN_ID="be.chameleon.eclipse.fj";

	@Override
	public Language createLanguage()  {
		Language result = new FJLanguageFactory().create();
		result.setPlugin(EclipseEditorExtension.class, new FJEditorExtension());
		return result;
	}


}
