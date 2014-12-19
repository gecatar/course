package com.sirma.itt.evgeni.task5;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Allow user to specify path and see its content.
 * 
 * @author GecaTM
 * 
 */
public class DirectoryBrowser {

	private static final Logger LOGGER = Logger
			.getLogger(DirectoryBrowser.class.getName());

	/**
	 * Display content on passed path.
	 * 
	 * @param path
	 * @return count of elements on current path.
	 */
	public int listContent(String path) {

		File file = new File(path);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Content:\n");
			for (int i = 0; i < files.length; i++) {
				stringBuilder.append(files[i].getName()).append("\n");
			}
			LOGGER.log(Level.INFO, stringBuilder.toString().trim());
			return files.length;
		}
		if (file.isFile()) {
			LOGGER.log(Level.INFO, "Path is on file!!!");
			return 1;
		}
		return 0;
	}
}
