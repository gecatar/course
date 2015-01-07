package com.sirma.itt.evgeni.server.test;

import static org.junit.Assert.assertTrue;

import java.io.ObjectOutputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferator;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;
import com.sirma.itt.evgeni.comunicator.test.ComunicatorListenerTest;
import com.sirma.itt.evgeni.server.Server;

@RunWith(MockitoJUnitRunner.class)
public class ServerTest {

	ComunicatorListener listener;
	Comunicator server;
	@Mock
	DataTransferator transferator;
	@Mock
	ObjectOutputStream ost;

	@Before
	public void setUp() throws Exception {

		listener = new ComunicatorListenerTest();
		server = new Server(listener);
	}

	@Test
	public void addUserTest() {

		Mockito.when(transferator.sendData(Mockito.any(Mesage.class)))
				.thenReturn(true);
		server.processMesage(new Mesage("test", MesageCommand.USER_LOG_IN),
				transferator);
		assertTrue(transferator.sendData(null));
		server.closeUserSession(transferator);
	}

}
