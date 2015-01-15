package com.sirma.itt.evgeni.client;

import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * List whit connected users.
 * 
 * @author GecaTM
 *
 */
public class UserList extends JList<String> {

	private DefaultListModel<String> listModel;

	public UserList(MouseListener mouseListener) {
		listModel = new DefaultListModel<String>();
		setModel(listModel);
		addMouseListener(mouseListener);
	}

	/**
	 * Add use.
	 */
	public void addUser(String name) {
		if (!listModel.contains(name)) {
			listModel.addElement(name);
		}
	}

	/**
	 * Remove user.
	 */
	public void removeUser(String name) {
		if (listModel.contains(name)) {
			listModel.removeElement(name);
		}
	}

	/**
	 * Get selected name.
	 * 
	 * @return
	 */
	public String getSelectedName() {
		return listModel.getElementAt(getSelectedIndex());
	}
}
