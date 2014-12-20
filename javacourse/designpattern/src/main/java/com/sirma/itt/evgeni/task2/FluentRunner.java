package com.sirma.itt.evgeni.task2;

/**
 * Implement fluent interface in java. MailBuilder create object for us.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class FluentRunner {

	/**
	 * Initialize and list all fields on mail object.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Mail mail = Mail.from("me").to("you").subject("aha").build();

	}

}