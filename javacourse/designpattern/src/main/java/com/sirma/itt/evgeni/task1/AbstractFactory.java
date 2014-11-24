package com.sirma.itt.evgeni.task1;


public abstract class AbstractFactory {
	
	public abstract Error getError(String type);
	public abstract Error getErrorReflection(String name);
	
	public abstract Command getCommand(String type,Calculator calculator);
	public abstract Command getCommandReflection(String type,Calculator calculator);
	
}
