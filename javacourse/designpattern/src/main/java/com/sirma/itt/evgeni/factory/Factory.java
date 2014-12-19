package com.sirma.itt.evgeni.factory;

import com.sirma.itt.evgeni.commands.Command;

public interface Factory {

	public Command createInstance(String type);

	public Command createInstanceReflection(String type);
}
