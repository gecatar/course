package com.sirma.itt.evgeni.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.Window;

public class ClientWindow extends Window implements ActionListener,
		MouseListener {

	private JTabbedPane mainPannel;
	private ConectionPanel conectionPanel;
	private ConversationPanel conversationPanel;
	private UserList userList;

	public ClientWindow() {
		setTitle("Client");
		mainPannel = new JTabbedPane();
		conectionPanel = new ConectionPanel(this);
		conversationPanel = new ConversationPanel(this);
		userList = new UserList(this);
		mainPannel.add("Conection", conectionPanel);
		mainPannel.add("Messages", conversationPanel);
		mainPannel.add("Users", userList);
		mainPannel.setVisible(true);
		add(mainPannel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JButton.class) {
			if (((JButton) e.getSource()).getName().equals("StartConection")) {
				listener.startConection(conectionPanel.getName(),
						conectionPanel.getIP(), conectionPanel.getPort());
			}
			if (((JButton) e.getSource()).getName().equals("StopConection")) {
				listener.stopConection();
			}
		}
		if (e.getSource().getClass() == JTextField.class) {

		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
