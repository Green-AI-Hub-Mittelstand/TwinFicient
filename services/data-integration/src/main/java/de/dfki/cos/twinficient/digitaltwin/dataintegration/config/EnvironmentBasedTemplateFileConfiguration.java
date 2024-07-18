package de.dfki.cos.twinficient.digitaltwin.dataintegration.config;

import java.nio.file.Path;
import java.nio.file.Paths;

public class EnvironmentBasedTemplateFileConfiguration implements TemplateFileConfiguration {

	public static final String ENV_TWINFICIENT_DATAINTEGRATION_TEMPLATE_FOLDER = "TF_DATAINTEGRATION_TEMPLATE_FOLDER";
	
	@Override
	public Path getTemplateFolder() {
		String folderName = EnvironmentVariables.getEnvOrThrow(ENV_TWINFICIENT_DATAINTEGRATION_TEMPLATE_FOLDER);
		return Paths.get(folderName);
	}

}
