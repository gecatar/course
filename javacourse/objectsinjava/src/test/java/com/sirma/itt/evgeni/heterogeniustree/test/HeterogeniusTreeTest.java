package com.sirma.itt.evgeni.heterogeniustree.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.evgeni.heterogenius.Tree;

/**
 * Add different element. After that check are they stored in tree.
 * Also test search functionality.
 * @author Evgeni Stefanov
 *
 */
public class HeterogeniusTreeTest {

	/**
	 * Test are element stored in data structure and is it possible to find them.
	 */
	@Test
	public void firstTest() {
		
		Tree tree = new Tree("greg");
		tree.addElement("opera");
		tree.addElement("qwerty");
		tree.addElement("odf");
		tree.addElement(7363);
		tree.addElement(new Double(23.3));
		
		assertTrue(tree.contains(7363));
		assertTrue(tree.contains("greg"));
		assertTrue(tree.contains("opera"));
		assertTrue(tree.contains("odf"));
	}

}