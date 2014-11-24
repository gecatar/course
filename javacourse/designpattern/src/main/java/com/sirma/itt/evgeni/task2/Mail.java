package com.sirma.itt.evgeni.task2;

import java.util.ArrayList;

/**
 * Example class that will be created via "Fluent interface".
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
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getCc() {
		return cc;
	}
	
	public void setCc(String cc) {
		this.cc = cc;
	}
	
	public ArrayList<Object> getAtachment() {
		return atachment;
	}
	
	public void setAtachment(ArrayList<Object> atachment) {
		this.atachment = atachment;
	}
}