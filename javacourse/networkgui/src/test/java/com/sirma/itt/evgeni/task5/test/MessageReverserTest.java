package com.sirma.itt.evgeni.task5.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.comunication.ComunicatorListener;
import com.sirma.itt.evgeni.task5.MessageReader;
import com.sirma.itt.evgeni.task5.MessageReverser;

public class MessageReverserTest implements ComunicatorListener {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test() throws IOException {
		MessageReverser messageReverser = new MessageReverser("localhost",
				7005, this);
		MessageReader messageReader = new MessageReader("localhost", 7005, this);
		Socket socket = messageReader.connect("localhost", 7005);
		ObjectInputStream inputStream = new ObjectInputStream(
				socket.getInputStream());
		ObjectOutputStream outputStream = new ObjectOutputStream(
				socket.getOutputStream());
	}

	@Override
	public void userConected() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void conectionStatusChange(boolean conected) {
		// TODO Auto-generated method stub

	}

}
