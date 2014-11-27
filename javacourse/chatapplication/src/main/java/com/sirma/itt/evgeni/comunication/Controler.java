package com.sirma.itt.evgeni.comunication;

public interface Controler {

	public void setComunicator(Comunicator comunicator);

	public void setWindow(Window window);

	public void startConection(String ip, String port);

	public void stopConection();

	public void setConectionStatus(boolean conected);

	public void addUser(String name);

	public void removeUser(String name);

	public void sendMesage(String sender, String receiver, String text);

	public void showMesage(String sender, String text);
	
	public void setName(String name);

}
