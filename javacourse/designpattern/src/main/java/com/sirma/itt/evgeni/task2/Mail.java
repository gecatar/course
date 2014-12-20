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

	private Mail() {
	}

	static To from(String from) {
		return new Builder(from);
	}

	static class Builder implements To {
		private Mail mail = new Mail();

		public Builder(String from) {
			mail.from = from;
		}

		public Builder subject(String subject) {
			mail.subject = subject;
			return this;
		}

		public Builder content(String content) {
			mail.content = content;
			return this;
		}

		public Builder to(String to) {
			mail.to = to;
			return this;
		}

		public Mail build() {
			return mail;
		}
	}

	public interface To {
		public Builder to(String subject);
	}

	public interface Subject {
		Content subject(String subject);
	}

	public interface Content {
		Build content(String content);
	}

	public interface Setter {

	}

	public interface Build {
		Mail build();
	}
}
