package com.sirma.itt.evgeni.client;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.ListModel;

import com.sirma.itt.evgeni.comunication.Window;

public class ListListener implements MouseListener {

	ConversationListener conversationListener;

	public ListListener(ConversationListener conversationListener) {
		this.conversationListener = conversationListener;
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			conversationListener.userSelected();
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
