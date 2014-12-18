package com.sirma.itt.evgeni.task1;

public interface Factory {

	public Command createInstance(String type);

	public Command createInstanceReflection(String type);
}
