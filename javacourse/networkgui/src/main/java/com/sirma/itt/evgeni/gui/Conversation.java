package com.sirma.itt.evgeni.gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.MessageLogger;

/**
 * Manage sending and receiving messages.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class Conversation extends JSplitPane implements ActionListener,
		KeyListener, MouseListener {

	private static final DateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	private static final String newLine = System.getProperty("line.separator");
	private final MessageLogger messageLogger = new MessageLogger();
	private final View view;
	private final JTextArea textArea = new JTextArea();
	private final JTextField textField = new JTextField();
	private final Double dividerLocation = 0.85D;
	private boolean conected = false;

	/**
	 * Create new conversation.
	 */
	public Conversation(String name, View view) {
		setName(name);
		setOrientation(VERTICAL_SPLIT);
		this.view = view;
		textArea.setName(name);
		textArea.setEditable(false);
		textArea.addMouseListener(view);
		JScrollPane scrollTextArea = new JScrollPane(textArea);
		textField.setName(name);
		textField.addActionListener(this);
		textField.addKeyListener(this);
		textField.addActionListener(this);
		textField.addMouseListener(this);
		setTopComponent(scrollTextArea);
		setBottomComponent(textField);
	}

	public boolean isConected() {
		return conected;
	}

	public void setConected(boolean conected) {
		this.conected = conected;
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
		if (conected) {
			messageLogger.logMessage(textField.getText());
			writeMesage("You", textField.getText());
			textField.setText("");
		}
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
	public void paint(Graphics g) {
		setDividerLocation(dividerLocation);
		super.paint(g);
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

	@Override
	public void mouseEntered(MouseEvent arg0) {
		view.clearNotification(getName());
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
