package com.sirma.itt.evgeni.task2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Check correct set up on mail object fields.
 */
import com.sirma.itt.evgeni.task2.Mail;

public class MailBuilderTest {

	/**
	 * Create new mail object and check fields.
	 */
	@Test
	public void MailBuilderTest() {

		Mail mail = Mail.from("test1").setTo("test2").setSubject("test3")
				.build();
		assertEquals("test1", mail.getFrom());
		assertEquals("test2", mail.getTo());
		assertEquals("test3", mail.getSubject());
	}

}
