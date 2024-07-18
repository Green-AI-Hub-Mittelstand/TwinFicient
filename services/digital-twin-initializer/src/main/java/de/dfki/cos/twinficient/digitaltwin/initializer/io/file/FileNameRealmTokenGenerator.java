package de.dfki.cos.twinficient.digitaltwin.initializer.io.file;

import java.nio.file.Path;

public class FileNameRealmTokenGenerator implements RealmTokenGenerator {

	@Override
	public String realmForPath(Path path) {
		return path.getFileName().toString();
	}

}