package com.sirma.itt.evgeni.task6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Contain information about items which are not available.
 * @author Evgeni Stefanov
 *
 */
public class SoldContainer implements Container {

	Map<String, Integer> items = new HashMap<String, Integer>();

	/**
	 * If quantity is zero add item in list.
	 */
	public void update(String description, int quantity, Observable obs) {
		if(quantity==0){
			if(!items.containsKey(description)){
				items.put(description, quantity);
			}
		}
	}

	public String toString() {
		Set<String> keys = items.keySet();
		StringBuilder stb = new StringBuilder();
		for (String key : keys) {
			stb.append("Description:");
			stb.append(key);
			stb.append("Quantity:");
			stb.append(items.get(key));
			stb.append("\n");
		}
		return stb.toString();
	}

}