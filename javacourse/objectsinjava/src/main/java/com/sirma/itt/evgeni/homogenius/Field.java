package com.sirma.itt.evgeni.homogenius;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Evgeni Stefanov
 * 
 * @param <D>
 */
public class Field<D extends Data> {

	List<Field<D>> conections = new ArrayList<Field<D>>();
	D data;

	public Field(D dt) {
		data = dt;
	}

	/**
	 * Allow searching for data in fields.
	 * 
	 * @param data
	 * @return true if field or his children`s contain object data.
	 */
	public boolean contains(D data) {
		if (this.data.hashCode() == data.hashCode()) {
			if (this.data.equals(data)) {
				return true;
			}
		}
		for (Field<D> node : conections) {
			if (node.contains(data)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return current field and his children's as string.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(data.toString()).append(" ");
		for (Field<D> node : conections) {
			stringBuilder.append(node.toString());
		}
		return stringBuilder.toString();
	}
}
