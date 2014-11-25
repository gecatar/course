package com.sirma.itt.evgeni.comunication;

public interface Comunicator {

	public void startConection(Conector conector);

	public void stopConection();

	public void sendMesage(Mesage mesage);

	public void removeConector();

	public void addDataTransferator(DataTransferator transferator);
	
	public boolean removeDataTransferator(DataTransferator dataTransferator);

	public void processMesage(Mesage mesage, DataTransferator transferator);

}
