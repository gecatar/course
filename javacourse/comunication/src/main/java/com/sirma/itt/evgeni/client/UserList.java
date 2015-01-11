package com.sirma.itt.evgeni.client;

import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class UserList extends JList<String> {

	private DefaultListModel<String> listModel;

	public UserList(MouseListener mouseListener) {
		listModel = new DefaultListModel<String>();
		setModel(listModel);
		addMouseListener(mouseListener);
	}

	public void addUser(String name) {
		if (!listModel.contains(name)) {
			listModel.addElement(name);
		}
	}

	public void removeUser(String name) {
		if (listModel.contains(name)) {
			listModel.removeElement(name);
		}
	}
}
