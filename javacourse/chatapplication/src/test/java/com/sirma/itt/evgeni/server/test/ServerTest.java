package com.sirma.itt.evgeni.server.test;

import org.junit.Before;

import com.sirma.itt.evgeni.server.Server;

public class ServerTest {

	Server server;

	@Before
	public void setUp() throws Exception {
		server = new Server(null);
	}
}
