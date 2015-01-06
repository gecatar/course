package com.sirma.itt.evgeni.task2;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JFileChooser;

import com.sirma.itt.evgeni.util.TransferObject;

/**
 * Download files from url. Update progress.
 * 
 * @author Evgeni Stefanov
 * 
 */
public class DownloadAgent extends Thread {

	private DownloadProgressListener progressUpdater;
	private String url;

	public DownloadAgent(DownloadProgressListener progressUpdater, String url) {
		this.progressUpdater = progressUpdater;
		this.url = url;
	}

	/**
	 * Prompt user to enter location on file.
	 */
	private File getFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showSaveDialog(fileChooser);
		return fileChooser.getSelectedFile();
	}

	/**
	 * Get input stream.
	 */
	private InputStream getInputStream(URLConnection conection)
			throws IOException {
		return conection.getInputStream();
	}

	/**
	 * Get connection.
	 */
	private URLConnection getConection(String url) throws IOException {
		return new URL(url).openConnection();
	}

	/**
	 * Get output stream.
	 */
	private OutputStream getOutputStream(File file)
			throws FileNotFoundException {
		return new BufferedOutputStream(new FileOutputStream(file));
	}

	/**
	 * Entry point for starting downloads.
	 * http://danutzayy.files.wordpress.com/2010/04/wallpaper-1080p-3.jpg
	 */
	@Override
	public void run() {
		downloadFile(url);
	}

	/**
	 * Download file.
	 */
	public boolean downloadFile(String res) {
		TransferObject transferator = null;
		try {
			URLConnection conection;
			conection = getConection(res);
			long size = conection.getContentLengthLong();
			progressUpdater.setFileSize(size);
			transferator = new TransferObject(getInputStream(conection),
					getOutputStream(getFile()));
			int readed = 0;
			long downloaded = 0;
			while (readed != -1) {
				downloaded += readed;
				readed = transferator.transfer(1000);
				int percentProgress = (int) (100 * downloaded / size);
				progressUpdater.setProgress(percentProgress);
				progressUpdater.setDownloadedSize(downloaded);
			}
			progressUpdater.setDownloadStatus(true);
			return true;
		} catch (IOException e) {
			progressUpdater.setDownloadStatus(false);
			return false;
		} finally {
			if (transferator != null) {
				transferator.close();
			}
		}

	}
}