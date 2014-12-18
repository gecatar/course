package com.sirma.itt.evgeni.task2;

import java.util.ArrayList;

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

		MailBuilder mailBuilder = new MailBuilder();

		System.out.println("Enter values for object that will be created:");
		System.out.println("Enter sender:");
		String from = ConsoleReader.readString();
		System.out.println("Enter receiver:");
		String to = ConsoleReader.readString();
		System.out.println("Enter CC:");
		String cc = ConsoleReader.readString();
		System.out.println("Enter Subject:");
		String subject = ConsoleReader.readString();
		System.out.println("Enter Content:");
		String content = ConsoleReader.readString();

		mailBuilder.from(from).to(to).cc(cc).content(content).subject(subject)
				.atachment(new ArrayList<Object>());

		Mail mail = mailBuilder.build();

		System.out.println("List all fields in mail object");
		System.out.println("Sender:");
		System.out.println(mail.getFrom());
		System.out.println("Receiver:");
		System.out.println(mail.getTo());
		System.out.println("CC:");
		System.out.println(mail.getCc());
		System.out.println("Subject:");
		System.out.println(mail.getSubject());
		System.out.println("Content:");
		System.out.println(mail.getContent());

	}

}