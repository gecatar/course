package com.sirma.itt.evgeni.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

/**
 * List whit connected users.
 * 
 * @author GecaTM
 *
 */
public class UserList extends JList<String> implements MouseListener {

	private final DefaultListModel<String> listModel = new DefaultListModel<String>();

	public UserList() {
		setModel(listModel);
		addMouseListener(this);
		TitledBorder title = new TitledBorder("Users");
		setBorder(title);
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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("User List:");
		for (Object name : listModel.toArray()) {
			stringBuilder.append("->").append(name);
		}
		return stringBuilder.toString();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
		}
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
