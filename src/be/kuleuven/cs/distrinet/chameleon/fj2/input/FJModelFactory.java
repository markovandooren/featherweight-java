package be.kuleuven.cs.distrinet.chameleon.fj2.input;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.input.ModelFactory;
import be.kuleuven.cs.distrinet.chameleon.input.ParseException;
import be.kuleuven.cs.distrinet.chameleon.support.input.ChameleonParser;
import be.kuleuven.cs.distrinet.chameleon.support.input.ModelFactoryUsingANTLR;
import be.kuleuven.cs.distrinet.chameleon.workspace.View;
import be.kuleuven.cs.distrinet.chameleon.fj2.model.FJ;

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
