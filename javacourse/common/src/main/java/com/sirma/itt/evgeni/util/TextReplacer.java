package com.sirma.itt.evgeni.util;

import java.util.regex.Pattern;

public class TextReplacer {

	private static final Pattern pattern = Pattern
			.compile("(\\<x\\>[\\w|\\s]*\\<\\/x>)");

	public static String replace(String text) {
		return pattern.matcher(text).replaceAll("<x/>");
	}
}
