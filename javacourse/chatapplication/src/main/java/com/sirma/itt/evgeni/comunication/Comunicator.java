package com.sirma.itt.evgeni.comunication;

public interface Comunicator {

	public void startConection(String ip, int port);

	public void stopConection();

	public void addUserSession(DataTransferator transferator);

	public void closeUserSession(DataTransferator transferator);

	public void closeConectorSession();

	public void setName(String name);

	public void processMesage(Mesage mesage, DataTransferator transferator);

	public void sendMesage(String name, String text);

}
