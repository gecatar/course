package com.sirma.itt.evgeni.client;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.MessageLogger;

/**
 * Manage sending and receiving messages.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Conversation extends JPanel implements ActionListener,
		KeyListener, MouseListener {

	private static final String newLine = System.getProperty("line.separator");
	private final JTextArea textArea;
	private final JTextField textField;
	private final MessageLogger messageLogger;
	private final DateFormat dateFormat;
	private final ChatWindow window;

	/**
	 * Create new conversation.
	 */
	public Conversation(ChatWindow window, String name) {
		this.window = window;
		setName(name);
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		textArea = new JTextArea();
		textArea.addMouseListener(this);
		textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textField = new JTextField();
		textField.setName(name);
		textField.setAlignmentX(CENTER_ALIGNMENT);
		textField.setMaximumSize(new Dimension(250, 50));
		textField.addActionListener(this);
		textField.addKeyListener(this);
		textField.addMouseListener(this);
		textArea.setEditable(false);
		messageLogger = new MessageLogger();
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
		stringBuilder.append(newLine);
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
	public void actionPerformed(ActionEvent e) {
		messageLogger.logMessage(textField.getText());
		window.sendMessage(getName(), getTextFieldText());
		writeMesage("You", textField.getText());
		textField.setText("");
	}

	/**
	 * Action listener.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource().getClass() == JTextField.class) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				textField.setText(messageLogger.getNextMessage());
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				textField.setText(messageLogger.getPreviousMessage());
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		window.clearNotification(getName());
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

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}
}
