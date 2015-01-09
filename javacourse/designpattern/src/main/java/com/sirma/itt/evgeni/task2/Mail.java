package com.sirma.itt.evgeni.task2;

import java.util.ArrayList;

/**
 * Example class mail builder. Responsible for creating mail objects.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Mail {

	private String from;
	private String to;
	private String subject;
	private String content;
	private String cc;
	private ArrayList<Object> atachment;

	/**
	 * Private constructor.
	 */
	private Mail() {
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public String getCc() {
		return cc;
	}

	public ArrayList<Object> getAtachment() {
		return atachment;
	}

	/**
	 * Create new Builder and set from field.
	 */
	public static To from(String from) {
		return new Builder(from);
	}

	/**
	 * Set fields on mail object.
	 * 
	 * @author GecaTM
	 *
	 */
	public static class Builder implements To {
		private Mail mail = new Mail();

		/**
		 * Builder constructor.
		 */
		public Builder(String from) {
			mail.from = from;
		}

		/**
		 * Set subject field.
		 */
		public Builder setSubject(String subject) {
			mail.subject = subject;
			return this;
		}

		public Builder setAtachment(ArrayList<Object> atachment) {
			mail.atachment = atachment;
			return this;
		}

		/**
		 * Set content field.
		 */
		public Builder setContent(String content) {
			mail.content = content;
			return this;
		}

		/**
		 * Set to field.
		 */
		public Builder setTo(String to) {
			mail.to = to;
			return this;
		}

		/**
		 * Return Mail object.
		 */
		public Mail build() {
			return mail;
		}
	}
}
