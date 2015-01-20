package com.sirma.itt.evgeni.client.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sirma.itt.evgeni.client.ClientComunicator;
import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;

@RunWith(MockitoJUnitRunner.class)
public class ClientTest {

	@Mock
	private ComunicatorListener listener;
	private Comunicator client;
	@Mock
	private DataTransferer transferer;

	@Before
	public void setUp() throws Exception {
		Mockito.when(transferer.readMessage()).thenThrow(new IOException());

	}

	/**
	 * Check behavior when adding user session.
	 */
	@Test
	public void addUserSessionTest() throws ClassNotFoundException, IOException {
		client = new ClientComunicator(listener);
		client.openSession(transferer);
		Mockito.verify(listener, Mockito.atLeast(1)).setConectionStatus(
				Mockito.any(MesageCommand.class));
		Mockito.verify(transferer, Mockito.atLeast(1)).sendData(
				Mockito.any(Mesage.class));
	}

	/**
	 * Check behavior when removing user session.
	 */
	@Test
	public void closeUserSessionTest() {
		client = new ClientComunicator(listener);
		client.openSession(transferer);
		client.closeSession(transferer);
		Mockito.verify(listener, Mockito.atLeast(1)).setConectionStatus(
				Mockito.any(MesageCommand.class));
		Mockito.verify(transferer, Mockito.atLeast(1)).closeSocket();
	}
}
