package com.sirma.itt.evgeni.client.view;

public interface UserActionListener {

	public void sendMessage(String name, String message);

	public void userSelected(String name);

	public void startConection(String nickname, String ip, String port);

	public void stopConection();
}
