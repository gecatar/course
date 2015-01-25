package com.sirma.itt.evgeni.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;

import com.sirma.itt.evgeni.util.ConsoleReader;

public class View extends JFrame implements ActionListener {

	private final ConectionDialog connectDialog = new ConectionDialog();
	private final JSplitPane splitPane = new JSplitPane();
	private final Double dividerLocation = 0.3D;

	public View(UserList userList, ConversationPanel panel) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(600, 300));
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu conversationMenu = new JMenu("Conversation");
		JMenuItem connectItem = new JMenuItem("Connect");
		JMenuItem closeActiveItem = new JMenuItem("Connect");
		JMenuItem closeAllItem = new JMenuItem("Connect");
		connectItem.addActionListener(this);
		closeActiveItem.addActionListener(this);
		closeAllItem.addActionListener(this);
		fileMenu.add(connectItem);
		conversationMenu.add(closeActiveItem);
		conversationMenu.add(closeAllItem);
		menuBar.add(fileMenu);
		menuBar.add(conversationMenu);
		setJMenuBar(menuBar);
		splitPane.setLeftComponent(userList);
		splitPane.setRightComponent(panel);
		splitPane.setDividerSize(3);
		add(splitPane);
		setVisible(true);
		splitPane.setDividerLocation(dividerLocation);
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
			System.out.println("5)Show message:");
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
				conversationPanel.showConversation(ConsoleReader.readString());
			}
			if (choise == 4) {
				System.out.println("Enter name:");
				conversationPanel.closeActiveConversation();
			}
			if (choise == 5) {
				System.out.println("Enter name:");
				String name = ConsoleReader.readString();
				System.out.println("Enter text:");
				String text = ConsoleReader.readString();
				conversationPanel.showMessage(name, text);
			}
		}
	}

	@Override
	public void paint(Graphics arg0) {
		splitPane.setDividerLocation(0.2D);
		super.paint(arg0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		connectDialog.setLocationRelativeTo(this);
		connectDialog.setVisible(true);
	}
}
