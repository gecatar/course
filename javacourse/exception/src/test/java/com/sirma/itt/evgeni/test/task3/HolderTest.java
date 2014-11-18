package com.sirma.itt.evgeni.test.task3;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.evgeni.task3.Holder;

/**
 * Add and remove objects.
 * @author Evgeni Stefanov
 *
 */
public class HolderTest {

	@Test
	public void test() {
		Holder holder = new Holder(2);
		assertFalse(holder.remove());
		assertTrue(holder.addElement("test"));
		assertTrue(holder.addElement("test"));
		assertFalse(holder.addElement("test"));
		assertTrue(holder.remove());
		assertTrue(holder.remove());
		assertFalse(holder.remove());
	}

}
