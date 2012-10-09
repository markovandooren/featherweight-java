package chameleon.fj2.input;

import chameleon.exception.ChameleonProgrammerException;
import chameleon.fj2.model.Klazz;
import chameleon.workspace.DirectInputSource;
import chameleon.workspace.DocumentLoaderImpl;
import chameleon.workspace.InputException;
import chameleon.workspace.ProjectException;
import chameleon.workspace.View;

public class BaseFJLoader extends DocumentLoaderImpl {

	@Override
	protected void notifyProjectAdded(View view) throws ProjectException {
		addObject(view);
	}
	
	private void addObject(View view) {
    Klazz obj = new Klazz("Object");
		try {
			addInputSource(new DirectInputSource(obj,"",view));
		} catch (InputException e) {
			throw new ChameleonProgrammerException(e);
		}
	}


}