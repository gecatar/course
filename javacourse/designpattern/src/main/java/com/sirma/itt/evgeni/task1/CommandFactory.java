package com.sirma.itt.evgeni.task1;
import com.sirma.itt.evgeni.task1.AbstractFactory;
import com.sirma.itt.evgeni.task1.Calculator;
import com.sirma.itt.evgeni.task1.Command;
import com.sirma.itt.evgeni.task1.DeductCommand;
import com.sirma.itt.evgeni.task1.DivisionCommand;
import com.sirma.itt.evgeni.task1.MultiplyCommand;
import com.sirma.itt.evgeni.task1.PowCommand;
import com.sirma.itt.evgeni.task1.SumCommand;


public class CommandFactory extends AbstractFactory {


	@Override
	public Command getCommand(String type,Calculator calculator) {
		Command command = null;
		if(type.equalsIgnoreCase("multiply")){
			command = new MultiplyCommand(calculator);
		}
		if(type.equalsIgnoreCase("deduct")){
			command = new DeductCommand(calculator);
		}
		if(type.equalsIgnoreCase("division")){
			command = new DivisionCommand(calculator);
		}
		if(type.equalsIgnoreCase("sum")){
			command = new SumCommand(calculator);
		}
		if(type.equalsIgnoreCase("pow")){
			command = new PowCommand(calculator);
		}
		return command;
	}

	@Override
	public Command getCommandReflection(String type,Calculator calculator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error getError(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Error getErrorReflection(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}