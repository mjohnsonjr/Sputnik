package sputnik.util.enumeration;

public enum LogLevel {

	/* Only logged on debug builds. */
	DEBUG,
	/* Will be logged on stable builds. */
	STABLE, 
	/* Nothing will be logged. (DO NOT USE THIS IN CODE BESIDES SETTING THIS LEVEL). */
	SILENT
	
}
