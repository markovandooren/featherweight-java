package be.kuleuven.cs.distrinet.chameleon.fj2.input;

import be.kuleuven.cs.distrinet.chameleon.exception.ChameleonProgrammerException;
import be.kuleuven.cs.distrinet.chameleon.workspace.DirectInputSource;
import be.kuleuven.cs.distrinet.chameleon.workspace.DocumentLoaderImpl;
import be.kuleuven.cs.distrinet.chameleon.workspace.InputException;
import be.kuleuven.cs.distrinet.chameleon.workspace.ProjectException;
import be.kuleuven.cs.distrinet.chameleon.workspace.View;
import be.kuleuven.cs.distrinet.chameleon.fj2.model.Klazz;

public class BaseFJLoader extends DocumentLoaderImpl {

	public BaseFJLoader() {
		super(false);
	}
	
	@Override
	protected void notifyViewAdded(View view) throws ProjectException {
		addObject(view);
	}
	
	private void addObject(View view) {
    Klazz obj = new Klazz("Object");
		try {
			new DirectInputSource(obj,"",view,this);
		} catch (InputException e) {
			throw new ChameleonProgrammerException(e);
		}
	}


}
