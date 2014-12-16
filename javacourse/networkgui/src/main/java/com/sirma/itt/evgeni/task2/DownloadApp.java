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

/**
 * Show progress on downloads.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class DownloadApp extends JFrame implements ActionListener,
		DownloadProgressListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JProgressBar downloadProgress = new JProgressBar();
	private final JTextField textField = new JTextField(20);
	private final JButton downloadFile = new JButton("Start Download");
	private final JPanel panel = new JPanel();
	private final JLabel percentValue = new JLabel("Progress in percent...");
	private final JLabel size = new JLabel("Size");
	private final JLabel downloadded = new JLabel("Downloaded size");

	public DownloadApp() {
		setSize(new Dimension(400, 500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		add(panel);
		// -----------------------------
		panel.add(textField);
		panel.add(downloadFile);
		panel.add(downloadProgress);
		panel.add(percentValue);
		panel.add(size);
		panel.add(downloadded);
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
		size.setAlignmentX(CENTER_ALIGNMENT);
		size.setMaximumSize(new Dimension(200, 30));
		downloadded.setAlignmentX(CENTER_ALIGNMENT);
		downloadded.setMaximumSize(new Dimension(200, 30));
		setVisible(true);
	}

	/**
	 * Triggered when user click start download button.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == downloadFile) {
			downloadProgress.setVisible(true);
			new DownloadAgent(this, textField.getText()).start();
		}
	}

	/**
	 * Set progress in percent.
	 */
	@Override
	public void setProgress(int progress) {
		downloadProgress.setValue(progress);
	}

	/**
	 * Set file size.
	 */
	@Override
	public void setFileSize(long fileSize) {
		size.setText(String.valueOf(fileSize));
	}

	/**
	 * Set how much bytes are transfered.
	 */
	@Override
	public void setDownloadedSize(long downloadedSize) {
		// TODO Auto-generated method stub
		downloadded.setText(String.valueOf(downloadedSize));
	}

	/**
	 * Display what error are occurred during download.
	 */
	@Override
	public void setDownloadError(String error) {
		// TODO Auto-generated method stub

	}

	// Runner-------------------------------------------
	public static void main(String[] args) {
		DownloadApp downloadApp = new DownloadApp();
	}
	// -------------------------------------------------
}