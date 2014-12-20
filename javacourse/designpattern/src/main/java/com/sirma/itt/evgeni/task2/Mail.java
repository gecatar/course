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

	/**
	 * Create new Builder and set from field.
	 * 
	 * @param from
	 * @return
	 */
	static To from(String from) {
		return new Builder(from);
	}

	/**
	 * Set fields on mail object.
	 * 
	 * @author GecaTM
	 *
	 */
	static class Builder implements To {
		private Mail mail = new Mail();

		/**
		 * Set from field
		 * 
		 * @param from
		 */
		public Builder(String from) {
			mail.from = from;
		}

		/**
		 * Set subject field.
		 * 
		 * @param subject
		 * @return
		 */
		public Builder subject(String subject) {
			mail.subject = subject;
			return this;
		}

		/**
		 * Set content field.
		 * 
		 * @param content
		 * @return
		 */
		public Builder content(String content) {
			mail.content = content;
			return this;
		}

		/**
		 * Set to field.
		 */
		public Builder to(String to) {
			mail.to = to;
			return this;
		}

		/**
		 * Return Mail object.
		 * 
		 * @return
		 */
		public Mail build() {
			return mail;
		}
	}

	/**
	 * Allow field to be mandatory.
	 * 
	 * @author GecaTM
	 *
	 */
	public interface To {
		public Builder to(String subject);
	}

}
