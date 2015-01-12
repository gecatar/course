package com.sirma.itt.evgeni.client;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;

import javax.swing.JTabbedPane;

import com.sirma.itt.evgeni.comunication.ComunicatorApp;
import com.sirma.itt.evgeni.comunication.MesageCommand;
import com.sirma.itt.evgeni.comunication.Window;

public class ClientWindow extends Window {

	private JTabbedPane mainPannel;
	private ConectionPanel conectionPanel;
	private ConversationPanel conversationPanel;
	private UserList userList;
	private ResourceBundle bundle = ResourceBundle.getBundle("test");

	public ClientWindow(ComunicatorApp listener) {
		super(listener);
		setTitle(bundle.getString("client_title"));
		mainPannel = new JTabbedPane();
		conectionPanel = new ConectionPanel(listener, bundle);
		conversationPanel = new ConversationPanel(listener);
		userList = new UserList(this);
		mainPannel.add(bundle.getString("conection_tab"), conectionPanel);
		mainPannel.add(bundle.getString("messages_tab"), conversationPanel);
		mainPannel.add(bundle.getString("user_tab"), userList);
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

	@Override
	public void setConectionStatus(MesageCommand status) {
		if (status == MesageCommand.USER_CONECTED) {
			mainPannel.setSelectedComponent(conectionPanel);
			conectionPanel.setConectionStatus("conected");
		}
		if (status == MesageCommand.USER_DISCONECTED) {
			mainPannel.setSelectedComponent(conectionPanel);
			conectionPanel.setConectionStatus("Disconected");
		}
	}

	@Override
	public void showMesage(String name, String text) {
		mainPannel.setSelectedComponent(conversationPanel);
		conversationPanel.showMessage(name, text);
	}

	@Override
	public void addUser(String name) {
		userList.addUser(name);
	}

	@Override
	public void removeUser(String name) {
		userList.removeUser(name);
	}

	@Override
	public String getMessageText(String name) {
		return conversationPanel.getMessageText(name);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

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
}
