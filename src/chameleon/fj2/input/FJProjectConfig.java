package chameleon.fj2.input;

import java.io.File;

import chameleon.workspace.FileInputSourceFactory;
import chameleon.workspace.ProjectConfig;
import chameleon.workspace.View;

public class FJProjectConfig extends ProjectConfig {

	public FJProjectConfig(View view, FileInputSourceFactory factory, String projectName, File root) {
		super(view, factory, projectName, root);
	}

}
