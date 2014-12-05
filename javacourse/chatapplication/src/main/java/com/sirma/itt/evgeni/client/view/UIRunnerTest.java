package com.sirma.itt.evgeni.client.view;

import com.sirma.itt.evgeni.comunication.Comunicator;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.comunication.MesageCommand;
import com.sirma.itt.evgeni.util.ConsoleReader;

public class UIRunnerTest extends Thread implements UILIstener,
		ComunicatorListener {

	StaffPane staffPane;
	View view;
	Comunicator comunicator;

	public UIRunnerTest() {
		staffPane = new StaffPane(this);
		comunicator = new Client(this);
		view = new View(staffPane);
	}

	public static void main(String[] args) {
		new UIRunnerTest().start();
	}

	@Override
	public void run() {
		int choise = 0;
		while (choise != 9) {
			System.out.println("1)Add user");
			System.out.println("2)Remove user");
			System.out.println("3)Display message");
			System.out.println("4)User selected");
			System.out.println("-------------------");
			System.out.println("5)Comunicator-proccesMessage(Message message)");
			System.out.println("6)Comunicator-setName(String name)");
			choise = ConsoleReader.readInt();
			if (choise == 1) {
				System.out.println("Enter user name:");
				String name = ConsoleReader.readString();
				addUser(name);
			}
			if (choise == 2) {
				System.out.println("Enter user name:");
				String name = ConsoleReader.readString();
				removeUser(name);
			}
			if (choise == 3) {
				System.out.println("Enter user name:");
				String name = ConsoleReader.readString();
				System.out.println("Enter message:");
				String message = ConsoleReader.readString();
				showMesage(name, message);
			}
			if (choise == 4) {
				System.out.println("Enter name:");
				String name = ConsoleReader.readString();
				staffPane.userSelected(name);
			}
			if (choise == 5) {
				System.out.println("1)Add user message.");
				System.out.println("2)Remove user message.");
				System.out.println("3)Show message.");
				choise = ConsoleReader.readInt();
				if (choise == 1) {
					System.out.println("Enter name");
					String name = ConsoleReader.readString();
					comunicator.processMesage(new Mesage(name,
							MesageCommand.USER_CONECTED), null);
				}
				if (choise == 2) {
					System.out.println("Enter name");
					String name = ConsoleReader.readString();
					comunicator.processMesage(new Mesage(name,
							MesageCommand.USER_DISCONECTED), null);
				}
				if (choise == 3) {
					System.out.println("Enter sender");
					String sender = ConsoleReader.readString();
					System.out.println("Enter receiver");
					String receiver = ConsoleReader.readString();
					System.out.println("Enter text");
					String text = ConsoleReader.readString();
					comunicator.processMesage(
							new Mesage(sender, receiver, text), null);
				}
			}
			if (choise == 6) {
				System.out.println("Enter name:");
				String name = ConsoleReader.readString();
				comunicator.setName(name);
			}
		}

	}

	// UI
	public void startConection(String nickname, String ip, String port) {
		comunicator.setName(nickname);
		comunicator.startConection(ip, Integer.parseInt(port));
	}

	// UI
	public void stopConection() {
		comunicator.stopConection();
	}

	// UI
	public void sendMessage(String name, String message) {
		System.out.println("Send message:" + name + " Text:" + message);
	}

	// client
	public void setConectionStatus(boolean conected) {
		// TODO Auto-generated method stub
		view.setConectionStatus(conected);
	}

	// client
	public void showMesage(String name, String message) {
		// TODO Auto-generated method stub
		staffPane.displayMessage(name, message);
	}

	// client
	public void addUser(String name) {
		// TODO Auto-generated method stub
		staffPane.addUser(name);
	}

	// client
	public void removeUser(String name) {
		// TODO Auto-generated method stub
		staffPane.removeUser(name);
	}
}
