package com.sirma.itt.evgeni.task8.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.sirma.itt.evgeni.task8.Hangman;

/**
 * Test behavior after series of correct answers.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class HangmanTest {

	Hangman hangman = new Hangman();

	/**
	 * Test correct opening on word.
	 */
	@Test
	public void test() {

		hangman.getWord();
		String answer = hangman.getAnswer();
		char[] answerArray = answer.toCharArray();
		for (char ch : answerArray) {
			hangman.checkLetter(ch);
		}
		assertTrue(hangman.isOpen());
	}

}
