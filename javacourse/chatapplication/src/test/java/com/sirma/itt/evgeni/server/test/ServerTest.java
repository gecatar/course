package com.sirma.itt.evgeni.server.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.comunication.DataTransferator;
import com.sirma.itt.evgeni.server.Server;

public class ServerTest {

	Server server;

	@Before
	public void setUp() throws Exception {
		server = new Server(null);
	}

	@Test
	public void addAndRemoveUserFromMapTest() {
		DataTransferator transferator = new DataTransferator(null, null, null,
				null);
		Assert.assertFalse(server.removeUserFromMap("test"));
		Assert.assertTrue(server.addUserInMap("test", transferator));
		Assert.assertFalse(server.addUserInMap("test", transferator));
		Assert.assertTrue(server.removeUserFromMap("test"));
	}

	@Test
	public void notifyForNewUserTest() {

	}

	@Test
	public void notifyForUserLeavingTest() {

	}

	@Test
	public void sendUserListTest() {

	}

	@Test
	public void registerUserTest() {

	}

	@Test
	public void notifyForBadNameTest() {

	}

	@Test
	public void getUserNameTest() {
	}

}
