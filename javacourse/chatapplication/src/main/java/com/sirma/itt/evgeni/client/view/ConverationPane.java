package com.sirma.itt.evgeni.client.view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConverationPane extends JTabbedPane {

	public ConverationPane() {
		Conversation conversation = new Conversation();
		add("ijijoi", conversation);
		setVisible(true);
		for(int i = 0;i<70;i++){
			conversation.writeMesage();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conversation.writeMesage();
	}

	public void addConversation() {

	}

}
