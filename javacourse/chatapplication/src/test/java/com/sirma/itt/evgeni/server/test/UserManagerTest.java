package com.sirma.itt.evgeni.server.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sirma.itt.evgeni.comunication.DataTransferator;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.server.UserManager;

@RunWith(MockitoJUnitRunner.class)
public class UserManagerTest {

	@Mock
	DataTransferator transferator;

	/**
	 * Test correct registering on new user.
	 */
	@Test
	public void registerUserTestSecond() {
		UserManager userManager = new UserManager();
		userManager.registerUser("test", transferator);
		assertEquals("Users:\ntest", userManager.toString());
	}

	/**
	 * Test correct removing on user.
	 */
	@Test
	public void removeUserTest() {
		UserManager userManager = new UserManager();
		userManager.registerUser("test", transferator);
		userManager.removeUser(transferator);
		assertEquals("Users:", userManager.toString());
		Mockito.verify(transferator, Mockito.atLeast(1)).closeSocket();
	}

	/**
	 * Test sending on messages to user.
	 */
	@Test
	public void sendMessageToUserTest() {
		UserManager userManager = new UserManager();
		userManager.registerUser("test", transferator);
		userManager.sendMesageToUser("sender", "test", "message text");
		Mockito.verify(transferator, Mockito.atLeast(1)).sendData(
				Mockito.any(Mesage.class));
	}

	/**
	 * Check correct removing on all users.
	 */
	@Test
	public void removeUsersSessionsTest() {
		UserManager userManager = new UserManager();
		userManager.registerUser("test", transferator);
		userManager.registerUser("testSecond", transferator);
		userManager.removeUsersSessions();
		Mockito.verify(transferator, Mockito.atLeast(2)).closeSocket();
		assertEquals("Users:", userManager.toString());
	}
}
