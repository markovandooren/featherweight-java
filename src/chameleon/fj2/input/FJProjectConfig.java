package chameleon.fj2.input;

import java.io.File;
import java.util.Collections;
import java.util.List;

import chameleon.workspace.FileInputSourceFactory;
import chameleon.workspace.ProjectConfig;
import chameleon.workspace.View;

public class FJProjectConfig extends ProjectConfig {

	public FJProjectConfig(View view, FileInputSourceFactory factory, String projectName, File root) {
		super(view, factory, projectName, root);
	}

	@Override
	protected List<String> sourceExtensions() {
		return Collections.singletonList(".fj");
	}

}
