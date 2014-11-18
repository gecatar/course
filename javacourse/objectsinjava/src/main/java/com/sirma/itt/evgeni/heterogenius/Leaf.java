package com.sirma.itt.evgeni.heterogenius;

import java.util.ArrayList;
import java.util.List;

public class Leaf {
	
	List<Leaf> conections = new ArrayList<Leaf>();
	Object object;
	
	public Leaf(Object object){
		this.object = object;
	}
	
	/**
	 * Check node and his children's for containing passed object.
	 * @param object will search this object in nodes.
	 * @return true if node or its children contain object.
	 */
	public boolean contains(Object object){
		if(this.object.equals(object)){
			return true;
		}else{
			for(Leaf node:conections){
				if(node.contains(object)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Represent node and its children's as text.
	 */
	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(object);
		stringBuilder.append(" ");
		for(Leaf node:conections){
			stringBuilder.append(node);
		}
		return stringBuilder.toString();
	}
}