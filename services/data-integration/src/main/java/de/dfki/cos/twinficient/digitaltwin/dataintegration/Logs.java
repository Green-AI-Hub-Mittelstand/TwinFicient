package de.dfki.cos.twinficient.digitaltwin.dataintegration;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logs {

	private static final String ENV_TF_LOG_LEVEL = "TF_LOG_LEVEL";

	private Logs() {
	}

	public static Logger getLogger(Class<?> cls) {
		String logLevel = System.getenv(ENV_TF_LOG_LEVEL);
		Level level;
		if (logLevel == null) {
			level = Level.SEVERE;
		} else {
			level = Level.parse(logLevel);
		}
		Logger logger = Logger.getLogger(cls.getName());
		logger.setLevel(level);
		
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(level);
		logger.addHandler(handler);
		
		logger.setUseParentHandlers(false);
		
		return logger;
	}
	
}
