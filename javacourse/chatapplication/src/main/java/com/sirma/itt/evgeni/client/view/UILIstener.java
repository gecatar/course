package com.sirma.itt.evgeni.client.view;

public interface UILIstener {

	public void startConection(String nickname, String ip, String port);

	public void stopConection();

	public void sendMessage(String name, String message);
}
