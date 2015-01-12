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
public class Conversation extends JPanel implements ActionListener {

	private final JTextArea textArea;
	private final JTextField textField;
	private final DateFormat dateFormat;
	private final ActionListener listener;

	/**
	 * Create new conversation.
	 */
	public Conversation(ActionListener listener, String name) {
		this.listener = listener;
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setName(name);
		textArea = new JTextArea();
		textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textField = new JTextField();
		textField.setAlignmentX(CENTER_ALIGNMENT);
		textField.setMaximumSize(new Dimension(250, 50));
		textField.addActionListener(this);
		textArea.setEditable(false);
		add(scrollPane);
		add(textField);
	}

	/**
	 * Create message.
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

	public String getTextFieldText() {
		return textField.getText();
	}

	/**
	 * Write message to text area.
	 */
	public void writeMesage(String name, String text) {
		textArea.setText(textArea.getText() + createMessage(name, text));
	}

	/**
	 * Detect when user send new message.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		writeMesage("You", textField.getText());
		textField.setText("");

	}
}
