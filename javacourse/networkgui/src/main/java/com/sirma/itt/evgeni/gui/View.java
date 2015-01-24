package com.sirma.itt.evgeni.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import com.sirma.itt.evgeni.util.ConsoleReader;

public class View extends JFrame {

	public View(UserList userList, ConversationPanel panel) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(600, 300));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setLeftComponent(userList);
		splitPane.setRightComponent(panel);
		splitPane.setDividerSize(3);
		add(splitPane);
		setVisible(true);
		splitPane.setDividerLocation(0.3d);
	}

	public static void main(String[] args) {
		UserList userList = new UserList();
		ConversationPanel conversationPanel = new ConversationPanel();
		View view = new View(userList, conversationPanel);
		int choise = 0;
		while (choise != 9) {
			System.out.println("Enter choise:");
			System.out.println("1)Add user:");
			System.out.println("2)Remove user:");
			System.out.println("3)Add conversation:");
			System.out.println("4)Close active conversation:");
			choise = ConsoleReader.readInt();
			if (choise == 1) {
				System.out.println("Enter name:");
				userList.addUser(ConsoleReader.readString());
			}
			if (choise == 2) {
				System.out.println("Enter name:");
				userList.removeUser(ConsoleReader.readString());
			}
			if (choise == 3) {
				System.out.println("Enter name:");
				conversationPanel
						.selectConversation(ConsoleReader.readString());
			}
			if (choise == 4) {
				System.out.println("Enter name:");
				conversationPanel.closeActiveConversation();
			}
		}
	}
}
