package com.sirma.itt.evgeni.task2;

public interface DownloadProgressListener {

	public void setProgress(int progress);
	public void setFileSize(long fileSize);
	public void setDownloadedSize(long downloadedSize);
	public void setDownloadError(String error);
}
