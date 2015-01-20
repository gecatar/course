package com.sirma.itt.comunication.test;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Conector;

public class StartStopTest extends Conector {

	public StartStopTest(Comunicator comunicator) {
		super(comunicator);
	}

	@Override
	protected void connect(String ip, int port) {

	}

}
