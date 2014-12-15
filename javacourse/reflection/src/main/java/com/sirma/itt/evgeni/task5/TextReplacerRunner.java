package com.sirma.itt.evgeni.task5;

import com.sirma.itt.evgeni.util.TextReplacer;

/**
 * Replace text surrounded by tags.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class TextReplacerRunner {

	/**
	 * Replace text.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "<x><b></b><x>Hello world</x> <b>sdfsdf</b><x>Good morning</x><x>69</x><x>sdfsdfsdf</x> </x>";
		System.out.println("Text before replacing:");
		System.out.println(text);
		System.out.println("Text after replacing:");
		System.out.println(TextReplacer.replace(text));
	}

}
