package chameleon.fj2.input;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

import chameleon.core.element.Element;
import chameleon.core.namespace.Namespace;
import chameleon.core.namespacedeclaration.NamespaceDeclaration;
import chameleon.fj2.model.FJ;
import chameleon.fj2.model.Klazz;
import chameleon.input.ModelFactory;
import chameleon.input.ParseException;
import chameleon.support.input.ChameleonParser;
import chameleon.support.input.ModelFactoryUsingANTLR;
import chameleon.workspace.View;

public class FJModelFactory extends ModelFactoryUsingANTLR {

	public FJModelFactory() {
		FJ lang = new FJ();
		setLanguage(lang, ModelFactory.class);
	}

	@Override
	public FJModelFactory clone() {
		return new FJModelFactory();
	}

	@Override
	public ChameleonParser getParser(InputStream inputStream, View view) throws IOException {
    ANTLRInputStream input = new ANTLRInputStream(inputStream);
    fjLexer lexer = new fjLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    fjParser parser = new fjParser(tokens);
    parser.setView(view);
    return parser;
	}

	@Override
	protected <P extends Element> Element parse(Element element, String text) throws ParseException {
		return null;
	}

}
