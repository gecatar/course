package com.sirma.itt.evgeni.util;

import java.util.regex.Pattern;

/**
 * Replace text. Surrounded by tags.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class TextReplacer {

	private static final Pattern pattern = Pattern
			.compile("\\<x\\>[\\w|\\s]*\\<\\/x>");

	/**
	 * Replace text. Surrounded by tags.
	 * 
	 * @param text
	 * @return
	 */
	public static String replace(String text) {
		return pattern.matcher(text).replaceAll("<x/>");
	}
}
