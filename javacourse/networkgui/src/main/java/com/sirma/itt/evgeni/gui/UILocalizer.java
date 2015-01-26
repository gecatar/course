package com.sirma.itt.evgeni.gui;

import java.awt.Component;
import java.util.ArrayList;

public class UILocalizer {

	private final ArrayList<Component> components = new ArrayList<Component>();

	public void addComponents(Component component) {
		components.add(component);
	}

	public void localize(String languege) {
		for (Component component : components) {
		}
	}
}
