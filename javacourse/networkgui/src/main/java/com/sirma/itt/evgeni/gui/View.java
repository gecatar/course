package com.sirma.itt.evgeni.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;

import com.sirma.itt.evgeni.util.ConsoleReader;

public class View extends JFrame implements ComunicatorListener, ActionListener {

	private final Map<String, Conversation> conversations = new HashMap<String, Conversation>();
	private final UserList userList = new UserList(this);
	private final ConversationPanel conversationPanel = new ConversationPanel();
	private final MessageNotifyer messageNotifyer = new MessageNotifyer();
	private final StatusTab statusTab = new StatusTab();
	private final JMenuBar menuBar = new JMenuBar();
	private final JSplitPane splitPane = new JSplitPane();
	private final String defaultLanguegeId = "BG_LANG";
	private final Dimension defaultViewDimension = new Dimension(600, 300);
	private final Double dividerLocation = 0.3D;
	private final JMenu fileMenu = new JMenu();
	private final JMenuItem connectItem = new JMenuItem();
	private final JMenu conversationMenu = new JMenu();
	private final JMenuItem closeActiveItem = new JMenuItem();
	private final JMenu languegeMenu = new JMenu();
	private String USER_CONECTED_MESSAGE;
	private String USER_DISCONECTED_MESSAGE;
	private String USERNAME_BISY_MESSAGE;
	private String CONECTING_MESSAGE;
	private ConectionDialog connectDialog;

	public View() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(defaultViewDimension);
		splitPane.setLeftComponent(userList);
		splitPane.setRightComponent(conversationPanel);
		splitPane.setDividerSize(3);
		add(splitPane);
		setVisible(true);
		ResourceBundle bundle = ResourceBundle.getBundle(defaultLanguegeId);
		splitPane.setDividerLocation(dividerLocation);
		fileMenu.setName(ComponentID.FILE_MENU_ID);
		connectItem.setName(ComponentID.CONNECT_MENU_ITEM_ID);
		fileMenu.add(connectItem);
		connectItem.addActionListener(this);
		conversationMenu.setName(ComponentID.CONVERSATION_MENU_ID);
		closeActiveItem.setName(ComponentID.CLOSE_ACTIVE_MENU_ITEM_ID);
		closeActiveItem.addActionListener(this);
		conversationMenu.add(closeActiveItem);
		languegeMenu.setName(ComponentID.LANGUEGE_MENU_ID);
		JMenuItem bgLanguege = new JMenuItem(
				bundle.getString(ComponentID.BG_LANGUEGE_ID));
		bgLanguege.setName(ComponentID.BG_LANGUEGE_ID);
		JMenuItem enLanguege = new JMenuItem(
				bundle.getString(ComponentID.EN_LANGUEGE_ID));
		enLanguege.setName(ComponentID.EN_LANGUEGE_ID);
		languegeMenu.add(bgLanguege);
		languegeMenu.add(enLanguege);
		menuBar.add(fileMenu);
		menuBar.add(conversationMenu);
		menuBar.add(languegeMenu);
		setJMenuBar(menuBar);
		initialize(bundle);
	}

	private void initialize(ResourceBundle bundle) {
		fileMenu.setText(bundle.getString(ComponentID.FILE_MENU_ID));
		connectItem.setText(bundle.getString(ComponentID.CONNECT_MENU_ITEM_ID));
		conversationMenu.setText(bundle
				.getString(ComponentID.CONVERSATION_MENU_ID));
		closeActiveItem.setText(bundle
				.getString(ComponentID.CLOSE_ACTIVE_MENU_ITEM_ID));
		languegeMenu.setText(bundle.getString(ComponentID.LANGUEGE_MENU_ID));
		USER_CONECTED_MESSAGE = bundle.getString("user_conected_message");
		USER_DISCONECTED_MESSAGE = bundle.getString("user_disconected_message");
		USERNAME_BISY_MESSAGE = bundle.getString("username_bisy_message");
		CONECTING_MESSAGE = bundle.getString("comunicator_conecting_message");
		conversationPanel.setLocalDetails(bundle, statusTab);
		userList.setLocalDetails(bundle);
		connectDialog = new ConectionDialog(bundle);
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
			setTitle(messageNotifyer.getNotificationText());
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
			conversationPanel.showConectionStatusIcon(conversation);
			messageNotifyer.removeNotification(name);
			setTitle(messageNotifyer.getNotificationText());
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

	/**
	 * Change connection status.
	 */
	@Override
	public void setConectionStatus(MesageCommand status) {
		if (status == MesageCommand.USER_CONECTED) {
			connectDialog.setConectionStatus(USER_CONECTED_MESSAGE);
			statusTab.setConectionStatus(USER_CONECTED_MESSAGE);
		}
		if (status == MesageCommand.COMUNICATOR_CONECTING) {
			connectDialog.setConectionStatus(CONECTING_MESSAGE);
			statusTab.setConectionStatus(CONECTING_MESSAGE);
		}
		if (status == MesageCommand.COMUNICATOR_DISCONECTED) {
			connectDialog.setConectionStatus(USER_DISCONECTED_MESSAGE);
			statusTab.setConectionStatus(USER_DISCONECTED_MESSAGE);
		}
		if (status == MesageCommand.INVALID_USER_NAME) {
			connectDialog.setConectionStatus(USERNAME_BISY_MESSAGE);
			statusTab.setConectionStatus(USERNAME_BISY_MESSAGE);
		}
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
		View view = new View();
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
