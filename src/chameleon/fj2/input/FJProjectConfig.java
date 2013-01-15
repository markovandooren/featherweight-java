package chameleon.fj2.input;

import java.io.File;

import chameleon.workspace.FileInputSourceFactory;
import chameleon.workspace.ProjectConfiguration;
import chameleon.workspace.View;
import chameleon.workspace.Workspace;

public class FJProjectConfig extends ProjectConfiguration {

	public FJProjectConfig(String projectName, File root, View view, Workspace workspace, FileInputSourceFactory factory) {
		super(projectName, root, view, workspace, factory);
	}

}
