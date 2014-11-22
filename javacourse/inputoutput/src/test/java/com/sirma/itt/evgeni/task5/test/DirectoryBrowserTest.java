package com.sirma.itt.evgeni.task5.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task5.DirectoryBrowser;

public class DirectoryBrowserTest {

	DirectoryBrowser directoryBrowser;
	@Before
	public void setUp() throws Exception {
		directoryBrowser = new DirectoryBrowser();
	}

	/**
	 * Return value must correspond to numbers of files found.
	 * If there is no files result must be zero.
	 */
	@Test
	public void listFilesTest() {
		
		assertEquals(0,directoryBrowser.listContent("wwwdwd"));
	}

}
