package com.sirma.itt.evgeni.client.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.evgeni.client.UserList;

/**
 * Check correct adding and removing on users from list.
 * 
 * @author GecaTM
 *
 */
public class UserListTest {

	private UserList userList;

	@Before
	public void setUp() throws Exception {
		userList = new UserList(null);
	}

	/**
	 * Check correct adding on users.
	 */
	@Test
	public void addUserTest() {
		userList.addUser("test");
		assertEquals("User List:->test", userList.toString());
		userList.addUser("test");
		assertEquals("User List:->test", userList.toString());
		userList.addUser("proba");
		assertEquals("User List:->test->proba", userList.toString());
	}

	/**
	 * Check correct removing on users.
	 */
	@Test
	public void removeUserTest() {
		userList.addUser("test");
		userList.addUser("proba");
		userList.removeUser("test");
		assertEquals("User List:->proba", userList.toString());
	}

}
