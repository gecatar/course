package com.sirma.itt.evgeni.client;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.ListModel;

import com.sirma.itt.evgeni.comunication.Window;

public class ListListener implements MouseListener {

	Window window;
	JList userList;
	ListModel<String> listModel;

	public ListListener(JList userList, ListModel<String> listModel,
			Window window) {
		this.userList = userList;
		this.window = window;
		this.listModel = listModel;
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
		//	window.addConversation(listModel.getElementAt(userList.getSelectedIndex()));
		//	window.selectConversation(listModel.getElementAt(userList.getSelectedIndex()));
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
