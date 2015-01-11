package com.sirma.itt.evgeni.server;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;

public class ServerConector extends Conector {

	public ServerConector(Comunicator comunicator) {
		super(comunicator);
	}

	@Override
	protected void connect(String ip, int port) {

	}

	@Override
	protected void disconect() {

	}

}
