package com.sirma.itt.evgeni.homogenius;

/**
 * Store Generic Elements. Make searches for them static int count determine number of nodes.
 * 
 * @author Evgeni Stefanov
 * @param <D>
 */
public class Tree<D extends Data> {

	public Tree(D dt) {
		node = new Field<D>(dt);
	}

	// define number of nodes
	private int count = 3;
	//Starting point.
	Field<D> node;
	
	/**
	 * Return data saved in node as string.
	 * @param node starting point.
	 */
	@Override
	public String toString(){
		return node.toString();
	}

	/**
	 * Search for element in tree.
	 * @param data 
	 * @return true if tree contain passed argument.
	 */
	public boolean contains(D data){
		return node.contains(data);
	}

	/**
	 * Add element in tree if element is unique.
	 * 
	 * @param data
	 *            will be added to tree
	 */
	public void addElement(D data) {
		Field<D> temp = node;
		if (!contains(data)) {
			while (temp != null) {
				if (temp.conections.size() < count) {
					temp.conections.add(new Field<D>(data));
					temp = null;
				} else {
					temp = temp.conections.get(0);
				}
			}
		}
	}
}