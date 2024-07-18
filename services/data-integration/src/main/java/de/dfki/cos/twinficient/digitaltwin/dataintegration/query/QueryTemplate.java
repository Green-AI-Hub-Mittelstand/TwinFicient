package de.dfki.cos.twinficient.digitaltwin.dataintegration.query;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Map.Entry;

import de.dfki.cos.twinficient.digitaltwin.dataintegration.config.TemplateFileConfiguration;

public class QueryTemplate {

	private final String template;
	
	private QueryTemplate(String template) {
		this.template = template;
	}
	
	public static QueryTemplate fromClasspath(Class<?> cls, String path) {
		try (InputStream in = cls.getResourceAsStream(path); BufferedInputStream bIn = new BufferedInputStream(in)) {
			byte[] all = bIn.readAllBytes();
			return new QueryTemplate(new String(all, StandardCharsets.UTF_8));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public static QueryTemplate fromFile(TemplateFileConfiguration config, String path) {
		Path folderPath = config.getTemplateFolder();
		Path filepath = folderPath.resolve(path);
		try {
			String data = Files.readString(filepath, StandardCharsets.UTF_8);
			return new QueryTemplate(data);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public String toQuery(Map<String, Object> params) {
		String newTemplate = template;
		for (Entry<String, Object> eachParam : params.entrySet()) {
			newTemplate = newTemplate.replace("params."+eachParam.getKey(), eachParam.getValue().toString());
		}
		return newTemplate;
	}
	
	
}
