package com.sirma.itt.evgeni.client.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sirma.itt.evgeni.client.Client;
import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.comunication.DataTransferator;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;

@RunWith(MockitoJUnitRunner.class)
public class ClientTest {

	@Mock
	ComunicatorListener listener;
	Comunicator client;
	@Mock
	DataTransferator transferator;

	@Before
	public void setUp() throws Exception {
		Mockito.when(transferator.readMessage()).thenThrow(new IOException());

	}

	/**
	 * Check behavior when adding user session.
	 */
	@Test
	public void addUserSessionTest() throws ClassNotFoundException, IOException {
		client = new Client(listener);
		client.addUserSession(transferator);
		Mockito.verify(listener, Mockito.atLeast(1)).setConectionStatus(
				"Conected...");
		Mockito.verify(transferator, Mockito.atLeast(1)).sendData(
				Mockito.any(Mesage.class));
	}

	/**
	 * Check behavior when removing user session.
	 */
	@Test
	public void closeUserSessionTest() {
		client = new Client(listener);
		client.addUserSession(transferator);
		client.closeUserSession(transferator);
		Mockito.verify(listener, Mockito.atLeast(1)).setConectionStatus(
				Mockito.anyString());
		Mockito.verify(transferator, Mockito.atLeast(1)).closeSocket();
	}

	@Test
	public void proccesMessageTest() {
		client = new Client(listener);
		client.processMesage(new Mesage(MesageCommand.INVALID_USER_NAME),
				transferator);
		Mockito.verify(listener, Mockito.atLeast(1)).setConectionStatus(
				Mockito.anyString());
		client.processMesage(new Mesage(MesageCommand.TEXT_MESAGE),
				transferator);
		Mockito.verify(listener, Mockito.atLeast(1)).showMesage(
				Mockito.anyString(), Mockito.anyString());
		client.processMesage(new Mesage(MesageCommand.USER_CONECTED),
				transferator);
		Mockito.verify(listener, Mockito.atLeast(1)).addUser(
				Mockito.anyString());
		client.processMesage(new Mesage(MesageCommand.USER_DISCONECTED),
				transferator);
		Mockito.verify(listener, Mockito.atLeast(1)).removeUser(
				Mockito.anyString());
	}

}
