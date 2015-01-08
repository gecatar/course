package com.sirma.itt.evgeni.comunication.test;

import org.junit.Test;
import org.mockito.Mock;

import com.sirma.itt.evgeni.comunication.ClientComunicator;
import com.sirma.itt.evgeni.comunication.ComunicatorListener;

public class ClientComunicatorTest {

	ClientComunicator comunicator;
	@Mock
	ComunicatorListener listener;

	@Test
	public void test() {
		comunicator = new ClientComunicator(listener);
	}

}
