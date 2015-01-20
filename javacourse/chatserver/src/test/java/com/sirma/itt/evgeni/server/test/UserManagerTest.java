package com.sirma.itt.evgeni.server.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sirma.itt.evgeni.comunication.DataTransferer;
import com.sirma.itt.evgeni.comunication.Mesage;
import com.sirma.itt.evgeni.server.UserManager;

@RunWith(MockitoJUnitRunner.class)
public class UserManagerTest {

	@Mock
	DataTransferer transferer;

	/**
	 * Test correct registering on new user.
	 */
	@Test
	public void registerUserTestSecond() {
		UserManager userManager = new UserManager();
		userManager.registerUser("test", transferer);
		assertEquals("Users:\ntest", userManager.toString());
	}

	/**
	 * Test correct removing on user.
	 */
	@Test
	public void removeUserTest() {
		UserManager userManager = new UserManager();
		userManager.registerUser("test", transferer);
		userManager.removeUser(transferer);
		assertEquals("Users:", userManager.toString());
		Mockito.verify(transferer, Mockito.atLeast(1)).closeSocket();
	}

	/**
	 * Test sending on messages to user.
	 */
	@Test
	public void sendMessageToUserTest() {
		UserManager userManager = new UserManager();
		userManager.registerUser("test", transferer);
		userManager.sendMesageToUser("sender", "test", "message text");
		Mockito.verify(transferer, Mockito.atLeast(1)).sendData(
				Mockito.any(Mesage.class));
	}

	/**
	 * Check correct removing on all users.
	 */
	@Test
	public void removeUsersSessionsTest() {
		UserManager userManager = new UserManager();
		userManager.registerUser("test", transferer);
		userManager.registerUser("testSecond", transferer);
		userManager.removeUsersSessions();
		Mockito.verify(transferer, Mockito.atLeast(2)).closeSocket();
		assertEquals("Users:", userManager.toString());
	}
}
