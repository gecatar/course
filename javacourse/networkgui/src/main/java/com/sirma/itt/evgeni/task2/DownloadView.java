package com.sirma.itt.evgeni.task2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class DownloadView extends JFrame implements ActionListener, DownloadProgressUpdater {

	JProgressBar downloadProgress = new JProgressBar();
	JTextField textField = new JTextField(20);
	JButton downloadFile = new JButton("Start Download");
	JPanel panel = new JPanel();
	JLabel percentValue = new JLabel("Progress in percent...");
	JLabel sizeDownload = new JLabel("Size and current download...");

	public DownloadView() {
		setSize(new Dimension(400, 500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		add(panel);
		// -----------------------------
		panel.add(textField);
		panel.add(downloadFile);
		panel.add(downloadProgress);
		panel.add(percentValue);
		panel.add(sizeDownload);
		// ------------------------------
		downloadProgress.setAlignmentX(CENTER_ALIGNMENT);
		downloadProgress.setMinimum(0);
		downloadProgress.setMaximum(100);
		downloadProgress.setValue(0);
		downloadProgress.setMaximumSize(new Dimension(200, 30));
		textField.setAlignmentX(CENTER_ALIGNMENT);
		textField.setMaximumSize(new Dimension(200, 30));
		downloadFile.addActionListener(this);
		downloadFile.setAlignmentX(CENTER_ALIGNMENT);
		downloadFile.setMaximumSize(new Dimension(200, 30));
		percentValue.setAlignmentX(CENTER_ALIGNMENT);
		percentValue.setMaximumSize(new Dimension(200, 30));
		sizeDownload.setAlignmentX(CENTER_ALIGNMENT);
		sizeDownload.setMaximumSize(new Dimension(200, 30));
		setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == downloadFile) {
			downloadProgress.setVisible(true);
			new DownloadAgent(this,textField.getText()).start();
		}
	}

	public void setProgress(int progress) {
		downloadProgress.setValue(progress);
	}

	public void setFileSize(long fileSize) {
	}

	public void setDownloadedSize(long downloadedSize) {
		// TODO Auto-generated method stub
		
	}


	public void setDownloadError(String error) {
		// TODO Auto-generated method stub
		
	}
}