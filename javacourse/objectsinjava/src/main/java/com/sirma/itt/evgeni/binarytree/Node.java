package com.sirma.itt.evgeni.binarytree;

/**
 * Hold number as int. And addresses to next two nodes.
 * 
 * @author Evgeni Stefanov
 */
public class Node {

	int number;
	Node leftNode;
	Node rightNode;

	public Node(int number) {
		this.number = number;
	}

	/**
	 * Return all elements in node and its child as String.
	 */
	@Override
	public String toString() {
		StringBuilder leftString = new StringBuilder();
		StringBuilder rightString = new StringBuilder();
		if (leftNode != null) {
			leftString.append(leftNode.toString());
		}
		if (rightNode != null) {
			rightString.append(rightNode.toString());
		}
		return leftString.toString() + " " + Integer.toString(number) + " "
				+ rightString.toString();
	}

}