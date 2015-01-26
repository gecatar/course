package com.sirma.itt.evgeni.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

/**
 * Create and select users conversations.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class ConversationPanel extends JTabbedPane implements ActionListener,
		MouseListener {

	private static final Icon userOnlineIcon = new ImageIcon(
			ConversationPanel.class.getResource("/user-green-icon.png"));
	private static final Icon userOflineIcon = new ImageIcon(
			ConversationPanel.class.getResource("/user-red-icon.png"));
	private static final Icon checkedMessageIcon = new ImageIcon(
			ConversationPanel.class.getResource("/mail-check-icon.png"));
	private static final Icon newMessageIcon = new ImageIcon(
			ConversationPanel.class.getResource("/mail-icon.png"));
	private final Map<String, Conversation> conversations = new HashMap<String, Conversation>();
	private final MessageNotifyer messageNotifyer = new MessageNotifyer("", "");

	public ConversationPanel() {
		addTab("Status", new StatusTab());
	}

	public void updateUserStatus(String name, boolean conected) {
		if (conversations.containsKey(name)) {
			Conversation conversation = conversations.get(name);
			conversation.setConected(conected);
			if (!messageNotifyer.hasNotifications(name)) {
				setConversationStatus(conversation, conected);
			}
		}
	}

	/**
	 * Close active conversation.
	 */
	public void closeActiveConversation() {
		Component temp = getComponent(getSelectedIndex());
		conversations.remove(temp.getName());
		remove(temp);
	}

	/**
	 * Close all conversations.
	 */
	public void closeAllConversation() {
		conversations.clear();
		removeAll();
	}

	/**
	 * Set status.
	 * 
	 * @param conversation
	 * @param conected
	 */
	private void setConversationStatus(Conversation conversation,
			boolean conected) {
		if (conected) {
			setIconAt(indexOfComponent(conversation), userOnlineIcon);
		} else {
			setIconAt(indexOfComponent(conversation), userOflineIcon);
		}
	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {
		Component component = (Component) mouseEvent.getSource();
		messageNotifyer.removeNotification(component.getName());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

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
