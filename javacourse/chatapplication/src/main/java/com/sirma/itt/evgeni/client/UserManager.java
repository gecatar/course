package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.comunication.DataTransferator;

public class UserManager {

	private DataTransferator transferator;

	public void registerUser(String name, DataTransferator transferator) {
		this.transferator = transferator;
	}

	public void removeUser() {

	}
}
