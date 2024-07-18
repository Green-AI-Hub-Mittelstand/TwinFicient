package de.dfki.cos.twinficient.digitaltwin.dataintegration.config;

import java.time.Duration;

public interface ProcessConfiguration {

	Duration getFetchFrequency();

	boolean isDisableTasks();

	Duration getStartUpDelay();

}