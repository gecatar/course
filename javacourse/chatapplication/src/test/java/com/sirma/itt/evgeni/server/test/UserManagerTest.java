package com.sirma.itt.evgeni.server.test;

import static org.junit.Assert.assertEquals;

import java.io.ObjectOutputStream;

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
	@Mock
	ObjectOutputStream ost;

	@Test
	public void registerUserTest() {
		UserManager userManager = new UserManager();
		Mockito.when(transferator.sendData(Mockito.any(Mesage.class)))
				.thenReturn(true);
		Mockito.verify(transferator, Mockito.times(0)).sendData(
				Mockito.any(Mesage.class));
		userManager.registerUser("test", transferator);
		assertEquals("Users:\ntest", userManager.toString());
	}

}
