package com.sirma.itt.evgeni.tas3.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.sirma.itt.evgeni.task3.ExceptionManager;

public class ExceptionManagerTest {

	@Test
	public void test() {
		ExceptionManager exmng = new ExceptionManager();
		exmng.addExceptionUsingCode("INVID");
		exmng.addExceptionUsingCode("INVPC");
		exmng.addExceptionUsingCode("INVDC");
		List<String> errors = exmng.getMesages();
		assertTrue(errors.get(0).equals("Invalid UID"));
		assertTrue(errors.get(1).equals("Invalid Post Code"));
		assertTrue(errors.get(2).equals("Invalid Debit Card Number"));
		exmng.addExceptionAndDescription("test", "test error");
		exmng.addExceptionUsingCode("test");
		errors = exmng.getMesages();
		assertTrue(errors.get(3).equals("test error"));
	}

}
