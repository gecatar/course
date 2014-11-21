package com.sirma.itt.evgeni.task8;

import com.sirma.itt.evgeni.util.ConsoleReader;

/**
 * Hangman game You have nine trays.
 * @author Evgeni Stefanov
 *
 */
public class HangmanRunner {

	/**
	 * Hangman Runner. Control user input and other stuff.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Hangman hangman = new Hangman();
		String userChoise = new String();
		System.out.println("Enter QUIT for EXIT");
		hangman.getWord();
		while (userChoise.compareTo("quit") != 0) {
			System.out.println(hangman.print());
			System.out.println("You have " + hangman.getWrongGuess() + " trys left!!!");
			userChoise = ConsoleReader.readString();
			hangman.checkLetter(userChoise.charAt(0));
			if (hangman.getWrongGuess() > 0) {
				if (hangman.isOpen()) {
					System.out.println("Congrachilation!!!!!!!!!!! Your opened the word!!!");
					hangman.getWord();
				}
			} else {
				System.out.println("You are death!!!!");
				System.out.println("The word is: "+hangman.getAnswer());
				hangman.getWord();
			}
		}

	}

}