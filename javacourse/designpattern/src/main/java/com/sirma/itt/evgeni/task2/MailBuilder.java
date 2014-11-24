package com.sirma.itt.evgeni.task2;

import java.util.ArrayList;


/**
 * Example class mail builder. Responsible for creating mail objects.
 * @author Evgeni Stefanov
 *
 */
public class MailBuilder {

	//This object will be returned after setup complete.
	private Mail mail;

	//Creating instance of object.
	public MailBuilder() {
		mail = new Mail();
	}
	
	//Set From.
	public MailBuilder from(String from){
		mail.setFrom(from);
		return this;
	}
	
	//Set to.
	public MailBuilder to(String to){
		mail.setTo(to);
		return this;
	}
	
	//Set subject.
	public MailBuilder subject(String subject){
		mail.setSubject(subject);
		return this;
	}
	
	//Set content.
	public MailBuilder content(String content){
		mail.setContent(content);
		return this;
	}
	
	//Set cc.
	public MailBuilder cc(String cc){
		mail.setCc(cc);
		return this;
	}
	
	//Add attachment.
	public MailBuilder atachment(ArrayList<Object> atachment){
		mail.setAtachment(atachment);
		return this;
	}
	
	//Return instance of preparered object.
	public Mail build(){
		return mail;
	}
}