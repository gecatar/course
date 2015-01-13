package com.sirma.itt.evgeni.task2;

/**
 * Allow listening for download events triggered from download agent.
 * 
 * @author GecaTM
 *
 */
public interface DownloadProgressListener {

	/**
	 * Set progress.
	 */
	public void setProgress(int progress);

	/**
	 * Set file size.
	 */
	public void setFileSize(long fileSize);

	/**
	 * Set current download size.
	 */
	public void setDownloadedSize(long downloadedSize);

	/**
	 * Set download status.
	 */
	public void setDownloadStatus(boolean compleeted);
}
