package chameleon.fj2.eclipse;

import chameleon.core.language.Language;
import chameleon.eclipse.connector.EclipseBootstrapper;
import chameleon.eclipse.connector.EclipseEditorExtension;
import chameleon.fj2.model.FJLanguageFactory;

public class Bootstrapper extends EclipseBootstrapper {

	public final static String PLUGIN_ID="be.chameleon.eclipse.fj";

	public Bootstrapper() {
		super("Featherweight Java","0.0.1","fj",PLUGIN_ID);
	}

	@Override
	public Language createLanguage()  {
		Language result = new FJLanguageFactory().create();
		
//		Project project = new Project("TODO", new RootNamespace(new SimpleNameSignature("")), result);
//		DirectoryLoader builder = new DirectoryLoader(project, ".fj");

		result.setPlugin(EclipseEditorExtension.class, new FJEditorExtension(getLanguageName()));
		return result;
	}


}
