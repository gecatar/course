package com.sirma.itt.evgeni.heterogenius;

/**
 * Create tree add elements and make searches.
 * @author Evgeni Stefanov
 *
 */
public class TreeRunner {

	public static void main(String[] args) {
		
		System.out.println("Add elements to tree....");
		System.out.println("Print all element in tree.");
		Tree tree = new Tree("greg");
		tree.addElement("opera");
		tree.addElement("qwerty");
		tree.addElement("odf");
		tree.addElement(7363);
		tree.addElement(new Double(23.3));
		tree.addElement(new Double(24.3));
		System.out.println(tree);
		System.out.println("Search for element in tree:" + "7363");
		if(tree.contains(7363)){
			System.out.println("Element findet.");
		}
	}

}
