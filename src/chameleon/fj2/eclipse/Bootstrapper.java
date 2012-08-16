package chameleon.fj2.eclipse;

import java.io.IOException;

import chameleon.core.declaration.SimpleNameSignature;
import chameleon.core.language.Language;
import chameleon.core.namespace.RootNamespace;
import chameleon.eclipse.connector.EclipseBootstrapper;
import chameleon.eclipse.connector.EclipseEditorExtension;
import chameleon.fj2.model.FJLanguageFactory;
import chameleon.input.ParseException;
import chameleon.workspace.DirectoryProjectBuilder;
import chameleon.workspace.Project;

public class Bootstrapper extends EclipseBootstrapper {

	public final static String PLUGIN_ID="be.chameleon.eclipse.fj";

	public Bootstrapper() {
		super("Featherweight Java","0.0.1","fj");
	}

	@Override
	public Language createLanguage() throws IOException, ParseException {
		Language result = new FJLanguageFactory().create();
		
		Project project = new Project("TODO", new RootNamespace(new SimpleNameSignature("")), result);
		DirectoryProjectBuilder builder = new DirectoryProjectBuilder(project, ".fj");

		result.setPlugin(EclipseEditorExtension.class, new FJEditorExtension(getLanguageName()));
		return result;
	}


}
