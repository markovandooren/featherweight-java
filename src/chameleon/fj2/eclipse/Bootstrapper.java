package chameleon.fj2.eclipse;

import java.io.IOException;

import chameleon.core.language.Language;
import chameleon.eclipse.connector.EclipseBootstrapper;
import chameleon.eclipse.connector.EclipseEditorExtension;
import chameleon.fj2.input.FJModelFactory;
import chameleon.fj2.model.FJ;
import chameleon.input.ModelFactory;
import chameleon.input.ParseException;

public class Bootstrapper extends EclipseBootstrapper {

	public final static String PLUGIN_ID="be.chameleon.eclipse.fj";

	public Bootstrapper() {
		super("Featherweight Java","0.0.1","fj");
	}

	@Override
	public Language createLanguage() throws IOException, ParseException {
		ModelFactory factory = new FJModelFactory();
		FJ result = (FJ) factory.language();
		result.setPlugin(EclipseEditorExtension.class, new EclipseEditorExtension(getLanguageName()));
		return result;

	}

}
