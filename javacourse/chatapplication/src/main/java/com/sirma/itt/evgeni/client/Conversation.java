package com.sirma.itt.evgeni.client;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Manage sending and receiving messages.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Conversation extends JScrollPane implements ActionListener {

	private final JTextArea textArea;
	private final JTextField textField;
	private final DateFormat dateFormat;
	private final UserActionListener userActionListener;

	/**
	 * Create new conversation.
	 * 
	 * @param userActionListener
	 * @param name
	 */
	public Conversation(UserActionListener userActionListener, String name) {
		this.userActionListener = userActionListener;
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		verticalScrollBar = this.getVerticalScrollBar();
		this.setAutoscrolls(true);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		setName(name);
		textArea = new JTextArea();
		textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		textField = new JTextField();
		textField.setMaximumSize(new Dimension(250, 170));
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		textField.addActionListener(this);
		textArea.setEditable(false);
		panel.add(textArea);
		panel.add(textField);
		setViewportView(panel);
	}

	/**
	 * Create mesage.
	 * 
	 * @param name
	 * @param text
	 * @return
	 */
	public String createMessage(String name, String text) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<");
		stringBuilder.append(dateFormat.format(System.currentTimeMillis()));
		stringBuilder.append("><");
		stringBuilder.append(name);
		stringBuilder.append(">");
		stringBuilder.append(text);
		stringBuilder.append("\n");
		return stringBuilder.toString();
	}

	/**
	 * Write message to text area.
	 * 
	 * @param name
	 * @param text
	 */
	public void writeMesage(String name, String text) {
		textArea.setText(textArea.getText() + createMessage(name, text));
	}

	/**
	 * Detect when user send new message.
	 */
	public void actionPerformed(ActionEvent arg0) {
		userActionListener.sendMessage(getName(), textField.getText());
		writeMesage("You", textField.getText());
		textField.setText("");

	}
}
