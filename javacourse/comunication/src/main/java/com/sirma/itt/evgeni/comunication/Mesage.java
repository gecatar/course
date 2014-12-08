package com.sirma.itt.evgeni.comunication;

import java.io.Serializable;

public class Mesage implements Serializable {

	public MesageCommand commandID;
	public String sender;
	public String receiver;
	public String text;

	public Mesage(String sender, String receiver, String text) {
		this.sender = sender;
		this.receiver = receiver;
		this.text = text;
		commandID = MesageCommand.TEXT_MESAGE;
	}

	public Mesage(MesageCommand commandIP) {
		this.commandID = commandID;
	}

	public Mesage(String name, MesageCommand commandID) {
		this.commandID = commandID;
		sender = name;
	}

}