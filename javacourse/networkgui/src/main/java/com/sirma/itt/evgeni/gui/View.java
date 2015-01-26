package com.sirma.itt.evgeni.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;

import com.sirma.itt.evgeni.util.ConsoleReader;

public class View extends JFrame implements ComunicatorListener, ActionListener {

	private final Map<String, Conversation> conversations = new HashMap<String, Conversation>();
	private final MessageNotifyer messageNotifyer = new MessageNotifyer(
			"You have", "messages");
	private final ConectionDialog connectDialog = new ConectionDialog();
	private final ConversationPanel conversationPanel;
	private final UserList userList;
	private final JSplitPane splitPane = new JSplitPane();
	private final Double dividerLocation = 0.3D;

	public View(UserList userList, ConversationPanel panel) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(600, 300));
		conversationPanel = panel;
		this.userList = userList;
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu conversationMenu = new JMenu("Conversation");
		JMenuItem connectItem = new JMenuItem("Connect");
		JMenuItem closeActiveItem = new JMenuItem("Connect");
		JMenuItem closeAllItem = new JMenuItem("Connect");
		closeActiveItem.setText("hewfjwehfk");
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

	@Override
	public void addUser(String name) {
		userList.addUser(name);
		if (conversations.containsKey(name)) {
			Conversation conversation = conversations.get(name);
			conversation.setConected(true);
			if (!messageNotifyer.hasNotifications(name)) {
				conversationPanel.showOnlineIcon(conversation);
			}
		}
	}

	@Override
	public void removeUser(String name) {
		userList.removeUser(name);
		if (conversations.containsKey(name)) {
			Conversation conversation = conversations.get(name);
			conversation.setConected(false);
			if (!messageNotifyer.hasNotifications(name)) {
				conversationPanel.showOfflineIcon(conversation);
			}
		}
	}

	/**
	 * Display message. If conversation doesn't exist first its created.
	 */
	@Override
	public void showMesage(String name, String message) {
		if (conversations.containsKey(name)) {
			Conversation conversation = conversations.get(name);
			conversation.writeMesage(name, message);
			conversationPanel.showNewMessageIcon(conversation);
			messageNotifyer.addNotification(name);
		} else {
			addConversation(name);
			showMesage(name, message);
		}
	}

	/**
	 * Notify user that his message is seen.
	 * 
	 * @param name
	 */
	public void showMessageReadedNotification(String name) {
		if (conversations.containsKey(name)) {
			conversationPanel.showCheckedMessageIcon(conversations.get(name));
		}
	}

	/**
	 * Select conversation.
	 */
	public void showConversation(String name) {
		if (!conversations.containsKey(name)) {
			addConversation(name);
			showConversation(name);
		} else {
			conversationPanel.setSelectedComponent(conversations.get(name));
		}
	}

	/**
	 * Clear notifications.
	 * 
	 * @param name
	 */
	public void clearNotification(String name) {
		if (conversations.containsKey(name)) {
			Conversation conversation = conversations.get(name);
			messageNotifyer.removeNotification(name);
			conversationPanel.showConectionStatusIcon(conversation);
		}
	}

	/**
	 * Add new Conversation.
	 */
	private void addConversation(String name) {
		if (!conversations.containsKey(name)) {
			Conversation conversation = new Conversation(name, this);
			if (userList.contains(name)) {
				conversation.setConected(true);
			}
			conversations.put(name, conversation);
			conversationPanel.addTab(name, conversation);
			conversationPanel.showConectionStatusIcon(conversation);
		}
	}

	@Override
	public void setConectionStatus(MesageCommand status) {

	}

	/**
	 * Close active conversation.
	 */
	public void closeActiveConversation() {
		Component temp = conversationPanel.getComponent(conversationPanel
				.getSelectedIndex());
		if (conversations.containsValue(temp)) {
			conversations.remove(temp.getName());
			conversationPanel.remove(temp);
		}
	}

	@Override
	public void paint(Graphics arg0) {
		splitPane.setDividerLocation(0.2D);
		super.paint(arg0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			JMenuItem menuItem = (JMenuItem) e.getSource();

		}
		connectDialog.setLocationRelativeTo(this);
		connectDialog.setVisible(true);
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
			System.out.println("6)Change status:");
			System.out.println("7)Show seen notification:");
			choise = ConsoleReader.readInt();
			if (choise == 1) {
				System.out.println("Enter name:");
				view.addUser(ConsoleReader.readString());
			}
			if (choise == 2) {
				System.out.println("Enter name:");
				view.removeUser(ConsoleReader.readString());
			}
			if (choise == 3) {
				System.out.println("Enter name:");
				view.showConversation(ConsoleReader.readString());
			}
			if (choise == 4) {
				System.out.println("Enter name:");
				view.closeActiveConversation();
			}
			if (choise == 5) {
				System.out.println("Enter name:");
				String name = ConsoleReader.readString();
				System.out.println("Enter text:");
				String text = ConsoleReader.readString();
				view.showMesage(name, text);
			}
			if (choise == 6) {
				System.out.println("Enter name:");
				String name = ConsoleReader.readString();
				choise = ConsoleReader.readInt();
				if (choise == 1) {
				} else {
				}
			}
			if (choise == 7) {
				System.out.println("Enter name:");
				String name = ConsoleReader.readString();
				view.showMessageReadedNotification(name);
			}
		}
	}
}
