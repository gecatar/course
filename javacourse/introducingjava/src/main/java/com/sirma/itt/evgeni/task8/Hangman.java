package com.sirma.itt.evgeni.task8;

import java.util.Random;

/**
 * Generate random words, count lives, check for open letters.
 * 
 * @author Evgeni Stefanov
 */
public class Hangman {

	private String[] words = { "telephone", "cartrige", "microscope", "torpedo",
			"aircraft", "inspector", "detective", "mailbox", "elephant" };
	private Random rnd = new Random();
	private String word = new String();
	private String opened = new String();
	private byte wrongGuess = 9;

	/**
	 * choose random word
	 */
	public void getWord() {
		word = words[Math.abs(rnd.nextInt() % words.length)].toString();
		wrongGuess = 9;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			stringBuilder.append("-");
		}
		opened = stringBuilder.toString();
	}

	/**
	 * Return word that must be opened.
	 * 
	 * @return current word.
	 */
	public String getAnswer() {
		return word;
	}

	/**
	 * Check word state.
	 * 
	 * @return true if word is fully opened.
	 */
	public Boolean isOpen() {
		if (opened.contains("-")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Check state of player.
	 * 
	 * @return number of left lives.
	 */
	public byte getWrongGuess() {
		return wrongGuess;
	}

	/**
	 * Print current word. Replace unopened letters whit "-".
	 * 
	 * @return string whit word state.
	 */
	public String print() {
		return opened;
	}

	/**
	 * Check for letter. Decrement lives.
	 * 
	 * @param ch
	 *            user input
	 * @return string whit opened letter.
	 */
	public String checkLetter(char ch) {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(opened);
		boolean decrementLife = true;
		int index = 0;
		index = word.indexOf(ch, index);
		while (index != -1 && index < word.length()) {
			stringBuilder.setCharAt(index, ch);
			index++;
			index = word.indexOf(ch, index);
			decrementLife = false;
		}
		if (decrementLife && wrongGuess > 0) {
			wrongGuess--;
		}
		opened = stringBuilder.toString();
		return opened;
	}

}
