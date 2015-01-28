package com.sirma.itt.evgeni.comunication;

import java.io.Serializable;

/**
 * Message object for communication between communicators.
 * 
 * @author GecaTM
 *
 */
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

	public Mesage(MesageCommand commandID) {
		this.commandID = commandID;
	}

	public Mesage(MesageCommand comandID, String receiver) {
		this.receiver = receiver;
		this.commandID = comandID;
	}

	public Mesage(String name, MesageCommand commandID) {
		this.commandID = commandID;
		sender = name;
	}

	public Mesage(String receiver, String text) {
		commandID = MesageCommand.TEXT_MESAGE;
		this.receiver = receiver;
		this.text = text;
	}

}