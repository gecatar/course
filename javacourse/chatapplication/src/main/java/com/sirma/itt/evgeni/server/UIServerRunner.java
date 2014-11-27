package com.sirma.itt.evgeni.server;

public class UIServerRunner {

	public static void main(String[] args) {
		ServerControler serverControler = new ServerControler();
		new Server(serverControler);
		new ServerWindow(serverControler);
	}

}
