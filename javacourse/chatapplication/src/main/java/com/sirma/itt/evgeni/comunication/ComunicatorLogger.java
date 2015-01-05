package com.sirma.itt.evgeni.comunication;

import java.util.logging.Logger;

public class ComunicatorLogger {

	private static final Logger LOGGER = Logger
			.getLogger(ComunicatorLogger.class.getName());

	public static Logger getlogger() {
		return LOGGER;
	}
}
