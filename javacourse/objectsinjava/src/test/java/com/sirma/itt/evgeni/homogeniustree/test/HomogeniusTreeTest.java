package com.sirma.itt.evgeni.homogeniustree.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.evgeni.homogenius.Data;
import com.sirma.itt.evgeni.homogenius.Tree;

/**
 * Create tree, add elements and then search for it.
 * @author Evgeni Stefanov
 *
 */
public class HomogeniusTreeTest {

	@Test
	public void test() {
		Data data = new Data("qwerty");
		Data data2 = new Data("asdfg");
		Data data3 = new Data("zxcvbn");		
		Tree<Data> tree = new Tree<Data>(data);
		tree.addElement(data3);
		tree.addElement(data2);
		tree.addElement(new Data("123456"));
		tree.addElement(new Data("123457"));
		tree.addElement(new Data("123458"));
		
		
		assertTrue(tree.contains(data));
		assertTrue(tree.contains(data2));
	}

}