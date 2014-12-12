package com.sirma.itt.evgeni.util.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.evgeni.util.EmailValidator;

/**
 * Check correct validating e mails.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class EmailValidatorTest {

	/**
	 * Validate valid email.
	 */
	@Test
	public void test() {
		assertTrue(EmailValidator.validate("example@example.test.com"));
	}

}
