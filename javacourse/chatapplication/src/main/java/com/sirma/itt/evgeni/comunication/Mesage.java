package com.sirma.itt.evgeni.comunication;

import java.io.Serializable;

public class Mesage implements Serializable {

	public int commandID;
	public String sender;
	public String receiver;
	public String text;

	public Mesage(String sender, String receiver, String text) {
		this.sender = sender;
		this.receiver = receiver;
		this.text = text;
		commandID = 1;
	}

	public Mesage(String name) {
		commandID = 2;
		sender = name;
	}

	public Mesage(int commandID, String name) {
		this.commandID = commandID;
		sender = name;
	}
}