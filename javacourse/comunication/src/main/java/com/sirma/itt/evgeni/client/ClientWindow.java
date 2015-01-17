package com.sirma.itt.evgeni.client;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;

import javax.swing.JTabbedPane;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;
import com.sirma.itt.evgeni.comunication.MesageCommand;
import com.sirma.itt.evgeni.comunication.Window;

/**
 * Client interface.
 * 
 * @author GecaTM
 *
 */
public class ClientWindow extends Window {

	private JTabbedPane mainPannel;
	private ConectionPanel conectionPanel;
	private ConversationPanel conversationPanel;
	private UserList userList;
	private MessageNotifyer notifyer;
	private String USER_CONECTED_MESSAGE;
	private String USER_DISCONECTED_MESSAGE;
	private String USERNAME_BISY_MESSAGE;
	private ResourceBundle bundle;

	public ClientWindow(ComunicatorApp listener) {
		super(listener);
		bundle = ResourceBundle.getBundle("test");
		setTitle(bundle.getString("client_title"));
		USER_CONECTED_MESSAGE = bundle.getString("user_conected_message");
		USER_DISCONECTED_MESSAGE = bundle.getString("user_disconected_message");
		USERNAME_BISY_MESSAGE = bundle.getString("username_bisy_message");
		mainPannel = new JTabbedPane();
		conectionPanel = new ConectionPanel(listener, bundle);
		conversationPanel = new ConversationPanel(listener);
		userList = new UserList(this);
		notifyer = new MessageNotifyer(this);
		mainPannel.add(bundle.getString("conection_tab_name"), conectionPanel);
		mainPannel
				.add(bundle.getString("messages_tab_name"), conversationPanel);
		mainPannel.add(bundle.getString("user_tab_name"), userList);
		mainPannel.setVisible(true);
		add(mainPannel);
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
	 * Change connection status.
	 */
	@Override
	public void setConectionStatus(MesageCommand status) {
		if (status == MesageCommand.USER_CONECTED) {
			mainPannel.setSelectedComponent(conectionPanel);
			conectionPanel.setConectionStatus(USER_CONECTED_MESSAGE);
		}
		if (status == MesageCommand.USER_DISCONECTED) {
			mainPannel.setSelectedComponent(conectionPanel);
			conectionPanel.setConectionStatus(USER_DISCONECTED_MESSAGE);
		}
		if (status == MesageCommand.INVALID_USER_NAME) {
			mainPannel.setSelectedComponent(conectionPanel);
			conectionPanel.setConectionStatus(USERNAME_BISY_MESSAGE);
		}
	}

	/**
	 * Show message.
	 */
	@Override
	public void showMesage(String name, String text) {
		mainPannel.setSelectedComponent(conversationPanel);
		conversationPanel.showMessage(name, text);
		notifyer.addNotification(name);
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
	 * Get message box text.
	 */
	@Override
	public String getMessageText(String name) {
		return conversationPanel.getMessageText(name);
	}

	/**
	 * When user is selected.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			mainPannel.setSelectedComponent(conversationPanel);
			conversationPanel.selectConversation(userList.getSelectedName());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
