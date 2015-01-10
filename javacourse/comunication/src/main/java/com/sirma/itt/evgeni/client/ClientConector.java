package com.sirma.itt.evgeni.client;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;

public class ClientConector extends Conector {

	public ClientConector(Comunicator comunicator) {
		super(comunicator);
	}

	@Override
	protected void connect(String ip, int port) {

	}

	@Override
	protected void disconect() {

	}
}
