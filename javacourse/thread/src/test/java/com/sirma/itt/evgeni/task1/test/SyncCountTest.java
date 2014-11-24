package com.sirma.itt.evgeni.task1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.task4.SyncCount;
import com.sirma.itt.evgeni.task4.Synchronizator;

public class SyncCountTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void runTest() {
		Synchronizator synchronizator = new Synchronizator();
		SyncCount syncCount = new SyncCount(3, true);
		
	}

}
