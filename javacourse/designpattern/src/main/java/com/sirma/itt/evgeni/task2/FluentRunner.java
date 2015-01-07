package com.sirma.itt.evgeni.task2;

import com.sirma.itt.evgeni.util.ConsoleReader;

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

		System.out.println("Enter sender:");
		String from = ConsoleReader.readString();
		System.out.println("Enter receiver:");
		String to = ConsoleReader.readString();
		System.out.println("Enter subject:");
		String subject = ConsoleReader.readString();
		Mail mail = Mail.from(from).setTo(to).setSubject(subject).build();
		System.out.println("Sender:" + mail.getFrom());
		System.out.println("Receiver:" + mail.getTo());
		System.out.println("Subject:" + mail.getSubject());
	}

}