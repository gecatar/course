package com.sirma.itt.evgeni.client;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class UserList extends JList<String> implements MouseListener {

	DefaultListModel<String> listModel;
	UserActionListener userListener;

	public UserList(UserActionListener userListener) {
		this.userListener = userListener;
		listModel = new DefaultListModel<String>();
		setModel(listModel);
		addMouseListener(this);
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

	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			userListener.userSelected(listModel
					.getElementAt(getSelectedIndex()));
		}
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
