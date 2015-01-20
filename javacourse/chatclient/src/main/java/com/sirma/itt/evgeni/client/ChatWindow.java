package com.sirma.itt.evgeni.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import com.sirma.itt.evgeni.comunication.ComponentID;
import com.sirma.itt.evgeni.comunication.MesageCommand;
import com.sirma.itt.evgeni.comunication.Window;

/**
 * Display all UI components.
 * 
 * @author GecaTM
 *
 */
public class ChatWindow extends Window implements ActionListener {

	private final ClientApp listener;
	private final JTabbedPane tabbedPane = new JTabbedPane();
	private final ConectionPanel conectionPanel;
	private final ConversationPanel conversationPanel;
	private final UserList userList;
	private final MessageNotifyer notifyer;
	private final ResourceBundle bundle;
	private final String USER_CONECTED_MESSAGE;
	private final String USER_DISCONECTED_MESSAGE;
	private final String USERNAME_BISY_MESSAGE;
	private final String CONECTING_MESSAGE;

	/**
	 * Create window.
	 */
	public ChatWindow(ClientApp listener) {
		this.listener = listener;
		bundle = ResourceBundle.getBundle("BG_LANG");
		setTitle(bundle.getString("client_title"));
		USER_CONECTED_MESSAGE = bundle.getString("user_conected_message");
		USER_DISCONECTED_MESSAGE = bundle.getString("user_disconected_message");
		USERNAME_BISY_MESSAGE = bundle.getString("username_bisy_message");
		CONECTING_MESSAGE = bundle.getString("comunicator_conecting_message");
		JMenuBar conversationBar = new JMenuBar();
		JMenu conversationMenu = new JMenu(
				bundle.getString("conversation_menu_name"));
		JMenuItem closeActiveConversation = new JMenuItem(
				bundle.getString("close_active_menu_name"));
		closeActiveConversation.setName(ComponentID.CLOSE_ACTIVE_MENU_ITEM);
		closeActiveConversation.addActionListener(this);
		JMenuItem closeAllConversation = new JMenuItem(
				bundle.getString("close_all_menu_name"));
		closeAllConversation.setName(ComponentID.CLOSE_ALL_MENU_ITEM);
		closeAllConversation.addActionListener(this);
		conversationMenu.add(closeActiveConversation);
		conversationMenu.add(closeAllConversation);
		conversationBar.add(conversationMenu);
		setJMenuBar(conversationBar);
		conectionPanel = new ConectionPanel(listener, bundle);
		conversationPanel = new ConversationPanel(this);
		userList = new UserList(this);
		notifyer = new MessageNotifyer(bundle.getString("you_have_message"),
				bundle.getString("message_message"));
		tabbedPane.add(bundle.getString("conection_tab_name"), conectionPanel);
		tabbedPane
				.add(bundle.getString("messages_tab_name"), conversationPanel);
		tabbedPane.add(bundle.getString("user_tab_name"), userList);
		add(tabbedPane);
		setVisible(true);
	}

	@Override
	public String getName() {
		return conectionPanel.getName();
	}

	@Override
	public String getIPField() {
		return conectionPanel.getIP();
	}

	@Override
	public int getPort() {
		return conectionPanel.getPort();
	}

	/**
	 * Show conversation.
	 */
	public void showConversation(String name) {
		tabbedPane.setSelectedComponent(conversationPanel);
		conversationPanel.selectConversation(name);
	}

	/**
	 * Clear notification.
	 */
	public void clearNotification(String name) {
		notifyer.removeNotification(name);
		setTitle(notifyer.getNotificationText());
	}

	/**
	 * Send message.
	 */
	public void sendMessage(String receiver, String text) {
		listener.sendMessage(receiver, text);
	}

	/**
	 * Change connection status.
	 */
	@Override
	public void setConectionStatus(MesageCommand status) {
		if (status == MesageCommand.USER_CONECTED) {
			tabbedPane.setSelectedComponent(conectionPanel);
			conectionPanel.setConectionStatus(USER_CONECTED_MESSAGE);
		}
		if (status == MesageCommand.COMUNICATOR_CONECTING) {
			tabbedPane.setSelectedComponent(conectionPanel);
			conectionPanel.setConectionStatus(CONECTING_MESSAGE);
		}
		if (status == MesageCommand.COMUNICATOR_DISCONECTED) {
			tabbedPane.setSelectedComponent(conectionPanel);
			conectionPanel.setConectionStatus(USER_DISCONECTED_MESSAGE);
		}
		if (status == MesageCommand.INVALID_USER_NAME) {
			tabbedPane.setSelectedComponent(conectionPanel);
			conectionPanel.setConectionStatus(USERNAME_BISY_MESSAGE);
		}
	}

	/**
	 * Show message.
	 */
	@Override
	public void showMesage(String name, String text) {
		notifyer.addNotification(name);
		setTitle(notifyer.getNotificationText());
		tabbedPane.setSelectedComponent(conversationPanel);
		conversationPanel.showMessage(name, text);
	}

	/**
	 * Add user.
	 */
	@Override
	public void addUser(String name) {
		userList.addUser(name);
	}

	/**
	 * Remove user.
	 */
	@Override
	public void removeUser(String name) {
		userList.removeUser(name);
	}

	/**
	 * When menu items are clicked.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			JMenuItem temp = (JMenuItem) e.getSource();
			if (temp.getName().equals(ComponentID.CLOSE_ACTIVE_MENU_ITEM)) {
				conversationPanel.closeActiveConversation();
			}
			if (temp.getName().equals(ComponentID.CLOSE_ALL_MENU_ITEM)) {
				conversationPanel.closeAllConversation();
			}
		}
	}
}
