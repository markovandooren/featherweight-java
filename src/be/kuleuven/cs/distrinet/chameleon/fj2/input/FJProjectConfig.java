package be.kuleuven.cs.distrinet.chameleon.fj2.input;

import java.io.File;

import be.kuleuven.cs.distrinet.chameleon.workspace.FileInputSourceFactory;
import be.kuleuven.cs.distrinet.chameleon.workspace.ProjectConfiguration;
import be.kuleuven.cs.distrinet.chameleon.workspace.View;
import be.kuleuven.cs.distrinet.chameleon.workspace.Workspace;

public class FJProjectConfig extends ProjectConfiguration {

	public FJProjectConfig(String projectName, File root, View view, Workspace workspace, FileInputSourceFactory factory) {
		super(projectName, root, view, workspace, factory);
	}

}
