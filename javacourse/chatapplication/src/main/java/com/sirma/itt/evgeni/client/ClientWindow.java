package com.sirma.itt.evgeni.client;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sirma.itt.evgeni.comunication.Controler;
import com.sirma.itt.evgeni.comunication.Window;


public class ClientWindow extends JFrame implements ActionListener, Window {

	Controler controler;
	JTabbedPane staffPane = new JTabbedPane();
	JTabbedPane conversationPane = new JTabbedPane();
	JPanel comboPanel = new JPanel();
	JList userList;
	DefaultListModel listModel;
	Map<String, JTextArea> conversation = new HashMap<String, JTextArea>();
	JTextField ipAdress = new JTextField(15);
	JTextField port = new JTextField(4);
	JTextField nickname = new JTextField(10);
	JButton startConection = new JButton("Conect");
	JButton stopConection = new JButton("Disconect");
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public ClientWindow(Controler controler) {

		this.controler = controler;
		this.controler.setWindow(this);
		setSize(new Dimension(400, 500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(staffPane);
		// -----------------------------------
		startConection.addActionListener(this);
		stopConection.addActionListener(this);
		// -----------------------------------
		listModel = new DefaultListModel<String>();
		userList = new JList(listModel);
		userList.addMouseListener(new ListListener(userList, listModel, this));
		// ----------------------------------
		JLabel ipLabel = new JLabel("IP Adress");
		ipLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ipAdress.setMaximumSize(new Dimension(150, 20));
		ipAdress.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel portLabel = new JLabel("Port");
		portLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		port.setMaximumSize(new Dimension(80, 20));
		port.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel nicknameLabel = new JLabel("Nickname");
		nicknameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		nickname.setText("User");
		nickname.setMaximumSize(new Dimension(150, 20));
		nickname.setAlignmentX(CENTER_ALIGNMENT);
		startConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		stopConection.setAlignmentX(Component.CENTER_ALIGNMENT);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(ipLabel);
		ipAdress.setText("localhost");
		panel.add(ipAdress);
		panel.add(portLabel);
		panel.add(port);
		panel.add(nicknameLabel);
		panel.add(nickname);
		panel.add(startConection);
		panel.add(stopConection);
		staffPane.add("Conection", panel);
		staffPane.add("Users", userList);
		staffPane.add("Mesages", conversationPane);
		// ----------------------------------
		setVisible(true);

	}

	public void selectConversation(String name) {
		staffPane.setSelectedIndex(staffPane.indexOfTab("Mesages"));
		conversationPane.setSelectedIndex(conversationPane.indexOfTab(name));
	}

	public void displayMesage(String sender, String text) {
		if (conversation.containsKey(sender)) {
			conversation.get(sender).append(createMesage(sender, text));
			selectConversation(sender);
		} else {
			addConversation(sender);
			displayMesage(sender, text);
		}
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
	
	public void clearUserList(){
		listModel.clear();
	}
	
	public void setConectionStatus(boolean conected){
		if(conected==true){
			setTitle("Conected...");
		}else{
			setTitle("disconected...");
			clearUserList();
		}
	}

	public void addConversation(String name) {
		if (!conversation.containsKey(name)) {
			JTextArea textArea = new JTextArea();
			JTextField textFields = new JTextField();
			textFields.setName(name);
			textFields.addActionListener(this);
			textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
			textFields.setMaximumSize(new Dimension(250, 170));
			textFields.setAlignmentX(Component.CENTER_ALIGNMENT);
			textFields.setName(name);
			conversationPane.add(name, createPanel(textArea, textFields));
			conversation.put(name, textArea);
		}
	}

	private JPanel createPanel(JTextArea textArea, JTextField textFields) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JScrollPane scrollPanel = new JScrollPane(textArea);
		panel.add(scrollPanel);
		panel.add(textFields);
		return panel;
	}

	private String createMesage(String sender, String text) {
		StringBuilder stb = new StringBuilder();
		stb.append("<");
		stb.append(dateFormat.format(new Date()));
		stb.append("><");
		stb.append(sender);
		stb.append(">");
		stb.append(text);
		stb.append("\n");
		return stb.toString();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JTextField.class) {
			JTextField temp = (JTextField) e.getSource();
			if (conversation.containsKey(temp.getName())) {
				conversation.get(temp.getName()).append(
						createMesage("You", temp.getText()));
			}
			controler.sendMesage(new Mesage(nickname.getText(), temp.getName(),
					temp.getText()));
			temp.setText("");
		}
		if (e.getSource() == startConection) {
			controler.startConection(ipAdress.getText(), 7005,
					nickname.getText());
		}
		if (e.getSource() == stopConection) {
			controler.stopConection();
		}
	}

}
